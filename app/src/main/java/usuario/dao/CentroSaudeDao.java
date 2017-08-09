package usuario.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import usuario.dominio.CentroSaude;
import usuario.dominio.ContatoEmergencia;
import usuario.dominio.PlanoSaude;

public class CentroSaudeDao {
    private SQLiteDatabase db;
    private DbHelper dataBaseHelper;
    private Context context;
    private SqlScripts script;

    public CentroSaudeDao(Context context) {
        this.context = context;
        dataBaseHelper = new DbHelper(context);
        script = new SqlScripts();
    }
    public void inserirCentro(CentroSaude centroSaude){
        ContentValues valor;
        db = dataBaseHelper.getWritableDatabase();

        valor = new ContentValues();
        valor.put(DbHelper.CENTRO_NOME, centroSaude.getNome());
        valor.put(DbHelper.CENTRO_ENDERECO, centroSaude.getEndereco());
        valor.put(DbHelper.CENTRO_TELEFONE, centroSaude.getTelefone());
        valor.put(DbHelper.CENTRO_LATLNG, centroSaude.getLocalizacao().toString());
        valor.put(DbHelper.PLANO_SAUDE, centroSaude.getPlanoSaude().getNome());

        db.insert(DbHelper.TABELA_PESSOA,null, valor);
        db.close();
    }
    public List<CentroSaude> buscarCentros(String plano){
        db = dataBaseHelper.getReadableDatabase();

        String[] parametros = { plano};

        Cursor cursor = db.rawQuery(script.cmdWhere(dataBaseHelper.TABELA_CONTATO, dataBaseHelper.CENTRO_PLANO_SAUDE),
                parametros);
        CentroSaude centro = null;
        List<CentroSaude> centros = new ArrayList<>();

        while (cursor.moveToNext()) {
            centro = criarCentro(cursor);
            centros.add(centro);
        }
        cursor.close();
        db.close();
        return centros;
    }


    public CentroSaude criarCentro(Cursor cursor) {
        CentroSaude centro = new CentroSaude();
        PlanoSaude plano = new PlanoSaude();

        plano.setNome(cursor.getString(5));
        centro.setId(cursor.getInt(0));
        centro.setNome(cursor.getString(1));
        centro.setTelefone(cursor.getString(2));
        centro.setEndereco(cursor.getString(3));
        //centro.setLocalizacao();
        centro.setPlanoSaude(plano);
        return centro;
    }
}

package usuario.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import usuario.dominio.CentroSaude;
import usuario.dominio.PlanoSaude;

/**
 *<h1>CentroSaudeDao</h1>
 * Classe responsavel pelas chamadas e operacoes realizadas no banco de dados, mais especificamente
 * na tabela correspondete aos centros de saude.
 */
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
        StringBuilder localizacao = new StringBuilder();
        localizacao.append(centroSaude.getLocalizacao().latitude);
        localizacao.append("/");
        localizacao.append(centroSaude.getLocalizacao().longitude);

        valor = new ContentValues();
        valor.put(DbHelper.CENTRO_NOME, centroSaude.getNome());
        valor.put(DbHelper.CENTRO_ENDERECO, centroSaude.getEndereco());
        valor.put(DbHelper.CENTRO_TELEFONE, centroSaude.getTelefone());
        valor.put(DbHelper.CENTRO_LATLNG, localizacao.toString());
        valor.put(DbHelper.CENTRO_PLANO_SAUDE, centroSaude.getPlanoSaude().getNome());

        db.insert(DbHelper.TABELA_CENTRO,null, valor);
        db.close();
    }

    /**
     * @param plano String do plano: parametro para consulta pelo nome do plano.
     * @return retorna uma List dos centros de saude de acordo com o plano.
     */

    public List<CentroSaude> buscarCentros(String plano){
        db = dataBaseHelper.getReadableDatabase();

        String[] parametros = { plano};

        Cursor cursor = db.rawQuery(script.cmdWhere(dataBaseHelper.TABELA_CENTRO, dataBaseHelper.CENTRO_PLANO_SAUDE),
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
        String[] local = cursor.getString(4).split("/");
        Double valor1 = Double.parseDouble(local[0]);
        Double valor2 = Double.parseDouble(local[1]);
        LatLng localizacao = new LatLng(valor1,valor2);

        centro.setId(cursor.getInt(0));
        centro.setNome(cursor.getString(1));
        centro.setTelefone(cursor.getString(2));
        centro.setEndereco(cursor.getString(3));
        centro.setLocalizacao(localizacao);
        centro.setPlanoSaude(plano);
        centro.setEspecializacao(cursor.getString(6));
        return centro;
    }
}

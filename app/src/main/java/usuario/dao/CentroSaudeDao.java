package usuario.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import usuario.dominio.CentroSaude;

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
        valor.put(DbHelper.CENTRO_LATLNG, centroSaude.getEndereco());
        valor.put(DbHelper.PLANO_SAUDE, centroSaude.getPlanoSaude().getNome());

        db.insert(DbHelper.TABELA_PESSOA,null, valor);
        db.close();
    }
}

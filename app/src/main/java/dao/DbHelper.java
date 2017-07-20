package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    protected static final String NOME_DB = "banco.db";
    protected static final int VERSAO = 1;
    private SqlScripts scripts = new SqlScripts();

    // TABELA DOS USUARIOS
    protected static final String TABELA_USUARIO = "usuarios";
    protected static final String ID_USUARIO = "_id_usuario";
    protected static final String USER = "user";
    protected static final String PASSWORD = "password";

    // TABELA DAS PESSOAS
    protected static final String TABELA_PESSOA = "pessoas";
    protected static final String ID_PESSOA ="_id_pessoa";
    protected static final String NOME = "nome";
    protected static final String ENDERECO_CASA = "endereco_casa";
    protected static final String ENDERECO_TRABALHO = "endereco_trabalho";
    protected static final String CONTATO_EMERGENCIA1 = "contato_emergencia1";
    protected static final String CONTATO_EMERGENCIA2 = "contato_emergencia2";
    protected static final String CONTATO_EMERGENCIA3 = "econtato_emergencia3";
    protected static final String PLANO_SAUDE = "plano_saude";
    protected static final String NASCIMENTO = "nascimento";
    protected static final String PESSOA_USER = "pessoa_user";


    public DbHelper(Context context){
        super(context, NOME_DB,null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(scripts.createTabelaUsuario());
        db.execSQL(scripts.createTabelaPessoa());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_PESSOA);

        onCreate(db);
    }


}

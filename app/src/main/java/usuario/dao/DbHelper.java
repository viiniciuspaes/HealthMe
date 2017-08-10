package usuario.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    protected static final String NOME_DB = "banco.db";
    protected static final int VERSAO = 7;
    private SqlScripts scripts = new SqlScripts();
    private Context context;

    // TABELA DOS USUARIOS
    protected static final String TABELA_USUARIO = "tabela_usuarios";
    //protected static final String ID_USUARIO = "_id_usuario";
    protected static final String USER = "user";
    protected static final String PASSWORD = "password";

    // TABELA DAS PESSOAS
    protected static final String TABELA_PESSOA = "tabela_pessoas";
    //protected static final String ID_PESSOA ="_id_pessoa";
    protected static final String NOME = "nome";
    protected static final String PESSOA_USER = "pessoa_usuario";
    protected static final String ENDERECO_CASA = "endereco_casa";
    protected static final String ENDERECO_TRABALHO = "endereco_trabalho";
    protected static final String PLANO_SAUDE = "plano_saude";
    protected static final String NASCIMENTO = "nascimento";

    //TABELA DOS EVENTOS
    protected static final String TABELA_EVENTO = "tabela_evento";
    //protected static final String ID_EVENTO = "_id_evento";
    protected static final String EVENTO_NOME = "evento_nome";
    protected static final String USUARIO_EVENTO = "evento_usuario";
    protected static final String DESCRICAO = "descricao";
    protected static final String DATA = "data";

    //TABELA CONTATOS
    protected static final String TABELA_CONTATO = "tabela_contato";
    protected static final String ID = "_id";
    //protected static final String ID_CONTATO = "_id_contato";
    protected static final String CONTATO_NOME = "contato_nome";
    protected static final String CONTATO_TELEFONE = "contato_telefone";
    protected static final String USUARIO_CONTATO = "contato_usuario";

    // TABELA CENTROS
    protected static final String TABELA_CENTRO = "tabela_centro";
    //protected static final String ID_CENTRO ="_id_centro";
    protected static final String CENTRO_NOME = "centro_nome";
    protected static final String CENTRO_TELEFONE = "centro_telefone";
    protected static final String CENTRO_ENDERECO = "cemtro_endereco";
    protected static final String CENTRO_LATLNG = "centro_latlng";
    protected static final String CENTRO_PLANO_SAUDE = "centro_plano_saude";
    protected static final String CENTRO_ESPECIALIZACAO = "centro_especializacao";

    public DbHelper(Context context){
        super(context, NOME_DB,null, VERSAO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(scripts.createTabelaUsuario());
        db.execSQL(scripts.createTabelaPessoa());
        db.execSQL(scripts.createTabelaEvento());
        db.execSQL(scripts.createTabelaContato());
        db.execSQL(scripts.createTabelaCentro());
        db.execSQL(scripts.povoar());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_PESSOA);
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_EVENTO);
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_CONTATO);
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_CENTRO);

        onCreate(db);
    }
}

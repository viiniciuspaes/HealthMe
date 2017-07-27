package usuario.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import usuario.dominio.ContatoEmergencia;
import usuario.dominio.Pessoa;
import usuario.negocio.UsuarioValidacao;



public class ContatoDao {
    private SQLiteDatabase db;
    private DbHelper dataBaseHelper;
    private UsuarioValidacao validacao;
    private Context context;
    private SqlScripts script;
    private ContatoEmergencia ctEmergencia;

    public ContatoDao(Context context){
        this.context = context;
        dataBaseHelper = new DbHelper(context);
        script = new SqlScripts();
    }
    public void inserirRegistro(ContatoEmergencia contatoEmergencia){
        ContentValues valor;
        db = dataBaseHelper.getWritableDatabase();

        valor = new ContentValues();
        valor.put(DbHelper.USUARIO_CONTATO, contatoEmergencia.getUsuario().getLogin());
        valor.put(DbHelper.CONTATO_NOME, contatoEmergencia.getNome());
        valor.put(DbHelper.CONTATO_TELEFONE, contatoEmergencia.getNumero());


        db.insert(DbHelper.TABELA_CONTATO, null, valor);
        db.close();
    }
}

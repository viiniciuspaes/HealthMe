package usuario.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import usuario.dominio.ContatoEmergencia;

import usuario.gui.R;
import usuario.negocio.UsuarioValidacao;



public class ContatoDao {
    private SQLiteDatabase db;
    private DbHelper dataBaseHelper;
    private UsuarioValidacao validacao;
    private Context context;
    private SqlScripts script;
    private ContatoEmergencia ctEmergencia;
    Cursor cursor;
    SimpleCursorAdapter adpter;
    ListView listViewContatos;

    public ContatoDao(Context context) {
        this.context = context;
        dataBaseHelper = new DbHelper(context);
        script = new SqlScripts();
    }

    public void inserirRegistro(ContatoEmergencia contatoEmergencia) {
        ContentValues valor;
        db = dataBaseHelper.getWritableDatabase();

        valor = new ContentValues();
        valor.put(DbHelper.USUARIO_CONTATO, contatoEmergencia.getUsuario().getLogin());
        valor.put(DbHelper.CONTATO_NOME, contatoEmergencia.getNome());
        valor.put(DbHelper.CONTATO_TELEFONE, contatoEmergencia.getNumero());


        db.insert(DbHelper.TABELA_CONTATO, null, valor);
        db.close();
    }

    public void atualizarRegistro(ContatoEmergencia contatoEmergencia) {
        ContentValues valor;
        String where = DbHelper.ID_CONTATO + "=" + contatoEmergencia.getId();
        db = dataBaseHelper.getWritableDatabase();


        valor = new ContentValues();
        valor.put(DbHelper.CONTATO_NOME, contatoEmergencia.getNome());
        valor.put(DbHelper.CONTATO_TELEFONE, contatoEmergencia.getNumero());

        db.update(DbHelper.TABELA_CONTATO, valor, where, null);
        db.close();
    }

    public ContatoEmergencia buscarContato(String usuario) {
        db = dataBaseHelper.getReadableDatabase();

        String[] parametros = {usuario};

        Cursor cursor = db.rawQuery(script.cmdWhere(dataBaseHelper.TABELA_CONTATO, dataBaseHelper.USUARIO_CONTATO),
                parametros);
        ContatoEmergencia contato = null;

        if (cursor.moveToNext()) {
            contato = criarContato(cursor);
        }
        cursor.close();
        db.close();
        return contato;
    }

    public ContatoEmergencia criarContato(Cursor cursor) {
        ContatoEmergencia contatoEmergencia = new ContatoEmergencia();
        contatoEmergencia.setId(cursor.getInt(0));
        contatoEmergencia.setNome(cursor.getString(2));
        contatoEmergencia.setNumero(cursor.getString(3));
        return contatoEmergencia;
    }

    public Cursor buscarDados(){

        db = dataBaseHelper.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM " + DbHelper.TABELA_CONTATO, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }

        return cursor;


    }
    public Cursor buscarDados2(){
        db = dataBaseHelper.getWritableDatabase();
        String[] todasAsColunas = new String[]{DbHelper.ID_CONTATO, DbHelper.CONTATO_NOME,DbHelper.CONTATO_TELEFONE,DbHelper.USUARIO_CONTATO};
        Cursor c = db.query(DbHelper.TABELA_CONTATO, todasAsColunas,null,null,null,null,null);
        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }
}

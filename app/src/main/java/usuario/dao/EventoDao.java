package usuario.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;

import usuario.dominio.Evento;
import usuario.negocio.EventoNegocio;

/**
 * <h1>EventoDao</h1>
 * Classe responsavel pelas chamadas e operacoes realizadas no banco de dados, mais especificamente
 * na tabela correspondete aos eventos do calendario de cada usuario.
 */

public class EventoDao {
    private Context context;
    private DbHelper dataBaseHelper;
    private SqlScripts script;
    private SQLiteDatabase db;
    private EventoNegocio validacao;
    Cursor cursor;

    public EventoDao(Context context){
        this.context = context;
        dataBaseHelper = new DbHelper(context);
        script = new SqlScripts();
    }

    public void inserirRegistro(Evento evento){
        ContentValues valor;
        db = dataBaseHelper.getWritableDatabase();
        validacao = new EventoNegocio(this.context);

        valor = new ContentValues();
        valor.put(DbHelper.EVENTO_NOME, evento.getNome());
        valor.put(DbHelper.USUARIO_EVENTO, evento.getUsuario().getLogin());
        valor.put(DbHelper.DESCRICAO, evento.getDescricao());
        valor.put(DbHelper.DATA, evento.getDate());

        db.insert(DbHelper.TABELA_EVENTO, null, valor);
        db.close();
    }

    public void atualizarRegistro(Evento evento){
        ContentValues valor;
        String where = DbHelper.ID + "=" + evento.getId();
        db = dataBaseHelper.getWritableDatabase();

        valor = new ContentValues();
        valor.put(DbHelper.EVENTO_NOME, evento.getNome());
        valor.put(DbHelper.USUARIO_EVENTO, evento.getUsuario().getLogin());
        valor.put(DbHelper.DESCRICAO, evento.getDescricao());
        valor.put(DbHelper.DATA, evento.getDate());


        db.update(DbHelper.TABELA_EVENTO, valor, where, null);
        db.close();
    }

    /**
     * Metodo utilizado na verificacao do evento para as operacoes de insercao, edicao e remocao do
     * evento no calendario.
     * @param data
     * @return
     */

    public Evento buscarEvento(String data) {
        db = dataBaseHelper.getReadableDatabase();

        String[] parametros = {data};

        Cursor cursor = db.rawQuery(script.cmdWhere(dataBaseHelper.TABELA_EVENTO,dataBaseHelper.DATA),
                parametros);

        Evento evento = null;

        if (cursor.moveToNext()) {
            evento = criarEvento(cursor);
        }
        cursor.close();
        db.close();
        return evento;
    }

    private Evento criarEvento(Cursor cursor){
        Evento evento = new Evento();
        evento.setId(cursor.getInt(0));
        evento.setNome(cursor.getString(1));
        evento.setDescricao(cursor.getString(3));
        //evento.setDate(cursor.getString(4));
        return evento;
    }

    /**
     * Metodo utilizado na construcao da View do perfil para o usuario, buscando os dados de acordo
     * com o cursor de dados dos eventos do usuario.
     *
     * @param usuario String do nome do usuario: busca realizada pelo nome do usuario.
     * @return Retorna a posicao do evento buscado.
     */

    public Cursor buscarDados(String usuario){

        db = dataBaseHelper.getWritableDatabase();
        String[] parametros = { usuario};

        cursor = db.rawQuery("SELECT * FROM " + DbHelper.TABELA_EVENTO + " WHERE " + DbHelper.USUARIO_EVENTO +" Like ?",parametros);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void delete(Evento evento){
        db = dataBaseHelper.getWritableDatabase();
        String where = DbHelper.ID + "=" + evento.getId();
        db.delete(DbHelper.TABELA_EVENTO, where, null) ;
        db.close();
    }
}

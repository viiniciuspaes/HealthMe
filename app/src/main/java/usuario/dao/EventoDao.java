package usuario.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import usuario.dominio.Evento;
import usuario.negocio.EventoNegocio;

public class EventoDao {
    private Context context;
    private DbHelper dataBaseHelper;
    private SqlScripts script;
    private SQLiteDatabase db;
    private EventoNegocio validacao;

    public EventoDao(Context context){
        this.context = context;
        dataBaseHelper = new DbHelper(context);
        script = new SqlScripts();

    }
    public void inserirregistro(Evento evento){
        ContentValues valor;
        db = dataBaseHelper.getWritableDatabase();
        validacao = new EventoNegocio(this.context);

        valor = new ContentValues();
        valor.put(DbHelper.EVENTO_NOME, evento.getNome());
        valor.put(DbHelper.USUARIO_EVENTO, evento.getUsuario().getLogin());
        valor.put(DbHelper.DESCRICAO, evento.getDescricao());
        valor.put(DbHelper.DATA_INICIO, validacao.mudarData(evento.getInicio()));
        valor.put(DbHelper.DATA_FIM, validacao.mudarData(evento.getFim()));

        db.insert(DbHelper.TABELA_EVENTO, null, valor);
        db.close();
    }
    public void atualizarRegistro(Evento evento){
        ContentValues valor;
        String where = DbHelper.ID_EVENTO + "=" + evento.getId();
        db = dataBaseHelper.getWritableDatabase();
        validacao = new EventoNegocio(this.context);

        valor = new ContentValues();
        valor.put(DbHelper.EVENTO_NOME, evento.getNome());
        valor.put(DbHelper.USUARIO_EVENTO, evento.getUsuario().getLogin());
        valor.put(DbHelper.DESCRICAO, evento.getDescricao());
        valor.put(DbHelper.DATA_INICIO, validacao.mudarData(evento.getInicio()));
        valor.put(DbHelper.DATA_FIM, validacao.mudarData(evento.getFim()));

        db.update(DbHelper.TABELA_EVENTO, valor, where, null);
        db.close();
    }
    public Evento buscarEvento(String nome) {
        db = dataBaseHelper.getReadableDatabase();

        String[] parametros = {nome};

        Cursor cursor = db.rawQuery(script.cmdWhere(dataBaseHelper.TABELA_EVENTO,dataBaseHelper.EVENTO_NOME),
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
        //evento.getInicio(cursor.getString(4));
        //evento.setFim(cursor.getString(5));
        return evento;
    }
}

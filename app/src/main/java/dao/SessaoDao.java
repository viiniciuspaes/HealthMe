package dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import dominio.Usuario;
import negocio.SessaoUsuario;
import negocio.UsuarioValidacao;

public class SessaoDao {
    private SQLiteDatabase db;
    private DbHelper dataBaseHelper;
    private UsuarioValidacao validacao;
    private Context context;
    private SqlScripts script;

    public SessaoDao(Context context){
        this.context = context;
        dataBaseHelper = new DbHelper(context);
        script = new SqlScripts();
    }
    public void inserirRegistro(Usuario usuario){
        ContentValues valor;
        db = dataBaseHelper.getWritableDatabase();

        valor = new ContentValues();
        valor.put(DbHelper.USER_SESSAO, usuario.getLogin());

        db.insert(DbHelper.TABELA_SESSAO, null, valor);
        db.close();
    }
    public SessaoUsuario buscarSessao(String user) {
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

        String[] parametros = {user};

        Cursor cursor = db.rawQuery(script.cmdWhere(dataBaseHelper.TABELA_SESSAO,dataBaseHelper.USER_SESSAO),
                parametros);

        SessaoUsuario sessao = null;

        if (cursor.moveToNext()) {
            sessao = criarSessao(cursor);
        }
        cursor.close();
        db.close();
        return sessao;
    }
    private SessaoUsuario criarSessao(Cursor cursor){

        UsuarioDao userDao= new UsuarioDao(context);

        SessaoUsuario sessao = new SessaoUsuario();
        sessao.setId(cursor.getShort(0));
        sessao.setUsuarioLogado(userDao.buscarUsuario(cursor.getString(1)));
        return sessao;
    }
}

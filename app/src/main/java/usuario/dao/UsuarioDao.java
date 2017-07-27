package usuario.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import usuario.dominio.ContatoEmergencia;
import usuario.dominio.Pessoa;
import usuario.dominio.Usuario;
import usuario.negocio.UsuarioValidacao;

public class UsuarioDao {
    private SQLiteDatabase db;
    private DbHelper dataBaseHelper;
    private UsuarioValidacao validacao;
    private Context context;
    private SqlScripts script;
    private ContatoEmergencia ctEmergencia;

    public UsuarioDao(Context context){
        this.context = context;
        dataBaseHelper = new DbHelper(context);
        script = new SqlScripts();
    }
    public void inserirRegistro(Pessoa pessoa){
        ContentValues valor;
        db = dataBaseHelper.getWritableDatabase();

        valor = new ContentValues();
        valor.put(DbHelper.USER, pessoa.getUsuario().getLogin());
        valor.put(DbHelper.PASSWORD, pessoa.getUsuario().getPassword());

        db.insert(DbHelper.TABELA_USUARIO, null, valor);

        valor = new ContentValues();
        valor.put(DbHelper.NOME, pessoa.getNome());
        valor.put(DbHelper.PESSOA_USER, pessoa.getUsuario().getLogin());
        valor.put(DbHelper.ENDERECO_CASA, pessoa.getEnderecoCasa());
        valor.put(DbHelper.ENDERECO_TRABALHO, pessoa.getEnderecoTrabalho());
        valor.put(DbHelper.PLANO_SAUDE, pessoa.getPlanoSaude());
        //valor.put(DbHelper.NASCIMENTO, validacao.mudarData(pessoa.getNascimento()) );

        db.insert(DbHelper.TABELA_PESSOA,null, valor);
        db.close();
    }
    public void atualizarRegistro(Pessoa pessoa){
        ContentValues valor;
        String where;
        validacao =  new UsuarioValidacao(this.context);

        db = dataBaseHelper.getWritableDatabase();
        where = DbHelper.ID_USUARIO + "=" + pessoa.getId();

        valor = new ContentValues();

        where = DbHelper.ID_PESSOA + "=" + pessoa.getId();
        valor = new ContentValues();
        valor.put(DbHelper.NOME, pessoa.getNome());
        valor.put(DbHelper.ENDERECO_CASA, pessoa.getEnderecoCasa());
        valor.put(DbHelper.ENDERECO_TRABALHO, pessoa.getEnderecoTrabalho());
        valor.put(DbHelper.PLANO_SAUDE, pessoa.getPlanoSaude());
        //valor.put(DbHelper.NASCIMENTO, validacao.mudarData(pessoa.getNascimento()) );

        db.update(DbHelper.TABELA_PESSOA, valor, where, null);
        db.close();
    }
    public Usuario buscarUsuario(String user, String password) {
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

        String[] parametros = {user, password};

        Cursor cursor = db.rawQuery(script.cmdWhere(dataBaseHelper.TABELA_USUARIO,dataBaseHelper.USER,dataBaseHelper.PASSWORD),
                parametros);

        Usuario usuario = null ;

        if (cursor.moveToNext()) {
            usuario = criarUsuario(cursor);
        }
        cursor.close();
        db.close();
        return usuario;
    }
    public Usuario buscarUsuario(String user) {
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

        String[] parametros = {user};

        Cursor cursor = db.rawQuery(script.cmdWhere(dataBaseHelper.TABELA_USUARIO,dataBaseHelper.USER),
                parametros);

        Usuario usuario = null;

        if (cursor.moveToNext()) {
            usuario = criarUsuario(cursor);
        }
        cursor.close();
        db.close();
        return usuario;
    }

    public Pessoa buscarPessoa(String nome) {
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

        String[] parametros = {nome};

        Cursor cursor = db.rawQuery(script.cmdWhere(dataBaseHelper.TABELA_PESSOA,dataBaseHelper.PESSOA_USER),
                parametros);

        Pessoa pessoa = null;

        if (cursor.moveToNext()) {
            pessoa = criarPessoa(cursor);
        }
        cursor.close();
        db.close();
        return pessoa;
    }
    private Usuario criarUsuario(Cursor cursor){
        Usuario usuario = new Usuario();
        usuario.setId(cursor.getInt(0));
        usuario.setLogin(cursor.getString(1));
        usuario.setPassword(cursor.getString(2));
        return usuario;
    }
    private Pessoa criarPessoa(Cursor cursor){

        Pessoa pessoa = new Pessoa();
        pessoa.setId(cursor.getShort(0));
        pessoa.setNome(cursor.getString(1));
        //pessoa.setEnderecoCasa(cursor.getString(3));
        //pessoa.setEnderecoTrabalho(cursor.getString(4));
        pessoa.setPlanoSaude(cursor.getString(5));
        return pessoa;
    }
    public boolean removerPessoa(int id){
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        return db.delete(dataBaseHelper.TABELA_PESSOA, "_id_pessoa = ?", new String[]{Integer.toString(id)}) > 0;

    }
    public void deletarPessoa(int id){

        String where = dataBaseHelper.ID_USUARIO + "=" + id;
        db = dataBaseHelper.getReadableDatabase();
        db.delete(dataBaseHelper.TABELA_PESSOA,where,null);
        db.close();
    }

}

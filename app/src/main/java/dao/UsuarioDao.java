package dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import dominio.ContatoEmergencia;
import dominio.Pessoa;
import dominio.Usuario;
import negocio.UsuarioValidacao;

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
        valor.put(DbHelper.USER, pessoa.getUsuario().toString());
        valor.put(DbHelper.PASSWORD, pessoa.getUsuario().getPassword());

        db.insert(DbHelper.TABELA_USUARIO, null, valor);

        valor = new ContentValues();
        valor.put(DbHelper.NOME, pessoa.getNome());
        valor.put(DbHelper.ENDERECO_CASA, pessoa.getEnderecoCasa());
        valor.put(DbHelper.ENDERECO_TRABALHO, pessoa.getEnderecoTrabalho());
        //valor.put(DbHelper.CONTATO_EMERGENCIA1, pessoa.getContatoEmergencia()[0].getNome());
        //valor.put(DbHelper.CONTATO_EMERGENCIA2, pessoa.getContatoEmergencia()[1].getNome());
        //valor.put(DbHelper.CONTATO_EMERGENCIA3, pessoa.getContatoEmergencia()[2].getNome());
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
        valor.put(DbHelper.USER, pessoa.getUsuario().getLogin());
        valor.put(DbHelper.PASSWORD, pessoa.getUsuario().getPassword());

        db.update(DbHelper.TABELA_USUARIO, valor, where, null);

        where = DbHelper.ID_PESSOA + "=" + pessoa.getId();
        valor = new ContentValues();
        valor.put(DbHelper.NOME, pessoa.getNome());
        valor.put(DbHelper.PESSOA_USER, pessoa.getUsuario().getLogin());
        valor.put(DbHelper.ENDERECO_CASA, pessoa.getEnderecoCasa());
        valor.put(DbHelper.ENDERECO_TRABALHO, pessoa.getEnderecoTrabalho());
        //valor.put(DbHelper.CONTATO_EMERGENCIA1, pessoa.getContatoEmergencia()[0].getNome());
        //valor.put(DbHelper.CONTATO_EMERGENCIA2, pessoa.getContatoEmergencia()[1].getNome());
        //valor.put(DbHelper.CONTATO_EMERGENCIA3, pessoa.getContatoEmergencia()[2].getNome());
        valor.put(DbHelper.PLANO_SAUDE, pessoa.getPlanoSaude());
        //valor.put(DbHelper.NASCIMENTO, validacao.mudarData(pessoa.getNascimento()) );

        db.update(DbHelper.TABELA_PESSOA, valor, where, null);
        db.close();
    }
    public Usuario buscarUsuario(String email, String password) {
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

        String[] parametros = {email, password};

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
    public Usuario buscarUsuario(String email) {
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

        String[] parametros = {email};

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
        ctEmergencia = new ContatoEmergencia();
        ContatoEmergencia[] lista = new ContatoEmergencia[3];

        Pessoa pessoa = new Pessoa();
        pessoa.setId(cursor.getShort(0));
        pessoa.setEnderecoCasa(cursor.getString(2));
        pessoa.setEnderecoTrabalho(cursor.getString(3));
        for(int x=0; x<3;x++){
            ctEmergencia.setNome(cursor.getString(x+4+x));
            lista[x]=ctEmergencia;
        }
        pessoa.setContatoEmergencia(lista);
        pessoa.setPlanoSaude(cursor.getString(7));
        return pessoa;
    }
}

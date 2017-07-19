package dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import dominio.Pessoa;
import dominio.Usuario;
import negocio.UsuarioValidacao;

public class UsuarioDao {
    private SQLiteDatabase db;
    private DbHelper dataBaseHelper;
    private UsuarioValidacao validacao;
    private Context context;


    public UsuarioDao(Context context){
        this.context = context;
        dataBaseHelper = new DbHelper(context);
    }
    public void inserirRegistro(Pessoa pessoa){
        ContentValues valor;
        long saida;
        db = dataBaseHelper.getWritableDatabase();

        valor = new ContentValues();
        valor.put(DbHelper.USER, pessoa.getUsuario().toString());
        valor.put(DbHelper.PASSWORD, pessoa.getUsuario().getPassword());

        db.insert(DbHelper.TABELA_USUARIO, null, valor);

        // precisa de algo para avisar se der erro
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
        valor.put(DbHelper.USER, pessoa.getUsuario().toString());
        valor.put(DbHelper.PASSWORD, pessoa.getUsuario().getPassword());

        db.update(DbHelper.TABELA_USUARIO, valor, where, null);

        // precisa de algo para avisar se der erro

        where = DbHelper.ID_PESSOA + "=" + pessoa.getId();
        valor = new ContentValues();
        valor.put(DbHelper.NOME, pessoa.getNome());
        valor.put(DbHelper.ENDERECO_CASA, pessoa.getEnderecoCasa());
        valor.put(DbHelper.ENDERECO_TRABALHO, pessoa.getEnderecoTrabalho());
        valor.put(DbHelper.CONTATO_EMERGENCIA1, pessoa.getContatoEmergencia()[0].getNome());
        valor.put(DbHelper.CONTATO_EMERGENCIA2, pessoa.getContatoEmergencia()[1].getNome());
        valor.put(DbHelper.CONTATO_EMERGENCIA3, pessoa.getContatoEmergencia()[2].getNome());
        valor.put(DbHelper.PLANO_SAUDE, pessoa.getPlanoSaude());
        valor.put(DbHelper.NASCIMENTO, validacao.mudarData(pessoa.getNascimento()) );

        db.update(DbHelper.TABELA_PESSOA, valor, where, null);
        db.close();
    }
    public Usuario buscarUsuario(String email, String password) {
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

        String comando = "SELECT * FROM" + dataBaseHelper.TABELA_USUARIO +
                " WHERE " + dataBaseHelper.USER + "LIKE ? AND" + dataBaseHelper.PASSWORD + " LIKE ?";

        String[] parametros = {email, password};

        Cursor cursor = db.rawQuery(comando, parametros);

        Usuario usuario = null;

        if (cursor.moveToNext()) {
            usuario = criarUsuario(cursor);
        }
        cursor.close();
        db.close();
        return usuario;
    }
    private Usuario criarUsuario(Cursor cursor){
        Usuario usuario = new Usuario();
        usuario.setId(cursor.getShort(0));
        usuario.setLogin(cursor.getString(1));
        usuario.setPassword(cursor.getString(2));
        return usuario;


    }
}

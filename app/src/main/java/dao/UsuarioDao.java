package dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import dominio.Pessoa;

public class UsuarioDao {
    private SQLiteDatabase db;
    private DbHelper dataBaseHelper;


    public UsuarioDao(Context context){
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
        valor.put(DbHelper.CONTATO_EMERGENCIA1, pessoa.getContatoEmergencia()[0].getNome());
        valor.put(DbHelper.CONTATO_EMERGENCIA2, pessoa.getContatoEmergencia()[1].getNome());
        valor.put(DbHelper.CONTATO_EMERGENCIA3, pessoa.getContatoEmergencia()[2].getNome());
        valor.put(DbHelper.PLANO_SAUDE, pessoa.getPlanoSaude());
        valor.put(DbHelper.NASCIMENTO, pessoa.getNascimento().toString() );

        db.insert(DbHelper.TABELA_PESSOA,null, valor);
        db.close();

    }
    public void atualizarRegistro(Pessoa pessoa){
        ContentValues values;
        String where;

        db = dataBaseHelper.getWritableDatabase();
        where = DbHelper.ID_USUARIO + "=" + pessoa.getId();

        values = new ContentValues();
        values.put(DbHelper.USER, pessoa.getUsuario().toString());
        values.put(DbHelper.PASSWORD, pessoa.getUsuario().getPassword());

        db.update(DbHelper.TABELA_USUARIO, values, where, null);

        // precisa de algo para avisar se der erro

        where = DbHelper.ID_PESSOA + "=" + pessoa.getId();
        values = new ContentValues();
        values.put(DbHelper.NOME, pessoa.getNome());
        values.put(DbHelper.ENDERECO_CASA, pessoa.getEnderecoCasa());
        values.put(DbHelper.ENDERECO_TRABALHO, pessoa.getEnderecoTrabalho());
        values.put(DbHelper.CONTATO_EMERGENCIA1, pessoa.getContatoEmergencia()[0].getNome());
        values.put(DbHelper.CONTATO_EMERGENCIA2, pessoa.getContatoEmergencia()[1].getNome());
        values.put(DbHelper.CONTATO_EMERGENCIA3, pessoa.getContatoEmergencia()[2].getNome());
        values.put(DbHelper.PLANO_SAUDE, pessoa.getPlanoSaude());
        values.put(DbHelper.NASCIMENTO, pessoa.getNascimento().toString() );

        db.update(DbHelper.TABELA_PESSOA, values, where, null);
        db.close();
    }
}

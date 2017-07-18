package dao;


import static dao.DbHelper.*;

public class SqlScripts {
    protected static String getTabelaUsuario(){

        StringBuilder userBuilder = new StringBuilder();
        userBuilder.append("CREATE TABLE "+ TABELA_USUARIO +" ( ");
        userBuilder.append(ID_USUARIO +" integer primary key autoincrement, ");
        userBuilder.append(USER+" text not null unique, ");
        userBuilder.append(PASSWORD+" text not null);");
        return userBuilder.toString();
    }
    protected static String getTabelaPessoa(){

        StringBuilder pessoaBuilder = new StringBuilder();
        pessoaBuilder.append("CREATE TABLE "+ TABELA_PESSOA +" ( ");
        pessoaBuilder.append(ID_PESSOA +" integer primary key autoincrement, ");
        pessoaBuilder.append(NOME +" text not null, ");
        pessoaBuilder.append(ENDERECO_CASA +" text, ");
        pessoaBuilder.append(ENDERECO_TRABALHO +" text, ");
        pessoaBuilder.append(CONTATO_EMERGENCIA1 +" text, ");
        pessoaBuilder.append(CONTATO_EMERGENCIA2 +" text, ");
        pessoaBuilder.append(CONTATO_EMERGENCIA3 +" text, ");
        pessoaBuilder.append(PLANO_SAUDE +" text, ");
        pessoaBuilder.append(NASCIMENTO +" text);");
        return pessoaBuilder.toString();
    }
}

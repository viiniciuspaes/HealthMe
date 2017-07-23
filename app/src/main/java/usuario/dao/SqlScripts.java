package usuario.dao;


import static usuario.dao.DbHelper.*;

public class SqlScripts {
    protected String createTabelaUsuario(){

        StringBuilder userBuilder = new StringBuilder();
        userBuilder.append("CREATE TABLE "+ TABELA_USUARIO +" ( ");
        userBuilder.append(ID_USUARIO +" integer primary key autoincrement, ");
        userBuilder.append(USER+" text not null unique, ");
        userBuilder.append(PASSWORD+" text not null);");
        return userBuilder.toString();
    }
    protected String createTabelaPessoa(){

        StringBuilder pessoaBuilder = new StringBuilder();
        pessoaBuilder.append("CREATE TABLE "+ TABELA_PESSOA +" ( ");
        pessoaBuilder.append(ID_PESSOA +" integer primary key autoincrement, ");
        pessoaBuilder.append(NOME +" text not null, ");
        pessoaBuilder.append(PESSOA_USER +" text not null unique, ");
        pessoaBuilder.append(ENDERECO_CASA +" text, ");
        pessoaBuilder.append(ENDERECO_TRABALHO +" text, ");
        //pessoaBuilder.append(CONTATO_EMERGENCIA1 +" text, ");
        //pessoaBuilder.append(CONTATO_EMERGENCIA2 +" text, ");
        //pessoaBuilder.append(CONTATO_EMERGENCIA3 +" text, ");
        pessoaBuilder.append(PLANO_SAUDE +" text);");
        //pessoaBuilder.append(NASCIMENTO +" text);");
        return pessoaBuilder.toString();
    }
    protected String createTabelaEvento(){
        StringBuilder eventoBuilder = new StringBuilder();
        eventoBuilder.append("CREATE TABLE "+ TABELA_EVENTO +" ( ");
        eventoBuilder.append(ID_EVENTO +" integer primary key autoincrement, ");
        eventoBuilder.append(EVENTO_NOME +" text not null unique, ");
        eventoBuilder.append(USUARIO_EVENTO +" text not null unique, ");
        eventoBuilder.append(DESCRICAO +" text, ");
        eventoBuilder.append(DATA_INICIO +" text, ");
        eventoBuilder.append(DATA_FIM +" text);");
        return eventoBuilder.toString();
    }
    protected String cmdWhere(String tabela, String a, String b){
        return "SELECT * FROM " + tabela + " WHERE " + a + " LIKE ? AND " + b + " LIKE ?";
    }
    protected String cmdWhere(String tabela, String a){
        return "SELECT * FROM " + tabela + " WHERE " + a + " LIKE ?";
    }
}
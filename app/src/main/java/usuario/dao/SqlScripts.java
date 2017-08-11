package usuario.dao;


import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

import usuario.dominio.CentroSaude;
import usuario.dominio.PlanoSaude;

import static usuario.dao.DbHelper.*;

public class SqlScripts {
    private CentroSaudeDao centroSaudeDao;
    protected String createTabelaUsuario(){

        StringBuilder userBuilder = new StringBuilder();
        userBuilder.append("CREATE TABLE "+ TABELA_USUARIO +" ( ");
        userBuilder.append(ID +" integer primary key autoincrement, ");
        userBuilder.append(USER+" text not null unique, ");
        userBuilder.append(PASSWORD+" text not null);");
        return userBuilder.toString();
    }
    protected String createTabelaPessoa(){

        StringBuilder pessoaBuilder = new StringBuilder();
        pessoaBuilder.append("CREATE TABLE "+ TABELA_PESSOA +" ( ");
        pessoaBuilder.append(ID +" integer primary key autoincrement, ");
        pessoaBuilder.append(NOME +" text not null, ");
        pessoaBuilder.append(PESSOA_USER +" text not null unique, ");
        pessoaBuilder.append(ENDERECO_CASA +" text, ");
        pessoaBuilder.append(ENDERECO_TRABALHO +" text, ");
        pessoaBuilder.append(PLANO_SAUDE +" text);");
        //pessoaBuilder.append(NASCIMENTO +" text);");
        return pessoaBuilder.toString();
    }
    protected String createTabelaEvento(){
        StringBuilder eventoBuilder = new StringBuilder();
        eventoBuilder.append("CREATE TABLE "+ TABELA_EVENTO +" ( ");
        eventoBuilder.append(ID +" integer primary key autoincrement, ");
        eventoBuilder.append(EVENTO_NOME +" text not null unique, ");
        eventoBuilder.append(USUARIO_EVENTO +" text not null, ");
        eventoBuilder.append(DESCRICAO +" text, ");
        eventoBuilder.append(DATA +" text);");
        return eventoBuilder.toString();
    }

    protected String createTabelaContato(){
        StringBuilder contatoBuilder = new StringBuilder();
        contatoBuilder.append("CREATE TABLE "+ TABELA_CONTATO +" ( ");
        contatoBuilder.append(ID+" integer primary key autoincrement, ");
        //contatoBuilder.append(ID_CONTATO +" integer autoincrement, ");
        contatoBuilder.append(USUARIO_CONTATO + " text, ");
        contatoBuilder.append(CONTATO_NOME +" text not null unique, ");
        contatoBuilder.append(CONTATO_TELEFONE +" text);");
        return contatoBuilder.toString();
    }
    
    protected String createTabelaCentro(){
        StringBuilder mapaBuilder = new StringBuilder();
        mapaBuilder.append("CREATE TABLE "+ TABELA_CENTRO +" ( ");
        mapaBuilder.append(ID+" integer primary key autoincrement, ");
        mapaBuilder.append(CENTRO_NOME +" text not null unique, ");
        mapaBuilder.append(CENTRO_TELEFONE + " text, ");
        mapaBuilder.append(CENTRO_ENDERECO +" text not null, ");
        mapaBuilder.append(CENTRO_LATLNG +" text, ");
        mapaBuilder.append(CENTRO_PLANO_SAUDE +" text);");
        mapaBuilder.append(CENTRO_ESPECIALIZACAO +" text);");
        return mapaBuilder.toString();
    }


    protected String cmdWhere(String tabela, String a, String b){
        return "SELECT * FROM " + tabela + " WHERE " + a + " LIKE ? AND " + b + " LIKE ?";
    }
    protected String cmdWhere(String tabela, String a){
        return "SELECT * FROM " + tabela + " WHERE " + a + " LIKE ?";
    }
    protected String cmdWhereValues(String tabela, String coluna, String valor){
        return "SELECT * FROM" + tabela +" WHERE " + coluna + " LIKE " + valor;
    }
    public String povoar(){

        String hospitais = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('Hospital Unimed Recife III', '(81)3320-7500', 'Rua Jose De Alencar, 770, Boa Vista', '-8.0645592/-34.8939489', 'UNIMED', 'Geral')," +
                " ('Hospital Santa Joana', '(81)3216-6666', 'Rua Joaquim Nabuco 200, Graças', '-8.052643/-34.8984431', 'SULAMERICA', 'Geral')," +
                " ('Real Hospital Portugues', '(81)3416-1122', 'Avenida portugal, 163, Paissandu', '-8.0670954/-34.8974943', 'UNIMED', 'Geral')," +
                " ('Hospital Memorial São José', '(81)3216-2222', 'Avenida agamenom magalhaes, 2291, Boa vista', '-8.0597126/-34.8974337', 'UNIMED', 'Geral')," +
                " ('Hospital Jayme da Fonte', '(81)3416-0037', 'Rua das pernambucanas, 103, Graças', '-8.0511732/-34.9004814', 'UNIMED', 'Cirugia geral,Clínica médica')," +
                " ('Hospital Esperança', '(81)3131-7878', 'Rua antonio gomes de freitas, 265, Ilha do leite', '-8.0670954/-34.8974943', 'UNIMED', 'Cirurgia cardíaca pediátrica, Cirurgia neurológica pediátrica')," +
                " ('HOPE - Hospital de Olhos do Recife', '(81)3302-2040', 'Rua francisco alves, 887, Ilha leite', '-8.0667061/-34.8963314', 'UNIMED', 'Oftalmologia')," +
                " ('Hospital de Ortopedia e Fratura', '(81)3092-9777', 'Avenida rui barbosa, 1541, Graças', '-8.0401013/-34.9062553', 'UNIMED', 'Ortopedia e Traumatologia')," +
                " ('Centro de Atenção Psicosocial Casa Forte', '(81)3441-0433', 'Rua marechal rondon, 256, Casa forte', '-8.0295025/-34.9238109', 'UNIMED', 'Psiquiatria')," +
                " ('Centro de Atenção Psicosocial Casa Forte', '(81)3441-0433', 'Rua marechal rondon, 256, Casa forte', '-8.0295025/-34.9238109', 'UNIMED', 'Psiquiatria')," +
                " ('Hospital de Avila', '(81)3117-5544', 'Av Visconde de Albuquerque 681, Madalena', '-8.0522372/-34.9090992', 'SULAMERICA', 'Geral')," +
                " ('Hospital Albert Sabin', '(81)3131-7400', 'R. Sen. José Henrique, 141 - Ilha do Leite', '-8.0659779/-34.8976523', 'UNIMED', 'Cirurgia Geral, Clínica Médica')," +
                " ('Hapvida_Espinheiro', '(81)40022870', 'R. Jose Luis da Silveira Barros. 134 - Espinheiro', '-8.0354903/-34.9162013', 'HAPVIDA', 'Dermatologia, Cardiologia e Ortopedia');";
        
        return hospitais;
    }
}

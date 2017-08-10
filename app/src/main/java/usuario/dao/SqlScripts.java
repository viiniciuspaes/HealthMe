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
        //mapaBuilder.append(ID+" integer primary key autoincrement, ");
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
    public void bancoLugares(Context context){

        centroSaudeDao = new CentroSaudeDao(context);

        PlanoSaude unimed = new PlanoSaude();
        unimed.setNome("UNIMED");
        PlanoSaude sulAmerca = new PlanoSaude();
        unimed.setNome("SULAMERICA");
        PlanoSaude hapVida = new PlanoSaude();
        unimed.setNome("HAPVIDA");

        LatLng unimed3L = new LatLng(-8.0645592,-34.8939489);
        CentroSaude unimed3 = new CentroSaude();
        unimed3.setLocalizacao(unimed3L);
        unimed3.setNome("Hospital Unimed Recife III");
        unimed3.setEndereco("Rua Jose De Alencar, 770, Boa Vista");
        unimed3.setTelefone("(81) 3320-7500");
        unimed3.setEspecializacao("Geral");
        unimed3.setPlanoSaude(unimed);

        LatLng albertL = new LatLng(-8.0659779,-34.8976523);
        CentroSaude albert = new CentroSaude();
        albert.setLocalizacao(albertL);
        albert.setNome("Hospital Albert Sabin");
        albert.setEndereco("R. Sen. José Henrique, 141 - Ilha do Leite");
        albert.setTelefone("(81)3131-7400");
        albert.setEspecializacao("Cirurgia Geral, Clínica Médica");
        albert.setPlanoSaude(unimed);
        // Obs: PLANOS DO ALBERT: unimed,camed,sulamerica

        LatLng memorialSaoJoseL= new LatLng(-8.0597126,-34.8974337);
        CentroSaude memorialSaoJose = new CentroSaude();
        memorialSaoJose.setLocalizacao(memorialSaoJoseL);
        memorialSaoJose.setNome("Hospital Memorial São José");
        memorialSaoJose.setEndereco("Avenida agamenom magalhaes, 2291, Boa vista");
        memorialSaoJose.setTelefone("(81)3216-2222");
        memorialSaoJose.setEspecializacao("Geral");
        memorialSaoJose.setPlanoSaude(unimed);

        LatLng hopeL = new LatLng(-8.0667061,-34.8963314);
        CentroSaude hope = new CentroSaude();
        hope.setLocalizacao(hopeL);
        hope.setNome("HOPE - Hospital de Olhos do Recife");
        hope.setEndereco("Rua francisco alves, 887, Ilha leite");
        hope.setTelefone("(81)3302-2040");
        hope.setEspecializacao("Oftalmologia");
        hope.setPlanoSaude(unimed);

        LatLng hoofL = new LatLng(-8.0401013,-34.9062553);
        CentroSaude hoof = new CentroSaude();
        hoof.setLocalizacao(hoofL);
        hoof.setNome("Hospital de Ortopedia e Fratura");
        hoof.setEndereco("Avenida rui barbosa, 1541, Graças");
        hoof.setTelefone("(81)3092-9777");
        hoof.setEspecializacao("ortopedia e traumatologia");
        hoof.setPlanoSaude(unimed);

        LatLng hoseL = new LatLng(-8.0670954,-34.8974943);
        CentroSaude hose = new CentroSaude();
        hose.setLocalizacao(hoseL);
        hose.setNome("Hospital Esperança");
        hose.setEndereco("Rua antonio gomes de freitas, 265, Ilha do leite");
        hose.setTelefone("(81)3131-7878");
        hose.setEspecializacao("cirurgia cardíaca pediátrica, cirurgia neurológica pediátrica");
        hose.setPlanoSaude(unimed);

        LatLng rhosL = new LatLng(-8.0670954,-34.8974943);
        CentroSaude rhos = new CentroSaude();
        rhos.setLocalizacao(rhosL);
        rhos.setNome("Real Hospital Portugues");
        rhos.setEndereco("Avenida portugal, 163, Paissandu");
        rhos.setTelefone("(81)3416-1122");
        rhos.setEspecializacao("Geral");
        rhos.setPlanoSaude(unimed);

        LatLng capsL = new LatLng(-8.0295025,-34.9238109);
        CentroSaude caps = new CentroSaude();
        caps.setLocalizacao(capsL);
        caps.setNome("Centro de Atenção Psicosocial Casa Forte");
        caps.setEndereco("Rua marechal rondon, 256, Casa forte");
        caps.setTelefone("(81)3441-0433");
        caps.setEspecializacao("Psiquiatria");
        caps.setPlanoSaude(unimed);

        LatLng jayL = new LatLng(-8.0511732,-34.9004814);
        CentroSaude jay = new CentroSaude();
        jay.setLocalizacao(jayL);
        jay.setNome("Hospital Jayme da Fonte");
        jay.setEndereco("Rua das pernambucanas, 103, Graças");
        jay.setTelefone("(81)3416-0037");
        jay.setEspecializacao("Cirugia geral,Clínica médica");
        jay.setPlanoSaude(unimed);

// PLANO sulamerica

        LatLng stajL= new LatLng(-8.052643,-34.8984431);
        CentroSaude staj = new CentroSaude();
        staj.setLocalizacao(stajL);
        staj.setNome("Hospital Santa Joana");
        staj.setEndereco("Rua Joaquim Nabuco 200, Graças");
        staj.setTelefone("(81)3216-6666");
        staj.setEspecializacao("Geral");
        staj.setPlanoSaude(sulAmerca);

        LatLng avilaL = new LatLng(-8.0522372,-34.9090992);
        CentroSaude avila = new CentroSaude();
        avila.setLocalizacao(avilaL);
        avila.setNome("Hospital de Avila");
        avila.setEndereco("Av Visconde de Albuquerque 681, Madalena");
        avila.setTelefone("(81)3117-5544");
        avila.setEspecializacao("Geral");
        avila.setPlanoSaude(sulAmerca);

//Hapvida

        LatLng hapesL= new LatLng(-8.0354903,-34.9162013);
        CentroSaude hapes = new CentroSaude();
        hapes.setLocalizacao(hapesL);
        hapes.setNome("Hapvida Espinheiro");
        hapes.setEndereco("R. José Luís da Silveira Barros, 134 - Espinheiro");
        hapes.setTelefone("(81)4002-2870");
        hapes.setEspecializacao("Dermatologia, Cardiologia e Ortopedia");
        hapes.setPlanoSaude(hapVida);

        centroSaudeDao.inserirCentro(albert);
        centroSaudeDao.inserirCentro(avila);
        centroSaudeDao.inserirCentro(caps);
        centroSaudeDao.inserirCentro(hapes);
        centroSaudeDao.inserirCentro(hoof);
        centroSaudeDao.inserirCentro(hope);
        centroSaudeDao.inserirCentro(hose);
        centroSaudeDao.inserirCentro(jay);
        centroSaudeDao.inserirCentro(memorialSaoJose);
        centroSaudeDao.inserirCentro(rhos);
        centroSaudeDao.inserirCentro(staj);
        centroSaudeDao.inserirCentro(unimed3);

    }
    public String povoar(){

        //Faz um Array para jogar num for no on create para botar todos

        String hapes = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('Hapvida_Espinheiro', '(81)40022870', 'R. Jose Luis da Silveira Barros. 134 - Espinheiro', '-8.0354903/-34.9162013', 'HAPVIDA', 'Dermatologia, Cardiologia e Ortopedia')," +
                " ('','','','','','');";

        String albert = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('Hospital Albert Sabin', '(81)3131-7400', 'R. Sen. José Henrique, 141 - Ilha do Leite', '-8.0659779/-34.8976523', 'UNIMED', 'Cirurgia Geral, Clínica Médica')," +
                " ('','','','','','');";

        String avila = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('Hospital de Avila', '(81)3117-5544', 'Av Visconde de Albuquerque 681, Madalena', '-8.0522372/-34.9090992', 'SULAMERICA', 'Geral')," +
                " ('','','','','','');";

        String caps = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('Centro de Atenção Psicosocial Casa Forte', '(81)3441-0433', 'Rua marechal rondon, 256, Casa forte', '-8.0295025/-34.9238109', 'UNIMED', 'Psiquiatria')," +
                " ('','','','','','');";

        String hoof = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('Hospital de Ortopedia e Fratura', '(81)3092-9777', 'Avenida rui barbosa, 1541, Graças', '-8.0401013/-34.9062553', 'UNIMED', 'Ortopedia e Traumatologia')," +
                " ('','','','','','');";

        String hope = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('HOPE - Hospital de Olhos do Recife', '(81)3302-2040', 'Rua francisco alves, 887, Ilha leite', '-8.0667061/-34.8963314', 'UNIMED', 'Oftalmologia')," +
                " ('','','','','','');";

        String hose = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('Hospital Esperança', '(81)3131-7878', 'Rua antonio gomes de freitas, 265, Ilha do leite', '-8.0670954/-34.8974943', 'UNIMED', 'Cirurgia cardíaca pediátrica, Cirurgia neurológica pediátrica')," +
                " ('','','','','','');";

        String jay = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('Hospital Jayme da Fonte', '(81)3416-0037', 'Rua das pernambucanas, 103, Graças', '-8.0511732/-34.9004814', 'UNIMED', 'Cirugia geral,Clínica médica')," +
                " ('','','','','','');";

        String memorialSaoJose = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('Hospital Memorial São José', '(81)3216-2222', 'Avenida agamenom magalhaes, 2291, Boa vista', '-8.0597126/-34.8974337', 'UNIMED', 'Geral')," +
                " ('','','','','','');";

        String rhos = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('Real Hospital Portugues', '(81)3416-1122', 'Avenida portugal, 163, Paissandu', '-8.0670954/-34.8974943', 'UNIMED', 'Geral')," +
                " ('','','','','','');";

        String staj = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('Hospital Santa Joana', '(81)3216-6666', 'Rua Joaquim Nabuco 200, Graças', '-8.052643/-34.8984431', 'SULAMERICA', 'Geral')," +
                " ('','','','','','');";

        String unimed3 = " INSERT INTO "+TABELA_CENTRO+" ("+CENTRO_NOME+","+CENTRO_TELEFONE+","+
                CENTRO_ENDERECO+","+CENTRO_LATLNG+","+CENTRO_PLANO_SAUDE+","+CENTRO_ESPECIALIZACAO+
                ") VALUES ('Hospital Unimed Recife III', '(81)3320-7500', 'Rua Jose De Alencar, 770, Boa Vista', '-8.0645592/-34.8939489', 'UNIMED', 'Geral')," +
                " ('','','','','','');";
        
        return hapes;
    }
}

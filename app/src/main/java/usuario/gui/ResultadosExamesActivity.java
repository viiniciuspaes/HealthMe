package usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import rede.RedeBayesiana;

public class ResultadosExamesActivity extends AppCompatActivity {

    private RedeBayesiana redeBayesiana;
    private ArrayList<String> arrayRespostas;
    private ArrayList<String> dados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_exames);

        arrayRespostas = getIntent().getExtras().getStringArrayList("lista");
        redeBayesiana = new RedeBayesiana();
        dados = new ArrayList<>();

        ListView lista = (ListView) findViewById(R.id.lvResultados);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, probabilidade());
        lista.setAdapter(arrayAdapter);

    }
    public void usarperguntaAperguntaBperguntaD(){
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasABD());
        }
    }
    public void usarperguntaAperguntaNBperguntaD(){
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasANBD());
        }
    }
    public void usarperguntaNAperguntaBperguntaD(){
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasNABD());
        }
    }
    public void usarperguntaNAperguntaNBperguntaD(){
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasNANBD());
        }
    }
    public void usarperguntaNAperguntaNBperguntaND(){
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasNANBND());
        }
    }
    public void usaperguntaAperguntaBperguntaND(){
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasABND());
        }
    }
    public void usarperguntaNAperguntaBperguntaND(){
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasNABND());
        }
    }
    public void usarperguntaAperguntaNBperguntaND(){
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasANBND());
        }
    }
    public void usarperguntaCperguntaDperguntaF(){
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("sim") && arrayRespostas.get(5).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasCDF());
        }
    }
    public void usarperguntaCperguntaNDperguntaF(){
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("nao") && arrayRespostas.get(5).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasCNDF());
        }
    }
    public void usarperguntaNCperguntaDrespostaF(){
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("sim") && arrayRespostas.get(5).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasNCDF());
        }
    }
    public void usarperguntaNCpergundaNDrespostaF(){
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("nao") && arrayRespostas.get(5).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasNCNDF());
        }
    }
    public void usarperguntaNCperguntaNDperguntaNF(){
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("nao") && arrayRespostas.get(5).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasNCNDNF());
        }
    }
    public void usaperguntaCperguntaDperguntaNF(){
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("sim") && arrayRespostas.get(5).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasCDNF());
        }
    }
    public void usarperguntaNCperguntaDperguntaNF(){
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("sim") && arrayRespostas.get(5).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasNCDNF());
        }
    }
    public void usarperguntaCperguntaNDperguntaNF(){
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("nao") && arrayRespostas.get(5).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasCNDNF());
        }
    }
    public void usarperguntaEperguntaFperguntaD(){
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasEFD());
        }
    }
    public void usarperguntaEperguntaNFrespostaD(){
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasENFD());
        }
    }
    public void usarperguntaNEperguntaFperguntaD(){
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasNEFD());
        }
    }
    public void usarperguntaNEperguntaNFperguntaD(){
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasNENFD());
        }
    }
    public void usarperguntaNEperguntaNFperguntaND(){
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasNENFND());
        }
    }
    public void usaperguntaEperguntaFperguntaND(){
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasEFND());
        }
    }
    public void usarperguntaNEperguntaFperguntaND(){
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasNEFND());
        }
    }
    public void usarperguntaEperguntaNFperguntaND(){
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasENFND());
        }
    }
    public List<String> probabilidade(){

        usarperguntaAperguntaBperguntaD();
        usarperguntaAperguntaNBperguntaD();
        usarperguntaNAperguntaBperguntaD();
        usarperguntaNAperguntaNBperguntaD();
        usarperguntaNAperguntaNBperguntaND();
        usaperguntaAperguntaBperguntaND();
        usarperguntaNAperguntaBperguntaND();
        usarperguntaAperguntaNBperguntaND();
        usarperguntaCperguntaDperguntaF();
        usarperguntaCperguntaNDperguntaF();
        usarperguntaNCperguntaDrespostaF();
        usarperguntaNCpergundaNDrespostaF();
        usarperguntaNCperguntaNDperguntaNF();
        usaperguntaCperguntaDperguntaNF();
        usarperguntaNCperguntaDperguntaNF();
        usarperguntaCperguntaNDperguntaNF();
        usarperguntaEperguntaFperguntaD();
        usarperguntaEperguntaNFrespostaD();
        usarperguntaNEperguntaFperguntaD();
        usarperguntaNEperguntaNFperguntaD();
        usarperguntaNEperguntaNFperguntaND();
        usaperguntaEperguntaFperguntaND();
        usarperguntaNEperguntaFperguntaND();
        usarperguntaEperguntaNFperguntaND();
        return dados;
    }
    public void voltarParaHome(View view) throws Exception{
       startActivity(new Intent(ResultadosExamesActivity.this, TelaInicialNavActivity.class));
   }
}

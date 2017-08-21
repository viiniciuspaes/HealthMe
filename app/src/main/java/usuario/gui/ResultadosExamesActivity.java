package usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import usuario.negocio.MinhaRedeBayesiana;

public class ResultadosExamesActivity extends AppCompatActivity {

    private MinhaRedeBayesiana redeBayesiana;
    private ArrayList<String> arrayRespostas;
    private ArrayList<ArrayList<String>> resultados;
    private ArrayList<String> dados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_exames);

        arrayRespostas = getIntent().getExtras().getStringArrayList("lista");
        redeBayesiana = new MinhaRedeBayesiana();

        ListView lista = (ListView) findViewById(R.id.lvResultados);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, probabilidade());
        lista.setAdapter(arrayAdapter);

    }
    public void usarperguntaAperguntaBperguntaD(){
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaAperguntaBperguntaD());
        }
    }
    public void usarperguntaAperguntaNBperguntaD(){
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaAperguntaNBperguntaD());
        }
    }
    public void usarperguntaNAperguntaBperguntaD(){
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaNAperguntaBperguntaD());
        }
    }
    public void usarperguntaNAperguntaNBperguntaD(){
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaNAperguntaNBperguntaD());
        }
    }
    public void usarperguntaNAperguntaNBperguntaND(){
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaNAperguntaNBperguntaND());
        }
    }
    public void usaperguntaAperguntaBperguntaND(){
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaAperguntaBperguntaND());
        }
    }
    public void usarperguntaNAperguntaBperguntaND(){
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaNAperguntaBperguntaND());
        }
    }
    public void usarperguntaAperguntaNBperguntaND(){
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaAperguntaNBperguntaND());
        }
    }
    public void usarperguntaCperguntaD(){
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.perguntaCperguntaD());
        }
    }
    public void usarperguntaCperguntaND(){
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.perguntaCperguntaND());
        }
    }
    public void usarperguntaNCperguntaD(){
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.perguntaNCperguntaD());
        }
    }
    public void usarperguntaNCpergundaND(){
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.perguntaNCpergundaND());
        }
    }
    public void usarperguntaEperguntaF(){
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.perguntaEperguntaF());
        }
    }
    public void usarperguntaEperguntaNF(){
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.perguntaEperguntaNF());
        }
    }
    public void usarperguntaNEperguntaF(){
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.perguntaNEperguntaF());
        }
    }
    public void usarperguntaNEperguntaNF(){
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.perguntaNEperguntaNF());
        }
    }
    public ArrayList<String> probabilidade(){

        ArrayList<String> dados = new ArrayList<>();
        usarperguntaAperguntaBperguntaD();
        usarperguntaAperguntaNBperguntaD();
        usarperguntaNAperguntaBperguntaD();
        usarperguntaNAperguntaNBperguntaD();
        usarperguntaNAperguntaNBperguntaND();
        usaperguntaAperguntaBperguntaND();
        usarperguntaNAperguntaBperguntaND();
        usarperguntaAperguntaNBperguntaND();
        usarperguntaCperguntaD();
        usarperguntaCperguntaND();
        usarperguntaNCperguntaD();
        usarperguntaNCpergundaND();
        usarperguntaEperguntaF();
        usarperguntaEperguntaNF();
        usarperguntaNEperguntaF();
        usarperguntaNEperguntaNF();
        return dados;
    }
    public void voltarParaHome(View view) throws Exception{
       startActivity(new Intent(ResultadosExamesActivity.this, TelaInicialNavActivity.class));
   }
}

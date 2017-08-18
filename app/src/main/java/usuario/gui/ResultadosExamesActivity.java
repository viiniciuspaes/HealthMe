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
    public ArrayList<String> probabilidade(){

        ArrayList<String> dados = new ArrayList<>();
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaAperguntaBperguntaD());
        }
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaAperguntaNBperguntaD());
        }
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaNAperguntaBperguntaD());
        }
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaNAperguntaNBperguntaD());
        }
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaNAperguntaNBperguntaND());
        }
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaAperguntaBperguntaND());
        }
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaNAperguntaBperguntaND());
        }
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.perguntaAperguntaNBperguntaND());
        }
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.perguntaCperguntaD());
        }
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.perguntaCperguntaND());
        }
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.perguntaNCperguntaD());
        }
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.perguntaNCpergundaND());
        }
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.perguntaEperguntaF());
        }
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.perguntaEperguntaNF());
        }
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.perguntaNEperguntaF());
        }
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.perguntaNEperguntaNF());
        }
        return dados;
    }
    public void voltarParaHome(View view) throws Exception{
       startActivity(new Intent(ResultadosExamesActivity.this, TelaInicialNavActivity.class));
   }
}

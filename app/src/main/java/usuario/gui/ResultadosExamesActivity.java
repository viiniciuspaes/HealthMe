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

        arrayRespostas =getIntent().getExtras().getStringArrayList("lista");
        redeBayesiana = new MinhaRedeBayesiana();


        ListView lista = (ListView) findViewById(R.id.lvResultados);
        //resultados.add(probabilidade());
        //resultados.add(probabilidade());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, probabilidade());
        lista.setAdapter(arrayAdapter);

       // ArrayList<String> respostas = ResultadosExamesActivity.respostas;

        //ArrayList<String> dados = new ArrayList<String>();


    }
    public ArrayList<String> probabilidade(){

        ArrayList<String> dados = new ArrayList<>();

        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.a_e_b());


        }
        return dados;
    }

    public void voltarParaHome(View view) throws Exception{
       startActivity(new Intent(ResultadosExamesActivity.this, TelaInicialNavActivity.class));
   }
}

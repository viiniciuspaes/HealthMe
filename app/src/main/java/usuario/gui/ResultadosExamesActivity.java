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
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.a_e_b_e_d());
        }
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.a_e_nb());
        }
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.na_e_b());
        }
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.na_e_nb());
        }
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.c_e_d());
        }
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.c_e_nd());
        }
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.nc_e_d());
        }
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.nc_e_nd());
        }
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.e_e_f());
        }
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.e_e_nf());
        }
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.ne_e_f());
        }
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.ne_e_nf());
        }
        return dados;
    }
    public void voltarParaHome(View view) throws Exception{
       startActivity(new Intent(ResultadosExamesActivity.this, TelaInicialNavActivity.class));
   }
}

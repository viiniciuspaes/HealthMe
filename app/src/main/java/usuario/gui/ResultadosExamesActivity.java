package usuario.gui;

import android.content.Context;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_exames);
        ArrayList<String> arrayRespostas =getIntent().getExtras().getStringArrayList("lista");


        ListView lista = (ListView) findViewById(R.id.lvResultados);

        //ArrayList<String> resultados = probabilidade();

       // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultados);
       // lista.setAdapter(arrayAdapter);

       // ArrayList<String> respostas = ResultadosExamesActivity.respostas;


    }

   public void voltarParaHome(View view) throws Exception{
       startActivity(new Intent(ResultadosExamesActivity.this, TelaInicialNavActivity.class));
   }
}

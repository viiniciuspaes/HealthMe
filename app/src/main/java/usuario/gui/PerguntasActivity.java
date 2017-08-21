package usuario.gui;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class PerguntasActivity extends AppCompatActivity {

    private RadioButton rbPergunta1Sim;
    private RadioButton rbPergunta1Nao;

    private RadioButton rbPergunta2Sim;
    private RadioButton rbPergunta2Nao;

    private RadioButton rbPergunta3Sim;
    private RadioButton rbPergunta3Nao;

    private RadioButton rbPergunta4Sim;
    private RadioButton rbPergunta4Nao;

    private RadioButton rbPergunta5Sim;
    private RadioButton rbPergunta5Nao;

    private RadioButton rbPergunta6Sim;
    private RadioButton rbPergunta6Nao;



    private ArrayList<String> respostas = new ArrayList<String>(6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);

        rbPergunta1Sim = (RadioButton) findViewById(R.id.rb_SimPergunta1);
        rbPergunta1Nao = (RadioButton) findViewById(R.id.rb_NaoPergunta1);

        rbPergunta2Sim = (RadioButton) findViewById(R.id.rb_SimPergunta2);
        rbPergunta2Nao = (RadioButton) findViewById(R.id.rb_NaoPergunta2);

        rbPergunta3Sim = (RadioButton) findViewById(R.id.rb_SimPergunta3);
        rbPergunta3Nao = (RadioButton) findViewById(R.id.rb_NaoPergunta3);

        rbPergunta4Sim = (RadioButton) findViewById(R.id.rb_SimPergunta4);
        rbPergunta4Nao = (RadioButton) findViewById(R.id.rb_NaoPergunta4);

        rbPergunta5Sim = (RadioButton) findViewById(R.id.rb_SimPergunta5);
        rbPergunta5Nao = (RadioButton) findViewById(R.id.rb_NaoPergunta5);

        rbPergunta6Sim = (RadioButton) findViewById(R.id.rb_SimPergunta6);
        rbPergunta6Nao = (RadioButton) findViewById(R.id.rb_NaoPergunta6);
    }

    public void verificarMarcacao(){
        if (rbPergunta1Sim.isChecked()){
            respostas.add(0,"sim");
        }
        if (rbPergunta1Nao.isChecked()){
            respostas.add(0, "nao");
        }
        if (rbPergunta2Sim.isChecked()){
            respostas.add(1,"sim");
        }
        if (rbPergunta2Nao.isChecked()){
            respostas.add(1, "nao");
        }
        if (rbPergunta3Sim.isChecked()){
            respostas.add(2,"sim");
        }
        if (rbPergunta3Nao.isChecked()){
            respostas.add(2, "nao");
        }
        if (rbPergunta4Sim.isChecked()){
            respostas.add(3,"sim");
        }
        if (rbPergunta4Nao.isChecked()){
            respostas.add(3, "nao");
        }
        if (rbPergunta5Sim.isChecked()){
            respostas.add(4,"sim");
        }
        if (rbPergunta5Nao.isChecked()){
            respostas.add(4, "nao");
        }
        if (rbPergunta6Sim.isChecked()){
            respostas.add(5,"sim");
        }
        if (rbPergunta6Nao.isChecked()){
            respostas.add(5, "nao");
        }

    }
    public void finalizar(View view) throws Exception{
        verificarMarcacao();
        Intent intent = new Intent(PerguntasActivity.this, ResultadosExamesActivity.class);
        intent.putStringArrayListExtra("lista",respostas);
        startActivity(intent);
        finish();
    }
}

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

/**
 * <h1>PerguntasActivity</h1>
 * Activity responsavel pelas funcionalidade das Perguntas do aplicativo.
 */

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

    private int contador = 0;

    private ArrayList<String> respostas = new ArrayList<String>(6);

    /**
     * O metodo onCreate() tem a funcionalidade de setar a layout activity_perguntas e setar os
     * RadioButtons da activity.
     *
     * @param savedInstanceState Objeto da classe Bundle que contem o estado anterior da activity
     */
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

    /**
     * O metodo verificarPergunta() tem a funcionalidade de verificar se a pergunta estar repondida
     * com sim ou nao e adiciionar na ArrayList.
     *
     * @param rb1 RadioButton relacionado as caixas: sim.
     * @param rb2 RadioButton relacionado as caixas: nao.
     * @param cont Contador int para adicionar cada resposta em ordem na ArrayList.
     * @return Retorna o contador int.
     */
    public int verificarPergunta(RadioButton rb1,RadioButton rb2, int cont) {
        if (rb1.isChecked()) {
            respostas.add(cont, "sim");
        }
        if (rb2.isChecked()) {
            respostas.add(cont, "nao");
        }
        return contador = ++cont;
    }

    /**
     * O metodo finalizar() tem a funcionalidade de verificar as perguntas e depois envia-las para
     * a activity ResultadosExamesActivity().
     *
     * @see ResultadosExamesActivity
     * @param view Contem o que foi observado na activity.
     * @throws Exception Excecao de erro java.
     */

    public void finalizar(View view) throws Exception{
        verificarPergunta(rbPergunta1Sim,rbPergunta1Nao,contador);
        verificarPergunta(rbPergunta2Sim,rbPergunta2Nao,contador);
        verificarPergunta(rbPergunta3Sim,rbPergunta3Nao,contador);
        verificarPergunta(rbPergunta4Sim,rbPergunta4Nao,contador);
        verificarPergunta(rbPergunta5Sim,rbPergunta5Nao,contador);
        verificarPergunta(rbPergunta6Sim,rbPergunta6Nao,contador);
        Intent intent = new Intent(PerguntasActivity.this, ResultadosExamesActivity.class);
        intent.putStringArrayListExtra("lista",respostas);
        startActivity(intent);
        finish();
    }
}
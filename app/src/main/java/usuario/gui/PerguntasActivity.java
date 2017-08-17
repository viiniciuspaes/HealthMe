package usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

public class PerguntasActivity extends AppCompatActivity {

    private CheckBox cbPergunta1Sim;
    private CheckBox cbPergunta1nao;

    private CheckBox cbPergunta2Sim;
    private CheckBox cbPergunta2Nao;

    private CheckBox cbPergunta3Sim;
    private CheckBox cbPergunta3Nao;

    private CheckBox cbPergunta4Sim;
    private CheckBox cbPergunta4Nao;

    private CheckBox cbPergunta5Sim;
    private CheckBox cbPergunta5Nao;

    private CheckBox cbPergunta6Sim;
    private CheckBox cbPergunta6Nao;

    ArrayList<String> respostas = new ArrayList<String>(6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);

        cbPergunta1Sim = (CheckBox) findViewById(R.id.cb_SimPergunta1);
        cbPergunta1nao = (CheckBox) findViewById(R.id.cb_NaoPergunta1);

        cbPergunta2Sim = (CheckBox) findViewById(R.id.cb_SimPergunta2);
        cbPergunta2Nao = (CheckBox) findViewById(R.id.cb_NaoPergunta2);

        cbPergunta3Sim = (CheckBox) findViewById(R.id.cb_SimPergunta3);
        cbPergunta3Nao = (CheckBox) findViewById(R.id.cb_NaoPergunta3);

        cbPergunta4Sim = (CheckBox) findViewById(R.id.cb_SimPergunta4);
        cbPergunta4Nao = (CheckBox) findViewById(R.id.cb_NaoPergunta4);

        cbPergunta5Sim = (CheckBox) findViewById(R.id.cb_SimPergunta5);
        cbPergunta5Nao = (CheckBox) findViewById(R.id.cb_NaoPergunta5);

        cbPergunta6Sim = (CheckBox) findViewById(R.id.cb_SimPergunta6);
        cbPergunta6Nao = (CheckBox) findViewById(R.id.cb_NaoPergunta6);

        checkPergunta1();
        checkPergunta2();
        checkPergunta3();
        checkPergunta4();
        checkPergunta5();
        checkPergunta6();
    }

    public void checkPergunta1(){
        cbPergunta1Sim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    respostas.add(0,"sim");
                    cbPergunta1nao.setChecked(false);
                }
            }
        });
        cbPergunta1nao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    respostas.add(0,"não");
                    cbPergunta1Sim.setChecked(false);
                }
            }
        });
    }

    public void checkPergunta2(){
        cbPergunta2Sim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    respostas.add(1,"sim");
                    cbPergunta2Nao.setChecked(false);
                }
            }
        });
        cbPergunta2Nao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    respostas.add(1,"nao");
                    cbPergunta2Sim.setChecked(false);
                }
            }
        });
    }

    public void checkPergunta3(){
        cbPergunta3Sim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    respostas.add(2,"sim");
                    cbPergunta3Nao.setChecked(false);
                }
            }
        });
        cbPergunta3Nao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    respostas.add(2,"nao");
                    cbPergunta3Sim.setChecked(false);
                }
            }
        });
    }

    public void checkPergunta4(){
        cbPergunta4Sim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    respostas.add(3,"sim");
                    cbPergunta4Nao.setChecked(false);
                }
            }
        });
        cbPergunta4Nao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    respostas.add(3,"nao");
                    cbPergunta4Sim.setChecked(false);
                }
            }
        });
    }

    public void checkPergunta5(){
        cbPergunta5Sim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    respostas.add(4,"sim");
                    cbPergunta5Nao.setChecked(false);
                }
            }
        });
        cbPergunta5Nao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    respostas.add(4,"nao");
                    cbPergunta5Sim.setChecked(false);
                }
            }
        });
    }

    public void checkPergunta6(){
        cbPergunta6Sim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    respostas.add(5,"sim");
                    cbPergunta6Nao.setChecked(false);
                }
            }
        });
        cbPergunta6Nao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    respostas.add(5,"nao");
                    cbPergunta6Sim.setChecked(false);
                }
            }
        });
    }

    public void finalizar(View view) throws Exception{
        Intent intent = new Intent(PerguntasActivity.this, ResultadosExamesActivity.class);
        intent.putStringArrayListExtra("lista",respostas);
        startActivity(intent);
        //respostas.clear();
    }
}

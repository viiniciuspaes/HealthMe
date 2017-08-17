package usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class PerguntasActivity extends AppCompatActivity {
    private CheckBox cbPergunta1SIM;
    private CheckBox cbPergunta1NAO;

    private CheckBox cbPergunta2SIM;
    private CheckBox cbPergunta2NAO;

    private CheckBox cbPergunta3SIM;
    private CheckBox cbPergunta3NAO;

    private CheckBox cbPergunta4SIM;
    private CheckBox cbPergunta4NAO;

    private CheckBox cbPergunta5SIM;
    private CheckBox cbPergunta5NAO;

    private CheckBox cbPergunta6SIM;
    private CheckBox cbPergunta6NAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);

        cbPergunta1SIM = (CheckBox) findViewById(R.id.cb_SimPergunta1);
        cbPergunta1NAO = (CheckBox) findViewById(R.id.cb_NaoPergunta1);

        cbPergunta2SIM = (CheckBox) findViewById(R.id.cb_SimPergunta2);
        cbPergunta2NAO = (CheckBox) findViewById(R.id.cb_NaoPergunta2);

        cbPergunta3SIM = (CheckBox) findViewById(R.id.cb_SimPergunta3);
        cbPergunta3NAO = (CheckBox) findViewById(R.id.cb_NaoPergunta3);

        cbPergunta4SIM = (CheckBox) findViewById(R.id.cb_SimPergunta4);
        cbPergunta4NAO = (CheckBox) findViewById(R.id.cb_NaoPergunta4);

        cbPergunta5SIM = (CheckBox) findViewById(R.id.cb_SimPergunta5);
        cbPergunta5NAO = (CheckBox) findViewById(R.id.cb_NaoPergunta5);

        cbPergunta6SIM = (CheckBox) findViewById(R.id.cb_SimPergunta6);
        cbPergunta6NAO = (CheckBox) findViewById(R.id.cb_NaoPergunta6);

        check1();
        check2();
        check3();
        check4();
        check5();
        check6();
    }
    public void check1(){
        cbPergunta1SIM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    cbPergunta1NAO.setChecked(false);
                }
            }
        });

        cbPergunta1NAO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbPergunta1SIM.setChecked(false);
                }
            }
        });

    }
    public void check2(){
        cbPergunta2SIM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    cbPergunta2NAO.setChecked(false);
                }
            }
        });
        cbPergunta2NAO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbPergunta2SIM.setChecked(false);
                }
            }
        });
    }

    public void check3(){
        cbPergunta3SIM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    cbPergunta3NAO.setChecked(false);
                }
            }
        });
        cbPergunta3NAO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbPergunta3SIM.setChecked(false);
                }
            }
        });
    }

    public void check4(){
        cbPergunta4SIM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    cbPergunta4NAO.setChecked(false);
                }
            }
        });
        cbPergunta4NAO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbPergunta4SIM.setChecked(false);
                }
            }
        });
    }

    public void check5(){
        cbPergunta5SIM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    cbPergunta5NAO.setChecked(false);
                }
            }
        });
        cbPergunta5NAO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbPergunta5SIM.setChecked(false);
                }
            }
        });
    }

    public void check6(){
        cbPergunta6SIM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    cbPergunta6NAO.setChecked(false);
                }
            }
        });
        cbPergunta6NAO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbPergunta6SIM.setChecked(false);
                }
            }
        });
    }

    public void Finalizar(){
        startActivity(new Intent(PerguntasActivity.this, ResultadosExamesActivity.class));
    }
}

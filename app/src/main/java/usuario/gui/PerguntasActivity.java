package usuario.gui;

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
        cbPergunta1NAO = (CheckBox) findViewById(R.id.cb_Naoergunta1);

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
    }



}

package mpoo.gui;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import negocio.SessaoUsuario;


public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private SessaoUsuario sessao;
    private TextView boasVindas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bemVindo();
    }
    public void bemVindo(){
        preferences = getSharedPreferences("user", Context.MODE_APPEND);
        sessao = new SessaoUsuario(preferences);
        sessao.iniciarSessao(getApplicationContext());
        boasVindas = (TextView)findViewById(R.id.boasVindas);
        String bemvindo = boasVindas.getText().toString() +  sessao.getUsuarioLogado().getNome();
        boasVindas.setText(bemvindo);
    }
}

package mpoo.gui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import negocio.SessaoUsuario;


public class TelaInicialActivity extends AppCompatActivity {
    private SharedPreferences preferences = getSharedPreferences("user", Context.MODE_APPEND);
    private SessaoUsuario sessao = new SessaoUsuario(preferences);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ok);

        sessao.iniciarSessao(getApplicationContext());
    }

}
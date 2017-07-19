package mpoo.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import dao.SessaoDao;
import negocio.SessaoUsuario;


public class TelaInicialActivity extends AppCompatActivity {
    private SessaoDao sessaoDao = new SessaoDao(getApplicationContext());
    private SessaoUsuario sessao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ok);
    }

}
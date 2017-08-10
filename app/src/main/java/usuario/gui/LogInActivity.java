package usuario.gui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import usuario.dao.ContatoDao;
import usuario.dominio.Usuario;
import usuario.negocio.CriptografiaSenha;
import usuario.negocio.SessaoUsuario;
import usuario.negocio.UsuarioNegocio;


public class LogInActivity extends AppCompatActivity {
    private EditText etLogin;
    private EditText etPassword;
    private SessaoUsuario sessao;

    private Resources resources;
    private UsuarioNegocio usuarioNegocio;
    private CriptografiaSenha cripto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = (EditText) findViewById(R.id.user_login);
        etPassword = (EditText) findViewById(R.id.user_password);

        initViews();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void initViews() {
        resources = getResources();
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        etPassword.addTextChangedListener(textWatcher);
        etLogin.addTextChangedListener(textWatcher);
        }

    public void startCadastroActivity(View v) {
        Intent i = new Intent(LogInActivity.this,CadastroActivity.class);
        startActivity(i);

    }

    public void startMainActivity(){
        Intent i = new Intent(LogInActivity.this, TelaInicialNavActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }

    public void logar(View v) throws Exception {
        boolean validar=validarCampos();
        if(validar){

            usuarioNegocio = new UsuarioNegocio(getApplicationContext());

            String usuario = etLogin.getText().toString();
            String senha = etPassword.getText().toString();

            cripto = new CriptografiaSenha();
            String novaSenha = cripto.criptoSenha(senha);

            sessao = new SessaoUsuario(getApplicationContext());

            Usuario validado = usuarioNegocio.login(usuario, novaSenha);

            if (validado ==  null){
                etLogin.requestFocus();
                etLogin.setError(resources.getString(R.string.erro_valido_usuario_senha));
            }else {
                sessao.logarUsuario(usuario);
                startMainActivity();
            }
        }
    }

    private boolean validarCampos(){

        String login = etLogin.getText().toString();
        String senha = etPassword.getText().toString();

        if(isCamposValidos(login, senha)){
            return  true;
        }
        return false;
    }

    public boolean isCamposValidos(String login, String senha) {
        boolean verificador = false;
        if (TextUtils.isEmpty(login)) {
            etLogin.requestFocus();
            etLogin.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(senha)) {
            etPassword.requestFocus();
            etPassword.setError(resources.getString(R.string.error_campo_vazio));
        } else {
            verificador = true;
        }
        return verificador;
    }
}

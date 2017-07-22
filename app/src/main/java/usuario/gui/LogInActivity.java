package usuario.gui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import usuario.dominio.Usuario;
import usuario.negocio.CriptografiaSenha;
import usuario.negocio.UsuarioValidacao;


public class LogInActivity extends AppCompatActivity {
    private EditText et_login;
    private EditText et_password;

    private Resources resources;
    private UsuarioValidacao usuarioValidacao;
    private CriptografiaSenha cripto;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_login = (EditText) findViewById(R.id.user_login);
        et_password = (EditText) findViewById(R.id.user_password);

        initViews();
    }

    public void onResume(){
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

        et_password.addTextChangedListener(textWatcher);
        et_login.addTextChangedListener(textWatcher);
        }

    public void startCadastroActivity(View v){
        Intent i = new Intent(LogInActivity.this,CadastroActivity.class);
        startActivity(i);
    }

    public void startMainActivity(){
        Intent i = new Intent(LogInActivity.this, TelaInicialNavActivity.class);
        startActivity(i);
        finish();
    }

    public void logar(View v) throws Exception {
        boolean validar=validarCampos();
        if(validar){

            usuarioValidacao = new UsuarioValidacao(getApplicationContext());

            String usuario = et_login.getText().toString();
            String senha = et_password.getText().toString();

            cripto = new CriptografiaSenha();
            String novaSenha = cripto.criptoSenha(senha);

            SharedPreferences prefs = getSharedPreferences("user", Context.MODE_APPEND);


            Usuario validado = usuarioValidacao.login(usuario, novaSenha);

            if (validado ==  null){
                et_login.requestFocus();
                et_login.setError(resources.getString(R.string.erro_valido_usuario_senha));
            }else {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("username",validado.getLogin());
                editor.apply();
                startMainActivity();
            }
        }
    }

    private boolean validarCampos(){

        String login = et_login.getText().toString();
        String senha = et_password.getText().toString();

        if(isCamposValidos(login, senha)){
            return  true;
        }
        return false;
    }

    public boolean isCamposValidos(String login, String senha) {
        boolean verificador = false;
        if (TextUtils.isEmpty(login)) {
            et_login.requestFocus();
            et_login.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(senha)) {
            et_password.requestFocus();
            et_password.setError(resources.getString(R.string.error_campo_vazio));
        } else {
            verificador = true;
        }
        return verificador;
    }
}

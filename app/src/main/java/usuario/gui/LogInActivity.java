package usuario.gui;

import android.content.Intent;
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
import usuario.negocio.SessaoUsuario;
import usuario.negocio.UsuarioNegocio;

/**
 * <h1>LogInActivity</h1>
 * Activity responsavel pelas funcionalidade do Login.
 */

public class LogInActivity extends AppCompatActivity {
    private EditText etLogin;
    private EditText etPassword;
    private SessaoUsuario sessao;

    private Resources resources;
    private UsuarioNegocio usuarioNegocio;
    private CriptografiaSenha cripto;

    /**
     * O método onCreate() tem a funcionalidade de setar o layout: activity_login e seus EditTexts
     * e chama o metodo initViews().
     *
     * @param savedInstanceState Objeto da classe Bundle que contêm o estado anterior da activity
     */

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

    /**
     * O metodo initViews() tem a funcionalidade de observar as mudancas nos textos dos EditTexts
     * da activity e se algum for mudado ira atualizar os atributos que estao relacionados com os
     * EditTexts mudados.
     */

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

    /**
     * O metodo startCadastroActivity() tem a funcionalidade fazer o app ir para
     * activity CadastroActivity.
     *
     * @param v Contem o que foi observado na activity.
     */
    public void startCadastroActivity(View v) {
        Intent i = new Intent(LogInActivity.this,CadastroActivity.class);
        startActivity(i);

    }

    /**
     * O metodo startMainActivity() tem a funcionalidade fazer o app ir para activity
     * TelaIniciaNavActivity.
     */

    public void startMainActivity(){
        Intent i = new Intent(LogInActivity.this, TelaInicialNavActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }

    /**
     * O metodo logar() tem a funcionalidade de fazer o usuario logar com auxilio dos metodos:
     * validarCampos() da mesma classe, criptoSenha() da classe CriptografiaSenha(), login() da
     * classe UsuarioNegocio(), caso nao seja logado e chamar o metodo startMainActivity, sera
     * mostrado um erro para o usuario.
     *
     * @see LogInActivity#validarCampos()
     * @see CriptografiaSenha#criptoSenha(String)
     * @see UsuarioNegocio#login(String, String)
     * @param v Contem o que foi observado na activity.
     * @throws Exception Excecao de erro java.
     */

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

    /**
     * O metedo validarCampos() tem a funcionalidade de verificar se os campos da activity foram
     * validados com auxilio dos metodos: isCamposValidos() da mesma classe.
     *
     * @see LogInActivity#isCamposValidos(String, String)
     * @return Retorna uma booleana.
     */

    private boolean validarCampos(){

        String login = etLogin.getText().toString();
        String senha = etPassword.getText().toString();

        if(isCamposValidos(login, senha)){
            return  true;
        }
        return false;
    }

    /**
     *  O metodo isCamposValidos() tem a funcionalidade de verificar se o campos estao vazios,
     *  caso algum esteja, emitira um sinal de erro.
     *
     * @param login String do campo: Login da activity.
     * @param senha String do campo: Senha da activity.
     * @return Retorna uma booleana.
     */

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

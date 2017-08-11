package usuario.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;


import usuario.dominio.Pessoa;
import usuario.dominio.Usuario;
import usuario.negocio.CriptografiaSenha;
import usuario.negocio.UsuarioNegocio;

public class CadastroActivity extends AppCompatActivity {
    private EditText etUser;
    private EditText etPassword;
    private EditText etPassword2;
    private EditText etNome;

    private Resources resources;
    private UsuarioNegocio usuarioNegocio;
    private CriptografiaSenha cripto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        usuarioNegocio = new UsuarioNegocio(getApplicationContext());

        etUser = (EditText) findViewById(R.id.et_register_login);
        etPassword = (EditText) findViewById(R.id.et_register_password);
        etPassword2 = (EditText) findViewById(R.id.et_register_password2);
        etNome = (EditText) findViewById(R.id.et_register_nome);

        initViews();
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
        etUser.addTextChangedListener(textWatcher);
        etNome.addTextChangedListener(textWatcher);
        etPassword2.addTextChangedListener(textWatcher);
    }

    public void cadastrar(View v) throws Exception{
        boolean validar=validarCampos();
        if(validar){
                cripto = new CriptografiaSenha();

                Usuario usuario = new Usuario();
                usuario.setLogin(etUser.getText().toString());
                String novaSenha = cripto.criptoSenha(etPassword.getText().toString());
                usuario.setPassword(novaSenha);

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(etNome.getText().toString());
                pessoa.setUsuario(usuario);

                usuarioNegocio.validarCadastro(pessoa);
                iniciarLoginActivity();
        }
    }

    public void iniciarLoginActivity(){
        startActivity(new Intent(this,LogInActivity.class));
        finish();
    }

    private boolean validarCampos(){
        String nome = etNome.getText().toString();
        String login = etUser.getText().toString();
        String senha = etPassword.getText().toString();
        String senhaConfirma = etPassword2.getText().toString();

        if(isCamposValidos(nome, login, senha, senhaConfirma) && isSenhasValidas(senha, senhaConfirma) &&
                validarLoginSenha(login,senha)){
            return  true;
        }
        return false;
    }

    public boolean isSenhasValidas(String campo_senha, String campo_senha_repetida) {
        if (campo_senha.equals(campo_senha_repetida)) {
        return true;
    }else{
            etPassword.requestFocus();
            etPassword.setError(resources.getString(R.string.erro_senha_comparar));
            return false;
        }
}

    public boolean isCamposValidos(String nome, String login, String senha, String senhaConfirma) {
        boolean verificador = false;
        if (TextUtils.isEmpty(nome)) {
            etNome.requestFocus();
            etNome.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(login)) {
            etUser.requestFocus();
            etUser.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(senha)) {
            etPassword.requestFocus();
            etPassword.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(senhaConfirma)) {
            etPassword2.requestFocus();
            etPassword2.setError(resources.getString(R.string.error_campo_vazio));
        }
        else {
            verificador = true;
        }
        return verificador;
    }
    public boolean validarLoginSenha(String login, String senha){
        boolean verificador = false;
        if(!usuarioNegocio.verEspacosBrancos(login)){
            etUser.requestFocus();
            etUser.setError(resources.getString(R.string.erro_espaco_branco));
        }else if(!usuarioNegocio.verAlfanumerico(login)){
            etUser.requestFocus();
            etUser.setError(resources.getString(R.string.erro_caracter_especial));
        }else if(!usuarioNegocio.verificarTamanho(login)){
            etUser.requestFocus();
            etUser.setError(resources.getString(R.string.erro_tamanho_login));
        }else if(!usuarioNegocio.verEspacosBrancos(senha)){
            etPassword.requestFocus();
            etPassword.setError(resources.getString(R.string.erro_espaco_branco));
        }else if(!usuarioNegocio.verAlfanumerico(senha)) {
            etPassword.requestFocus();
            etPassword.setError(resources.getString(R.string.erro_caracter_especial));
        }else if(!usuarioNegocio.verificarTamanho(senha)){
            etPassword.requestFocus();
            etPassword.setError(resources.getString(R.string.erro_tamanho_senha));
        }else {
            verificador = true;
        }
        return  verificador;
    }
}

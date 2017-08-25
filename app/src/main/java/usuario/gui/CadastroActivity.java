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

/**
 * <h1>CadastroActivity</h1>
 * Activity responsavel por implementar as funcionalidades do cadastro dos usuarios.
 */

public class CadastroActivity extends AppCompatActivity {
    private EditText etUser;
    private EditText etPassword;
    private EditText etPassword2;
    private EditText etNome;

    private Resources resources;
    private UsuarioNegocio usuarioNegocio;
    private CriptografiaSenha cripto;

    /**
     * O metodo onCreate() tem a funcionalidade de setar o layout: activity_cadastro e setar os
     * EditTexts do layout para cada atributo da classe e chamar o metodo initViews() da mesma
     * classe.
     *
     * @see CadastroActivity#initViews()
     * @param savedInstanceState Um objeto da classe Bundle que contem o estado anterior da activity
     */

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

    /**
     * O metodo initViews() tem a funcionalidade de observar as mudancas nos textos dos EditTexts da
     * activity e se algum for mudado ira atualizar os atributos que estao relacionados com os
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
        etUser.addTextChangedListener(textWatcher);
        etNome.addTextChangedListener(textWatcher);
        etPassword2.addTextChangedListener(textWatcher);
    }

    /**
     * O metodo cadastrar tem a funcionalidade de ser responsavel pelo cadastro do usuario,
     * criando um Objeto Usuario e um objeto Pessoa e chamando os metodos para auxilia-lo:
     * validarCadastro() da classe UsuarioNegocio, criptoSenha() da classe CriptografiaSenha.
     *
     * @see UsuarioNegocio#validarCadastro(Pessoa)
     * @see CriptografiaSenha#criptoSenha(String)
     * @param v Contêm o que foi "observado" na nossa activity.
     * @throws Exception Excecao de erro java.
     */

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

    /**
     * O metodo iniciarLoginActity() encerra a activity CadastroActivity e inicia a
     * activity LogInActivity.
     *
     * @see LogInActivity
     */

    public void iniciarLoginActivity(){
        startActivity(new Intent(this,LogInActivity.class));
        finish();
    }

    /**
     * O metodo validarCampos() tem a funcionalidade de verificar se os campos da activity foram
     * validados com auxilio dos metodos: isCamposValidos(), isSenhasValidas e validarLoginSenha()
     * da mesma classe.
     *
     * @see CadastroActivity#isCamposValidos(String, String, String, String)
     * @see CadastroActivity#isSenhasValidas(String, String)
     * @see CadastroActivity#validarLoginSenha(String, String)
     * @return Retorna uma booleana.
     */

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

    /**
     * O metodo isSenhasValidade() tem a funcionalidade de verificar se as senhas dos campos: Senha
     * e Confirmar senha da activity estao identicos, se nao manda um aviso que as senhas nao
     * conferem.
     *
     * @param campo_senha String do campo: Senha da activity.
     * @param campo_senha_repetida String do campo: Confirmar senha da activity.
     * @return Retorna uma booleana.
     */

    public boolean isSenhasValidas(String campo_senha, String campo_senha_repetida) {
        if (campo_senha.equals(campo_senha_repetida)) {
        return true;
    }else{
            etPassword.requestFocus();
            etPassword.setError(resources.getString(R.string.erro_senha_comparar));
            return false;
        }
    }

    /**
     *  O metodo isCamposValidos() tem a funcionalidade de verificar se o campos estao vazios,
     *  caso algum esteja, emitira um sinal de erro.
     *
     * @param nome String do campo: Nome da activity.
     * @param login String do campo: Login da activity.
     * @param senha String do campo: Senha da activity.
     * @param senhaConfirma String do campo: Confirmar Senhada activity.
     * @return Retorna uma booleana.
     */
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

    /**
     * O metodo validarLoginSenha() tem a funcionalidade de verificar se existem espacos em branco
     * no login e senha, caso houver emitira um sinal de erro.
     *
     * @param login String do campo: Login da activity.
     * @param senha String do campo: Senha da activity.
     * @return Retorna uma booleana.
     */

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

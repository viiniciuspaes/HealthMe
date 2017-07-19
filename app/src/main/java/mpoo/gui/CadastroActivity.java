package mpoo.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import dominio.Pessoa;
import dominio.Usuario;
import negocio.UsuarioValidacao;

public class CadastroActivity extends AppCompatActivity {
    private EditText et_user ;
    private EditText et_password ;
    private EditText et_password2 ;
    private EditText et_nome ;

    private Resources resources;
    private UsuarioValidacao usuarioValidacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        usuarioValidacao = new UsuarioValidacao(getApplicationContext());

        et_user = (EditText) findViewById(R.id.et_register_login);
        et_password = (EditText) findViewById(R.id.et_register_password);
        et_password2 = (EditText) findViewById(R.id.et_register_password2);
        et_nome = (EditText) findViewById(R.id.et_register_nome);

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

        et_password.addTextChangedListener(textWatcher);
        et_user.addTextChangedListener(textWatcher);
        et_nome.addTextChangedListener(textWatcher);
        et_password2.addTextChangedListener(textWatcher);

    }
    public void cadastrar(View v){
        boolean validar=validarCampos();
        if(validar){
                Usuario usuario = new Usuario();
                usuario.setLogin(et_user.getText().toString());
                usuario.setPassword(et_password.getText().toString());

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(et_nome.getText().toString());
                pessoa.setUsuario(usuario);

                //falta pegar foto

                //falta arrumar validacao

                usuarioValidacao.validarCadastro(pessoa);
                iniciarLoginActivity();

        }else {
            //Toast.makeText(getApplicationContext(),"deu errado")
        }
    }
    public void iniciarLoginActivity(){
        startActivity(new Intent(this,LogInActivity.class));
        finish();
    }
    private boolean validarCampos(){
        String nome = et_nome.getText().toString().trim();
        String login = et_user.getText().toString().trim();
        String senha = et_password.getText().toString();
        String senhaConfirma = et_password2.getText().toString();

        if(isCamposValidos(nome, login, senha, senhaConfirma) && isSenhasValidas(senha, senhaConfirma)){
            return  true;
        }

        return false;
    }
    public boolean isSenhasValidas(String campo_senha, String campo_senha_repetida) {
    if (campo_senha.equals(campo_senha_repetida)) {
        return true;
    }
    et_password.setError(resources.getString(R.string.error_password_match));
    et_password.requestFocus();
    return false;
}
    public boolean isCamposValidos(String nome, String login, String senha, String senhaConfirma) {
        boolean verifacor = false;
        if (TextUtils.isEmpty(nome)) {
            et_nome.requestFocus();
            et_nome.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(login)) {
            et_user.requestFocus(); // troca ordem
            et_user.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(senha)) {
            et_password.requestFocus();
            et_password.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(senhaConfirma)) {
            et_password2.requestFocus();
            et_password2.setError(resources.getString(R.string.error_campo_vazio));
        }
        else {
            verifacor = true;
        }
        return verifacor;
    }


}

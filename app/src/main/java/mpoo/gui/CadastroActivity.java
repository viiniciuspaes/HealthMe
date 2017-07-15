package mpoo.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import dominio.Pessoa;
import dominio.Usuario;
import negocio.UsuarioValidacao;

public class CadastroActivity extends AppCompatActivity {
    EditText et_user ;
    EditText et_password ;
    EditText et_password2 ;
    EditText et_nome ;
    EditText et_nascimento ;
    EditText et_plano ;

    private Resources resources;
    private UsuarioValidacao usuarioValidacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        
        usuarioValidacao = new UsuarioValidacao(getApplicationContext());

        et_user = (EditText) findViewById(R.id.editText_register_login);
        et_password = (EditText) findViewById(R.id.editText_register_password);
        et_password2 = (EditText) findViewById(R.id.editText_register_password2);
        et_nome = (EditText) findViewById(R.id.editText_register_nome);
        et_nascimento = (EditText) findViewById(R.id.editText_register_nascimento);
        et_plano = (EditText) findViewById(R.id.editText_register_plano);

        initViews();

    }
    private void initViews() {
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
        et_nascimento.addTextChangedListener(textWatcher);
        et_plano.addTextChangedListener(textWatcher);
    }
    private  void cadastrar(){
        if(validarCampos()){
                Usuario usuario = new Usuario();
                usuario.setLogin(et_user.getText().toString());
                usuario.setPassword(et_password.getText().toString());

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(et_nome.getText().toString());
                pessoa.setPlanoSaude(et_plano.getText().toString());
                pessoa.setUsuario(usuario);
                //falta pegar foto

                //falta arrumar validacao

            usuarioValidacao.validarCadastro(pessoa);
            iniciarLoginActivity();

        }
    }
    public void iniciarLoginActivity(){
        startActivity(new Intent(this,LogInActivity.class));
        finish();
    }
    private boolean validarCampos(){
        String nome = et_nome.getText().toString().trim();
        String login = et_user.getText().toString().trim();
        String plano = et_plano.getText().toString().trim();
        String senha = et_plano.getText().toString();
        String senhaConfirma = et_password2.getText().toString();
        String nascimento = et_nascimento.getText().toString();

        return (!isCamposValidos(nome, login, plano, senha, senhaConfirma,nascimento)
                && isSenhasValidas(senha, senhaConfirma) );
    }
    public boolean isSenhasValidas(String campo_senha, String campo_senha_repetida) {
    if (!campo_senha.contentEquals(campo_senha_repetida)) {
        return false;
    }
    return true;
}
    private boolean isCamposValidos(String nome, String login, String plano, String senha, String senhaConfirma, String nascimento) {
        if (TextUtils.isEmpty(nome)) {
            et_nome.requestFocus();
            et_nome.setError(resources.getString(R.string.error_campo_vazio));
            return true;
        } else if (TextUtils.isEmpty(login)) {
            et_user.requestFocus();
            et_user.setError(resources.getString(R.string.error_campo_vazio));
            return true;
        } else if (TextUtils.isEmpty(plano)) {
            et_plano.requestFocus();
            et_plano.setError(resources.getString(R.string.error_campo_vazio));
            return true;
        } else if (TextUtils.isEmpty(senha)) {
            et_password.requestFocus();
            et_password.setError(resources.getString(R.string.error_campo_vazio));
            return true;
        } else if (TextUtils.isEmpty(senhaConfirma)) {
            et_password2.requestFocus();
            et_password2.setError(resources.getString(R.string.error_campo_vazio));
            return true;
        }else if (TextUtils.isEmpty(nascimento)) {
            et_nascimento.requestFocus();
            et_nascimento.setError(resources.getString(R.string.error_campo_vazio));
            return true;
        }
        return false;
    }


}

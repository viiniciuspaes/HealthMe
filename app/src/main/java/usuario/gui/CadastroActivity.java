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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import usuario.dominio.Pessoa;
import usuario.dominio.Usuario;
import infra.CriptografiaSenha;
import usuario.negocio.UsuarioValidacao;

public class CadastroActivity extends AppCompatActivity {
    private EditText et_user ;
    private EditText et_password ;
    private EditText et_password2 ;
    private EditText et_nome ;

    private Resources resources;
    private UsuarioValidacao usuarioValidacao;
    private CriptografiaSenha cripto;

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
    public void cadastrar(View v) throws Exception{
        boolean validar=validarCampos();
        if(validar){
                cripto = new CriptografiaSenha();

                Usuario usuario = new Usuario();
                usuario.setLogin(et_user.getText().toString());
                String novaSenha = cripto.criptoSenha(et_password.getText().toString());
                usuario.setPassword(novaSenha);

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(et_nome.getText().toString());
                pessoa.setUsuario(usuario);

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
        String senha = et_password.getText().toString();
        String senhaConfirma = et_password2.getText().toString();

        if(isCamposValidos(nome, login, senha, senhaConfirma) && isSenhasValidas(senha, senhaConfirma) &&
                validarLoginESenha(login,senha)){
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
        boolean verificador = false;
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
            verificador = true;
        }
        return verificador;
    }
    public boolean validarLoginESenha(String login,String senha){
        boolean verificador = false;
        if(hasSpacePassword(login) == false){
            et_user.requestFocus();
            et_user.setError("Espaço em branco encontrado");
        }else if(hasNoNumbersPassword(login) == false){
            et_user.requestFocus();
            et_user.setError("Caracter especial encontrado");
        }else if(hasSpacePassword(senha) == false){
            et_password.requestFocus();
            et_password.setError("Espaço em branco encontrado");
        }else if(hasNoNumbersPassword(senha) == false){
            et_password.requestFocus();
            et_password.setError("Caracter especial encontrado");
        }
        else{
            verificador = true;
        }
        return  verificador;
    }
    public boolean hasSpacePassword(String campo){
        String senha = campo;
        Pattern p= Pattern.compile("\\S+");
        Matcher m = p.matcher(senha);
        System.out.println(m.matches());
        return m.matches();
    }

    public boolean hasNoNumbersPassword(String campo){
        String senha = campo;
        Pattern p = Pattern.compile("^[A-Za-z0-9]+$");
        Matcher m = p.matcher(senha);
        System.out.print(m.matches()+"\n");
        return m.matches();
    }

    public boolean hasNumbersLettersPassword(String campo){
        String senha = campo;
        Pattern p = Pattern.compile("^(?=.+[a-z])(?=.+[0-9]).+$");
        Matcher m = p.matcher(senha);
        System.out.print(m.matches()+"\n");
        return m.matches();
    }
}

package mpoo.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dominio.Pessoa;
import dominio.Usuario;
import negocio.UsuarioValidacao;


public class LogInActivity extends AppCompatActivity {
    private EditText et_login;
    private EditText et_password;
    private Button btn_cadastrar ;
    private Button btn_logar;

    private Resources resources;
    private UsuarioValidacao usuarioValidacao;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioValidacao = new UsuarioValidacao(getApplicationContext());

        et_login = (EditText) findViewById(R.id.user_login);
        et_password = (EditText) findViewById(R.id.user_password);
        btn_cadastrar = (Button) findViewById(R.id.btn_register_user);
        btn_logar = (Button) findViewById(R.id.btn_login);

        initViews();
    }

    public void onButtonClick(View v){
        String usuarioEmail = et_login.getText().toString();
        String usuarioPassword = et_password.getText().toString();

        try{
            usuarioValidacao.login(usuarioEmail, usuarioPassword);
            Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

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



    public void logar(View v){
        boolean validar=validarCampos();
        if(validar){
            Usuario usuario = new Usuario();
            usuario.setLogin(et_login.getText().toString());
            usuario.setPassword(et_password.getText().toString());

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(et_login.getText().toString());
            pessoa.setUsuario(usuario);

            //falta arrumar validacao

            usuarioValidacao.validarLogin(pessoa);

        }else {
            //Toast.makeText(getApplicationContext(),"deu errado")
        }
    }

    private boolean validarCampos(){
        String login = et_login.getText().toString().trim();
        String senha = et_password.getText().toString();

        if(isCamposValidos(login, senha){
            return  true;
        }

        return false;
    }



}

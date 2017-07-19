package mpoo.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
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



    public void logar(View v) throws Exception {
        boolean validar=validarCampos();
        if(validar){
            String usuarioTeste = et_login.getText().toString();
            String senhaTeste = et_password.getText().toString();

            //falta arrumar validacao

            usuarioValidacao.login(usuarioTeste,senhaTeste);
            Intent i = new Intent(LogInActivity.this,TelaInicialActivity.class);
            startActivity(i);

        }else {
            //Toast.makeText(getApplicationContext(),"deu errado")
        }
    }


    private boolean validarCampos(){

        String login = et_login.getText().toString().trim();
        String senha = et_password.getText().toString();


        if(isCamposValidos(login, senha)){
            return  true;
        }

        return false;
    }

    public boolean isCamposValidos(String login, String senha) {
        boolean verifacor = false;
        if (TextUtils.isEmpty(login)) {
            et_login.requestFocus();
            et_login.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(senha)) {
            et_password.requestFocus();
            et_password.setError(resources.getString(R.string.error_campo_vazio));
        } else {
            verifacor = true;
        }
        return verifacor;
    }



}

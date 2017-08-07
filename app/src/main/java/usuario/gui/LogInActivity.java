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

import usuario.dominio.Usuario;
import usuario.negocio.CriptografiaSenha;
import usuario.negocio.SessaoUsuario;
import usuario.negocio.UsuarioNegocio;


public class LogInActivity extends AppCompatActivity {
    private EditText et_login;
    private EditText et_password;
    private SessaoUsuario sessao;

    private Resources resources;
    private UsuarioNegocio usuarioNegocio;
    private CriptografiaSenha cripto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_login = (EditText) findViewById(R.id.user_login);
        et_password = (EditText) findViewById(R.id.user_password);

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

        et_password.addTextChangedListener(textWatcher);
        et_login.addTextChangedListener(textWatcher);
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

    public void panico(View v)throws Exception{
         /*
        String posted_by = "5581996556828";
        Uri u = Uri.parse("tel:" + posted_by);
        Intent it = new Intent(Intent.ACTION_DIAL, u);

        startActivity(it);

        String no = "996556828";
        Intent callintent = new Intent(Intent.ACTION_CALL);
        callintent.setData(Uri.parse("tel:" +no));
        startActivity(callintent);
        */
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+5581988619746",null,"Oi",null,null);

        if(isPermissionGranted()) {
            call_action();
        }
    }

    public void logar(View v) throws Exception {
        boolean validar=validarCampos();
        if(validar){

            usuarioNegocio = new UsuarioNegocio(getApplicationContext());

            String usuario = et_login.getText().toString();
            String senha = et_password.getText().toString();

            cripto = new CriptografiaSenha();
            String novaSenha = cripto.criptoSenha(senha);

            sessao = new SessaoUsuario(getApplicationContext());

            Usuario validado = usuarioNegocio.login(usuario, novaSenha);

            if (validado ==  null){
                et_login.requestFocus();
                et_login.setError(resources.getString(R.string.erro_valido_usuario_senha));
            }else {
                sessao.logarUsuario(usuario);
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

    public void call_action(){
        String phnum = "996556828";
        Intent callIntent = new Intent(Intent.ACTION_CALL).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //check wheather it is dual sim or not then

        //if sim 1
        callIntent.putExtra("com.android.phone.extra.slot",0);

        //else if sim 2
        //callIntent.putExtra("simSlot", 1);

        callIntent.setData(Uri.parse("tel:" + phnum));
        startActivity(callIntent);
    }
    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                    call_action();
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}

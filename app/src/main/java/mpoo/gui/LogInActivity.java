package mpoo.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class LogInActivity extends AppCompatActivity {
    EditText et_logar;
    Button btn_cadastrar ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void startCadastroActivity(View v){
        Intent i = new Intent(LogInActivity.this,CadastroActivity.class);
        startActivity(i);
    }
}

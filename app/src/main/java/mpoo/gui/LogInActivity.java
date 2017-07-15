package mpoo.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class LogInActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void register(){
        Intent i = new Intent(LogInActivity.this,CadastroActivity.class);
        startActivity(i);
    }
}

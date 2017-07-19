package mpoo.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by LuizC on 19/07/2017.
 */

public class TelaInicialActivity extends AppCompatActivity {

    public void startLoginActivity(View v){
        Intent i = new Intent(TelaInicialActivity.this,LogInActivity.class);
        startActivity(i);
    }
}
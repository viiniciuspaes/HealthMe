package usuario.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * <h1>SplashActivity</h1>
 * Actitivy responsavel por implementar as funcionalidades da tela de abertura (splash screen)
 * durante a inicialização do aplicativo.
 */

public class SplashActivity extends Activity implements Runnable {

    /**
     * O método onCreate() tem a funcionalidade de setar o layout: activity_splash e
     * usa um handler para essa activity.
     *
     * @param savedInstanceState Objeto da classe Bundle que contem o estado anterior da activity
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(this, 3000);
    }

    /**
     * O metodo run() tem a funcionalidade de mudar dessa activity para a LogInActivity e
     * finaliza essa activity.
     *
     * @see LogInActivity
     */

    public void run(){
        startActivity(new Intent(this,LogInActivity.class));
        finish();
    }
}



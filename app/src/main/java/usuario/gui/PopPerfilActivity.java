package usuario.gui;

import android.content.Intent;
import android.content.PeriodicSync;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;


public class PopPerfilActivity extends AppCompatActivity {
    private TextView tv_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_perfil);

        tv_ok=(TextView)findViewById(R.id.tv_ok);

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        DisplayMetrics medidas= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);

        int largura=medidas.widthPixels;
        int altura=medidas.heightPixels;

        getWindow().setLayout((int)(largura * 0.7),(int)(altura * 0.1));
    }
}

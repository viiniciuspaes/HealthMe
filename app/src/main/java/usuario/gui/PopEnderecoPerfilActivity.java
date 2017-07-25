package usuario.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;


public class PopEnderecoPerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_endereco_perfil);

        DisplayMetrics medidas= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);

        int largura=medidas.widthPixels;
        int altura=medidas.heightPixels;

        getWindow().setLayout((int)(largura * 0.8),(int)(altura * 0.5));
    }
}

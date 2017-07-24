package usuario.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.EditText;


public class PopContatoEmergenciaActivity extends AppCompatActivity {
    private EditText et_nomeContatoEmergencia;
    private EditText et_telefoneContatoEmergencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_contato_emergencia);

        et_nomeContatoEmergencia=(EditText)findViewById(R.id.et_nomeContatoEmergencia);
        et_telefoneContatoEmergencia=(EditText)findViewById(R.id.et_telefoneContatoEmergencia);

        DisplayMetrics medidas= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);

        int largura=medidas.widthPixels;
        int altura=medidas.heightPixels;

        getWindow().setLayout((int)(largura * 0.6),(int)(altura * 0.2));
    }
}

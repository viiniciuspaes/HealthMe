package usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ResultadosExamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_exames);
    }

    public void voltarParaHome(){
        startActivity(new Intent(ResultadosExamesActivity.this, TelaInicialNavActivity.class));
    }
}

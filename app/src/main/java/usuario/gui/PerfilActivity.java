package usuario.gui;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class PerfilActivity extends AppCompatActivity {
    private TextView tv_nome;
    private TextView tv_endereco;
    private TextView tv_planoSaude;
    private TextView tv_contatoEmergencia1;
    private TextView tv_contatoEmergencia2;
    private TextView tv_contatoEmergencia3;

    private ImageButton ibtn_editarPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tv_nome=(TextView)findViewById(R.id.tv_nome);
        tv_endereco=(TextView)findViewById(R.id.tv_endereco);
        tv_planoSaude=(TextView)findViewById(R.id.tv_planoSaude);
        tv_contatoEmergencia1=(TextView)findViewById(R.id.tv_contatoEmergencia1);
        tv_contatoEmergencia2=(TextView)findViewById(R.id.tv_contatoEmergencia2);
        tv_contatoEmergencia3=(TextView)findViewById(R.id.tv_contatoEmergencia3);

        ibtn_editarPerfil=(ImageButton)findViewById(R.id.ibtn_editarPerfil);

        ibtn_editarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PerfilActivity.this, EditarPerfilActivity.class));
            }
        });



    }
}

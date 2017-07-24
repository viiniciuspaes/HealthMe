package usuario.gui;

import android.content.Intent;
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

    private ImageButton ibtn_editarNome;
    private ImageButton ibtn_editarEndereco;
    private ImageButton ibtn_editarPlanoSaude;
    private ImageButton ibtn_editarContatoEmergencia1;
    private ImageButton ibtn_editarContatoEmergencia2;
    private ImageButton ibtn_editarContatoEmergencia3;

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

        ibtn_editarNome=(ImageButton)findViewById(R.id.ibtn_editarNome);
        ibtn_editarEndereco=(ImageButton)findViewById(R.id.ibtn_editarEndereco);
        ibtn_editarPlanoSaude=(ImageButton)findViewById(R.id.ibtn_editarPlanoSaude);
        ibtn_editarContatoEmergencia1=(ImageButton)findViewById(R.id.ibtn_editarContatoEmergencia1);
        ibtn_editarContatoEmergencia2=(ImageButton)findViewById(R.id.ibtn_editarContatoEmergencia2);
        ibtn_editarContatoEmergencia3=(ImageButton)findViewById(R.id.ibtn_editarContatoEmergencia3);

        ibtn_editarNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PerfilActivity.this, PopPerfilActivity.class));
            }
        });

        ibtn_editarEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PerfilActivity.this, PopEnderecoPerfilActivity.class));
            }
        });

        ibtn_editarPlanoSaude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PerfilActivity.this, PopPerfilActivity.class));
            }
        });

        ibtn_editarContatoEmergencia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PerfilActivity.this, PopContatoEmergenciaActivity.class));
            }
        });

        ibtn_editarContatoEmergencia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PerfilActivity.this, PopContatoEmergenciaActivity.class));
            }
        });

        ibtn_editarContatoEmergencia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PerfilActivity.this, PopContatoEmergenciaActivity.class));
            }
        });

    }
}

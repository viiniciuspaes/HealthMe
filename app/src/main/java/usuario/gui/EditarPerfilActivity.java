package usuario.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class EditarPerfilActivity extends AppCompatActivity {
    private EditText et_editarNome;
    private EditText et_editarRua;
    private EditText et_editarNumero;
    private EditText et_editarPlanoSaude;
    private EditText et_editarNomeContatoEmergencia1;
    private EditText et_editarTelefoneContatoEmergencia1;
    private EditText et_editarNomeContatoEmergencia2;
    private EditText et_editarTelefoneContatoEmergencia2;
    private EditText et_editarNomeContatoEmergencia3;
    private EditText et_editarTelefoneContatoEmergencia3;
    private Button btn_confirmar;
    private ImageButton ibtn_deletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        et_editarNome=(EditText)findViewById(R.id.et_editarNome);
        et_editarRua=(EditText)findViewById(R.id.et_editarRua);
        et_editarNumero=(EditText)findViewById(R.id.et_editarNumero);
        et_editarPlanoSaude=(EditText)findViewById(R.id.et_editarPlanoSaude);
        et_editarNomeContatoEmergencia1=(EditText)findViewById(R.id.et_editarNomeContatoEmergencia1);
        et_editarTelefoneContatoEmergencia1=(EditText)findViewById(R.id.et_editarTelefoneContatoEmergencia1);
        et_editarNomeContatoEmergencia2=(EditText)findViewById(R.id.et_editarNomeContatoEmergencia2);
        et_editarTelefoneContatoEmergencia2=(EditText)findViewById(R.id.et_editarTelefoneContatoEmergencia2);
        et_editarNomeContatoEmergencia3=(EditText)findViewById(R.id.et_editarNomeContatoEmergencia3);
        et_editarTelefoneContatoEmergencia3=(EditText)findViewById(R.id.et_editarTelefoneContatoEmergencia3);
        btn_confirmar=(Button)findViewById(R.id.btn_confirmar);
        ibtn_deletar=(ImageButton)findViewById(R.id.ibtn_deletar);
    }
}

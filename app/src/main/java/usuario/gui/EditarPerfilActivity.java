package usuario.gui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.regex.Pattern;


public class EditarPerfilActivity extends AppCompatActivity {
    private EditText et_editarNome;
    //private EditText et_editarRua;
    //private EditText et_editarNumero;
    private EditText et_editarPlanoSaude;
    private EditText et_editarNomeContatoEmergencia1;
    private EditText et_editarTelefoneContatoEmergencia1;
    private EditText et_editarNomeContatoEmergencia2;
    private EditText et_editarTelefoneContatoEmergencia2;
    private EditText et_editarNomeContatoEmergencia3;
    private EditText et_editarTelefoneContatoEmergencia3;
    private Button btn_confirmar;
    private Resources resources;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        et_editarNome=(EditText)findViewById(R.id.et_editarNome);
        //et_editarRua=(EditText)findViewById(R.id.et_editarRua);
        //et_editarNumero=(EditText)findViewById(R.id.et_editarNumero);
        et_editarPlanoSaude=(EditText)findViewById(R.id.et_editarPlanoSaude);
        et_editarNomeContatoEmergencia1=(EditText)findViewById(R.id.et_editarNomeContatoEmergencia1);
        et_editarTelefoneContatoEmergencia1=(EditText)findViewById(R.id.et_editarTelefoneContatoEmergencia1);
        et_editarNomeContatoEmergencia2=(EditText)findViewById(R.id.et_editarNomeContatoEmergencia2);
        et_editarTelefoneContatoEmergencia2=(EditText)findViewById(R.id.et_editarTelefoneContatoEmergencia2);
        et_editarNomeContatoEmergencia3=(EditText)findViewById(R.id.et_editarNomeContatoEmergencia3);
        et_editarTelefoneContatoEmergencia3=(EditText)findViewById(R.id.et_editarTelefoneContatoEmergencia3);
        btn_confirmar=(Button)findViewById(R.id.btn_confirmar);

        initViews();
    }

    @Override
    public void onResume(){
        super.onResume();
    }
    public void initViews() {
        resources = getResources();
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        et_editarNome.addTextChangedListener(textWatcher);
        et_editarPlanoSaude.addTextChangedListener(textWatcher);
        et_editarNomeContatoEmergencia1.addTextChangedListener(textWatcher);
        et_editarTelefoneContatoEmergencia1.addTextChangedListener(textWatcher);
        et_editarNomeContatoEmergencia2.addTextChangedListener(textWatcher);
        et_editarTelefoneContatoEmergencia2.addTextChangedListener(textWatcher);
        et_editarNomeContatoEmergencia3.addTextChangedListener(textWatcher);
        et_editarTelefoneContatoEmergencia3.addTextChangedListener(textWatcher);
    }
    public void editar(View v) throws Exception{
        


    }
}

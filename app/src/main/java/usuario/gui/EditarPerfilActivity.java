package usuario.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import usuario.dao.ContatoDao;
import usuario.dao.UsuarioDao;
import usuario.dominio.ContatoEmergencia;
import usuario.dominio.Pessoa;
import usuario.negocio.SessaoUsuario;


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
    private UsuarioDao daoUser;
    private ContatoDao daoContato;
    private SessaoUsuario sessaoUsuario;
    private ContatoEmergencia contatoExistente;



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
        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        daoContato = new ContatoDao(getApplicationContext());

        sessaoUsuario.iniciarSessao();
        et_editarNome.setText(sessaoUsuario.getPessoaLogada().getNome());
        et_editarPlanoSaude.setText(sessaoUsuario.getPessoaLogada().getPlanoSaude());
        contatoExistente = daoContato.buscarContato(sessaoUsuario.getUsuarioLogado().getLogin());
        if(!(contatoExistente==null)){
            et_editarNomeContatoEmergencia1.setText(contatoExistente.getNome());
            et_editarTelefoneContatoEmergencia1.setText(contatoExistente.getNumero());
        }
    }

    @Override
    public void onResume(){super.onResume();}

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
        daoUser = new UsuarioDao(getApplicationContext());
        Pessoa pessoa = sessaoUsuario.getPessoaLogada();
        pessoa.setNome(et_editarNome.getText().toString());
        pessoa.setPlanoSaude(et_editarPlanoSaude.getText().toString());

        daoContato = new ContatoDao(getApplicationContext());

        if (!TextUtils.isEmpty(et_editarNomeContatoEmergencia1.getText().toString())){
            ContatoEmergencia contato;
            if (!(daoContato.buscarContato(sessaoUsuario.getUsuarioLogado().getLogin())== null)){
                contato = daoContato.buscarContato(sessaoUsuario.getUsuarioLogado().getLogin());
                contato.setNome(et_editarNomeContatoEmergencia1.getText().toString());
                contato.setNumero(et_editarTelefoneContatoEmergencia1.getText().toString());
                daoContato.atualizarRegistro(contato);
            }else {
                contato = new ContatoEmergencia();
                contato.setNome(et_editarNomeContatoEmergencia1.getText().toString());
                contato.setNumero(et_editarTelefoneContatoEmergencia1.getText().toString());
                contato.setUsuario(sessaoUsuario.getUsuarioLogado());
                daoContato.inserirRegistro(contato);
            }
            if (!TextUtils.isEmpty(et_editarNomeContatoEmergencia2.getText().toString())){
                ContatoEmergencia contato2;
                if (!(daoContato.buscarContato(sessaoUsuario.getUsuarioLogado().getLogin())== null)){
                    contato2 = daoContato.buscarContato(sessaoUsuario.getUsuarioLogado().getLogin());
                    contato2.setNome(et_editarNomeContatoEmergencia2.getText().toString());
                    contato2.setNumero(et_editarTelefoneContatoEmergencia2.getText().toString());
                    daoContato.atualizarRegistro(contato2);
                }else {
                    contato2 = new ContatoEmergencia();
                    contato2.setNome(et_editarNomeContatoEmergencia2.getText().toString());
                    contato2.setNumero(et_editarTelefoneContatoEmergencia2.getText().toString());
                    contato2.setUsuario(sessaoUsuario.getUsuarioLogado());
                    daoContato.inserirRegistro(contato2);
                }
                if (!TextUtils.isEmpty(et_editarNomeContatoEmergencia3.getText().toString())){
                    ContatoEmergencia contato3;
                    if (!(daoContato.buscarContato(sessaoUsuario.getUsuarioLogado().getLogin())== null)){
                        contato3 = daoContato.buscarContato(sessaoUsuario.getUsuarioLogado().getLogin());
                        contato3.setNome(et_editarNomeContatoEmergencia3.getText().toString());
                        contato3.setNumero(et_editarTelefoneContatoEmergencia3.getText().toString());
                        daoContato.atualizarRegistro(contato3);
                    }else {
                        contato3 = new ContatoEmergencia();
                        contato3.setNome(et_editarNomeContatoEmergencia3.getText().toString());
                        contato3.setNumero(et_editarTelefoneContatoEmergencia3.getText().toString());
                        contato3.setUsuario(sessaoUsuario.getUsuarioLogado());
                        daoContato.inserirRegistro(contato3);
            }
        }
    }
}
        daoUser.atualizarRegistro(pessoa);
        startActivity(new Intent(this, PerfilActivity.class));
        finish();
    }
}

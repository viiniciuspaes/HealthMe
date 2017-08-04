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

import java.util.ArrayList;
import java.util.List;

import usuario.dao.ContatoDao;
import usuario.dao.UsuarioDao;
import usuario.dominio.ContatoEmergencia;
import usuario.dominio.Pessoa;
import usuario.negocio.ContatoNegocio;
import usuario.negocio.SessaoUsuario;


public class EditarPerfilActivity extends AppCompatActivity {
    private EditText et_editarNome;
    private EditText et_editarPlanoSaude;
    private EditText et_editarNomeContatoEmergencia1;
    private EditText et_editarTelefoneContatoEmergencia1;
    private EditText et_editarNomeContatoEmergencia2;
    private EditText et_editarTelefoneContatoEmergencia2;
    private EditText et_editarNomeContatoEmergencia3;
    private EditText et_editarTelefoneContatoEmergencia3;
    private Resources resources;
    private UsuarioDao daoUser;
    private ContatoDao daoContato;
    private SessaoUsuario sessaoUsuario;
    private List<ContatoEmergencia> contatoExistente;
    private String[] contatosOriginais;
    private ContatoNegocio validacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        et_editarNome=(EditText)findViewById(R.id.et_editarNome);
        et_editarPlanoSaude=(EditText)findViewById(R.id.et_editarPlanoSaude);
        et_editarNomeContatoEmergencia1=(EditText)findViewById(R.id.et_editarNomeContatoEmergencia1);
        et_editarTelefoneContatoEmergencia1=(EditText)findViewById(R.id.et_editarTelefoneContatoEmergencia1);
        et_editarNomeContatoEmergencia2=(EditText)findViewById(R.id.et_editarNomeContatoEmergencia2);
        et_editarTelefoneContatoEmergencia2=(EditText)findViewById(R.id.et_editarTelefoneContatoEmergencia2);
        et_editarNomeContatoEmergencia3=(EditText)findViewById(R.id.et_editarNomeContatoEmergencia3);
        et_editarTelefoneContatoEmergencia3=(EditText)findViewById(R.id.et_editarTelefoneContatoEmergencia3);


        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        daoContato = new ContatoDao(getApplicationContext());

        sessaoUsuario.iniciarSessao();
        contatosOriginais = new String[3];
        setview();
        initViews();
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

        adicionarContato(et_editarNomeContatoEmergencia1,et_editarTelefoneContatoEmergencia1,daoContato,contatosOriginais[0]);
        adicionarContato(et_editarNomeContatoEmergencia2,et_editarTelefoneContatoEmergencia2,daoContato,contatosOriginais[1]);
        adicionarContato(et_editarNomeContatoEmergencia3,et_editarTelefoneContatoEmergencia3,daoContato,contatosOriginais[2]);
        daoUser.atualizarRegistro(pessoa);
        startActivity(new Intent(this, PerfilActivity.class));
        finish();
    }
    public void setview(){
        et_editarNome.setText(sessaoUsuario.getPessoaLogada().getNome());
        et_editarPlanoSaude.setText(sessaoUsuario.getPessoaLogada().getPlanoSaude());
        contatoExistente = daoContato.buscarContatos(sessaoUsuario.getUsuarioLogado().getLogin());
        contatosOriginais[0] = "none";
        contatosOriginais[1] = "none";
        contatosOriginais[2] = "none";
        int tamanho = contatoExistente.size();
        if(tamanho == 1){
            et_editarNomeContatoEmergencia1.setText(contatoExistente.get(0).getNome());
            et_editarTelefoneContatoEmergencia1.setText(contatoExistente.get(0).getNumero());
            contatosOriginais[0] = et_editarNomeContatoEmergencia1.getText().toString();
        }
        if(tamanho == 2){
            et_editarNomeContatoEmergencia1.setText(contatoExistente.get(0).getNome());
            et_editarTelefoneContatoEmergencia1.setText(contatoExistente.get(0).getNumero());
            et_editarNomeContatoEmergencia2.setText(contatoExistente.get(1).getNome());
            et_editarTelefoneContatoEmergencia2.setText(contatoExistente.get(1).getNumero());
            contatosOriginais[0] = et_editarNomeContatoEmergencia1.getText().toString();
            contatosOriginais[1] = et_editarNomeContatoEmergencia2.getText().toString();
        }
        if(tamanho == 3){
            et_editarNomeContatoEmergencia1.setText(contatoExistente.get(0).getNome());
            et_editarTelefoneContatoEmergencia1.setText(contatoExistente.get(0).getNumero());
            et_editarNomeContatoEmergencia2.setText(contatoExistente.get(1).getNome());
            et_editarTelefoneContatoEmergencia2.setText(contatoExistente.get(1).getNumero());
            et_editarNomeContatoEmergencia3.setText(contatoExistente.get(2).getNome());
            et_editarTelefoneContatoEmergencia3.setText(contatoExistente.get(2).getNumero());
            contatosOriginais[0] = et_editarNomeContatoEmergencia1.getText().toString();
            contatosOriginais[1] = et_editarNomeContatoEmergencia2.getText().toString();
            contatosOriginais[2] = et_editarNomeContatoEmergencia3.getText().toString();
        }
    }
    public void adicionarContato(EditText etNome, EditText etTelefone, ContatoDao daoContato, String contatoOriginal){
        if (!TextUtils.isEmpty(etNome.getText().toString())) {
            Boolean validado = validarCampos(etNome);
            if (validado) {
                ContatoEmergencia contato = daoContato.buscarContato(contatoOriginal);
                if (!(contato == null)) {
                    contato.setUsuario(sessaoUsuario.getUsuarioLogado());
                    contato.setNome(etNome.getText().toString());
                    contato.setNumero(etTelefone.getText().toString());
                    daoContato.atualizarRegistro(contato);
                } else {
                    contato = new ContatoEmergencia();
                    contato.setNome(etNome.getText().toString());
                    contato.setNumero(etTelefone.getText().toString());
                    contato.setUsuario(sessaoUsuario.getUsuarioLogado());
                    daoContato.inserirRegistro(contato);
                }
            }
        }
    }
    public boolean validarCampos(EditText et_nome){
        boolean verificador = false;
        validacao = new ContatoNegocio(getApplicationContext());
        if(!validacao.verAlfanumerico(et_nome.getText().toString())){
            et_nome.requestFocus();
            et_nome.setError(resources.getString(R.string.erro_caracter_especial));
        }else {
            verificador = true;
        }
        return  verificador;
    }
}

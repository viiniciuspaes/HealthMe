package usuario.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import usuario.dao.ContatoDao;
import usuario.dao.UsuarioDao;
import usuario.dominio.ContatoEmergencia;
import usuario.dominio.Pessoa;
import usuario.negocio.ContatoNegocio;
import usuario.negocio.SessaoUsuario;


public class EditarPerfilActivity extends AppCompatActivity {
    private EditText etEditarNome;
    private EditText etEditarPlanoSaude;
    private EditText etEditarNomeContatoEmergencia1;
    private EditText etEditarTelefoneContatoEmergencia1;
    private EditText etEditarNomeContatoEmergencia2;
    private EditText etEditarTelefoneContatoEmergencia2;
    private EditText etEditarNomeContatoEmergencia3;
    private EditText etEditarTelefoneContatoEmergencia3;
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

        etEditarNome =(EditText)findViewById(R.id.et_editarNome);
        etEditarPlanoSaude =(EditText)findViewById(R.id.et_editarPlanoSaude);
        etEditarNomeContatoEmergencia1 =(EditText)findViewById(R.id.et_editarNomeContatoEmergencia1);
        etEditarTelefoneContatoEmergencia1 =(EditText)findViewById(R.id.et_editarTelefoneContatoEmergencia1);
        etEditarNomeContatoEmergencia2 =(EditText)findViewById(R.id.et_editarNomeContatoEmergencia2);
        etEditarTelefoneContatoEmergencia2 =(EditText)findViewById(R.id.et_editarTelefoneContatoEmergencia2);
        etEditarNomeContatoEmergencia3 =(EditText)findViewById(R.id.et_editarNomeContatoEmergencia3);
        etEditarTelefoneContatoEmergencia3 =(EditText)findViewById(R.id.et_editarTelefoneContatoEmergencia3);


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

        etEditarNome.addTextChangedListener(textWatcher);
        etEditarPlanoSaude.addTextChangedListener(textWatcher);
        etEditarNomeContatoEmergencia1.addTextChangedListener(textWatcher);
        etEditarTelefoneContatoEmergencia1.addTextChangedListener(textWatcher);
        etEditarNomeContatoEmergencia2.addTextChangedListener(textWatcher);
        etEditarTelefoneContatoEmergencia2.addTextChangedListener(textWatcher);
        etEditarNomeContatoEmergencia3.addTextChangedListener(textWatcher);
        etEditarTelefoneContatoEmergencia3.addTextChangedListener(textWatcher);
    }
    public void editar(View v) throws Exception{
        daoUser = new UsuarioDao(getApplicationContext());
        Pessoa pessoa = sessaoUsuario.getPessoaLogada();
        pessoa.setNome(etEditarNome.getText().toString());
        pessoa.setPlanoSaude(etEditarPlanoSaude.getText().toString());

        daoContato = new ContatoDao(getApplicationContext());

        adicionarContato(etEditarNomeContatoEmergencia1, etEditarTelefoneContatoEmergencia1,daoContato,contatosOriginais[0]);
        adicionarContato(etEditarNomeContatoEmergencia2, etEditarTelefoneContatoEmergencia2,daoContato,contatosOriginais[1]);
        adicionarContato(etEditarNomeContatoEmergencia3, etEditarTelefoneContatoEmergencia3,daoContato,contatosOriginais[2]);
        daoUser.atualizarRegistro(pessoa);
        startActivity(new Intent(this, PerfilActivity.class));
        finish();
    }
    public void setview(){
        etEditarNome.setText(sessaoUsuario.getPessoaLogada().getNome());
        etEditarPlanoSaude.setText(sessaoUsuario.getPessoaLogada().getPlanoSaude());
        contatoExistente = daoContato.buscarContatos(sessaoUsuario.getUsuarioLogado().getLogin());
        contatosOriginais[0] = "none";
        contatosOriginais[1] = "none";
        contatosOriginais[2] = "none";
        int tamanho = contatoExistente.size();
        if(tamanho == 1){
            etEditarNomeContatoEmergencia1.setText(contatoExistente.get(0).getNome());
            etEditarTelefoneContatoEmergencia1.setText(contatoExistente.get(0).getNumero());
            contatosOriginais[0] = etEditarNomeContatoEmergencia1.getText().toString();
        }
        if(tamanho == 2){
            etEditarNomeContatoEmergencia1.setText(contatoExistente.get(0).getNome());
            etEditarTelefoneContatoEmergencia1.setText(contatoExistente.get(0).getNumero());
            etEditarNomeContatoEmergencia2.setText(contatoExistente.get(1).getNome());
            etEditarTelefoneContatoEmergencia2.setText(contatoExistente.get(1).getNumero());
            contatosOriginais[0] = etEditarNomeContatoEmergencia1.getText().toString();
            contatosOriginais[1] = etEditarNomeContatoEmergencia2.getText().toString();
        }
        if(tamanho == 3){
            etEditarNomeContatoEmergencia1.setText(contatoExistente.get(0).getNome());
            etEditarTelefoneContatoEmergencia1.setText(contatoExistente.get(0).getNumero());
            etEditarNomeContatoEmergencia2.setText(contatoExistente.get(1).getNome());
            etEditarTelefoneContatoEmergencia2.setText(contatoExistente.get(1).getNumero());
            etEditarNomeContatoEmergencia3.setText(contatoExistente.get(2).getNome());
            etEditarTelefoneContatoEmergencia3.setText(contatoExistente.get(2).getNumero());
            contatosOriginais[0] = etEditarNomeContatoEmergencia1.getText().toString();
            contatosOriginais[1] = etEditarNomeContatoEmergencia2.getText().toString();
            contatosOriginais[2] = etEditarNomeContatoEmergencia3.getText().toString();
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

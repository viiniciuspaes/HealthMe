package usuario.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import usuario.dao.ContatoDao;
import usuario.dao.UsuarioDao;
import usuario.dominio.ContatoEmergencia;
import usuario.dominio.Pessoa;
import usuario.dominio.Usuario;
import usuario.negocio.ContatoNegocio;
import usuario.negocio.SessaoUsuario;

/**
 * <h1>EditarPerfilActivity</h1>
 * Activity responsavel pelas funcionalidades de edicao nas informacoes do usuario.
 */

public class EditarPerfilActivity extends AppCompatActivity {
    private EditText etEditarNome;
    private Spinner spPlanoSaude;
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

    /**
     * O método onCreate() tem a funcionalidade de setar o layout: activity_editar_perfil e setar
     * os EditTexts do layout para cada atributo da classe, criar um spinner e chamar os metodos
     * initViews() e setview().
     *
     * @see EditarPerfilActivity#initViews()
     * @see EditarPerfilActivity#setview()
     * @param savedInstanceState Objeto da classe Bundle que contêm o estado anterior da activity
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        etEditarNome =(EditText)findViewById(R.id.et_editarNome);
        spPlanoSaude = (Spinner) findViewById(R.id.spinnerId);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.planos_de_saude, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPlanoSaude.setAdapter(adapter);

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

    /**
     * O método initViews() tem a funcionalidade de observar as mudancas nos textos dos EditTexts
     * da activity e se algum for mudado ira atualizar os atributos que estao relacionados com os
     * EditTexts mudados.
     */

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
        etEditarNomeContatoEmergencia1.addTextChangedListener(textWatcher);
        etEditarTelefoneContatoEmergencia1.addTextChangedListener(textWatcher);
        etEditarNomeContatoEmergencia2.addTextChangedListener(textWatcher);
        etEditarTelefoneContatoEmergencia2.addTextChangedListener(textWatcher);
        etEditarNomeContatoEmergencia3.addTextChangedListener(textWatcher);
        etEditarTelefoneContatoEmergencia3.addTextChangedListener(textWatcher);
    }

    /**
     * O método editar() tem a funcionalidade de editar as informacoes do usuario, criando um
     * objeto pessoa e setando com novas informacoes editadas pelo usuario, em seguida chama
     * o metodo atualizarRegistro() da classe UsuarioDao() e inicia a activity PerfilActivity().
     *
     * @see UsuarioDao#atualizarRegistro(Pessoa)
     * @see PerfilActivity
     * @param v Contem o que foi observado na  activity.
     * @throws Exception Excecao de erro java.
     */

    public void editar(View v) throws Exception{
        daoUser = new UsuarioDao(getApplicationContext());
        Pessoa pessoa = sessaoUsuario.getPessoaLogada();
        pessoa.setNome(etEditarNome.getText().toString());
        String x = spPlanoSaude.getSelectedItem().toString();
        if (!(x.equals("Plano de Saúde"))) {
            pessoa.setPlanoSaude(spPlanoSaude.getSelectedItem().toString());
        }
        daoContato = new ContatoDao(getApplicationContext());

        adicionarContato(etEditarNomeContatoEmergencia1, etEditarTelefoneContatoEmergencia1,daoContato,contatosOriginais[0]);
        adicionarContato(etEditarNomeContatoEmergencia2, etEditarTelefoneContatoEmergencia2,daoContato,contatosOriginais[1]);
        adicionarContato(etEditarNomeContatoEmergencia3, etEditarTelefoneContatoEmergencia3,daoContato,contatosOriginais[2]);
        pessoa.setUsuario(sessaoUsuario.getUsuarioLogado());
        daoUser.atualizarRegistro(pessoa);
        startActivity(new Intent(this, PerfilActivity.class));
        finish();
    }

    /**
     * O metodo setview() tem a funcionalidade de setar os contatos que foram encontrados pelo
     * metodo buscarContatos() da classe ContatoDao() nos EditTexts relacionado com os contatos
     * e telefones da activity.
     *
     * @see ContatoDao#buscarContatos(String)
     */

    public void setview(){
        etEditarNome.setText(sessaoUsuario.getPessoaLogada().getNome());
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

    /**
     * O metodo adicionarContato() tem a funcionalidade de adicionar os contatos que foram
     * colocados nos EditTexts da layout pelo usuario com auxilio dos metodos: validarCampos()
     * dessa mesma classe, se ja existir algum contato de emergencia chama o atualizarRegistro()
     * da classe ContatoDao, se nao chama o inserirRegistro() da classe ContatoDao.
     *
     * @see EditarPerfilActivity#validarCampos(EditText)
     * @see ContatoDao#atualizarRegistro(ContatoEmergencia)
     * @see ContatoDao#inserirRegistro(ContatoEmergencia)
     * @param etNome EditText do campo: Nome contato da activity.
     * @param etTelefone EditText do campo: Telefone da activity.
     * @param daoContato Objeto ContatoDao.
     * @param contatoOriginal Contato existente no banco de dados (sendo null inicialmente).
     */

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

    /**
     * O método validarCampos() tem a funcionalidade de verificar se os campos de contatos nao
     * contem caracteres especiais com auxilio do metodo verAlfanumerico() da classe ContatoNegocio.
     *
     * @see ContatoNegocio#verAlfanumerico(String)
     * @param et_nome EditText dos campos relacionados com contato e telefone.
     * @return Retorna uma booleana.
     */

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

    /**
     * O metodo desativar() tem a funcionalidade de desativar a conta do usuario e com auxilio
     * dos metodos: setInativo() da classe Usuario() e atualizarRegistro() da classe UsuarioDao() e
     * posteriormente inicia a activity LogInActivity.
     *
     * @see Usuario#setInativo()
     * @see UsuarioDao#atualizarRegistro(Pessoa)
     * @param view Contem o que foi observado na activity.
     */

    public void desativar(View view){
        Pessoa pessoa = sessaoUsuario.getPessoaLogada();
        Usuario usuario = sessaoUsuario.getUsuarioLogado();
        daoUser = new UsuarioDao(getApplicationContext());
        usuario.setInativo();
        pessoa.setUsuario(usuario);
        daoUser.atualizarRegistro(pessoa);

        startActivity(new Intent(this,LogInActivity.class));
        finish();
    }
}

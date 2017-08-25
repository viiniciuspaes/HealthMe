package usuario.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import usuario.dao.EventoDao;
import usuario.dominio.Evento;
import usuario.negocio.EventoNegocio;
import usuario.negocio.SessaoUsuario;

/**
 * <h1>EditarEventoActivity</h1>
 * Activity responsavel pelas funcionalidades de edicao nos eventos do calendario.
 */

public class EditarEventoActivity extends AppCompatActivity {
    private EditText etNome;
    private EditText etDescricao;
    private TextView etInicio;
    private Resources resources;
    private EventoNegocio eventoNegocio;
    private EventoDao eventoDao;
    private SessaoUsuario sessao;

    /**
     * O método onCreate() tem a funcionalidade de setar o layout: activity_editar_evento e setar
     * os EditTexts e TetxView do layout, setar os atributos: eventoNegocio, eventoDao e sessao,
     * inicia a sessao do usuario nessa activity e inicia os métodos: inciarTextos() e initViews().
     *
     * @see EditarEventoActivity#iniciarTextos()
     * @see EditarEventoActivity#initViews()
     * @param savedInstanceState Objeto da classe Bundle que contem o estado anterior da activity.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_evento);

        etNome =(EditText)findViewById(R.id.et_nome_evento_edit);
        etDescricao =(EditText)findViewById(R.id.et_descricao_evento_edit);
        etInicio =(TextView)findViewById(R.id.et_data_evento_edit);
        resources = getResources();

        eventoDao = new EventoDao(getApplicationContext());
        eventoNegocio = new EventoNegocio(getApplicationContext());
        sessao = new SessaoUsuario(getApplicationContext());

        sessao.iniciarSessao();

        Intent intentCalendario = getIntent();
        String data = intentCalendario.getStringExtra("data");
        etInicio.setText(data);

        iniciarTextos();
        initViews();
    }

    /**
     * O método initViews() tem a funcionalidade de ficar observando as mudancas nos textos dos
     * EditTexts da activity e se algum for mudado ira atualizar os atributos que estao
     * relacionados com os EditTexts mudados.
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

        etNome.addTextChangedListener(textWatcher);
        etDescricao.addTextChangedListener(textWatcher);
    }

    /**
     * O método iniciarTextos() tem a funcionalidade de setar os textos nos EditTexts que foram
     * encontrados no metodo buscarEvento() da classe EventoDao.
     *
     * @see EventoDao#buscarEvento(String)
     */

    public void iniciarTextos(){
        Evento evento = eventoDao.buscarEvento(etInicio.getText().toString());
        etNome.setText(evento.getNome());
        etDescricao.setText(evento.getDescricao());
    }

    /**
     * O método editarEvento() tem a funcionalidade de criar um objeto Evento e seta seus
     * atributos, em seguida chama o metodo atualizarRegistro() da classe eventoDao e inicia
     * o activity CalendarioActivity.
     *
     * @see CadastroActivity
     * @see EventoDao#atualizarRegistro(Evento)
     * @param view Contem o que foi "observado" na activity.
     */
    public  void editarEvento(View view){
        Evento evento = eventoDao.buscarEvento(etInicio.getText().toString());
        evento.setUsuario(sessao.getUsuarioLogado());
        evento.setNome(etNome.getText().toString());
        evento.setDescricao(etDescricao.getText().toString());
        evento.setDate(etInicio.getText().toString());

        eventoDao.atualizarRegistro(evento);

        startActivity(new Intent(this, CalendarioActivity.class));
        finish();
    }

    /**
     * O método deletar() tem a funcionalidade de criar um objeto Evento e chamar o método
     * delete() da classe eventoDao e em seguida inicia a activity CalendarioActivity().
     *
     * @see EventoDao#delete(Evento)
     * @see CalendarioActivity
     * @param view Contem o que foi "observado" na activity.
     */
    public void deletar(View view){
        Evento evento = eventoDao.buscarEvento(etInicio.getText().toString());
        eventoDao.delete(evento);
        startActivity(new Intent(this,CalendarioActivity.class));
        finish();
    }

}

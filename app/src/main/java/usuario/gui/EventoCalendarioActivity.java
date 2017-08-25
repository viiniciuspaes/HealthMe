package usuario.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;

import infra.GuiUtil;
import usuario.dao.EventoDao;
import usuario.dominio.Evento;
import usuario.negocio.EventoNegocio;
import usuario.negocio.SessaoUsuario;

/**
 * <h1>EventoCalendarioActivity</h1>
 * Activity responsavel por implementar as funcionalidade de adcionar eventos no calendario.
 */
public class EventoCalendarioActivity extends AppCompatActivity {
    private EditText etNome;
    private EditText etDescricao;
    private TextView etInicio;
    private Evento evento;
    private EventoNegocio validacao;
    private EventoDao dao;
    private SessaoUsuario sessao;
    private Resources resources;

    /**
     * O método onCreate() tem a funcionalidade de setar o layout: activity_evento_calendario e
     * setar os EditTexts e TextView do layout para cada atributo da classe e chama o metodo
     * getIntent() da classe Intent para resgatar Intent anterior para resgatar a data que esse
     * Intent enviou usando o metodo getStringExtra().
     *
     * @see Intent#getIntent(String)
     * @see Intent#getStringExtra(String)
     * @param savedInstanceState Objeto da classe Bundle que contem o estado anterior da activity
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_calendario);

        etNome =(EditText)findViewById(R.id.et_nome_evento);
        etDescricao =(EditText)findViewById(R.id.et_descricao_evento);
        etInicio =(TextView)findViewById(R.id.et_data_evento);
        resources = getResources();

        Intent intentCalendario = getIntent();
        String data = intentCalendario.getStringExtra("data");
        etInicio.setText(data);
    }

    /**
     * O metodo criarEvento() tem a funcionalidade de criar o evento com auxilio dos metodos:
     * iniciarSessao(), do SessaoUsuario, validarCampos() da mesma classe e inserirRegistro() do
     * EventoDao(). Depois retorna para activity CalendarioActivity().
     *
     * @see SessaoUsuario#iniciarSessao()
     * @see EventoCalendarioActivity#validarCampos(String)
     * @see EventoDao#inserirRegistro(Evento)
     * @param view Contem o que foi observado na activity.
     * @throws ParseException
     */

    public void criarEvento(View view) throws ParseException {
        evento = new Evento();
        validacao = new EventoNegocio(getApplicationContext());
        dao = new EventoDao(getApplicationContext());
        sessao = new SessaoUsuario(getApplicationContext());
        sessao.iniciarSessao();

        Boolean valido = validarCampos(etNome.getText().toString());
        if (valido){
            evento.setNome(etNome.getText().toString());
            evento.setDescricao(etDescricao.getText().toString());
            evento.setUsuario(sessao.getUsuarioLogado());
            String[] s = etInicio.getText().toString().split("/");
            String dataInvertida = s[2]+"/"+s[1]+"/"+s[0];
            evento.setDate(validacao.mudarData(dataInvertida));

            dao.inserirRegistro(evento);
            startActivity(new Intent(this, CalendarioActivity.class));
            finish();
        }else {
            GuiUtil gui = new GuiUtil();
            gui.toastShort(getApplicationContext(),"Erro ao inserir Evento");
        }
    }

    /**
     * O método voltar() tem a funcionalidade de voltar para activity CalendarioActivity.
     * @param view Contem o que foi observado na activity.
     */

    public void voltar(View view){
        startActivity(new Intent(EventoCalendarioActivity.this, CalendarioActivity.class));
        finish();
    }

    /**
     * O método validarCampos() tem a funcionalidade de verificar se o campo esta seguindo as
     * regras de negocio do app com auxilio dos metodos: verEspacosBrancos() e verAlfanumerico()
     * da classe EventoNegocio().
     *
     * @see EventoNegocio#verAlfanumerico(String)
     * @see EventoNegocio#verEspacosBrancos(String)
     * @param nome EditText do campo: etNome.
     * @return Retorna uma booleana
     */

    public boolean validarCampos(String nome){
        boolean verificador = false;
        if(!validacao.verEspacosBrancos(nome)){
            etNome.requestFocus();
            etNome.setError(resources.getString(R.string.erro_espaco_branco));
        }else if(!validacao.verAlfanumerico(nome)){
            etNome.requestFocus();
            etNome.setError(resources.getString(R.string.erro_caracter_especial));
        }else {
            verificador = true;
        }
        return  verificador;
    }
}

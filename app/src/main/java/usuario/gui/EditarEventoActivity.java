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

public class EditarEventoActivity extends AppCompatActivity {
    private EditText etNome;
    private EditText etDescricao;
    private TextView etInicio;
    private Resources resources;
    private EventoNegocio eventoNegocio;
    private EventoDao eventoDao;
    private SessaoUsuario sessao;

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
    public void iniciarTextos(){
        Evento evento = eventoDao.buscarEvento(etInicio.getText().toString());
        etNome.setText(evento.getNome());
        etDescricao.setText(evento.getDescricao());
    }
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
    public void deletar(View view){
        Evento evento = eventoDao.buscarEvento(etInicio.getText().toString());
        eventoDao.delete(evento);
        startActivity(new Intent(this,CalendarioActivity.class));
        finish();
    }

}

package usuario.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;

import infra.GuiUtil;
import usuario.dao.EventoDao;
import usuario.dominio.Evento;
import usuario.negocio.EventoNegocio;
import usuario.negocio.SessaoUsuario;


public class PopCalendarioActivity extends AppCompatActivity {
    private EditText etNome;
    private EditText etDescricao;
    private TextView etInicio;
    private Evento evento;
    private EventoNegocio validacao;
    private EventoDao dao;
    private SessaoUsuario sessao;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_calendario);

        etNome =(EditText)findViewById(R.id.et_nome_evento);
        etDescricao =(EditText)findViewById(R.id.et_descricao_evento);
        etInicio =(TextView)findViewById(R.id.et_data_evento);
        resources = getResources();

        Intent intentCalendario = getIntent();
        String data = intentCalendario.getStringExtra("data");
        etInicio.setText(data);
    }

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

            dao.inserirregistro(evento);
            startActivity(new Intent(this, CalendarioActivity.class));
            finish();
        }else {
            GuiUtil gui = new GuiUtil();
            gui.toastShort(getApplicationContext(),"Erro ao inserir Evento");
        }
    }

    public void voltar(View view){
        startActivity(new Intent(PopCalendarioActivity.this, CalendarioActivity.class));
        finish();
    }

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

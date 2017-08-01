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
    private EditText et_nome;
    private EditText et_descricao;
    private TextView et_inicio;
    private Evento evento;
    private EventoNegocio validacao;
    private EventoDao dao;
    private SessaoUsuario sessao;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_calendario);

        et_nome=(EditText)findViewById(R.id.et_nome_evento);
        et_descricao=(EditText)findViewById(R.id.et_descricao_evento);
        et_inicio=(TextView)findViewById(R.id.et_data_evento);
        resources = getResources();

        DisplayMetrics medidas= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);

        int largura=medidas.widthPixels;
        int altura=medidas.heightPixels;

        getWindow().setLayout((int)(largura * 0.8),(int)(altura * 0.6));

        Intent intentCalendario = getIntent();
        String data = intentCalendario.getStringExtra("data");
        et_inicio.setText(data);
    }

    public void criarEvento(View view) throws ParseException {
        evento = new Evento();
        validacao = new EventoNegocio(getApplicationContext());
        dao = new EventoDao(getApplicationContext());
        sessao = new SessaoUsuario(getApplicationContext());
        sessao.iniciarSessao();

        Boolean valido = validarCampos(et_nome.getText().toString());
        if (valido){
            evento.setNome(et_nome.getText().toString());
            evento.setDescricao(et_descricao.getText().toString());
            evento.setUsuario(sessao.getUsuarioLogado());
            String[] s = et_inicio.getText().toString().split("/");
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

    public boolean validarCampos(String nome){
        boolean verificador = false;
        if(!validacao.verEspacosBrancos(nome)){
            et_nome.requestFocus();
            et_nome.setError(resources.getString(R.string.erro_espaco_branco));
        }else if(!validacao.verAlfanumerico(nome)){
            et_nome.requestFocus();
            et_nome.setError(resources.getString(R.string.erro_caracter_especial));
        }else {
            verificador = true;
        }
        return  verificador;
    }
}

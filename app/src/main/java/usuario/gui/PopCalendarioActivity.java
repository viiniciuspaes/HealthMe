package usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;

import usuario.dao.EventoDao;
import usuario.dominio.Evento;
import usuario.negocio.SessaoUsuario;
import usuario.negocio.UsuarioValidacao;


public class PopCalendarioActivity extends AppCompatActivity {
    private EditText et_nome;
    private EditText et_descricao;
    private EditText et_inicio;
    private Evento evento;
    private UsuarioValidacao validacao;
    private EventoDao dao;
    private SessaoUsuario sessao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_calendario);

        et_nome=(EditText)findViewById(R.id.et_nome_evento);
        et_descricao=(EditText)findViewById(R.id.et_descricao_evento);
        et_inicio=(EditText)findViewById(R.id.et_data_evento);



        DisplayMetrics medidas= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);

        int largura=medidas.widthPixels;
        int altura=medidas.heightPixels;

        getWindow().setLayout((int)(largura * 0.8),(int)(altura * 0.6));
    }
    public void criarEvento(View view) throws ParseException {
        evento = new Evento();
        validacao = new UsuarioValidacao(getApplicationContext());
        dao = new EventoDao(getApplicationContext());
        sessao = new SessaoUsuario(getApplicationContext());
        sessao.iniciarSessao();

        evento.setNome(et_nome.getText().toString());
        evento.setDescricao(et_descricao.getText().toString());
        evento.setUsuario(sessao.getUsuarioLogado());
        evento.setDate(validacao.mudarData(et_inicio.getText().toString()));


        dao.inserirregistro(evento);
        startActivity(new Intent(this, CalendarioActivity.class));
        finish();
    }
}

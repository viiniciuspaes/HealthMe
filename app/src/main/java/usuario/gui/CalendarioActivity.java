package usuario.gui;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import usuario.dao.ContatoDao;
import usuario.dao.EventoDao;
import usuario.negocio.SessaoUsuario;

public class CalendarioActivity extends AppCompatActivity {
    private CalendarView calendario;
    private EventoDao daoEvento;
    private SessaoUsuario sessaoUsuario;
    private ListView listViewContatos;
    private SimpleCursorAdapter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        calendario=(CalendarView)findViewById(R.id.calendario);

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String data = i2 + "/" + i1 + "/" + i;

                Intent intentCalendario = new Intent(CalendarioActivity.this, PopCalendarioActivity.class);
                intentCalendario.putExtra("data",data);
                startActivity(intentCalendario);
            }
        });
        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        daoEvento = new EventoDao(getApplicationContext());
        sessaoUsuario.iniciarSessao();

        setTextos();
    }
    public void setTextos(){
        Cursor c = daoEvento.buscarDados(sessaoUsuario.getUsuarioLogado().getLogin());
        String[] from = new String[]{"_id","evento_nome","evento_usuario","descricao","data"};
        int[] to = new int[]{R.id.txvEventoId,R.id.txvEventoNome,R.id.txvEventoUsuario,R.id.txvEventoDescricao,R.id.txvEventoData};
        adpter = new SimpleCursorAdapter(getApplicationContext(), R.layout.modelo_listview_eventos, c, from, to,0);
        adpter.notifyDataSetChanged();
        listViewContatos = (ListView) findViewById(R.id.listaDeContatos);
        listViewContatos.setAdapter(adpter);
    }
}

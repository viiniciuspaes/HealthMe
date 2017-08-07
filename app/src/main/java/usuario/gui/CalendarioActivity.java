package usuario.gui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ListView;

import usuario.negocio.EventoNegocio;
import usuario.negocio.SessaoUsuario;

public class CalendarioActivity extends AppCompatActivity {
    private CalendarView calendario;
    private SessaoUsuario sessaoUsuario;
    private ListView listViewEventos;
    private EventoNegocio eventoNegocio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        calendario=(CalendarView)findViewById(R.id.calendario);

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String data = i2 + "/" + (1+i1) + "/" + i;

                Intent intentCalendario = new Intent(CalendarioActivity.this, PopCalendarioActivity.class);
                intentCalendario.putExtra("data",data);
                startActivity(intentCalendario);
                finish();
            }
        });
        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        sessaoUsuario.iniciarSessao();
        listViewEventos = (ListView) findViewById(R.id.listagem);
        eventoNegocio = new EventoNegocio(getApplicationContext());
        listViewEventos.setAdapter(eventoNegocio.construtorAdapter(sessaoUsuario));
    }
}

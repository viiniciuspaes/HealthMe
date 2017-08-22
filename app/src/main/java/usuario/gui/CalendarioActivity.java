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
        eventoNegocio = new EventoNegocio(getApplicationContext());
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String data = i2 + "/" + (1+i1) + "/" + i;

                Boolean verificador = eventoNegocio.verificarEvento(data);

                if (verificador){
                    Intent intentCalendario = new Intent(CalendarioActivity.this, EditarEventoActivity.class);
                    intentCalendario.putExtra("data",data);
                    startActivity(intentCalendario);
                    finish();
                }else {
                    Intent intentCalendario = new Intent(CalendarioActivity.this, EventoCalendarioActivity.class);
                    intentCalendario.putExtra("data",data);
                    startActivity(intentCalendario);
                    finish();
                }
            }
        });
        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        sessaoUsuario.iniciarSessao();
        listViewEventos = (ListView) findViewById(R.id.listagem);
        listViewEventos.setAdapter(eventoNegocio.construtorAdapter(sessaoUsuario));
    }
}

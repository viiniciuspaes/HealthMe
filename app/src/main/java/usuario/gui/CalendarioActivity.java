package usuario.gui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ListView;

import usuario.negocio.EventoNegocio;
import usuario.negocio.SessaoUsuario;

/**
 * <h1>CalendarioActivity</h1>
 * Acitivity responsavel pelas funcionalidades do Calendario.
 */

public class CalendarioActivity extends AppCompatActivity {
    private CalendarView calendario;
    private SessaoUsuario sessaoUsuario;
    private ListView listViewEventos;
    private EventoNegocio eventoNegocio;

    /**
     * O método onCreate() tem a funcionalidade de setar o layout: activity_calendario e setar o
     * CalendarView e o ListView do layout e caso o usuario clicar em uma data ira verificar se
     * existe evento em tal data usando o verificarEvento() da classe EventoNegocio() e depois ira
     * transitar para a activity EditarEventoActivity().
     *
     * @see EventoNegocio#verificarEvento(String)
     * @see EditarEventoActivity
     * @param savedInstanceState Um objeto da classe Bundle que contem o estado anterior da activity.
     */

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

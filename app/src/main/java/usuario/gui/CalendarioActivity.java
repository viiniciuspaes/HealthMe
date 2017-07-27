package usuario.gui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;


public class CalendarioActivity extends AppCompatActivity {
    //private static final String TAG = "calendarActivity";
    private CalendarView calendario;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        calendario=(CalendarView)findViewById(R.id.calendario);

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String data = i2 + "/" + i1 + "/" + i;
                //Log.d(TAG, "onSelectedDayChange: date: " + data);
                //startActivity(new Intent(CalendarioActivity.this, PopCalendarioActivity.class));

                Intent intentCalendario = new Intent(CalendarioActivity.this, PopCalendarioActivity.class);
                intentCalendario.putExtra("data",data);
                startActivity(intentCalendario);
            }
        });
    }
}

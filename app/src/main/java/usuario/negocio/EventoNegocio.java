package usuario.negocio;


import android.content.Context;

import java.util.Date;

public class EventoNegocio {
    private Context context;

    public EventoNegocio(Context context){
        this.context=context;
    }
     public String mudarData(Date a){
            return String.valueOf(a);
        }
}

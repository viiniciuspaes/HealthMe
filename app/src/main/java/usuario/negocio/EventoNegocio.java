package usuario.negocio;


import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventoNegocio {
    private Context context;
    private Pattern p1 = Pattern.compile("\\S+");
    private Pattern p2 = Pattern.compile("^[A-Za-z0-9]+$");
    private Matcher m;

    public EventoNegocio(Context context){
        this.context=context;
    }
     public String mudarData(Date a){
            return String.valueOf(a);
        }
    public Date mudarData(String a) throws ParseException {
        Date data=new SimpleDateFormat("yyyy/MM/dd").parse(a);
        return data;
    }
    public boolean verEspacosBrancos(String campo){
        String texto = campo;
        m = p1.matcher(texto);
        return m.matches();
    }
    public boolean verAlfanumerico(String campo){
        String texto = campo;
        m = p2.matcher(texto);
        return m.matches();
    }
}

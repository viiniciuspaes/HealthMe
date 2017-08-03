package usuario.negocio;


import android.content.Context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContatoNegocio {
    private Context context;
    private Pattern p2 = Pattern.compile("^[A-Za-z0-9]+$");
    private Matcher m;

    public ContatoNegocio(Context context) {
        this.context = context;
    }

    public boolean verAlfanumerico(String campo){
        String texto = campo;
        m = p2.matcher(texto);
        return m.matches();
    }
}

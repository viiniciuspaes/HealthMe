package usuario.negocio;


import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import usuario.dao.EventoDao;
import usuario.gui.R;

public class EventoNegocio {
    private Context context;
    private Pattern p1 = Pattern.compile("\\S+");
    private Pattern p2 = Pattern.compile("^[A-Za-z0-9]+$");
    private Matcher m;
    private EventoDao daoEvento;
    private SimpleCursorAdapter adapter;

    public EventoNegocio(Context context){
        this.context=context;
        daoEvento = new EventoDao(context);
    }
    public String mudarData(Date a){
            return String.valueOf(a);
        }
    public String mudarData(String a){
        String[] s = a.toString().split("/");
        String data = s[2]+"/"+s[1]+"/"+s[0];
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
    public SimpleCursorAdapter construtorAdapter(SessaoUsuario sessaoUsuario){
        Cursor c = daoEvento.buscarDados(sessaoUsuario.getUsuarioLogado().getLogin());
        String[] from = new String[]{"_id","evento_nome","evento_usuario","descricao","data"};
        int[] to = new int[]{R.id.txvEventoId,R.id.txvEventoNome,R.id.txvEventoUsuario,R.id.txvEventoDescricao,R.id.txvEventoData};
        adapter = new SimpleCursorAdapter(this.context, R.layout.modelo_listview_eventos, c, from, to,0);
        adapter.notifyDataSetChanged();
        return adapter;
    }
}

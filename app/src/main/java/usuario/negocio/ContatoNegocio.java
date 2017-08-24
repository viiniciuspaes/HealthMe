package usuario.negocio;


import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import usuario.dao.ContatoDao;
import usuario.dominio.ContatoEmergencia;
import usuario.gui.R;

public class ContatoNegocio {
    private Context context;
    private Pattern p2 = Pattern.compile("^[A-Za-z0-9]+$");
    private Matcher m;
    private ContatoDao daoContato;
    private SimpleCursorAdapter adapter;

    public ContatoNegocio(Context context) {
        this.context = context;
        daoContato = new ContatoDao(this.context);
    }

    public boolean verAlfanumerico(String campo){
        String texto = campo;
        m = p2.matcher(texto);
        return m.matches();
    }

    public SimpleCursorAdapter construtorAdapter(SessaoUsuario sessaoUsuario){
        Cursor c = daoContato.buscarDados(sessaoUsuario.getUsuarioLogado().getLogin());
        String[] from = new String[]{"_id","contato_usuario","contato_nome","contato_telefone"};
        int[] to = new int[]{R.id.txvContatoEmergencial,R.id.txvContatoUsuario,R.id.txvContatoNome,R.id.txvContatoNumero,};
        adapter = new SimpleCursorAdapter(this.context, R.layout.modelo_listview_contatos, c, from, to,0);
        adapter.notifyDataSetChanged();
        return adapter;
    }

    public ArrayList<ContatoEmergencia> smsContato(SessaoUsuario sessao){
        ArrayList<ContatoEmergencia> meusContatos = (ArrayList<ContatoEmergencia>) daoContato.buscarContatos(sessao.getUsuarioLogado().getLogin());
        return meusContatos;
    }
}





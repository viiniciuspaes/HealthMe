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

/**
 * <h1>ContatoNegocio</h1>
 * Classe responsavel pelas regras de negocio dos objetos ContatoEmergencia.
 */

public class ContatoNegocio {
    private Context context;
    private Pattern p2 = Pattern.compile("^[A-Za-z0-9]+$");
    private Matcher m;
    private ContatoDao daoContato;
    private SimpleCursorAdapter adapter;

    /**
     * Contrutor do Contato negocio.
     *
     * @param context O contexto da activity que esta chamando o ContatoNegocio.
     */
    public ContatoNegocio(Context context) {
        this.context = context;
        daoContato = new ContatoDao(this.context);
    }

    /**
     * O metodo verAlfanumerico() tem a funcionalidade de verificar se o campo que
     * foi usado como paremetro tem apenas letras e numeros com auxilio dos metodos: matcher() da
     * classe Pattern() e matches da classe Matcher().
     *
     * @see Pattern#matcher(CharSequence)
     * @see Matcher#matches()
     * @param campo Campos escolhido em formato String para ser verificado
     * @return Retorna uma booleana.
     */

    public boolean verAlfanumerico(String campo){
        String texto = campo;
        m = p2.matcher(texto);
        return m.matches();
    }

    /**
     * O metodo contrutorAdapter tem a funcionalidade de criar um adaptador com os contatos de
     * emergencia do usuario com seus respectivos telefones.
     *
      * @param sessaoUsuario A sessao do usuario que esta logado no aplicativo para coletar os dados dessa sessao.
     * @return Retorna um adaptador.
     */

    public SimpleCursorAdapter construtorAdapter(SessaoUsuario sessaoUsuario){
        Cursor c = daoContato.buscarDados(sessaoUsuario.getUsuarioLogado().getLogin());
        String[] from = new String[]{"_id","contato_usuario","contato_nome","contato_telefone"};
        int[] to = new int[]{R.id.txvContatoEmergencial,R.id.txvContatoUsuario,R.id.txvContatoNome,R.id.txvContatoNumero,};
        adapter = new SimpleCursorAdapter(this.context, R.layout.modelo_listview_contatos, c, from, to,0);
        adapter.notifyDataSetChanged();
        return adapter;
    }

    /**
     * O metodo smsContato() tem a funcionalidade de criar uma ArrayList com os contatos de emergencia
     * do usuario.
     *
     * @param sessao A sessao do usuario que esta logado no aplicativo para coletar os dados dessa sessao.
     * @return Retorna uma ArrayList
     */

    public ArrayList<ContatoEmergencia> smsContato(SessaoUsuario sessao){
        ArrayList<ContatoEmergencia> meusContatos = (ArrayList<ContatoEmergencia>) daoContato.buscarContatos(sessao.getUsuarioLogado().getLogin());
        return meusContatos;
    }
}





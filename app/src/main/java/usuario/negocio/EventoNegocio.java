package usuario.negocio;


import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import usuario.dao.EventoDao;
import usuario.dominio.Evento;
import usuario.gui.R;

/**
 * <h1>EventoNegocio</h1>
 * Classe responsavel pelas regras de negocio relacionadas com os objetos Evento do aplicativo.
 */

public class EventoNegocio {
    private Context context;
    private Pattern patternUm = Pattern.compile("\\S+");
    private Pattern patternDois = Pattern.compile("^[A-Za-z0-9]+$");
    private Matcher matcher;
    private EventoDao daoEvento;
    private SimpleCursorAdapter adapter;

    /**
     * Contrutor do EventoNegocio.
     *
     * @param context Parametro que ira ser o contexto da activity que ele for chamado.
     */

    public EventoNegocio(Context context){
        this.context=context;
        daoEvento = new EventoDao(context);
    }

    /**
     * O metodo mudarData() tem a funcionalidade de inverter a data que foi pega.
     *
     * @param a Data em formato String que foi escolhida.
     * @return Retorna a data invertida em formato String.
     */

    public String mudarData(String a){
        String[] s = a.toString().split("/");
        String data = s[2]+"/"+s[1]+"/"+s[0];
        return data;
    }

    /**
     * O metodo verEspacosBrancos() tem a funcionalidade de verificar se o campo usado como parametro
     * tem espacos em branco com auxilio dos metodos: matcher() da classe Pattern() e matches() da
     * classe Matcher().
     *
     * @see Pattern#matcher(CharSequence)
     * @see Matcher#matches()
     * @param campo Campos selecionado para ser verificado.
     * @return Retorna uma booleana.
     */

    public boolean verEspacosBrancos(String campo){
        String texto = campo;
        matcher = patternUm.matcher(texto);
        return matcher.matches();
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
        matcher = patternDois.matcher(texto);
        return matcher.matches();
    }

    /**
     * O metodo contrutorAdapter tem a funcionalidade de criar um adaptador com eventos do usuario
     * com suas respectivas datas.
     *
     * @param sessaoUsuario A sessao do usuario que esta logado no aplicativo para coletar os dados dessa sessao.
     * @return Retorna um adaptador.
     */

    public SimpleCursorAdapter construtorAdapter(SessaoUsuario sessaoUsuario){
        Cursor c = daoEvento.buscarDados(sessaoUsuario.getUsuarioLogado().getLogin());
        String[] from = new String[]{"_id","evento_nome","evento_usuario","descricao","data"};
        int[] to = new int[]{R.id.txvEventoId,R.id.txvEventoNome,R.id.txvEventoUsuario,R.id.txvEventoDescricao,R.id.txvEventoData};
        adapter = new SimpleCursorAdapter(this.context, R.layout.modelo_listview_eventos, c, from, to,0);
        adapter.notifyDataSetChanged();
        return adapter;
    }

    /**
     * O metodo verificarEvento() tem a funcionalidade de verificar no banco de dados se existe evento
     * marcado na data que foi usada como parametro com auxilio do buscarEvento() da classe EventoDao().
     *
     * @see EventoDao#buscarEvento(String)
     * @param data Data que deseja ser verificada.
     * @return Retorna uma booleana.
     */

    public Boolean verificarEvento(String data){
        Evento verificador = daoEvento.buscarEvento(data);
        if (verificador == null){
            return false;
        }else {
            return true;
        }
    }
}

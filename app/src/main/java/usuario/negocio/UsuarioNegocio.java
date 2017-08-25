package usuario.negocio;


import android.content.Context;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import infra.GuiUtil;
import usuario.dao.UsuarioDao;
import usuario.dominio.Pessoa;
import usuario.dominio.Usuario;

/**
 * <h1>UsuarioNegocio</h1>
 * Classe responsavel pelas regras de negocio relacionadas aos objetos Usuario do aplicativo.
 */

public class UsuarioNegocio {
    private Context context;
    private UsuarioDao usuarioDao;
    private Pattern patternUm = Pattern.compile("\\S+");
    private Pattern patternDois = Pattern.compile("^[A-Za-z0-9]+$");
    private Matcher matcher;

    /**
     * Contrutor do UsuarioNegocio.
     * @param context O contexto da activity que esta chamando o UsuarioNegocio.
     */

    public UsuarioNegocio(Context context) {
        this.context=context;
    }


    /**
     * O metodo login() tem a funcionalidade de verificar o login e senha do usuario existe no banco
     * de dados e verificar se o usuario esta ativo com ajuda do metodo: buscarUsuario() da classe
     * UsuarioDao().
     *
     * @see UsuarioDao#buscarUsuario(String)
     * @param email O login do usuario.
     * @param senha A senha do usuario.
     * @return Retorna o objeto Usuario relacionado com as informacoes dadas pelos parametros.
     */

    public Usuario login(String email, String senha){
        usuarioDao = new UsuarioDao(context);
        Usuario usuario = usuarioDao.buscarUsuario(email, senha);
        if(usuario.getAtivo().equals("0"))
            usuario = null;
        return usuario;
    }

    /**
     * O metodo validarCadastro() tem a funcionalidade de verificar se ja existe um usuario ja cadastrado
     * se nao houver chama o metodo inserirRegisto() da classe UsuarioDao() e caso o usuario estiver
     * apenas inativo o ativa novamente.
     *
     * @see UsuarioDao#inserirRegistro(Pessoa)
     * @param pessoa O objeto Pessoa que sera validado.
     */

    public void validarCadastro(Pessoa pessoa)  {
        usuarioDao = new UsuarioDao(context);
        Usuario verificar = usuarioDao.buscarUsuario(pessoa.getUsuario().getLogin());
        if (verificar==null){
            usuarioDao.inserirRegistro(pessoa);
            GuiUtil gui = new GuiUtil();
            gui.toastShort(context,"Cadastro realizado");
        }else{
            if (verificar.getAtivo().equals("0")){
                verificar.setAtivo();
                pessoa = usuarioDao.buscarPessoa(verificar.getLogin());
                pessoa.setUsuario(verificar);
                usuarioDao.atualizarRegistro(pessoa);
                GuiUtil gui = new GuiUtil();
                gui.toastShort(context,"Bem Vindo De volta.");
            }else {
                GuiUtil gui = new GuiUtil();
                gui.toastShort(context,"Usuário já cadastrado");
            }

        }

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
     * O metodo verificarTamanho tem a funcionalidade de verificar se o campo que foi usado
     * como parametro tem tamanho entre 4 a 12 caracteres.
     *
     * @param campo Campos escolhido em formato String para ser verificado
     * @return Retorna uma booleana.
     */
    public boolean verificarTamanho(String campo) {
        String texto = campo;
        if (texto.length() > 12 || texto.length() < 4) {
            return false;
        } else {
            return true;
        }
    }


}

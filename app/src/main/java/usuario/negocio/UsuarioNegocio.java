package usuario.negocio;


import android.content.Context;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import infra.GuiUtil;
import usuario.dao.UsuarioDao;
import usuario.dominio.Pessoa;
import usuario.dominio.Usuario;


public class UsuarioNegocio {
    private Context context;
    private UsuarioDao usuarioDao;
    private Pattern p1 = Pattern.compile("\\S+");
    private Pattern p2 = Pattern.compile("^[A-Za-z0-9]+$");
    private Matcher m;

    public UsuarioNegocio(Context context) {
        this.context=context;
    }

    public Usuario login(String email, String senha){
        usuarioDao = new UsuarioDao(context);
        Usuario usuario = usuarioDao.buscarUsuario(email, senha);
        if(usuario.getAtivo().equals("0"))
            usuario = null;
        return usuario;
    }

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

    public boolean verificarTamanho(String campo) {
        String texto = campo;
        if (texto.length() > 12 || texto.length() < 4) {
            return false;
        } else {
            return true;
        }
    }


}

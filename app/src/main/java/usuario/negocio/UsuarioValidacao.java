package usuario.negocio;


import android.content.Context;
import android.widget.Toast;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import usuario.dao.UsuarioDao;
import usuario.dominio.Pessoa;
import usuario.dominio.Usuario;


public class UsuarioValidacao {
    private Context context;
    private UsuarioDao usuarioDao;
    private Pattern p1 = Pattern.compile("\\S+");
    private Pattern p2 = Pattern.compile("^[a-z0-9]+$");
    private Matcher m;

    public UsuarioValidacao(Context context) {
        this.context=context;
    }

    public Usuario login(String email, String senha){
        usuarioDao = new UsuarioDao(context);
        Usuario usuario = usuarioDao.buscarUsuario(email, senha);
        return usuario;
    }

    public void validarCadastro(Pessoa pessoa)  {
        usuarioDao = new UsuarioDao(context);

        if (usuarioDao.buscarUsuario(pessoa.getUsuario().getLogin())==null){
            usuarioDao.inserirRegistro(pessoa);
            Toast.makeText(context, "Cadastro realizado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context,"Usuário já cadastrado",Toast.LENGTH_LONG).show();
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
        if (texto.length() > 8 || texto.length() < 4) {
            return false;
        } else {
            return true;
        }
    }
   // public String mudarData(Date a){
    //    return String.valueOf(a);
    //}
}

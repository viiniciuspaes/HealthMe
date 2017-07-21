package usuario.negocio;


import android.content.Context;
import android.widget.Toast;

import java.util.Date;

import usuario.dao.UsuarioDao;
import usuario.dominio.Pessoa;
import usuario.dominio.Usuario;


public class UsuarioValidacao {
    private Context context;
    private UsuarioDao usuarioDao;

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
        }else{
            Toast.makeText(context,"Usuário já cadastrado",Toast.LENGTH_LONG).show();
        }
    }
   // public String mudarData(Date a){
    //    return String.valueOf(a);
    //}
}

package negocio;


import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.UsuarioDao;
import dominio.Pessoa;
import dominio.Usuario;
import infra.CriptografiaSenha;


public class UsuarioValidacao {
    private Context context;
    private UsuarioDao usuarioDao;


    public UsuarioValidacao(Context context) {
        this.context=context;
    }

    public Usuario login(String email, String senha) throws Exception {

        Usuario usuario = usuarioDao.buscarUsuario(email, senha);

        return usuario;
    }

    public void validarCadastro(Pessoa pessoa)  {
        if (usuarioDao.buscarUsuario(pessoa.getUsuario().getLogin(),pessoa.getUsuario().getPassword()) == null){
            usuarioDao = new UsuarioDao(context);
            usuarioDao.inserirRegistro(pessoa);
        }
        }
    public String mudarData(Date a){
        return String.valueOf(a);
    }
}

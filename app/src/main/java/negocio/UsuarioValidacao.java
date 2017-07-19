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
    private CriptografiaSenha criptografiaSenha = new CriptografiaSenha();


    public UsuarioValidacao(Context context) {
        this.context=context;
    }


    public void login(String email, String senha) throws Exception {

        String senhaCriptografada = criptografiaSenha.criptoSenha(senha);

        Usuario usuario = usuarioDao.buscarUsuario(email, senhaCriptografada);

        if(usuario==null){
            throw  new Exception("Usuário e/ou senha inválidos");
        }else{
            //testando (não é assim)
            throw new Exception("Logado");
        }

    }

    public void validarCadastro(Pessoa pessoa)  {
        //falta coisa p cacimba nesse metodo como por exemplo buscar se o nome de usuario nao existe
            usuarioDao = new UsuarioDao(context);
            usuarioDao.inserirRegistro(pessoa);
        }
    public String mudarData(Date a){
        return String.valueOf(a);
    }
}

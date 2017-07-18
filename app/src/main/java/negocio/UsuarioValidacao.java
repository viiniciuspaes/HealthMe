package negocio;


import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import dao.UsuarioDao;
import dominio.Pessoa;
import dominio.Usuario;


public class UsuarioValidacao {
    private Context context;
    private UsuarioDao usuarioDao;


    public UsuarioValidacao(Context context) {
        this.context=context;
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

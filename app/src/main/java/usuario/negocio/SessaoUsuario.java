package usuario.negocio;


import android.content.Context;
import android.content.SharedPreferences;

import usuario.dao.UsuarioDao;
import usuario.dominio.Pessoa;

public class SessaoUsuario {

    private Pessoa usuarioLogado;
    private SharedPreferences preferences;
    //private SharedPreferences.Editor editor;

    public SessaoUsuario(SharedPreferences preferences){
        this.preferences = preferences;
        //this.editor = this.preferences.edit();
    }

    public Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Pessoa usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    public void iniciarSessao(Context context){
        UsuarioDao dao = new UsuarioDao(context);
        String usuario = preferences.getString("username","");

        setUsuarioLogado(dao.buscarPessoa(usuario));
    }
}

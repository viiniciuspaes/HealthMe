package usuario.negocio;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import usuario.dao.UsuarioDao;
import usuario.dominio.Pessoa;
import usuario.dominio.Usuario;
import usuario.gui.LogInActivity;

public class SessaoUsuario {
    private Pessoa pessoaLogada;



    private Usuario usuarioLogado;
    private SharedPreferences preferences;
    private Context context;
    private SharedPreferences.Editor editor;
    private static final String USUARIO_LOGADO = "Logado";
    private static final String NOME_USUARIO = "nome";
    private static final String PREFER_NOME = "preferencia";


    public SessaoUsuario(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREFER_NOME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void iniciarSessao(){
        UsuarioDao dao = new UsuarioDao(this.context);
        String usuario = getNome();

        setPessoaLogada(dao.buscarPessoa(usuario));
        setUsuarioLogado(dao.buscarUsuario(usuario));
    }

    public void logarUsuario(String nome) {
        editor.putBoolean(USUARIO_LOGADO, true);
        editor.putString(NOME_USUARIO, nome);
        editor.apply();
    }

    public void encerrarSessao() {
        editor.clear();
        editor.apply();

    }

    public boolean verificarLogin() {
        if (!this.vericarSesssao()){
            Intent intent = new Intent(context, LogInActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

            return true;
        }
        return false;
    }

    public Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public void setPessoaLogada(Pessoa pessoaLogada) {
        this.pessoaLogada = pessoaLogada;
    }
    public String getNome() {
        return preferences.getString(NOME_USUARIO, null);
    }
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    private boolean vericarSesssao() {
        return preferences.getBoolean(USUARIO_LOGADO, false);
    }
}

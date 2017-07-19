package negocio;


import dominio.Pessoa;
import dominio.Usuario;

public class SessaoUsuario {

    private Pessoa pessoaLogada;
    private Usuario usuarioLogado;
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public void setPessoaLogada(Pessoa pessoaLogada) {
        this.pessoaLogada = pessoaLogada;
    }
    public void iniciarSessao(){

    }
}

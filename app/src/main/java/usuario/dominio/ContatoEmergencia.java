package usuario.dominio;


public class ContatoEmergencia {
    private String nome;
    private String numero;



    private Usuario usuario;

    public ContatoEmergencia(){
        this.nome =null;
        this.numero =null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

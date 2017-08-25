package usuario.dominio;

/**
 * <h1>Evento</h1>
 * Classe responsavel pela criacao dos objetos Evento com seus gets e sets.
 */

public class Evento {
    private int id;
    private Usuario usuario;
    private String nome;
    private String descricao;
    private String data;

    public Evento(){
        this.nome = null;
        this.usuario = null;
        this.descricao = null;
        this.data = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDate() {
        return data;
    }

    public void setDate(String data) {
        this.data = data;
    }
}

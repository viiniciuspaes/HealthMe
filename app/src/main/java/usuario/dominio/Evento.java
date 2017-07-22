package usuario.dominio;


import java.util.Date;

public class Evento {
    private int id;
    private Usuario usuario;
    private String nome;
    private  String descricao;
    private Date inicio;
    private  Date fim;

    public Evento(){
        this.nome = null;
        this.usuario = null;
        this.descricao = null;
        this.inicio = null;
        this.fim = null;
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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }


}

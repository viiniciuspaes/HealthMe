package domain;


import java.util.Date;

public class Pessoa {
    private int id;
    private Usuario usuario;
    private String nome;
    private  String enderecoCasa;
    private  String enderecoTrabalho;
    private  String planoSaude;
    private Date nascimento;
    private  ContatoEmergencia[] contatoEmergencia;

    public Pessoa(){
        this.nome = null;
        this.usuario = null;
        this.enderecoCasa = null;
        this.enderecoTrabalho = null;
        this.planoSaude = null;
        this.nascimento = null;
        this.contatoEmergencia = null;
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

    public String getEnderecoCasa() {
        return enderecoCasa;
    }

    public void setEnderecoCasa(String enderecoCasa) {
        this.enderecoCasa = enderecoCasa;
    }

    public String getEnderecoTrabalho() {
        return enderecoTrabalho;
    }

    public void setEnderecoTrabalho(String enderecoTrabalho) {
        this.enderecoTrabalho = enderecoTrabalho;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public ContatoEmergencia[] getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(ContatoEmergencia[] contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }



}

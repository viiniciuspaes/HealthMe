package domain;


public class ContatoEmergencia {
    private String nome;
    private String numero;

    public ContatoEmergencia(){
        this.nome =null;
        this.numero =null;
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

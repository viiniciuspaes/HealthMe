package usuario.dominio;


import java.util.ArrayList;

public class PlanoSaude {

    private String nome;
    private ArrayList<CentroSaude> centrosSaude;

    public ArrayList<CentroSaude> getCentrosSaude() {
        return centrosSaude;
    }

    public void setCentrosSaude(ArrayList<CentroSaude> centrosSaude) {
        this.centrosSaude = centrosSaude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

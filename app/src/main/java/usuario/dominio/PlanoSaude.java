package usuario.dominio;

import java.util.ArrayList;

/**
 * <h1>PlanoSaude</h1>
 * Classe responsavel pela criacao dos objetos PlanoSaude com seus gets e sets.
 */

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

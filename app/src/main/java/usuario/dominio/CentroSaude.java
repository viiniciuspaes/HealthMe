package usuario.dominio;

import com.google.android.gms.maps.model.LatLng;

public class CentroSaude {

    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private LatLng localizacao;
    private PlanoSaude planoSaude;
    private String especializacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlanoSaude getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(PlanoSaude planoSaude) {
        this.planoSaude = planoSaude;
    }

    public LatLng getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LatLng localizacao) {
        this.localizacao = localizacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}

package dominio;


import com.google.android.gms.maps.model.LatLng;

public class CentroSaude {

    private String edereco;
    private LatLng localizacao;


    public LatLng getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LatLng localizacao) {
        this.localizacao = localizacao;
    }


    public String getEdereco() {
        return edereco;
    }

    public void setEdereco(String edereco) {
        this.edereco = edereco;
    }


}

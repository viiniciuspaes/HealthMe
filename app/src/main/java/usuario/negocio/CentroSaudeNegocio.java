package usuario.negocio;


import android.content.Context;

import java.util.List;

import usuario.dao.CentroSaudeDao;
import usuario.dominio.CentroSaude;

public class CentroSaudeNegocio {
    private CentroSaudeDao centroDao;


    public List<CentroSaude> getHospitais(Context context, String plano){
        centroDao = new CentroSaudeDao(context);
        List<CentroSaude> centros = centroDao.buscarCentros(plano);
        return centros;
    }
}

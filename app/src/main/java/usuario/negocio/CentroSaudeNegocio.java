package usuario.negocio;


import android.content.Context;

import java.util.List;

import usuario.dao.CentroSaudeDao;
import usuario.dominio.CentroSaude;

/**
 * <h1>CentroSaudeNegocio</h1>
 * Classe responsavel pelas regras de negocio relacionada com os CentroSaude.
 */

public class CentroSaudeNegocio {
    private CentroSaudeDao centroDao;

    /**
     * O metodo getHospitais() tem a funcionalidade de verificar qual o plano do usuario e cria uma
     * lista com os hospitais que aceitam o plano com auxilio do metodo buscarCentro()
     * da classe CentroSaudeDao().
     *
     * @see CentroSaudeDao#buscarCentros(String)
     * @param context Parametro que ira ser o contexto da activity que ele for chamado.
     * @param plano Parametro que e o plano de saude do usuario.
     * @return Retorna uma List com os objetos CentroSaude.
     */

    public List<CentroSaude> getHospitais(Context context, String plano){
        centroDao = new CentroSaudeDao(context);
        List<CentroSaude> centros = centroDao.buscarCentros(plano);
        return centros;
    }
}

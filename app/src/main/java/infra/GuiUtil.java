package infra;

import android.content.Context;
import android.widget.Toast;

/**
 * <h1>GuiUtil</h1>
 * Classe responsavel pela criacao dos toasts do aplicativo.
 */

public final class GuiUtil {

    public void toastLong(Context context, String texto){
        Toast.makeText(context, texto, Toast.LENGTH_LONG).show();
    }

    public void toastShort(Context context, String texto){
        Toast.makeText(context, texto, Toast.LENGTH_SHORT).show();
    }
}

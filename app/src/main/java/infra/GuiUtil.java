package infra;

import android.content.Context;
import android.widget.Toast;

public final class GuiUtil {

    public void toastLong(Context context, String texto){
        Toast.makeText(context, texto, Toast.LENGTH_LONG).show();
    }

    public void toastShort(Context context, String texto){
        Toast.makeText(context, texto, Toast.LENGTH_SHORT).show();
    }
}

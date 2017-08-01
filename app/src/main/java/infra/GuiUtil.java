package infra;

import android.content.Context;
import android.widget.Toast;

public final class GuiUtil {
    //private static GuiUtil guiUtil = new GuiUtil();

    //public GuiUtil(){
   // }

    //public static GuiUtil getGuiUtil(){
     //   return guiUtil;
    //}

    public void toastLong(Context context, String texto){
        Toast.makeText(context, texto, Toast.LENGTH_LONG).show();
    }

    public void toastShort(Context context, String texto){
        Toast.makeText(context, texto, Toast.LENGTH_SHORT).show();
    }
}

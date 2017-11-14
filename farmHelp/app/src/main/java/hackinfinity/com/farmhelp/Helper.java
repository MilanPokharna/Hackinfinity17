package hackinfinity.com.farmhelp;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

/**
 * Created by mohit on 12/11/17.
 */

public class Helper {
    private static ProgressDialog progressDialog;

    public static void log(String msg){
        Log.e("MohitDebugger", msg);
    }

    public static void startProgress(Context context, String msg){
        if(progressDialog == null){
            progressDialog = new ProgressDialog(context);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        progressDialog.setMessage(msg);
        progressDialog.show();

    }

    public static void dismissProgress(){
        if(progressDialog != null){
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    }
}

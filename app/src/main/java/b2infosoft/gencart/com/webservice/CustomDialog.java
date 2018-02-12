package b2infosoft.gencart.com.webservice;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import b2infosoft.gencart.com.R;


/**
 * Created by B2infosoft on 7/26/2017.
 */

public class CustomDialog extends Dialog {
    Context mContext = null;
    Activity activity = null;
    Boolean isCancelable = false;

    public CustomDialog(Context mContext) {
        super(mContext);
        this.mContext = mContext;
        activity = (Activity) mContext;
        isCancelable = false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.dialog_progress);
            AppGlobal.customDialog = this;
            this.setCancelable(isCancelable);
            //this.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
        } catch (Exception e) {
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}


//final Window window = customDialog.getWindow();
//window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


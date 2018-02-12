package b2infosoft.gencart.com.webservice;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by u on 19-Dec-17.
 */

public class AppGlobal {

    public static CustomDialog customDialog = null;
    public static String InternetConnectionFailed = "Either there was an Internet connection or problem may occured. Please try again";
    public static String EmptyField = "Please Enter All Fields.";
    public static String BaseUrl = "http://67.205.161.7/";
    public static String GetToken = BaseUrl + "oauth/token";
    public static String UserRegister = BaseUrl + "api/register";
    public static String GetStoresList = BaseUrl + "api/stores";
    public static String GetStoreProductList = BaseUrl + "api/stores/";
    public static String AuthGrantType = "password";
    public static String AuthUserName = "08095034525";
    public static String Authpassword = "password";
    public static String TokenType = "";
    public static String Expires_in = "";
    public static String Access_token = "";
    public static String Refresh_token = "";
    public static String address = "";
    ProgressDialog pDlg = null;


    public ProgressDialog showProgressDialog(Context mContext) {
        pDlg = new ProgressDialog(mContext);
        pDlg.setMessage("Please Wait...");
        pDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDlg.setCancelable(false);
        pDlg.show();
        return pDlg;
    }
}

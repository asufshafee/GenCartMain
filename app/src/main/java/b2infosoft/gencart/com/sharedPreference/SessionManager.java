package b2infosoft.gencart.com.sharedPreference;

import android.content.Context;
import android.content.SharedPreferences;


public class SessionManager {
    public static String Key_MilkPrice = "ss";
    public static String Key_SellMilkPrice = "aa";
    public static String Key_AnimalMilkFilter = "none";
    public static String PinNumber = "pin";
    Context mContext;
    static final String MyPREFERENCES = "MyPrefs";
    public static String KEY_UserID = "userID";
    public static String KEY_Mobile = "mob";
    public static String KEY_Email = "pass";
    public static String KEY_Adhar = "adhar";
    public static String KEY_Address = "address";
    public static String KEY_Name = "name";
    public static String KEY_FatherName = "f_name";
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    private static final String IS_LOGIN = "IsLoggedIn";
    public static String Key_UserGroupID = "gID";
    public static String Key_Status = "status";
    public static String Key_pwd = "pwd";


    public void createLoginSession(String userID, String name, String email, String phone, String user_grooupID) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_UserID, userID);
        editor.putString(KEY_Mobile, phone);
        editor.putString(KEY_Email, email);
        editor.putString(KEY_Name, name);
        editor.putString(Key_UserGroupID, user_grooupID);
        editor.apply();
    }

    public String getValueSesion(String key) {

        String value = sharedPreferences.getString(key, null);
        return value;

    }

    public void setValueSession(String key, String value) {
        editor.putString(key, value);
        editor.commit();

    }

    public void clearUserPreference(Context mContext) {

        this.mContext = mContext;
        editor.clear();
        editor.commit();
    }

    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }
}

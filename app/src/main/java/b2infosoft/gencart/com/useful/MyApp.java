package b2infosoft.gencart.com.useful;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;


/**
 * Created by Pankaj Jangid on 13-Oct-16.
 */

public class MyApp extends Application {

    private static MyApp mInstance;

    public static synchronized MyApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
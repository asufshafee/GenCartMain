package b2infosoft.gencart.com.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.webservice.AppGlobal;
import b2infosoft.gencart.com.webservice.WebServiceCaller;

public class SplashActivity extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext = SplashActivity.this;
      getAuthToken();
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 2 * 1000);*/
    }

    private void getAuthToken() {
        WebServiceCaller serviceCaller = new WebServiceCaller(WebServiceCaller.POST_TASK, mContext, "Processing..", false) {
            @Override
            public void handleResponse(String response) {
                Log.d("response>>>>", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    AppGlobal.TokenType = jsonObject.getString("token_type");
                    AppGlobal.Expires_in = jsonObject.getString("expires_in");
                    AppGlobal.Access_token = jsonObject.getString("access_token");
                    AppGlobal.Refresh_token = jsonObject.getString("refresh_token");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }, 2 * 1000);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        serviceCaller.addNameValuePair("grant_type", AppGlobal.AuthGrantType);
        serviceCaller.addNameValuePair("username", AppGlobal.AuthUserName);
        serviceCaller.addNameValuePair("password", AppGlobal.Authpassword);
        serviceCaller.execute(AppGlobal.GetToken);
        Log.d("Url>>>", AppGlobal.GetToken);

    }
}

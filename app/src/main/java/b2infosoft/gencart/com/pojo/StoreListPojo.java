package b2infosoft.gencart.com.pojo;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import b2infosoft.gencart.com.activity.LoginActivity;
import b2infosoft.gencart.com.useful.UtilityMethod;
import b2infosoft.gencart.com.webservice.AppGlobal;
import b2infosoft.gencart.com.webservice.MyApplication;

/**
 * Created by u on 25-Dec-17.
 */

public class StoreListPojo {


    public static void getStoreList(final Context mContext) {
        final ProgressDialog dialog = new AppGlobal().showProgressDialog(mContext);
        JsonObjectRequest myRequest = new JsonObjectRequest(Request.Method.GET, AppGlobal.GetStoresList, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONObject jo = new JSONObject();
                        JSONArray ja = new JSONArray();


                        //verificationSuccess(response);
                        Log.d("response>>>", response.toString());
                        dialog.dismiss();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error>>>", error.toString());
                        dialog.dismiss();

                        //verificationFailed(error);
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                headers.put("Authorization", AppGlobal.TokenType + " " + AppGlobal.Access_token);
                Log.d("headers>>>", headers.toString());
                return headers;
            }
        };
        MyApplication.getInstance().addToRequestQueue(myRequest, "tag");
    }

}



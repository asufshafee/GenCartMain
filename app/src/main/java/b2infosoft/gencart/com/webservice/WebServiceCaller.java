package b2infosoft.gencart.com.webservice;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import b2infosoft.gencart.com.useful.UtilityMethod;


public abstract class WebServiceCaller extends AsyncTask<String, Integer, String> {

    public static final int POST_TASK = 1;
    public static final int GET_TASK = 2;

    private static final String TAG = "WebServiceTask";

    // connection timeout, in milliseconds (waiting to connect)
    private static final int CONN_TIMEOUT = 60000;


    // socket timeout, in milliseconds (waiting for data)
    private static final int SOCKET_TIMEOUT = 60000;
    Context mContext;
    HttpEntity entity;
    private int taskType = GET_TASK;
    // private Context mContext = null;
    private String processMessage = "Processing...";
    private ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
    private ProgressDialog pDlg = null;
    private boolean DialogYesNo;

    public WebServiceCaller(int taskType, Context mContext, String processMessage, boolean DialogYesNo) {
        this.taskType = taskType;
        this.mContext = mContext;
        this.processMessage = processMessage;
        this.DialogYesNo = DialogYesNo;
    }

    public void addNameValuePair(String name, String value) {
        params.add(new BasicNameValuePair(name, value));
    }

    public void addEntity(HttpEntity entity) {
        this.entity = entity;
    }


    public void addNameValuePairArray(ArrayList<NameValuePair> params) {

        this.params = params;
    }

    public void addJsonPair(String name, String value) {

        params.add(new BasicNameValuePair(name, value));
    }


    private void showProgressDialog() {
        pDlg = new ProgressDialog(mContext);
        pDlg.setMessage(processMessage);
        pDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDlg.setCancelable(false);
        pDlg.show();
    }

    @Override
    protected void onPreExecute() {
        // hideKeyboard();
        if (DialogYesNo) {
            showProgressDialog();
        }
        /*if (pDlg != null && pDlg.isShowing()){
             pDlg.dismiss();
            pDlg = null;
        }*/
    }

    protected String doInBackground(String... urls) {
        String url = urls[0];
        String result = "";
        HttpResponse response = doResponse(url);

        if (response == null) {
            return result;
        } else {
            try {
                result = inputStreamToString(response.getEntity().getContent());
            } catch (IllegalStateException e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            } catch (IOException e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }
        }
        return result;
    }

    @Override
    protected void onPostExecute(String response) {
        handleResponse(response);

        if (response.isEmpty()) {

            //Toast.makeText(mContext, "Api calling failed", Toast.LENGTH_SHORT).show();
            UtilityMethod.showAlertBox(mContext, "Either there was network issue or some error occurred in submitting request, please try again...");
        }
        if (DialogYesNo) {
            if (pDlg != null && pDlg.isShowing()) {
                pDlg.dismiss();
                pDlg = null;
            }
        }
    }

    public abstract void handleResponse(String response);

    // Establish connection and socket (data retrieval) timeouts
    private HttpParams getHttpParams() {
        HttpParams htpp = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(htpp, CONN_TIMEOUT);
        HttpConnectionParams.setSoTimeout(htpp, SOCKET_TIMEOUT);
        return htpp;
    }

    /*private HttpResponse doResponse(String url) {
        // Use our connection and data timeouts as parameters for our
        // DefaultHttpClient
        HttpClient httpclient = new DefaultHttpClient(getHttpParams());
        HttpResponse response = null;
        try {
            switch (taskType) {
                case POST_TASK:
                    HttpPost httppost = new HttpPost(url);
                    // Add parameters
                    if (params.size() > 0) {
                        httppost.setEntity(new UrlEncodedFormEntity(params));
                    }
                    response = httpclient.execute(httppost);
                    break;
                case GET_TASK:
                    HttpGet httpget = new HttpGet(url);
                    response = httpclient.execute(httpget);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getLocalizedMessage(), e);

        }

        return response;
    }*/

    private HttpResponse doResponse(String url) {
        // Use our connection and data timeouts as parameters for our
        // DefaultHttpClient
        HttpClient httpclient = new DefaultHttpClient(getHttpParams());
        HttpResponse response = null;
        try {
            switch (taskType) {
                case POST_TASK:
                    HttpPost httppost = new HttpPost(url);
                    httppost.setHeader("Authorization", "Bearer " + AppGlobal.Access_token);

                    // httppost.setHeader();
                    // Add parameters
                    if (params.size() > 0) {
                        httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
                    }
                    if (entity != null) {
                        httppost.setEntity(entity);
                        //httppost.setEntity(new StringEntity(entity, HTTP.UTF_8));
                    }
                    response = httpclient.execute(httppost);
                    break;
                case GET_TASK:
                    HttpGet httpget = new HttpGet(url);
                    response = httpclient.execute(httpget);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getLocalizedMessage(), e);

        }

        return response;
    }

    private String inputStreamToString(InputStream is) {

        String line = "";
        StringBuilder total = new StringBuilder();

        // Wrap a BufferedReader around the InputStream
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));

        try {
            // Read response until the end
            while ((line = rd.readLine()) != null) {
                total.append(line);
            }
        } catch (IOException e) {
            Log.e(TAG, e.getLocalizedMessage(), e);
        }

        // Return full string
        return total.toString();
    }

}


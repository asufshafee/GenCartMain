package b2infosoft.gencart.com.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.useful.*;
import b2infosoft.gencart.com.webservice.AppGlobal;
import b2infosoft.gencart.com.webservice.MyApplication;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextInputLayout textInputLayoutemail, textInputLayoutFname, textInputLayoutLname, textInputLayoutPassword, textInputLayoutRePassword, textInputLayoutAddress, textInputLayoutMobile, textInputLayoutZip;
    EditText edtFirstName, edtLastName, edtPassword, edtRePassword, edtemail, edtMobile, edtZipCode;
    TextView tvSample;
    Button btnSignIn, btnFacebook;
    Context mContext;
    AutoCompleteTextView edtAddress;
    ConnectionDetector connectionDetector;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+[a-z]+";
    private static final String API_KEY = "AIzaSyCWSJNo4sQfVonDPjn0CVhWmK07aypSebA";
    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    private static final String OUT_JSON = "/json";

    String lat_long = "";
    TextView toolbar_title;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mContext = SignUpActivity.this;
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        toolbar_title.setText("Sign Up");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        connectionDetector = new ConnectionDetector(mContext);
        tvSample = (TextView) findViewById(R.id.tvSample);
        textInputLayoutZip = (TextInputLayout) findViewById(R.id.textInputLayoutZip);
        textInputLayoutFname = (TextInputLayout) findViewById(R.id.textInputLayoutFname);
        textInputLayoutLname = (TextInputLayout) findViewById(R.id.textInputLayoutLname);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutRePassword = (TextInputLayout) findViewById(R.id.textInputLayoutRePassword);
        textInputLayoutemail = (TextInputLayout) findViewById(R.id.textInputLayoutemail);
        textInputLayoutAddress = (TextInputLayout) findViewById(R.id.textInputLayoutAddress);
        textInputLayoutMobile = (TextInputLayout) findViewById(R.id.textInputLayoutMobile);
        edtFirstName = (EditText) findViewById(R.id.edtFirstName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtRePassword = (EditText) findViewById(R.id.edtRePassword);
        edtemail = (EditText) findViewById(R.id.edtemail);
        edtMobile = (EditText) findViewById(R.id.edtMobile);
        edtZipCode = (EditText) findViewById(R.id.edtZipCode);
        edtAddress = (AutoCompleteTextView) findViewById(R.id.edtAddress);

        tvSample.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        textInputLayoutZip.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        textInputLayoutMobile.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        textInputLayoutAddress.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        textInputLayoutFname.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        textInputLayoutLname.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        textInputLayoutPassword.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        textInputLayoutRePassword.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        textInputLayoutemail.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
//        textInputLayoutSelectDate.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        edtFirstName.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        edtLastName.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        edtPassword.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        edtRePassword.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        edtAddress.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        edtemail.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        edtMobile.setTypeface(Typeface.createFromAsset(getAssets(), "font/roboto_regular.ttf"));
        edtZipCode.setTypeface(Typeface.createFromAsset(getAssets(), "font/roboto_regular.ttf"));

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        edtAddress.setAdapter(new GooglePlacesAutocompleteAdapter(this, R.layout.list_item));
        edtAddress.setOnItemClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnSignIn:
                if (connectionDetector.isConnectingToInternet()) {
                    if (!edtZipCode.getText().toString().equals("") && !edtAddress.getText().toString().equals("") && !edtPassword.getText().toString().equals("") && !edtemail.getText().toString().equals("") &&
                            !edtFirstName.getText().toString().equals("") && !edtMobile.getText().toString().equals("") && !edtRePassword.getText().toString().equals("")) {
                        if (edtemail.getText().toString().trim().matches(emailPattern)) {
                            if (edtPassword.getText().toString().length() <= 6 && edtRePassword.getText().toString().length() <= 6) {
                                if (edtPassword.getText().toString().equals(edtRePassword.getText().toString())) {
                                    if (edtMobile.getText().toString().length() == 10) {
                                        registerUser();

                                    } else {
                                        UtilityMethod.showAlertBox(mContext, "Invalid Mobile Number.");

                                    }
                                } else {
                                    UtilityMethod.showAlertBox(mContext, "Your Password didn't match.");
                                }
                            } else {
                                UtilityMethod.showAlertBox(mContext, "Please enter password above 6 digit.");
                            }
                        } else {
                            UtilityMethod.showAlertBox(mContext, "Invalid Email Address");
                        }
                    } else {
                        UtilityMethod.showAlertBox(mContext, AppGlobal.EmptyField);
                    }
                } else {
                    UtilityMethod.showAlertBox(mContext, AppGlobal.InternetConnectionFailed);
                }
                break;
        }


    }

    private void registerUser() {
        final ProgressDialog dialog = new AppGlobal().showProgressDialog(mContext);
        Map<String, String> params = new HashMap<String, String>();
        params.put("address", edtAddress.getText().toString());
        params.put("name", edtFirstName.getText().toString());
        params.put("phone", edtMobile.getText().toString());
        params.put("email", edtemail.getText().toString());
        params.put("password", edtPassword.getText().toString());
        params.put("password_confirmation", edtRePassword.getText().toString());
        params.put("place_id", "");
        params.put("lat_long", lat_long);
        params.put("zipcode", edtZipCode.getText().toString());
        Log.d("params>>>", params.toString());
        JsonObjectRequest myRequest = new JsonObjectRequest(Request.Method.POST, AppGlobal.UserRegister, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //verificationSuccess(response);
                        Log.d("response>>>", response.toString());
                        dialog.dismiss();
                        UtilityMethod.showAlertBoxwithIntent(mContext, "Registration Success", LoginActivity.class);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error>>>", error.toString());
                        dialog.dismiss();
                        UtilityMethod.showAlertBox(mContext, "Registration Failed");
                        //verificationFailed(error);
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", AppGlobal.TokenType + " " + AppGlobal.Access_token);
                Log.d("headers>>>", headers.toString());
                return headers;
            }
        };
        MyApplication.getInstance().addToRequestQueue(myRequest, "tag");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String address = (String) adapterView.getItemAtPosition(position);
        Log.d("address>>>", address);
        Geocoder coder = new Geocoder(mContext);
        List<Address> addressList = null;
        try {
            // May throw an IOException
            addressList = coder.getFromLocationName(address, 5);
            Address location = addressList.get(0);
            lat_long = "" + location.getLatitude() + "," + location.getLongitude();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        edtAddress.setText("");
        edtAddress.setText(address);
        edtAddress.setSelection(edtAddress.getText().toString().length());
    }

    class GooglePlacesAutocompleteAdapter extends ArrayAdapter<String> implements Filterable {
        private ArrayList<String> resultList;

        public GooglePlacesAutocompleteAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }

        @Override
        public int getCount() {
            return resultList.size();
        }

        @Override
        public String getItem(int index) {
            return resultList.get(index);
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (constraint != null) {
                        // Retrieve the autocomplete results.
                        resultList = autocomplete(constraint.toString());

                        // Assign the data to the FilterResults
                        filterResults.values = resultList;
                        filterResults.count = resultList.size();
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    if (results != null && results.count > 0) {
                        notifyDataSetChanged();
                    } else {
                        notifyDataSetInvalidated();
                    }
                }
            };
            return filter;
        }
    }

    public static ArrayList<String> autocomplete(String input) {
        ArrayList<String> resultList = null;
        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();
        try {
            StringBuilder sb = new StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE + OUT_JSON);
            sb.append("?key=" + API_KEY);
            // sb.append("&components=country:US");
            sb.append("&input=" + URLEncoder.encode(input, "utf8"));
            URL url = new URL(sb.toString());
            System.out.println("URL: " + url);
            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            // Load the results into a StringBuilder
            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
        } catch (MalformedURLException e) {
            //Log.e(LOG_TAG, "Error processing Places API URL", e);
            return resultList;
        } catch (IOException e) {
            //Log.e(LOG_TAG, "Error connecting to Places API", e);
            return resultList;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        try {

            // Create a JSON object hierarchy from the results
            JSONObject jsonObj = new JSONObject(jsonResults.toString());
            JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");

            // Extract the Place descriptions from the results
            resultList = new ArrayList<String>(predsJsonArray.length());
            for (int i = 0; i < predsJsonArray.length(); i++) {
                System.out.println(predsJsonArray.getJSONObject(i).getString("description"));
                System.out.println("============================================================");
                resultList.add(predsJsonArray.getJSONObject(i).getString("description"));
            }
        } catch (JSONException e) {
            //Log.e(LOG_TAG, "Cannot process JSON results", e);
            e.printStackTrace();
        }

        return resultList;
    }
}

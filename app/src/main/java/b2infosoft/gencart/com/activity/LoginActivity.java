package b2infosoft.gencart.com.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
import java.util.List;

import b2infosoft.gencart.com.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtUserName, edtPassword;
    Button btnLogin, btnFb, btnTwitter;
    TextView tvOr, tvForgetPassword, tvNewHere, tvSignUp;

    Context mContext;



    public static final String FACEBOOK = "FACEBOOK";
    public static final String GOOGLE = "GOOGLE";
    public static final String TWITTER = "TWITTER";
    public static final String INSTAGRAM = "INSTAGRAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = LoginActivity.this;
        initView();
//        ButterKnife.bind(this);
    }

    private void initView() {

        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnFb = (Button) findViewById(R.id.btnFb);
        btnTwitter = (Button) findViewById(R.id.btnTwitter);
        tvOr = (TextView) findViewById(R.id.tvOr);
        tvForgetPassword = (TextView) findViewById(R.id.tvForgetPassword);
        tvNewHere = (TextView) findViewById(R.id.tvNewHere);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);

        edtUserName.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        edtPassword.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        btnLogin.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        btnFb.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        btnTwitter.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvOr.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvForgetPassword.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvNewHere.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvSignUp.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));


        btnLogin.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tvSignUp:
                startActivity(new Intent(mContext, SignUpActivity.class));
                break;
            case R.id.btnLogin:
                startActivity(new Intent(mContext, StoreListActivity.class));
                break;
        }

    }

//    void connectFacebook() {
//        List<String> scopes = Arrays.asList("user_birthday", "user_friends");
//
//        SimpleAuth.getInstance().connectFacebook(scopes, new AuthCallback() {
//            @Override
//            public void onSuccess(SocialUser socialUser) {
//                ProfileActivity.start(MainActivity.this, FACEBOOK, socialUser);
//            }
//
//            @Override
//            public void onError(Throwable error) {
//                toast(error.getMessage());
//            }
//
//            @Override
//            public void onCancel() {
//                toast("Canceled");
//            }
//        });
//    }
}

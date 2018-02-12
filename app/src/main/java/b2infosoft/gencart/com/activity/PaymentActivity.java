package b2infosoft.gencart.com.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.useful.UtilityMethod;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvPayment, tvCOD, tvPayOnline, tvYumCash, tvOnlineNetbanking, tvAddMoney, tvTotalCost, tvIncTax;
    ImageView imgRightClick;
    Context mContext;
    LinearLayout layoutCOD, layoutPaytm, layoutPayOnline, layoutYumCash, layoutYumCashTxt;
    String paymentMode = "", tax_percentage = "";
    TextView cashClick, onlineClick;
    RadioButton radioButtonOnline, radioButtonCash;
    TextView toolbar_title;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        mContext = PaymentActivity.this;
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
        toolbar_title.setText("Payment");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tvIncTax = (TextView) findViewById(R.id.tvIncTax);
        tvTotalCost = (TextView) findViewById(R.id.tvTotalCost);
        cashClick = (TextView) findViewById(R.id.cashClick);
        onlineClick = (TextView) findViewById(R.id.onlineClick);


        tvCOD = (TextView) findViewById(R.id.tvCOD);
        tvPayOnline = (TextView) findViewById(R.id.tvPayOnline);
        tvYumCash = (TextView) findViewById(R.id.tvYumCash);
        tvOnlineNetbanking = (TextView) findViewById(R.id.tvOnlineNetbanking);
        tvAddMoney = (TextView) findViewById(R.id.tvAddMoney);
        layoutCOD = (LinearLayout) findViewById(R.id.layoutCOD);
        layoutPaytm = (LinearLayout) findViewById(R.id.layoutPaytm);
        layoutPayOnline = (LinearLayout) findViewById(R.id.layoutPayOnline);
        layoutYumCash = (LinearLayout) findViewById(R.id.layoutYumCash);
        layoutYumCashTxt = (LinearLayout) findViewById(R.id.layoutYumCashTxt);

        radioButtonOnline = (RadioButton) findViewById(R.id.radioButtonOnline);
        radioButtonCash = (RadioButton) findViewById(R.id.radioButtonCash);

        layoutCOD.setBackgroundColor(getResources().getColor(R.color.color_white));
        layoutPayOnline.setBackgroundColor(getResources().getColor(R.color.color_white));

        tvCOD.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        tvPayOnline.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        tvYumCash.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        tvOnlineNetbanking.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvAddMoney.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_bold.ttf"));
        tvIncTax.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvTotalCost.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        imgRightClick = (ImageView) findViewById(R.id.imgRightClick);

        // imgRightClick.setOnClickListener(this);
        cashClick.setOnClickListener(this);
        onlineClick.setOnClickListener(this);
        imgRightClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, MyOrderActivity.class);
                startActivity(intent);
            }
        });


        // tvTotalCost.setText("Total Cost: " + .TotalCost + "/-");


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.locIcon:
                UtilityMethod.goNextClass(mContext, PickAddressActivity.class);
                break;
            case R.id.imgRightClick:

                if (paymentMode.equals("")) {

                    UtilityMethod.showAlertBox(mContext, "Please select payment mode.");

                } else {
                    bookOrder();
                }


                break;
            case R.id.cashClick:
                paymentMode = "cod";
                radioButtonCash.setChecked(true);
                radioButtonOnline.setChecked(false);

                break;
            case R.id.onlineClick:
                paymentMode = "paid";
                radioButtonCash.setChecked(false);
                radioButtonOnline.setChecked(true);
                break;

        }


    }


    private void bookOrder() {
    }
}
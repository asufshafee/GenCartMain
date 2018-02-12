package b2infosoft.gencart.com.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.adapter.ReviewOrderAdapter;

public class ReviewOrderActivity extends AppCompatActivity {

    RecyclerView recycler_cartList;
    TextView tvHotelNameTxt, tvPayableTxt, tvPayAmt, tvHotelName, tvInCart, tvPriceDetails, tvSubTotalTxt, tvSubTotal, tvTaxTxt, tvTax, tvDiscountTxt, tvDiscount, tvMinimumPurchaseTxt, tvMinimumPurchase, tvAddInfo, tvSave;
    LinearLayout LayoutExtraCharge, layoutShipping, layoutLateNight, layoutDiscount, layoutContainer, bgGst, discount_bg, extra_bg;
    TextView tvExtraCharge, tvExtraChargeFee, tvContainerChargeTxt, tvContainerCharge, tvGstTxt, tvGstAmt, tvLateNightChargeTxt, tvLateNightCharge;
    View viewExtraCharge;
    ImageView iconGoNext, locIcon;
    Context mContext;
    double amount = 0;
    EditText edtSuggestText;
    String suggestionText = "";
    String restName = "", Discount = "", DiscountType = "";
    String containerCharge = "";
    String minimumPurchase = "";
    String extraCharge = "", GstAmt = "";
    double discountPrice = 0;
    double discount = 0;
    double containerChargeDouble = 0;
    String RestInTime = "", RestOffTime = "";
    View viewLate, divDis, divContainer;
    TextView tvAfterDiscountTot, tvAfterDiscountTotTxt, tvAfterGstTotTxt, tvAfterGstTot;
    TextView toolbar_title;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_order);
        mContext = ReviewOrderActivity.this;

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
        toolbar_title.setText("Order Review");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        viewLate = (View) findViewById(R.id.viewLate);
        divContainer = (View) findViewById(R.id.divContainer);
        divDis = (View) findViewById(R.id.divDis);

        tvAfterGstTotTxt = (TextView) findViewById(R.id.tvAfterGstTotTxt);
        tvAfterGstTot = (TextView) findViewById(R.id.tvAfterGstTot);
        tvAfterDiscountTot = (TextView) findViewById(R.id.tvAfterDiscountTot);
        tvAfterDiscountTotTxt = (TextView) findViewById(R.id.tvAfterDiscountTotTxt);
        tvLateNightChargeTxt = (TextView) findViewById(R.id.tvLateNightChargeTxt);
        tvLateNightCharge = (TextView) findViewById(R.id.tvLateNightCharge);
        tvContainerChargeTxt = (TextView) findViewById(R.id.tvContainerChargeTxt);
        tvContainerCharge = (TextView) findViewById(R.id.tvContainerCharge);
        tvInCart = (TextView) findViewById(R.id.tvInCart);
        tvAddInfo = (TextView) findViewById(R.id.tvAddInfo);
        tvPriceDetails = (TextView) findViewById(R.id.tvPriceDetails);
        tvSubTotalTxt = (TextView) findViewById(R.id.tvSubTotalTxt);
        tvSubTotal = (TextView) findViewById(R.id.tvSubTotal);
        tvTaxTxt = (TextView) findViewById(R.id.tvTaxTxt);
        tvTax = (TextView) findViewById(R.id.tvTax);
        tvPayableTxt = (TextView) findViewById(R.id.tvPayableTxt);
        tvPayAmt = (TextView) findViewById(R.id.tvPayAmt);
        tvHotelNameTxt = (TextView) findViewById(R.id.tvHotelNameTxt);
        tvHotelName = (TextView) findViewById(R.id.tvHotelName);
        tvDiscountTxt = (TextView) findViewById(R.id.tvDiscountTxt);
        tvDiscount = (TextView) findViewById(R.id.tvDiscount);
        tvMinimumPurchaseTxt = (TextView) findViewById(R.id.tvMinimumPurchaseTxt);
        tvMinimumPurchase = (TextView) findViewById(R.id.tvMinimumPurchase);
        LayoutExtraCharge = (LinearLayout) findViewById(R.id.LayoutExtraCharge);
        layoutLateNight = (LinearLayout) findViewById(R.id.layoutLateNight);
        tvExtraCharge = (TextView) findViewById(R.id.tvExtraCharge);
        tvExtraChargeFee = (TextView) findViewById(R.id.tvExtraChargeFee);
        extra_bg = (LinearLayout) findViewById(R.id.extra_bg);
        discount_bg = (LinearLayout) findViewById(R.id.discount_bg);
        bgGst = (LinearLayout) findViewById(R.id.bgGst);

        tvGstTxt = (TextView) findViewById(R.id.tvGstTxt);
        tvGstAmt = (TextView) findViewById(R.id.tvGstAmt);
        viewExtraCharge = (View) findViewById(R.id.viewExtraCharge);
        iconGoNext = (ImageView) findViewById(R.id.iconGoNext);
        locIcon = (ImageView) findViewById(R.id.locIcon);
        layoutShipping = (LinearLayout) findViewById(R.id.layoutShipping);
        layoutDiscount = (LinearLayout) findViewById(R.id.layoutDiscount);
        layoutContainer = (LinearLayout) findViewById(R.id.layoutContainer);


        tvAfterGstTotTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvAfterDiscountTotTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvLateNightChargeTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvInCart.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvGstTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvHotelName.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvHotelNameTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvExtraCharge.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvExtraChargeFee.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvPayableTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvContainerChargeTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        //tvContainerCharge.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        //tvPriceDetails.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvSubTotalTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvMinimumPurchaseTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvAddInfo.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        // tvSubTotal.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        //tvTax.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        tvMinimumPurchase.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvDiscountTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        //tvDiscount.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        //tvConvenFee.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        //tvConvenice.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        tvTaxTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));

        iconGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, PickAddressActivity.class));
            }
        });
        setListAdapter();
    }


    public void setListAdapter() {
        ArrayList<String> mainCartList = new ArrayList<>();
        recycler_cartList = (RecyclerView) findViewById(R.id.recycler_cartList);
        final RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        recycler_cartList.setLayoutManager(linearLayoutManager);
        recycler_cartList.setAdapter(new ReviewOrderAdapter(mContext, mainCartList));
        recycler_cartList.setNestedScrollingEnabled(false);
    }

}

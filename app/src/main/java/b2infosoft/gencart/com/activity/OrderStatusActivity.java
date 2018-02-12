package b2infosoft.gencart.com.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import b2infosoft.gencart.com.R;

/**
 * Created by b2andro on 12/26/2017.
 */

public class OrderStatusActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvOrderID, tvOrderStatus, tvRecieved, tvInProcess, tvOut, tvCompletd, tvContainerChargeTxt, tvContainerCharge;
    ImageView imgRecieved, imgInProcess, imgCompleted;
    Context mContext;
    // ConnectionDetector connectionDetector;
    //SessionManager sessionManager;
    TextView tvAmountPay, tvAmountPayTxt, tvTotalCost, tvTotalCostTxt, tvTax, tvTaxTxt, tvConvenice, tvConvenFee, tvDeliveryCharge, tvDeliveryChargeTxt, tvCost, tvQuantity, tvMealName, tvOrderSummry, tvAddress, tvAddressTxt, tvPlacedAt, tvPlacedAtTxt, tvScheduleTime, tvScheduleTimeTxt, tvOrderDate, tvOrderDateTxt;
    RecyclerView recycler_orderList;
    private Timer mTimer1;
    ImageView imgOutToDeli;
    private TimerTask mTt1;
    TextView tvNextOrder, tvVarient;
    private Handler mTimerHandler = new Handler();
    private final static int INTERVAL = 1000 * 60 * 1; //1 minutes
    View divContainer, divDiscount;
    LinearLayout layoutContainer, layoutDiscount;
    TextView tvItemTot, tvItemTotTxt;
    TextView tvAfterDiscountTot, tvAfterDiscountTotTxt, tvAfterGstTotTxt, tvAfterGstTot, tvGstTxt, tvGstAmt;
    LinearLayout layoutContainer_bg, layoutDelivery_bg, tvGst_bg, layoutDiscount_bg;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderstatusactivity);
        mContext = OrderStatusActivity.this;
        initView();
    }


    private void initView() {


        //   connectionDetector = new ConnectionDetector(mContext);
        // sessionManager = new SessionManager(mContext);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tvAfterGstTotTxt = (TextView) findViewById(R.id.tvAfterGstTotTxt);
        tvAfterGstTot = (TextView) findViewById(R.id.tvAfterGstTot);
        tvAfterDiscountTot = (TextView) findViewById(R.id.tvAfterDiscountTot);
        tvAfterDiscountTotTxt = (TextView) findViewById(R.id.tvAfterDiscountTotTxt);
        imgOutToDeli = (ImageView) findViewById(R.id.imgOutToDeli);

        layoutDiscount_bg = (LinearLayout) findViewById(R.id.layoutDiscount_bg);
        tvGst_bg = (LinearLayout) findViewById(R.id.tvGst_bg);
        layoutDelivery_bg = (LinearLayout) findViewById(R.id.layoutDelivery_bg);
        layoutContainer_bg = (LinearLayout) findViewById(R.id.layoutContainer_bg);


        tvItemTot = (TextView) findViewById(R.id.tvItemTot);
        tvItemTotTxt = (TextView) findViewById(R.id.tvItemTotTxt);
        tvOrderID = (TextView) toolbar.findViewById(R.id.tvOrderID);
        tvOrderStatus = (TextView) toolbar.findViewById(R.id.tvOrderStatus);
        tvVarient = (TextView) findViewById(R.id.tvHalfLabel);
        tvRecieved = (TextView) findViewById(R.id.tvRecieved);
        tvInProcess = (TextView) findViewById(R.id.tvInProcess);
        tvOut = (TextView) findViewById(R.id.tvOut);
        tvCompletd = (TextView) findViewById(R.id.tvCompletd);
        imgRecieved = (ImageView) findViewById(R.id.imgRecieved);
        imgInProcess = (ImageView) findViewById(R.id.imgInProcess);
        imgOutToDeli = (ImageView) findViewById(R.id.imgOutToDeli);
        imgCompleted = (ImageView) findViewById(R.id.imgCompleted);
        tvAmountPay = (TextView) findViewById(R.id.tvAmountPay);
        tvAmountPayTxt = (TextView) findViewById(R.id.tvAmountPayTxt);
        tvTotalCost = (TextView) findViewById(R.id.tvTotalCost);
        tvTotalCostTxt = (TextView) findViewById(R.id.tvTotalCostTxt);
        tvTax = (TextView) findViewById(R.id.tvTax);
        tvTaxTxt = (TextView) findViewById(R.id.tvTaxTxt);
        tvConvenice = (TextView) findViewById(R.id.tvConvenice);
        tvDeliveryCharge = (TextView) findViewById(R.id.tvDeliveryCharge);
        tvDeliveryChargeTxt = (TextView) findViewById(R.id.tvDeliveryChargeTxt);
        tvCost = (TextView) findViewById(R.id.tvHalfPrice);
        tvQuantity = (TextView) findViewById(R.id.tvHalfQty);
        tvMealName = (TextView) findViewById(R.id.tvMealName);
        tvOrderSummry = (TextView) findViewById(R.id.tvOrderSummry);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        tvAddressTxt = (TextView) findViewById(R.id.tvAddressTxt);
        tvPlacedAt = (TextView) findViewById(R.id.tvPlacedAt);
        tvPlacedAtTxt = (TextView) findViewById(R.id.tvPlacedAtTxt);
        tvScheduleTime = (TextView) findViewById(R.id.tvScheduleTime);
        tvScheduleTimeTxt = (TextView) findViewById(R.id.tvScheduleTimeTxt);
        tvOrderDate = (TextView) findViewById(R.id.tvOrderDate);
        tvOrderDateTxt = (TextView) findViewById(R.id.tvOrderDateTxt);
        tvConvenFee = (TextView) findViewById(R.id.tvConvenFee);
        tvNextOrder = (TextView) findViewById(R.id.tvNextOrder);
        tvContainerChargeTxt = (TextView) findViewById(R.id.tvContainerChargeTxt);
        tvContainerCharge = (TextView) findViewById(R.id.tvContainerCharge);
        layoutContainer = (LinearLayout) findViewById(R.id.layoutContainer);
        layoutDiscount = (LinearLayout) findViewById(R.id.layoutDiscount);
        divDiscount = (View) findViewById(R.id.divDiscount);
        divContainer = (View) findViewById(R.id.divContainer);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tvGstTxt = (TextView) findViewById(R.id.tvGstTxt);
        tvGstAmt = (TextView) findViewById(R.id.tvGstAmt);
        recycler_orderList = (RecyclerView) findViewById(R.id.recycler_orderList);
        imgOutToDeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(OrderStatusActivity.this, DrivermapActivity.class);
                startActivity(intent3);
            }
        });


        tvGstTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvAfterGstTotTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvAfterDiscountTotTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvContainerChargeTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvItemTotTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvRecieved.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvInProcess.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvOut.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvCompletd.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        // tvOrderID.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvOrderStatus.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvNextOrder.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        //tvAmountPay.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvAmountPayTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        //tvTotalCost.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvTotalCostTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvVarient.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        //  tvTax.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvTaxTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        //  tvConvenice.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvConvenFee.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        //tvDeliveryCharge.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvDeliveryChargeTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvCost.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvQuantity.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvMealName.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvOrderSummry.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvAddress.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvAddressTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvPlacedAt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvPlacedAtTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        //tvScheduleTime.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvScheduleTimeTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        //tvOrderDate.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvOrderDateTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        //MyOrderPojo.getOrderList(mContext, sessionManager.getValuesSession(SessionManager.Key_UserID), "OrderStatus");
        //tvOrderID.setText("#" + AppGlobal.OrderID);
        tvNextOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(OrderStatusActivity.this, StoreListActivity.class);
                startActivity(intent2);
                //onBackPressed();
                //UtilityMethod.goNextClass(mContext, RestaurantListActivity.class);
            }
        });


    }


    @Override
    public void onClick(View view) {


    }

}

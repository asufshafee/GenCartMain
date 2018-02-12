package b2infosoft.gencart.com.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.adapter.PickAddressAdapter;

public class PickAddressActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recycler_addressList;
    TextView tvNameTxt, tvName, tvMobileTxt, tvMobile, tvEmailTxt, tvEmail;
    LinearLayout layoutAddAddress;
    Context mContext;
    ImageView  iconGoNext;
    Button btnAddAddress;
    TextView toolbar_title;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_address);
        mContext = PickAddressActivity.this;
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
        toolbar_title.setText("Address");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tvNameTxt = (TextView) findViewById(R.id.tvNameTxt);
        tvName = (TextView) findViewById(R.id.tvName);
        tvMobileTxt = (TextView) findViewById(R.id.tvMobileTxt);
        tvMobile = (TextView) findViewById(R.id.tvMobile);
        tvEmailTxt = (TextView) findViewById(R.id.tvEmailTxt);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        layoutAddAddress = (LinearLayout) findViewById(R.id.layoutAddAddress);
        btnAddAddress = (Button) findViewById(R.id.btnAddAddress);
        iconGoNext = (ImageView) findViewById(R.id.iconGoNext);
        layoutAddAddress.setOnClickListener(this);
        iconGoNext.setOnClickListener(this);

        tvNameTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvName.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvMobileTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        // tvMobile.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvEmailTxt.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvEmail.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        btnAddAddress.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        btnAddAddress.setOnClickListener(this);



        ArrayList<String>list = new ArrayList<>();
        recycler_addressList = findViewById(R.id.recycler_addressList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        recycler_addressList.setLayoutManager(linearLayoutManager);
        recycler_addressList.setHasFixedSize(true);
        PickAddressAdapter adapter = new PickAddressAdapter(mContext, list);
        recycler_addressList.setAdapter(adapter);



        iconGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PickAddressActivity.this,PaymentActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}

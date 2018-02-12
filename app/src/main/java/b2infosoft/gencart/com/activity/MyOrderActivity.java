package b2infosoft.gencart.com.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.adapter.MyOrderAdapter;
import b2infosoft.gencart.com.pojo.MyOrderPojo;

public class MyOrderActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerMyOrder;
    Context mContext;
    Button myOrderButton;
    TextView toolbar_title;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        mContext = MyOrderActivity.this;
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
        toolbar_title.setText("My Order");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        setOrderAdapter();
    }

    public void setOrderAdapter() {
        ArrayList<MyOrderPojo> mList = new ArrayList<>();
        recyclerMyOrder = (RecyclerView) findViewById(R.id.recyclerMyOrder);
        final RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        recyclerMyOrder.setLayoutManager(linearLayoutManager);
        recyclerMyOrder.setAdapter(new MyOrderAdapter(mContext, mList));
    }

    @Override
    public void onClick(View view) {

    }
}

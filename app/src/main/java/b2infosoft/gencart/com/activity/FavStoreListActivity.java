package b2infosoft.gencart.com.activity;

import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.adapter.AllProductListAdapter;
import b2infosoft.gencart.com.adapter.FavStoreListAdapter;
import b2infosoft.gencart.com.pojo.StoreListPojo;

public class FavStoreListActivity extends AppCompatActivity {

    RecyclerView recyclerFavStoreList;
    TextView toolbar_title;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_store_list);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        toolbar_title.setText("Favourite Store");

        recyclerFavStoreList = (RecyclerView) findViewById(R.id.recyclerFavStoreList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerFavStoreList.setLayoutManager(linearLayoutManager);
        recyclerFavStoreList.setHasFixedSize(true);
        ArrayList<StoreListPojo> mStoreListPojos = new ArrayList<>();
        FavStoreListAdapter mAdapter = new FavStoreListAdapter(getApplicationContext(), mStoreListPojos);
        recyclerFavStoreList.setAdapter(mAdapter);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}

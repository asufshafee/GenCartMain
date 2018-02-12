package b2infosoft.gencart.com.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.adapter.ProductsViewPagerAdapter;

public class ProductListActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Context mContext;
    TextView tvAddress;
    ImageView htab_header;
    RelativeLayout logoShadow;
    EditText autoCompView;
    public ImageView fabCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        initView();
    }

    private void initView() {
        mContext = ProductListActivity.this;
        toolbar = (Toolbar) findViewById(R.id.htab_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null) getSupportActionBar().setTitle("Store 1");
        logoShadow = (RelativeLayout) findViewById(R.id.logoShadow);
        viewPager = (ViewPager) findViewById(R.id.htab_viewpager);
        htab_header = (ImageView) findViewById(R.id.htab_header);
        autoCompView = (EditText) findViewById(R.id.autoCompleteTextView);
        autoCompView.setCursorVisible(false);
        autoCompView.setClickable(false);
        autoCompView.setEnabled(false);
        autoCompView.setText("Store 1");
        fabCart = (ImageView) findViewById(R.id.fabCart);
        autoCompView.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        setListAdapter();
        fabCart.setOnClickListener(this);
    }


    public void setListAdapter() {
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.htab_collapse_toolbar);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorAccent));
        collapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.color_black));
        viewPager = (ViewPager) findViewById(R.id.htab_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.htab_tabs);


        ArrayList<String> restaurantCategoryList = new ArrayList<>();
        restaurantCategoryList.add("Home and Kitchen");
        restaurantCategoryList.add("Toy-Games");
        restaurantCategoryList.add("Sports");
        restaurantCategoryList.add("Health");
        restaurantCategoryList.add("Beauty");
        for (int i = 0; i < restaurantCategoryList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText("" + restaurantCategoryList.get(i)));
        }
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        final ProductsViewPagerAdapter adapter = new ProductsViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), restaurantCategoryList);
        viewPager.setAdapter(adapter);
        viewPager.getAdapter().notifyDataSetChanged();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Fragment f = adapter.getItem(position);
                f.onResume();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                //AppGlobal.CategoryID = restaurantCategoryList.get(tab.getPosition()).category_id;
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabCart:
                startActivity(new Intent(mContext, ReviewOrderActivity.class));
                break;
        }
    }
}

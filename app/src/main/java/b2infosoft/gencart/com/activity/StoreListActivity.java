package b2infosoft.gencart.com.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.adapter.AdvertiesViewPagerAdapter;
import b2infosoft.gencart.com.adapter.StoreViewPagerAdapter;
import b2infosoft.gencart.com.pojo.CategarylistPojo;
import b2infosoft.gencart.com.pojo.StoreListPojo;
import b2infosoft.gencart.com.pojo.ZoomOutPageTransformer;
import de.hdodenhof.circleimageview.CircleImageView;
import me.angeldevil.autoscrollviewpager.AutoScrollViewPager;

public class StoreListActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvCity, tvArea, edtSearch, tvChat, tvFav, tvOrder, tvCart, tvNotification;
    RelativeLayout RelativeHeaderbar;
    Context mContext;
    ViewPager htab_viewpager;
    TabLayout tablayoutmain;
    StoreViewPagerAdapter myAdapter;
    AutoScrollViewPager viewpager_adverties;
    LinearLayout layoutFav, layoutCart, layoutNotification, layoutOrder,layoutChat;
    ArrayList<CategarylistPojo> tabsPagerAdapterPojos = new ArrayList<>();
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_store_list_main);
        initView();
    }

    private void initView() {
        mContext = StoreListActivity.this;
        RelativeHeaderbar = (RelativeLayout) findViewById(R.id.RelativeHeaderbar);
        tvNotification = (TextView) findViewById(R.id.tvNotification);
        tvOrder = (TextView) findViewById(R.id.tvOrder);
        tvCity = (TextView) findViewById(R.id.tvCity);
        edtSearch = (TextView) findViewById(R.id.edtSearch);
        tvArea = (TextView) findViewById(R.id.tvArea);
        tvFav = (TextView) findViewById(R.id.tvFav);
        tvChat = (TextView) findViewById(R.id.tvChat);
        tvCart = (TextView) findViewById(R.id.tvCart);
        layoutFav = (LinearLayout) findViewById(R.id.layoutFav);
        layoutCart = (LinearLayout) findViewById(R.id.layoutCart);
        layoutOrder = (LinearLayout) findViewById(R.id.layoutOrder);
        layoutNotification = (LinearLayout) findViewById(R.id.layoutNotification);
        layoutChat = (LinearLayout) findViewById(R.id.layoutChat);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.htab_collapse_toolbar);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorAccent));
        collapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.color_black));
        tvNotification.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvCart.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvCity.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvFav.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvChat.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvOrder.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        tvArea.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        edtSearch.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));
        htab_viewpager = (ViewPager) findViewById(R.id.htab_viewpager);
        tablayoutmain = (TabLayout) findViewById(R.id.htab_tabs);
        layoutFav.setOnClickListener(this);
        layoutCart.setOnClickListener(this);
        layoutNotification.setOnClickListener(this);
        layoutOrder.setOnClickListener(this);
        layoutChat.setOnClickListener(this);
        setAdapterList();
    }


    @SuppressLint("NewApi")
    public void setAdapterList() {
        final ArrayList<Integer> advertiesPojos = new ArrayList<>();
        advertiesPojos.add(R.drawable.food);
        advertiesPojos.add(R.drawable.food);
        advertiesPojos.add(R.drawable.food);
        advertiesPojos.add(R.drawable.food);
        advertiesPojos.add(R.drawable.food);
        advertiesPojos.add(R.drawable.food);

        viewpager_adverties = (AutoScrollViewPager) findViewById(R.id.viewpager_adverties);
       /* viewpager_adverties.setAdapter(new AdvertiesViewPagerAdapter(viewpager_adverties, advertiesPojos, mContext));
        viewpager_adverties.setPageTransformer(true, new ZoomOutPageTransformer());*/
        //   viewpager_adverties.setCycle(true);
        //    viewpager_adverties.setDirection(AutoScrollViewPager.DIRECTION_RIGHT);

        viewpager_adverties.setClipToPadding(false);
        viewpager_adverties.setPadding(20, 10, 20, 10);
        viewpager_adverties.setPageMargin(10);

        viewpager_adverties.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return advertiesPojos.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }

            @Override
            public Object instantiateItem(ViewGroup container, final int position) {
                ImageView view = new ImageView(container.getContext());
                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Glide.with(mContext)
                        .load(R.drawable.food)
                        .crossFade()
                        .into(view);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });

        viewpager_adverties.setScrollFactor(5);
        viewpager_adverties.setOffscreenPageLimit(4);
        viewpager_adverties.startAutoScroll(2500);
        tabsPagerAdapterPojos.add(new CategarylistPojo("hhjfh", "h", "bh", "All", "ghg", "ghh"));
        tabsPagerAdapterPojos.add(new CategarylistPojo("GH", "G", "GY", "Department", "HH", "GH"));
        tabsPagerAdapterPojos.add(new CategarylistPojo("hhjfh", "h", "bh", "Coupan", "ghg", "ghh"));
        tabsPagerAdapterPojos.add(new CategarylistPojo("GH", "G", "GY", "Get$50", "HH", "GH"));
        tabsPagerAdapterPojos.add(new CategarylistPojo("GH", "G", "GY", "Grocries Items Store", "HH", "GH"));

        for (int i = 0; i < tabsPagerAdapterPojos.size(); i++) {
            tablayoutmain.addTab(tablayoutmain.newTab().setText("" + tabsPagerAdapterPojos.get(i).CategaryCoupan));
            TabLayout.Tab tab = tablayoutmain.getTabAt(i);
            LinearLayout relativeLayout = (LinearLayout)
                    LayoutInflater.from(this).inflate(R.layout.tab_layout, tablayoutmain, false);

            View div;
            TextView tabTextView = (TextView) relativeLayout.findViewById(R.id.tab_title);
            CircleImageView imgCategory = (CircleImageView) relativeLayout.findViewById(R.id.imgCategory);
            imgCategory.setImageResource(R.drawable.food);
            tabTextView.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_semibold.ttf"));
            tabTextView.setText(tab.getText());
            tab.setCustomView(relativeLayout);

        }
        tablayoutmain.setTabGravity(TabLayout.GRAVITY_FILL);
        htab_viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayoutmain));
        ArrayList<StoreListPojo> storeListPojos = new ArrayList<>();
        //ViewPagerAdapter myAdapter=new ViewPagerAdapter(mContext,storeListPojos);
        myAdapter = new StoreViewPagerAdapter(getSupportFragmentManager(), tablayoutmain.getTabCount(), tabsPagerAdapterPojos);
        htab_viewpager.setAdapter(myAdapter);
        htab_viewpager.getAdapter().notifyDataSetChanged();
        //htab_viewpager.setNestedScrollingEnabled(false);
        htab_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               /* Fragment f = myAdapter.getItem(position);
                f.onResume();*/
                tablayoutmain.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        tablayoutmain.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // AppGlobal.CategoryID = restaurantCategoryList.get(tab.getPosition()).category_id;
                htab_viewpager.setCurrentItem(tab.getPosition());
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
            case R.id.layoutFav:
                startActivity(new Intent(mContext, FavStoreListActivity.class));
                break;
            case R.id.layoutCart:
                startActivity(new Intent(mContext, ReviewOrderActivity.class));
                break;
            case R.id.layoutNotification:
                startActivity(new Intent(mContext, NotificationActivity.class));
                break;
            case R.id.layoutOrder:
                startActivity(new Intent(mContext, MyOrderActivity.class));
                break;case R.id.layoutChat:
                startActivity(new Intent(mContext, ChatActivity.class));
                break;
        }
    }
}




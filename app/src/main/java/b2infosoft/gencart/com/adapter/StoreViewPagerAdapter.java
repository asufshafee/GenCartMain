package b2infosoft.gencart.com.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.ArrayList;

import b2infosoft.gencart.com.fragment.AllStorefragment;
import b2infosoft.gencart.com.fragment.ProductStorelistFragment;
import b2infosoft.gencart.com.pojo.CategarylistPojo;

/**
 * Created by B2infosoft on 12/21/2017.
 */

public class StoreViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;
    ArrayList<CategarylistPojo> tabsPagerAdapterPojos;
    int tabCount;
    private int NUM_ITEMS = 2;


    private String[] titles= new String[]{"AllStorefragment", "ProductStorelistFragment"};


    public StoreViewPagerAdapter(FragmentManager fm, int tabcount, ArrayList<CategarylistPojo>tabsPagerAdapterPojos) {
        super(fm);
        this.tabCount = tabcount;
        this.tabsPagerAdapterPojos=tabsPagerAdapterPojos;

    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return  tabCount ;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new AllStorefragment();
        }
        else{
            return new ProductStorelistFragment();
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return FragmentStatePagerAdapter.POSITION_NONE;

    }
}

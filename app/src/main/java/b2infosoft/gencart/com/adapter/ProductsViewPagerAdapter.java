package b2infosoft.gencart.com.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import b2infosoft.gencart.com.fragment.AllProductsListFragment;
import b2infosoft.gencart.com.fragment.AllStorefragment;
import b2infosoft.gencart.com.fragment.ProductListFragment;
import b2infosoft.gencart.com.fragment.ProductStorelistFragment;
import b2infosoft.gencart.com.pojo.CategarylistPojo;

/**
 * Created by u on 25-Dec-17.
 */

public class ProductsViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;
    ArrayList<String> tabsPagerAdapterPojos;
    int tabCount;




    public ProductsViewPagerAdapter(FragmentManager fm, int tabcount, ArrayList<String>tabsPagerAdapterPojos) {
        super(fm);
        this.tabCount = tabcount;
        this.tabsPagerAdapterPojos=tabsPagerAdapterPojos;

    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return  tabCount ;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new AllProductsListFragment();
        }
        else{
            return new ProductListFragment();
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return FragmentStatePagerAdapter.POSITION_NONE;
    }
}

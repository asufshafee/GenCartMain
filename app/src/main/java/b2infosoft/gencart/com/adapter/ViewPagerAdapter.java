package b2infosoft.gencart.com.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.pojo.StoreListPojo;

/**
 * Created by u on 25-Dec-17.
 */

public class ViewPagerAdapter extends PagerAdapter {

    Context mContext;
    ArrayList<StoreListPojo> mList;
    LayoutInflater mLayoutInflater;
    Activity activity;

    public ViewPagerAdapter(Context ctx, ArrayList<StoreListPojo> storeListPojos) {

        mContext = ctx;
        mList = storeListPojos;
        activity = (Activity) mContext;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 5;
    }

    public void destroyItem(ViewGroup container, int pos, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (object);
    }

    public Object instantiateItem(ViewGroup container, final int position) {


        View itemView = mLayoutInflater.inflate(R.layout.recomdedfragment, container, false);
        RecyclerView recycler_storelist = (RecyclerView)itemView.findViewById(R.id.recycler_storelist);

        AllStoreListAdapter adapter = new AllStoreListAdapter(mContext, mList);
        recycler_storelist.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        recycler_storelist.setLayoutManager(linearLayoutManager);
        recycler_storelist.setHasFixedSize(true);
        /*TextView tvAddress, tvDistance, tvStoreName;
        ImageView imgStore, imgRating5, imgRating4, imgRating3, imgRating2, imgRating1;
        tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
        tvDistance = (TextView) itemView.findViewById(R.id.tvDistance);
        imgStore = (ImageView) itemView.findViewById(R.id.imgStore);
        imgRating5 = (ImageView) itemView.findViewById(R.id.imgRating5);
        imgRating4 = (ImageView) itemView.findViewById(R.id.imgRating4);
        imgRating3 = (ImageView) itemView.findViewById(R.id.imgRating3);
        imgRating2 = (ImageView) itemView.findViewById(R.id.imgRating2);
        imgRating1 = (ImageView) itemView.findViewById(R.id.imgRating1);
        tvStoreName = (TextView) itemView.findViewById(R.id.tvStoreName);
        tvAddress.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
        tvDistance.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
        tvStoreName.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));*/
        container.addView(itemView);
        return itemView;

    }
}

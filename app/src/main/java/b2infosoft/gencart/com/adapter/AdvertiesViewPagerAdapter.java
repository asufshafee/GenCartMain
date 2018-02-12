package b2infosoft.gencart.com.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import b2infosoft.gencart.com.R;

/**
 * Created by Microsoft on 5/11/2017.
 */
public class AdvertiesViewPagerAdapter extends PagerAdapter {

    private Context mContext;

    String pageIDsArray[];
    ViewPager pager;
    int count;
    int currentPage = 0;
    Timer timer;
    public static int LOOPS_COUNT = 1000;
    ArrayList<Integer> advertiesPojosList;

    public AdvertiesViewPagerAdapter(final ViewPager viewPager, ArrayList<Integer> advertiesPojos, Context context) {
        super();
        mContext = context;
        this.advertiesPojosList = advertiesPojos;
        pager = viewPager;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, final int position) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.layout_restaurent_adverties_row, collection, false);
        ImageView imageView = (ImageView) layout.findViewById(R.id.imageView);
        // int pageId = Integer.parseInt(pageIDsArray[position]);
        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.right_to_left);
        layout.startAnimation(animation);
        try {
            Glide.with(mContext)
                    .load(advertiesPojosList.get(currentPage))
                    .crossFade()
                    .into(imageView);
            if (currentPage >= advertiesPojosList.size() - 1) {
                currentPage = 0;
            } else {
                ++currentPage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //imageView.setImageResource(advertiesPojosList.get(position).Adv_image);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}

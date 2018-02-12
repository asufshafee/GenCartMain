package b2infosoft.gencart.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.activity.PickAddressActivity;

/**
 * Created by u on 25-Dec-17.
 */

public class ReviewOrderAdapter extends RecyclerView.Adapter<ReviewOrderAdapter.ReviewOrderHolder> {

    int cartValue = 0;
    private Context mContext;
    AppCompatActivity appCompatActivity;
    int count = 0;
    ArrayList<String> mList;

    public ReviewOrderAdapter(Context ctx, ArrayList<String> list) {
        mContext = ctx;
        mList = list;
        appCompatActivity = (AppCompatActivity) mContext;
    }

    @Override
    public ReviewOrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_review_order_row, parent, false);
        return new ReviewOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(final ReviewOrderHolder holder, final int position) {


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ReviewOrderHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img_Icon, iconPlus, iconMines;
        TextView tv_itemName, tv_afterDiscountPrice, tvItemCount, tvActualRs, tv_Rs, tvActualRsTxt;
        View view, div1, div2, div3, div4;
        TextView tvHalfPrice, tvHalfLabel, tvHalfItemCount, tvMediumPrice, tvMediumLabel, tvMediumItemCount, tvFullPrice, tvFullLabel, tvFullItemCount, tvLargePrice, tvLargeLabel, tvLargeItemCount;
        ImageView imgHalfMines, imgHalfPlus, imgMediumMines, imgMediumPlus, imgFullMines, imgFullPlus, imgLargeMines, imgLargePlus;
        LinearLayout layoutHalf, layoutMedium, layoutFull, layoutLarge;

        public ReviewOrderHolder(View itemView) {
            super(itemView);
            // callFragment = new ManageAddressActivity();
            img_Icon = (ImageView) itemView.findViewById(R.id.img_Icon);
            iconPlus = (ImageView) itemView.findViewById(R.id.iconPlus);
            iconMines = (ImageView) itemView.findViewById(R.id.iconMines);
            tvActualRs = (TextView) itemView.findViewById(R.id.tvActualRs);
            tv_Rs = (TextView) itemView.findViewById(R.id.tv_Rs);
            tvActualRsTxt = (TextView) itemView.findViewById(R.id.tvActualRsTxt);
            tv_itemName = (TextView) itemView.findViewById(R.id.tv_itemName);
            tv_afterDiscountPrice = (TextView) itemView.findViewById(R.id.tv_afterDiscountPrice);
            view = (View) itemView.findViewById(R.id.dic);
            tv_itemName.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
            tvActualRsTxt.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
            tv_Rs.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
            tvItemCount = (TextView) itemView.findViewById(R.id.tvItemCount);
            // tvItemCount.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));


            tvHalfPrice = (TextView) itemView.findViewById(R.id.tvHalfPrice);
            tvHalfLabel = (TextView) itemView.findViewById(R.id.tvHalfLabel);
            tvHalfItemCount = (TextView) itemView.findViewById(R.id.tvHalfItemCount);
            tvMediumPrice = (TextView) itemView.findViewById(R.id.tvMediumPrice);
            tvMediumLabel = (TextView) itemView.findViewById(R.id.tvMediumLabel);
            tvMediumItemCount = (TextView) itemView.findViewById(R.id.tvMediumItemCount);
            tvFullItemCount = (TextView) itemView.findViewById(R.id.tvFullItemCount);
            tvLargeLabel = (TextView) itemView.findViewById(R.id.tvLargeLabel);
            tvLargeItemCount = (TextView) itemView.findViewById(R.id.tvLargeItemCount);
            tvLargePrice = (TextView) itemView.findViewById(R.id.tvLargePrice);
            tvFullPrice = (TextView) itemView.findViewById(R.id.tvFullPrice);
            tvFullLabel = (TextView) itemView.findViewById(R.id.tvFullLabel);

            layoutHalf = (LinearLayout) itemView.findViewById(R.id.layoutHalf);
            layoutMedium = (LinearLayout) itemView.findViewById(R.id.layoutMedium);
            layoutFull = (LinearLayout) itemView.findViewById(R.id.layoutFull);
            layoutLarge = (LinearLayout) itemView.findViewById(R.id.layoutLarge);

            div1 = (View) itemView.findViewById(R.id.div1);
            div2 = (View) itemView.findViewById(R.id.div2);
            div3 = (View) itemView.findViewById(R.id.div3);
            div4 = (View) itemView.findViewById(R.id.div4);

            imgHalfMines = (ImageView) itemView.findViewById(R.id.imgHalfMines);
            imgHalfPlus = (ImageView) itemView.findViewById(R.id.imgHalfPlus);
            imgMediumMines = (ImageView) itemView.findViewById(R.id.imgMediumMines);
            imgMediumPlus = (ImageView) itemView.findViewById(R.id.imgMediumPlus);
            imgFullMines = (ImageView) itemView.findViewById(R.id.imgFullMines);
            imgFullPlus = (ImageView) itemView.findViewById(R.id.imgFullPlus);
            imgLargeMines = (ImageView) itemView.findViewById(R.id.imgLargeMines);
            imgLargePlus = (ImageView) itemView.findViewById(R.id.imgLargePlus);

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            final int pos = getLayoutPosition();
            //String Id = mList.get(pos).NewsId;
            /*Log.d("Id",Id);
            AppGlobal.NewsID = Id;
            mContext.startActivity(new Intent(mContext, NewsDetailsActivity.class));*/

            switch (v.getId()) {
                //  case R.id.iconEdit:
                /*    String AddressId = mList.get(pos).AddressId;
                    // callFragment.setFragment(AddressId);
                    break;*/

                //mContext.startActivity(new Intent(mContext, PickAddressActivity.class));

            }

        }
    }
}

package b2infosoft.gencart.com.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.pojo.StoreListPojo;

/**
 * Created by u on 25-Dec-17.
 */

public class ProductListAdapter  extends RecyclerView.Adapter<ProductListAdapter.MyviewHolder> {
    Context mContext;
    ArrayList<StoreListPojo> mList;


    public ProductListAdapter(Context mcontext, ArrayList<StoreListPojo> productlistPojos) {
        this.mContext = mcontext;
        this.mList = productlistPojos;

    }

    @Override
    public ProductListAdapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vp = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_list_row, parent, false);
        return new ProductListAdapter.MyviewHolder(vp);
    }

    @Override
    public void onBindViewHolder(ProductListAdapter.MyviewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvFoodName, tvFoodDesc, tvActualRs;


        public MyviewHolder(View itemView) {
            super(itemView);
            tvFoodName = (TextView) itemView.findViewById(R.id.tvFoodName);
            tvFoodDesc = (TextView) itemView.findViewById(R.id.tvFoodDesc);

            tvActualRs = (TextView) itemView.findViewById(R.id.tvActualRs);
            tvFoodName.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
            tvFoodDesc.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
            tvActualRs.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //   mContext.startActivity(new Intent(mContext, ProductListActivity.class));
                }
            });
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {

            }
        }
    }
}

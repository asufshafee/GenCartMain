package b2infosoft.gencart.com.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.pojo.StoreListPojo;

/**
 * Created by u on 25-Dec-17.
 */

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.MyviewHolder> {
    Context mContext;
    ArrayList<StoreListPojo> mList;


    public StoreListAdapter(Context mcontext, ArrayList<StoreListPojo> productlistPojos) {
        this.mContext = mcontext;
        this.mList = productlistPojos;

    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        View vp = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_store_list_single2, parent, false);
        return new MyviewHolder(vp);

    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView txtStoreName, txtDistance, txtAddress;
        ImageView imageViewStore, imRat5, imRat3, imRat4, imRat2, imRat1;


        public MyviewHolder(View itemView) {
            super(itemView);
            txtStoreName = (TextView) itemView.findViewById(R.id.txtStoreName);
            txtDistance = (TextView) itemView.findViewById(R.id.txtDistance);
            imageViewStore = (ImageView) itemView.findViewById(R.id.imageViewStore);
            imRat1 = (ImageView) itemView.findViewById(R.id.imRat1);
            imRat2 = (ImageView) itemView.findViewById(R.id.imRat2);
            imRat3 = (ImageView) itemView.findViewById(R.id.imRat3);
            imRat4 = (ImageView) itemView.findViewById(R.id.imRat4);
            imRat5 = (ImageView) itemView.findViewById(R.id.imRat5);
            txtAddress = (TextView) itemView.findViewById(R.id.txtAddress);
            txtStoreName.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
            txtDistance.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
            txtAddress.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));

        }
    }
}

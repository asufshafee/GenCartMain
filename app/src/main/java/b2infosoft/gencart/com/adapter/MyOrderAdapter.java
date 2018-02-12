package b2infosoft.gencart.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.activity.OrderStatusActivity;
import b2infosoft.gencart.com.activity.ReviewOrderActivity;
import b2infosoft.gencart.com.pojo.MyOrderPojo;

/**
 * Created by Microsoft on 6/2/2017.
 */

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyOrderHolder> {

    Context mContext;
    ArrayList<MyOrderPojo> mList = new ArrayList<>();

    public MyOrderAdapter(Context ctx, ArrayList<MyOrderPojo> resturentListPojos) {
        mContext = ctx;
        mList = resturentListPojos;
    }


    @Override
    public MyOrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_order_row, parent, false);
        return new MyOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(MyOrderHolder holder, final int position) {
       /* Log.d("restID>>", mList.get(position).restaurant_id + "      " + mList.get(position).OrderTime);
        holder.tvOrderTIme.setText(mList.get(position).OrderTime);
        holder.tvOrderID.setText(mList.get(position).OrderID);
        holder.tvOrderStatus.setText(mList.get(position).status);
        if (position == mList.size() - 1) {
            holder.div1.setVisibility(View.GONE);
        }
        if (mList.get(position).status.equals("completed") && mList.get(position).order_review_status.equals("0")) {
            holder.btnReview.setVisibility(View.VISIBLE);
        } else {
            holder.btnReview.setVisibility(View.GONE);
        }
        holder.btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AppGlobal.Restaurant_id = mList.get(position).restaurant_id;
                Log.d("order_id>>>", mList.get(position).OrderID);
                //AppGlobal.OrderID = mList.get(position).OrderID;
                Intent intent = new Intent(mContext, ReviewOrderActivity.class);
                mContext.startActivity(intent);
                //Toast.makeText(mContext, "REVIEW", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    public class MyOrderHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvOrderTxt, tvOrderID, tvOrderTIme, tvOrderStatus;
        Button btnReview;
        View div1;
        ImageView iconArrow;


        public MyOrderHolder(View itemView) {
            super(itemView);
            tvOrderID = (TextView) itemView.findViewById(R.id.tvOrderID);
            tvOrderTxt = (TextView) itemView.findViewById(R.id.tvOrderTxt);
            tvOrderStatus = (TextView) itemView.findViewById(R.id.tvOrderStatus);
            btnReview = (Button) itemView.findViewById(R.id.btnReview);
            div1 = (View) itemView.findViewById(R.id.div1);
            iconArrow = (ImageView) itemView.findViewById(R.id.iconArrow);
            // tvOrderID.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_medium.ttf"));
            tvOrderTxt.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
            tvOrderStatus.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
            if (mList.size() != 0) {
                itemView.setOnClickListener(this);
            }
            itemView.setOnClickListener(this);
            iconArrow.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            mContext.startActivity(new Intent(mContext,OrderStatusActivity.class));
           /* switch (view.getId()) {
                case R.id.itemView:*/
            // AppGlobal.OrderID = mList.get(pos).OrderID;
            //AppGlobal.OrderStatus = mList.get(pos).status;
          //  mContext.startActivity(new Intent(mContext,OrderStatusActivity.class));
             /*                break;
            }*/
        }
    }
}

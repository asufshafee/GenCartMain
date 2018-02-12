package b2infosoft.gencart.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;


/**
 * Created by b2andro on 12/28/2017.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {

    Context mContext;
    ArrayList<String> mList = new ArrayList<>();


    public NotificationAdapter(Context ctx, ArrayList<String> resturentListPojos) {

        mContext = ctx;
        mList = resturentListPojos;
    }


    @Override
    public NotificationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_notification_list_row, parent, false);
        return new NotificationHolder(view);
    }

    @Override
    public void onBindViewHolder(NotificationHolder holder, final int position) {

        // holder.tvNotificationDesc.setText(mList.get(position).NotificationDesc);
        //holder.tvNotificationTitle.setText(mList.get(position).NotificationTitle);

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class NotificationHolder extends RecyclerView.ViewHolder {

        ImageView iconNotification, iconClose;
        TextView tvNotificationTitle, tvNotificationDesc, tvNotificationTiming;

        public NotificationHolder(View itemView) {
            super(itemView);

        //    iconNotification = (ImageView) itemView.findViewById(R.id.iconNotification);
            //    iconClose = (ImageView) itemView.findViewById(R.id.iconClose2);
          tvNotificationDesc = (TextView) itemView.findViewById(R.id.tvNotificationDesc);
           tvNotificationTitle = (TextView) itemView.findViewById(R.id.tvNotificationTitle);
            //tvNotificationTiming = (TextView) itemView.findViewById(R.id.tvNotificationTiming);
            //tvNotificationTiming.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_medium.ttf"));
           tvNotificationDesc.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
            tvNotificationTitle.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_medium.ttf"));
            // itemView.setOnClickListener(this);
            //  iconClose.setOnClickListener(this);


        }
    }
}


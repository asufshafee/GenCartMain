package b2infosoft.gencart.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.pojo.FriendListPojo;


/**
 * Created by b2andro on 12/29/2017.
 */

public class NewchatcallAdapter extends RecyclerView.Adapter<NewchatcallAdapter.FriendListHolder> {

    Context mContext;
    ArrayList<FriendListPojo> mList;
    ArrayList<String> fcmFriendList;

    public NewchatcallAdapter(Context ctx,ArrayList<FriendListPojo> list, ArrayList<String> fcmFriendList) {
        this.mContext = mContext;
        mContext = ctx;
        mList = list;
        this.fcmFriendList = fcmFriendList;
    }

    @Override
    public FriendListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_call_list_row, parent, false);
        return new FriendListHolder(view);

    }

    @Override
    public void onBindViewHolder(FriendListHolder holder, int position) {
       // UserDetails.chatWith = mList.get(position).phone_number;
        //holder.imgUser.setImageResource(mList.get(position).ProfileImage);
      //  holder.tvUserName.setText(mList.get(position).name);
      /*  holder.chatlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < fcmFriendList.size(); i++) {
                    if (mList.get(position).phone_number.equals(fcmFriendList.get(i))) {
                        Intent intent = new Intent(mContext, ChatActivity.class);
                        intent.putExtra("FRIEND_NAME", mList.get(position).name);
                        intent.putExtra("IMAGE_PATH", mList.get(position).profile_image);
                        intent.putExtra("FRIEND_id", mList.get(position).id);
                        intent.putExtra("FRIEND_mob", mList.get(position).phone_number);
                        intent.putExtra("firebase_tocan", mList.get(position).firebase_tocan);
                        mContext.startActivity(intent);
                    }
                }
            }
        });
*/
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class FriendListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       // public View chatlayout;
        TextView tvUserName;
        ImageView imgChat, imgUser;
        View div;
        LinearLayout chatlayout;


        public FriendListHolder(View itemView) {
            super(itemView);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            imgChat = (ImageView) itemView.findViewById(R.id.imgChat);
            imgUser = (ImageView) itemView.findViewById(R.id.imgUser);
            chatlayout = (LinearLayout) itemView.findViewById(R.id.chatlayout);
            tvUserName.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_regular.ttf"));
            itemView.setOnClickListener(this);
            imgUser.setOnClickListener(this);
            tvUserName.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}

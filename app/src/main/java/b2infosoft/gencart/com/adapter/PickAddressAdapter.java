package b2infosoft.gencart.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;

/**
 * Created by u on 25-Dec-17.
 */

public class PickAddressAdapter extends RecyclerView.Adapter<PickAddressAdapter.PickAddressHolder> {

    Context mContext;
    private int rbPosoition = 0;
    private RadioButton rbChecked = null;
    public int mSelectedItem = -1;
    ArrayList<String> mList;

    public PickAddressAdapter(Context ctx, ArrayList<String> list) {
        mContext = ctx;
        mList = list;

    }

    @Override
    public PickAddressHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_pick_address_row, parent, false);
        return new PickAddressHolder(view);
    }

    @Override
    public void onBindViewHolder(final PickAddressHolder holder, final int position) {
       /* holder.tv_address.setText(mList.get(position).flat_number + " , " + mList.get(position).landmark + " , " + mList.get(position).locality);
        holder.tv_type.setText(mList.get(position).tag_address);
        if (mList.get(position).tag_address.equals("Home")) {
            holder.img_Icon.setBackgroundResource(R.drawable.home_icon);
        } else if (mList.get(position).tag_address.equals("Office")) {
            holder.img_Icon.setBackgroundResource(R.drawable.office_icon);
        } else if (mList.get(position).tag_address.equals("Other")) {
            holder.img_Icon.setBackgroundResource(R.drawable.other_icon);
        }
        holder.radioButton.setChecked(position == mSelectedItem);*/
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class PickAddressHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img_Icon, iconEdit;
        TextView tv_address, tv_type;
        View view;
        RadioButton radioButton;

        public PickAddressHolder(View itemView) {
            super(itemView);
            img_Icon = (ImageView) itemView.findViewById(R.id.img_Icon);
            radioButton = (RadioButton) itemView.findViewById(R.id.radioButton);
            iconEdit = (ImageView) itemView.findViewById(R.id.iconEdit);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);
            tv_type = (TextView) itemView.findViewById(R.id.tv_type);
            tv_type.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/raleway_medium.ttf"));
            iconEdit.setOnClickListener(this);

           /* itemView.setOnClickListener(clickListener);
            radioButton.setOnClickListener(clickListener);*/

        }


        @Override
        public void onClick(View v) {
            final int pos = getLayoutPosition();
            //String Id = mList.get(pos).NewsId;

            switch (v.getId()) {
                /*case R.id.iconEdit:
                    String AddressId = mList.get(pos).AddressId;
                    Intent intent = new Intent(mContext, ManageAddressActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("FromWhere", "PickAddressActivity");
                    bundle.putString("AddressID", AddressId);
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                    break;*/


            }

        }
    }
}

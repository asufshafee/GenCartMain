package b2infosoft.gencart.com.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.adapter.AllStoreListAdapter;
import b2infosoft.gencart.com.pojo.StoreListPojo;
import b2infosoft.gencart.com.pojo.StoreProductListPojo;

public class AllStorefragment extends Fragment {
    Context mContext;
    RecyclerView recycler_storelist;

    public AllStorefragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recomdedfragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mContext = getActivity();

      //  StoreListPojo.getStoreList(mContext);
        StoreProductListPojo.getStoreList(mContext);
        recycler_storelist = (RecyclerView) view.findViewById(R.id.recycler_storelist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recycler_storelist.setLayoutManager(linearLayoutManager);
        recycler_storelist.setHasFixedSize(true);
        ArrayList<StoreListPojo> productlistPojos = new ArrayList<>();
        AllStoreListAdapter adapter = new AllStoreListAdapter(mContext, productlistPojos);
        recycler_storelist.setAdapter(adapter);
        /*recycler_storelist.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    Log.d("Scroll Up>>>","Scroll Up");

                    // Scrolling up
                } else {
                    // Scrolling down
                    Log.d("Scroll down>>>","Scroll down");

                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {
                    Log.d("Scroll >>>","SCROLL_STATE_FLING");
                    // Do something
                } else if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    // Do something
                    Log.d("Scroll >>>","SCROLL_STATE_TOUCH_SCROLL");
                } else {
                    // Do something
                    Log.d("Scroll >>>","Else");
                }
            }
        });*/
    }
}
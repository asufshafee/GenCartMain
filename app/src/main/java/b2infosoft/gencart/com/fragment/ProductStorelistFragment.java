package b2infosoft.gencart.com.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.adapter.AllStoreListAdapter;
import b2infosoft.gencart.com.adapter.StoreListAdapter;
import b2infosoft.gencart.com.pojo.StoreListPojo;

public class ProductStorelistFragment extends Fragment {
    Context mContext;
    RecyclerView recycler_storelist;
    public ProductStorelistFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        View view = inflater.inflate(R.layout.productstorelist, container, false);
        initView(view);
        return view;
    }
    private void initView(View view) {
        mContext = getActivity();
        recycler_storelist = (RecyclerView) view.findViewById(R.id.recycler_storelist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recycler_storelist.setLayoutManager(linearLayoutManager);
        recycler_storelist.setHasFixedSize(true);
        ArrayList<StoreListPojo> productlistPojos = new ArrayList<>();
        StoreListAdapter adapter = new StoreListAdapter(mContext, productlistPojos);
        recycler_storelist.setAdapter(adapter);
    }
}
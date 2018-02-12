package b2infosoft.gencart.com.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.adapter.AllProductListAdapter;
import b2infosoft.gencart.com.pojo.StoreListPojo;

/**
 * Created by u on 25-Dec-17.
 */

public class ProductListFragment  extends Fragment {
    RecyclerView recycler_all_product_fragment;

    Context context;
    public ProductListFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        context = getActivity();
        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.dummyfrag_bg);
        recycler_all_product_fragment = (RecyclerView) view.findViewById(R.id.recycler_all_product_fragment);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getActivity().getBaseContext(),2);
        recycler_all_product_fragment.setLayoutManager(linearLayoutManager);
        recycler_all_product_fragment.setHasFixedSize(true);
        ArrayList<StoreListPojo> mStoreListPojos = new ArrayList<>();
        AllProductListAdapter mAdapter = new AllProductListAdapter(context, mStoreListPojos);
        recycler_all_product_fragment.setAdapter(mAdapter);
        return view;
    }
}

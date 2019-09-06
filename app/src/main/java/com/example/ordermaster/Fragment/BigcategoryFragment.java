package com.example.ordermaster.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ordermaster.Adapter.Bigcategory_Adapater;
import com.example.ordermaster.DB.OrderMasterDatabase;
import com.example.ordermaster.DB.ShopDao;
import com.example.ordermaster.R;

public class BigcategoryFragment extends Fragment {

    private Bigcategory_Adapater bc_Adapter;
    private ShopDao shopDao;

    private RecyclerView recyclerView;

    public BigcategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bigcategory, container, false);
        recyclerView = view.findViewById(R.id.rv_bc_fragment);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        shopDao = OrderMasterDatabase.getDatabase(getContext()).shopDao();

        bc_Adapter = new Bigcategory_Adapater(this, shopDao.getAll(),new OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {

            }

            @Override
            public void onLongClick(View v, int position) {

            }
        });

        if (bc_Adapter.getItemCount() == 0) {
            //메뉴 없음 띄우기
        } else {
            recyclerView.setAdapter(bc_Adapter);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

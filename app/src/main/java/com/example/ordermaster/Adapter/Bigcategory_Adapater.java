package com.example.ordermaster.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordermaster.DB.ShopInfo;
import com.example.ordermaster.Fragment.OnItemClickListener;
import com.example.ordermaster.R;

import java.util.List;

public class Bigcategory_Adapater extends RecyclerView.Adapter<Bigcategory_Adapater.ViewHolder> {
    private Context context;
    private LiveData<List<ShopInfo>> liveData;
    private static OnItemClickListener listener;

    public Bigcategory_Adapater(LifecycleOwner lifecycleOwner, LiveData<List<ShopInfo>> liveData, OnItemClickListener listener) {

        this.liveData = liveData;
        this.liveData.observe(lifecycleOwner, new Observer<List<ShopInfo>>() {
            @Override
            public void onChanged(List<ShopInfo> shopInfos) {
                notifyDataSetChanged();
            }
        });

        this.listener = listener;
    }

    public int getItemCount() {
        return liveData == null ? 0 : liveData.getValue() == null ? 0 : liveData.getValue().size();
    }

    public ShopInfo getItem(int position) {
        return liveData == null ? null : liveData.getValue() == null ? null : liveData.getValue().get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bigcategory, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShopInfo shopInfo = liveData.getValue().get(position);

        if(shopInfo != null) {
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout linearLayout;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.ll_bc_item);
            imageView = itemView.findViewById(R.id.iv_bc_item);
            textView = itemView.findViewById(R.id.tv_bc_item);

            linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }
}

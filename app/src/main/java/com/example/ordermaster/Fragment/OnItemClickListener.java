package com.example.ordermaster.Fragment;

import android.view.View;

public interface OnItemClickListener {
    void onClick(View v, int position);

    void onLongClick(View v, int position);
}

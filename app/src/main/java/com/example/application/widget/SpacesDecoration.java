package com.example.application.widget;

import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Rect;
import android.view.View;

public class SpacesDecoration extends RecyclerView.ItemDecoration {
    private int space; // 空白间隔

    public SpacesDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View v, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space; // 左边空白间隔
        outRect.right = space; // 右边空白间隔
        outRect.bottom = space; // 上方空白间隔
        outRect.top = space; // 下方空白间隔
    }
}

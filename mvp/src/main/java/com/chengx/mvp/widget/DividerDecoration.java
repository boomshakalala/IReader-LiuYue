package com.chengx.mvp.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chengx.mvp.adapter.HeaderAndFooterCommonAdapter;

/**
 * 作者：chengx
 * 日期：2017/2/21
 * 描述：
 */

public class DividerDecoration extends RecyclerView.ItemDecoration {
    private ColorDrawable colorDrawable;
    private int height;
    private int paddingLeft;
    private int paddingRight;
    private boolean drawLastItem;
    private boolean drawHeaderFooter;

    public DividerDecoration(int height, int color) {
        this.height = height;
        this.colorDrawable = new ColorDrawable(color);
    }

    public DividerDecoration(int color, int height, int paddingLeft, int paddingRight) {
        this.colorDrawable = new ColorDrawable(color);
        this.height = height;
        this.paddingLeft = paddingLeft;
        this.paddingRight = paddingRight;
    }

    public boolean isDrawLastItem() {
        return drawLastItem;
    }

    public void setDrawLastItem(boolean drawLastItem) {
        this.drawLastItem = drawLastItem;
    }

    public boolean isDrawHeaderFooter() {
        return drawHeaderFooter;
    }

    public void setDrawHeaderFooter(boolean drawHeaderFooter) {
        this.drawHeaderFooter = drawHeaderFooter;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        int orientation = 0;
        int headerCount = 0;
        int footerCount = 0;
        if (parent.getAdapter() instanceof HeaderAndFooterCommonAdapter){
            headerCount = ((HeaderAndFooterCommonAdapter)parent.getAdapter()).getHeadersCount();
            footerCount = ((HeaderAndFooterCommonAdapter)parent.getAdapter()).getFootersCount();
        }
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager){
            orientation = ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        }else if (layoutManager instanceof GridLayoutManager){
            orientation = ((GridLayoutManager) layoutManager).getOrientation();
        }else if (layoutManager instanceof LinearLayoutManager){
            orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        }

        if (position > headerCount && position < parent.getAdapter().getItemCount() - footerCount || drawHeaderFooter){
            if (orientation == OrientationHelper.VERTICAL){
                outRect.bottom = height;
            }else {
                outRect.right = height;
            }
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int orientation = 0;
        int headerCount = 0,footerCount,dataCount;
        if (parent.getAdapter() == null)
            return;
        if (parent.getAdapter() instanceof HeaderAndFooterCommonAdapter){
            headerCount = ((HeaderAndFooterCommonAdapter) parent.getAdapter()).getHeadersCount();
            footerCount = ((HeaderAndFooterCommonAdapter) parent.getAdapter()).getFootersCount();
            dataCount = ((HeaderAndFooterCommonAdapter) parent.getAdapter()).getRealItemCount();
        }else {
            dataCount = parent.getAdapter().getItemCount();
        }
        int dataStartPos = headerCount;
        int dataEndPos = headerCount + dataCount;

        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager){
            orientation = ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        }else if (layoutManager instanceof GridLayoutManager){
            orientation = ((GridLayoutManager) layoutManager).getOrientation();
        }else if (layoutManager instanceof LinearLayoutManager){
            orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        }
        int start,end;
        if (orientation == OrientationHelper.VERTICAL){
            start = parent.getPaddingLeft() + paddingLeft;
            end = parent.getWidth() - parent.getPaddingRight() - paddingRight;
        }else {
            start = parent.getPaddingTop() + paddingLeft;
            end = parent.getHeight() - parent.getPaddingBottom() - paddingRight;
        }

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(child);

            if (position > dataStartPos && position < dataEndPos-1
                    || (position == dataEndPos - 1&&drawLastItem)
                    || (!(position>=dataStartPos&&position<dataEndPos)&&drawHeaderFooter)
                    ){
                if (orientation == OrientationHelper.VERTICAL){
                    RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                    int top = child.getBottom() + params.bottomMargin;
                    int bottom = top + params.height;
                    colorDrawable.setBounds(start,top,end,bottom);
                    colorDrawable.draw(c);
                }else {
                    RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                    int left = child.getRight() + params.rightMargin;
                    int right = left + height;
                    colorDrawable.setBounds(left,start,right,end);
                    colorDrawable.draw(c);
                }
            }
        }
    }
}

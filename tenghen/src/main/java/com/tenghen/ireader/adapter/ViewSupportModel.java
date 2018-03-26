package com.tenghen.ireader.adapter;

import java.io.Serializable;

/**
 * 作者: chengx
 * 日期: 2016/10/27.
 * 描述:
 */
public class ViewSupportModel implements Serializable {
    private static final long serialVersionUID = -3205706735259288549L;
    public static int VIEW_TYPE_SPLIT_LINE = 1;
    public static int VIEW_TYPE_SPLIT_SPACE = 2;
    public static int VIEW_TYPE_EMPTY = 3;

    private int viewType;

    public ViewSupportModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }


}

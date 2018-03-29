package com.tenghen.ireader.module;

/**
 * 作者: 陈冠希
 * 日期: 2018/3/29
 * 描述:
 */

public class Type {
    int id;
    String text;
    boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

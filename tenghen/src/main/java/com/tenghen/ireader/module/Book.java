package com.tenghen.ireader.module;

import java.io.Serializable;

/**
 * 作者：chengx
 * 日期：2017/2/24
 * 描述：
 */

public class Book implements Serializable{
    private String id;
    private String name;
    private String cover;
    private String view_id;
    private String description;
    private String pen_name;
    private String category_name;
    private String all_click;


    public boolean isRec = false;
    public boolean isRank = false;
    public boolean shouRank = false;


    public String getAll_click() {
        return all_click;
    }

    public void setAll_click(String all_click) {
        this.all_click = all_click;
    }

    public String getView_id() {
        return view_id;
    }

    public void setView_id(String view_id) {
        this.view_id = view_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPen_name() {
        return pen_name;
    }

    public void setPen_name(String pen_name) {
        this.pen_name = pen_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", view_id='" + view_id + '\'' +
                ", description='" + description + '\'' +
                ", pen_name='" + pen_name + '\'' +
                ", category_name='" + category_name + '\'' +
                ", all_click='" + all_click + '\'' +
                ", isRec=" + isRec +
                ", isRank=" + isRank +
                ", shouRank=" + shouRank +
                '}';
    }
}

package com.tenghen.ireader.module;

import java.io.Serializable;

/**
 * 作者：chengx
 * 日期：2017/3/6
 * 描述：
 */

public class RankBook implements Serializable {
    private String id;
    private String cover;
    private String category_name;
    private String view_id;
    private String pen_name;
    private String description;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getView_id() {
        return view_id;
    }

    public void setView_id(String view_id) {
        this.view_id = view_id;
    }

    public String getPen_name() {
        return pen_name;
    }

    public void setPen_name(String pen_name) {
        this.pen_name = pen_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RankBook{" +
                "id='" + id + '\'' +
                ", cover='" + cover + '\'' +
                ", category_name='" + category_name + '\'' +
                ", view_id='" + view_id + '\'' +
                ", pen_name='" + pen_name + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

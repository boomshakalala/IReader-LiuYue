package com.tenghen.ireader.module;

import java.io.Serializable;

/**
 * 作者：chengx
 * 日期：2017/3/6
 * 描述：
 */

public class CategoryBook implements Serializable{

    private String id;
    private String cover;
    private String all_click;
    private String pen_name;
    private String description;
    private String word_count;
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

    public String getAll_click() {
        return all_click;
    }

    public void setAll_click(String all_click) {
        this.all_click = all_click;
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

    public String getWord_count() {
        return word_count;
    }

    public void setWord_count(String word_count) {
        this.word_count = word_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

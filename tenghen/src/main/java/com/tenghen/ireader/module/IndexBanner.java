package com.tenghen.ireader.module;

import java.io.Serializable;

public class IndexBanner implements Serializable{

    private String id;
    private String name;
    private String picture;
    private String src;
    private String create_date;
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getPicture() {
        return picture;
    }

    public void setSrc(String src) {
        this.src = src;
    }
    public String getSrc() {
        return src;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
    public String getCreate_date() {
        return create_date;
    }
}
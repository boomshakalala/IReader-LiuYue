package com.tenghen.ireader.module;

import java.io.Serializable;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class LatestBook implements Serializable{
    private String book_id;
    private String book_name;
    private String book_cover;
    private String pen_name;
    private String chapter_id;
    private String create_date;
    private String create_time;
    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }
    public String getBook_id() {
        return book_id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
    public String getBook_name() {
        return book_name;
    }

    public void setBook_cover(String book_cover) {
        this.book_cover = book_cover;
    }
    public String getBook_cover() {
        return book_cover;
    }

    public void setPen_name(String pen_name) {
        this.pen_name = pen_name;
    }
    public String getPen_name() {
        return pen_name;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
    }
    public String getChapter_id() {
        return chapter_id;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
    public String getCreate_time() {
        return create_time;
    }
}

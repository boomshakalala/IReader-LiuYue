package com.tenghen.ireader.module;

import java.io.Serializable;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class Cost implements Serializable {
    private String id;
    private String user_id;
    private String user_name;
    private String book_id;
    private String chapter_id;
    private String price;
    private String type;
    private String create_date;
    private String create_time;
    private Book book;
    private Chapter chapter;
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getUser_id() {
        return user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_name() {
        return user_name;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }
    public String getBook_id() {
        return book_id;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
    }
    public String getChapter_id() {
        return chapter_id;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
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

    public void setBook(Book book) {
        this.book = book;
    }
    public Book getBook() {
        return book;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
    public Chapter getChapter() {
        return chapter;
    }
}

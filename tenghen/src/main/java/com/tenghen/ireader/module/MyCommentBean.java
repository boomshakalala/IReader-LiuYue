package com.tenghen.ireader.module;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/2/4/004.
 */

public class MyCommentBean implements Serializable {
    private String id;
    private String book_id;
    private String user_id;
    private String nick_name;
    private String fid;
    private String content;
    private String create_date;
    private String path;
    private Book book;
    private ParentComment parent_comment;
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }
    public String getBook_id() {
        return book_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getUser_id() {
        return user_id;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }
    public String getNick_name() {
        return nick_name;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }
    public String getFid() {
        return fid;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
    public String getCreate_date() {
        return create_date;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public Book getBook() {
        return book;
    }

    public void setParent_commen(ParentComment parent_comment) {
        this.parent_comment = parent_comment;
    }
    public ParentComment getParent_comment() {
        return parent_comment;
    }
}

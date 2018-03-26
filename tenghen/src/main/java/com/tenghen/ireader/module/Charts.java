package com.tenghen.ireader.module;

import java.io.Serializable;
import java.util.List;

public class Charts implements Serializable {
    private String id;
    private String name;
    private String has_num;
    private String channel;
    private String position;
    private String book_id;
    private List<Book> book;

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
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

    public String getHas_num() {
        return has_num;
    }

    public void setHas_num(String has_num) {
        this.has_num = has_num;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }
}
package com.tenghen.ireader.module;

/**
 * 作者：chengx
 * 日期：2017/3/8
 * 描述：
 */

public class Chapter {
    private String id;
    private String book_id;
    private String volume_id;
    private String cname;
    private String cindex;
    private String word_count;
    private String is_vip;
    private String is_fee;
    private String price;
    private String create_date;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getVolume_id() {
        return volume_id;
    }

    public void setVolume_id(String volume_id) {
        this.volume_id = volume_id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCindex() {
        return cindex;
    }

    public void setCindex(String cindex) {
        this.cindex = cindex;
    }

    public String getWord_count() {
        return word_count;
    }

    public void setWord_count(String word_count) {
        this.word_count = word_count;
    }

    public String getIs_vip() {
        return is_vip;
    }

    public void setIs_vip(String is_vip) {
        this.is_vip = is_vip;
    }

    public String getIs_fee() {
        return is_fee;
    }

    public void setIs_fee(String is_fee) {
        this.is_fee = is_fee;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

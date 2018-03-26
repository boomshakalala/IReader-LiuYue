package com.tenghen.ireader.module;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class BookDetail implements Serializable {
    BookDetailHeader book;
    List<Gift> giftList;
    Rewards rewards;
    List<Comment> comments;

    public BookDetailHeader getBook() {
        return book;
    }

    public List<Gift> getGiftList() {
        return giftList;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public static class Rewards{
        int amount;
        List<GiftLog> list;

        public int getAmount() {
            return amount;
        }

        public List<GiftLog> getList() {
            return list;
        }
    }
}

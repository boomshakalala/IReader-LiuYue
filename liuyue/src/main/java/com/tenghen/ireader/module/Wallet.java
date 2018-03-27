package com.tenghen.ireader.module;

import java.io.Serializable;

/**
 * Created by mac on 2018/1/10.
 */

public class Wallet implements Serializable {
    private String user_id;
    private String score;
    private String level_id;
    private String level;
    private String money;
    private String gift_money;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLevel_id() {
        return level_id;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getGift_money() {
        return gift_money;
    }

    public void setGift_money(String gift_money) {
        this.gift_money = gift_money;
    }
}

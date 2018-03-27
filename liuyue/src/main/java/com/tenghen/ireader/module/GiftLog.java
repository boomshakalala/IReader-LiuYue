package com.tenghen.ireader.module;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class GiftLog implements Serializable {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("user_name")
    private String userName;
    private String amount;
    @SerializedName("money_type")
    private String moneyType;
    private String num;
    private String type;
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getAmount() {
        return amount;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }
    public String getMoneyType() {
        return moneyType;
    }

    public void setNum(String num) {
        this.num = num;
    }
    public String getNum() {
        return num;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

}

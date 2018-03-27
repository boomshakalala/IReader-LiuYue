package com.tenghen.ireader.module;

import java.io.Serializable;
import java.util.List;

public class RewardsLog implements Serializable{
    String amount;
    List<GiftLog> list;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<GiftLog> getList() {
        return list;
    }

    public void setList(List<GiftLog> list) {
        this.list = list;
    }
}
package com.tenghen.ireader.module;

import java.io.Serializable;
import java.util.List;

public class MyRehargeRecord implements Serializable{
    String money;
    List<Recharge> record;

    public List<Recharge> getRecord() {
        return record;
    }

    public void setRecord(List<Recharge> record) {
        this.record = record;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
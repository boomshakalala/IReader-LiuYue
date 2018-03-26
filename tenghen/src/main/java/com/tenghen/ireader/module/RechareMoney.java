package com.tenghen.ireader.module;

import java.io.Serializable;

public class RechareMoney implements Serializable{
    public int tengbi;
    public int zTengbi;
    public int money;

    public RechareMoney(int tengbi, int zTengbi, int money) {
        this.tengbi = tengbi;
        this.zTengbi = zTengbi;
        this.money = money;
    }
}
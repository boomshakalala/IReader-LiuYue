package com.tenghen.ireader.module;

import java.io.Serializable;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class Gift implements Serializable {
    String giftId;
    int giftImage;

    public boolean isChecked;

    public Gift(String giftId, int giftImage) {
        this.giftId = giftId;
        this.giftImage = giftImage;
    }

    public int getGiftImage() {
        return giftImage;
    }

    public void setGiftImage(int giftImage) {
        this.giftImage = giftImage;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }
}

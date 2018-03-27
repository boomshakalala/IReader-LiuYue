package com.tenghen.ireader.module;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/3/003.
 */

public class VerifyCode implements Serializable {
    String verify_code;

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }
}

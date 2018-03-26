package com.tenghen.ireader.module;

import java.io.Serializable;

/**
 * Created by chengx on 18-2-8.
 */

public class UserRecord implements Serializable {
    public String id;
    public String volume_id;
    public String price;
    public String create_date;
    public String status;
    public String is_vip;
    public String is_fee;
    public String word_count;
    public String book_id;
    public String cindex;
    public String cname;
}

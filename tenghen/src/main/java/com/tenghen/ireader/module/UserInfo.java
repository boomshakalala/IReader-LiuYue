package com.tenghen.ireader.module;

import java.io.Serializable;

public class UserInfo implements Serializable {
    BaseInfo base_info;
    MonthlyInfo monthlyInfo;

    public BaseInfo getBase_info() {
        return base_info;
    }

    public void setBase_info(BaseInfo base_info) {
        this.base_info = base_info;
    }

    public MonthlyInfo getMonthlyInfo() {
        return monthlyInfo;
    }

    public void setMonthlyInfo(MonthlyInfo monthlyInfo) {
        this.monthlyInfo = monthlyInfo;
    }

    public class BaseInfo implements Serializable{
        private String id;
        private String name;
        private String user_image;
        private String description;
        private String is_vip;
        private String sex;
        private String email;
        private String mobile;
        private String user_status;
        private String openid;
        private String sina_openid;
        private String wechat_openid;
        public void setId(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setUser_image(String user_image) {
            this.user_image = user_image;
        }
        public String getUser_image() {
            return user_image;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        public String getDescription() {
            return description;
        }

        public void setIs_vip(String is_vip) {
            this.is_vip = is_vip;
        }
        public String getIs_vip() {
            return is_vip;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
        public String getSex() {
            return sex;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        public String getEmail() {
            return email;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
        public String getMobile() {
            return mobile;
        }

        public void setUser_status(String user_status) {
            this.user_status = user_status;
        }
        public String getUser_status() {
            return user_status;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }
        public String getOpenid() {
            return openid;
        }

        public void setSina_openid(String sina_openid) {
            this.sina_openid = sina_openid;
        }
        public String getSina_openid() {
            return sina_openid;
        }

        public void setWechat_openid(String wechat_openid) {
            this.wechat_openid = wechat_openid;
        }
        public String getWechat_openid() {
            return wechat_openid;
        }

    }

    public class MonthlyInfo implements Serializable{
        private String user_id;
        private String starttime;
        private String endtime;
        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
        public String getUser_id() {
            return user_id;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }
        public String getStarttime() {
            return starttime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }
        public String getEndtime() {
            return endtime;
        }
    }
}
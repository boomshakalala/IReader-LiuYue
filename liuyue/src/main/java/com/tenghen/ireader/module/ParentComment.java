package com.tenghen.ireader.module;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/4/004.
 */

public class ParentComment implements Serializable {

        private String id;
        private String fid;
        private String user_id;
        private String nick_name;
        private String content;
        private String path;
        private String create_date;
        public void setId(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }
        public String getFid() {
            return fid;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
        public String getUser_id() {
            return user_id;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }
        public String getNick_name() {
            return nick_name;
        }

        public void setContent(String content) {
            this.content = content;
        }
        public String getContent() {
            return content;
        }

        public void setPath(String path) {
            this.path = path;
        }
        public String getPath() {
            return path;
        }

        public void setCreate_date(String create_date) {
            this.create_date = create_date;
        }
        public String getCreate_date() {
            return create_date;
        }
}

package com.tenghen.ireader.module;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class Comment implements Serializable {
    private String id;
    private String fid;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("nick_name")
    private String nickName;
    private String content;
    private String path;
    @SerializedName("create_date")
    private String createDate;
    private List<Comment> sub_comment;

    public List<Comment> getSub_comment() {
        return sub_comment;
    }

    public void setSub_comment(List<Comment> sub_comment) {
        this.sub_comment = sub_comment;
    }

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

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserId() {
        return userId;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getNickName() {
        return nickName;
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

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getCreateDate() {
        return createDate;
    }

}

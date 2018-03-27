package com.tenghen.ireader.module;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public  class BookDetailHeader implements Serializable {
    private String id;
    private String name;
    @SerializedName("category_id")
    private String categoryId;
    private String description;
    @SerializedName("pen_name")
    private String penName;
    private String cover;
    @SerializedName("word_count")
    private String wordCount;
    @SerializedName("create_date")
    private String createDate;
    @SerializedName("is_first")
    private String isFirst;
    @SerializedName("is_finish")
    private String isFinish;
    @SerializedName("is_vip")
    private String isVip;
    @SerializedName("is_monthly")
    private String isMonthly;
    private String channel;
    @SerializedName("first_chapter_id")
    private String firstChapterId;
    @SerializedName("first_chapter_name")
    private String firstChapterName;
    @SerializedName("last_update_chapter_id")
    private String lastUpdateChapterId;
    @SerializedName("last_update_chapter_name")
    private String lastUpdateChapterName;
    @SerializedName("last_common_chapter_id")
    private String lastCommonChapterId;
    @SerializedName("last_common_chapter_name")
    private String lastCommonChapterName;
    @SerializedName("last_update_chapter_date")
    private String lastUpdateChapterDate;
    @SerializedName("user_record")
    private UserRecord userRecord;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    public String getPenName() {
        return penName;
    }

    public String getCover() {
        return cover;
    }

    public String getWordCount() {
        return wordCount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getIsFirst() {
        return isFirst;
    }

    public String getIsFinish() {
        return isFinish;
    }

    public String getIsVip() {
        return isVip;
    }

    public String getIsMonthly() {
        return isMonthly;
    }

    public String getChannel() {
        return channel;
    }

    public String getFirstChapterId() {
        return firstChapterId;
    }

    public String getFirstChapterName() {
        return firstChapterName;
    }

    public String getLastUpdateChapterId() {
        return lastUpdateChapterId;
    }

    public String getLastUpdateChapterName() {
        return lastUpdateChapterName;
    }

    public String getLastCommonChapterId() {
        return lastCommonChapterId;
    }

    public String getLastCommonChapterName() {
        return lastCommonChapterName;
    }

    public String getLastUpdateChapterDate() {
        return lastUpdateChapterDate;
    }

    public UserRecord getUserRecord() {
        return userRecord;
    }
}

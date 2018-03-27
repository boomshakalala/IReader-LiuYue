package com.tenghen.ireader.module;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/8
 * 描述：下载队列实体
 */

public class DownloadQueue implements Serializable {

    public String bookId;

    public List<Chapter> chapters;

    public int start;

    public int end;

    /**
     * 是否已经开始下载
     */
    public boolean isStartDownload = false;

    /**
     * 是否中断下载
     */
    public boolean isCancel = false;

    /**
     * 是否下载完成
     */
    public boolean isFinish = false;

    public DownloadQueue(String bookId, List<Chapter> chapters, int start, int end) {
        this.bookId = bookId;
        this.chapters = chapters;
        this.start = start;
        this.end = end;
    }

    /**
     * 空事件。表示通知继续执行下一条任务
     */
    public DownloadQueue() {
    }
}

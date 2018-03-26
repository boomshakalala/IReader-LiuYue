package com.tenghen.ireader.module;

import java.io.Serializable;

/**
 * 作者：chengx
 * 日期：2017/3/8
 * 描述：
 */

public class DownloadProgress implements Serializable {
    public String bookId;
    public String message;
    public boolean isAlreadyDownload = false;

    public DownloadProgress(String bookId, String message, boolean isAlreadyDownload) {
        this.bookId = bookId;
        this.message = message;
        this.isAlreadyDownload = isAlreadyDownload;
    }
}

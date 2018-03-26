package com.tenghen.ireader.cache;

import com.chengx.mvp.utils.AppUtils;
import com.chengx.mvp.utils.FileUtils;
import com.tenghen.ireader.base.BaseApplication;

import java.io.File;

/**
 * 作者：chengx
 * 日期：2017/3/8
 * 描述：
 */

public class BookCacheManager {

    public static String getBookCachePath(String bookId,int chapter) {
        return FileUtils.createRootPath(AppUtils.getAppContext()) + "/book/" + bookId + File.separator + chapter + ".txt";
    }

    public static File getBookChapterFile(String bookId,int chapter){
        File file = new File(getBookCachePath(bookId,chapter));
        if (!file.exists()) {
            FileUtils.createOrExistsFile(file);
        }
        if (file!= null && file.length()>50)
            return file;
        return null;
    }

}

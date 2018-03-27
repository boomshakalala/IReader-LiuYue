package com.tenghen.ireader.service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;

import com.chengx.mvp.utils.AppUtils;
import com.chengx.mvp.utils.FileUtils;
import com.chengx.mvp.utils.NetworkUtils;
import com.chengx.mvp.utils.StringUtils;
import com.tenghen.ireader.cache.BookCacheManager;
import com.tenghen.ireader.module.Chapter;
import com.tenghen.ireader.module.DownloadMessage;
import com.tenghen.ireader.module.DownloadProgress;
import com.tenghen.ireader.module.DownloadQueue;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * 作者：chengx
 * 日期：2017/3/8
 * 描述：
 */

public class DownloadService extends Service {

    public static List<DownloadQueue> downloadQueues = new ArrayList<>();

    public boolean isBusy = false;

    public static boolean canceled = false;

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public static void post(DownloadQueue downloadQueue){
        EventBus.getDefault().post(downloadQueue);
    }

    public static void post(DownloadProgress progress){
        EventBus.getDefault().post(progress);
    }

    public static void post(DownloadMessage complete){
        EventBus.getDefault().post(complete);
    }

    public synchronized void addToDownloadQueue(DownloadQueue queue){
        if (!StringUtils.isEmpty(queue.bookId)){
            boolean exists = false;
            //检测下载任务是否存在
            for (int i = 0; i <downloadQueues.size() ; i++) {
                if (downloadQueues.get(i).bookId.equals(queue.bookId)){
                    exists = true;
                    break;
                }
            }
            if (exists){
                post(new DownloadMessage(queue.bookId,"当前下载任务已存在",false));
                return;
            }
            //添加到下载队列
            downloadQueues.add(queue);
            post(new DownloadMessage(queue.bookId, "成功加入缓存队列", false));
            //从队列中取出第一条下载
            if (downloadQueues.size()>0 && !isBusy) {
                isBusy = true;
                downloadBook(downloadQueues.get(0));
            }
        }
    }

    private synchronized void downloadBook(final DownloadQueue downloadQueue) {
        AsyncTask<Integer,Integer,Integer> downloadTask = new AsyncTask<Integer, Integer, Integer>() {
            List<Chapter> chapters = downloadQueue.chapters;
            String bookId = downloadQueue.bookId;
            int start = downloadQueue.start;
            int end = downloadQueue.end;


            @Override
            protected Integer doInBackground(Integer... integers) {
                int failureCount = 0;
                for (int i = start; i < end && i<=chapters.size(); i++) {
                    if (canceled){
                        break;
                    }
                    if (!NetworkUtils.isAvailable(DownloadService.this)){
                        downloadQueue.isCancel = true;
                        post(new DownloadMessage(bookId,"网络异常,已取消下载",true));
                        failureCount = -1;
                        break;
                    }

                    if (!downloadQueue.isFinish && !downloadQueue.isCancel){
                        if (BookCacheManager.getBookChapterFile(bookId,i) == null){
                            Chapter chapter = chapters.get(i - 1);
                            String url = "";
                            int ret = download(url,bookId,"",i,chapters.size());
                            if (ret != 1){
                                failureCount++;
                            }
                        }else {
                            post(new DownloadProgress(bookId,String.format("已缓存过:%1$s(%2$d/%3$d)...","",i,chapters.size()),true));

                        }
                    }
                }

                return failureCount;
            }

            @Override
            protected void onPostExecute(Integer failureCount) {
                super.onPostExecute(failureCount);
                downloadQueue.isFinish = true;
                if (failureCount>-1){
                    post(new DownloadMessage(bookId, String.format("已缓存过:%1$s(%2$d/%3$d)...", failureCount), true));
                }
                downloadQueues.remove(downloadQueue);
                isBusy = false;
                if (!canceled){
                    post(new DownloadQueue());
                }else {
                    downloadQueues.clear();
                }
                canceled = false;
            }
        };
        downloadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
     }

    private int download(String url,String bookId,final String title,int chapter,int chapterSize){
        final int[] result = {-1};
        //TODO: 网络请求章节详情
        return 0;
    }
}

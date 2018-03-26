package com.tenghen.ireader.module;

import java.io.Serializable;

public class ChapterContent implements Serializable {
    private User_status user_status;
    private Msg msg;
    private Text text;
    private BookInfo book_info;
    private ChapterInfo chapter_info;
    private LastAndNext context;

    public LastAndNext getContext() {
        return context;
    }

    public void setContext(LastAndNext context) {
        this.context = context;
    }

    public void setUser_status(User_status user_status) {
        this.user_status = user_status;
    }
    public User_status getUser_status() {
        return user_status;
    }

    public void setMsg(Msg msg) {
        this.msg = msg;
    }
    public Msg getMsg() {
        return msg;
    }

    public void setText(Text text) {
        this.text = text;
    }
    public Text getText() {
        return text;
    }

    public BookInfo getBook_info() {
        return book_info;
    }

    public void setBook_info(BookInfo book_info) {
        this.book_info = book_info;
    }

    public ChapterInfo getChapter_info() {
        return chapter_info;
    }

    public void setChapter_info(ChapterInfo chapter_info) {
        this.chapter_info = chapter_info;
    }

    public static class LastAndNext{
        String pre_chapter_id;
        String next_chapter_id;

        public String getPre_chapter_id() {
            return pre_chapter_id;
        }

        public void setPre_chapter_id(String pre_chapter_id) {
            this.pre_chapter_id = pre_chapter_id;
        }

        public String getNext_chapter_id() {
            return next_chapter_id;
        }

        public void setNext_chapter_id(String next_chapter_id) {
            this.next_chapter_id = next_chapter_id;
        }
    }

    public static class  Text implements Serializable{
        private String chapter_id;
        private String book_id;
        private String ext_content;
        private String content;
        public void setChapter_id(String chapter_id) {
            this.chapter_id = chapter_id;
        }
        public String getChapter_id() {
            return chapter_id;
        }

        public void setBook_id(String book_id) {
            this.book_id = book_id;
        }
        public String getBook_id() {
            return book_id;
        }

        public void setExt_content(String ext_content) {
            this.ext_content = ext_content;
        }
        public String getExt_content() {
            return ext_content;
        }

        public void setContent(String content) {
            this.content = content;
        }
        public String getContent() {
            return content;
        }

    }

   public static   class Msg  implements Serializable{
        private int costCode;
        private String warning;
        public void setCostCode(int costCode) {
            this.costCode = costCode;
        }
        public int getCostCode() {
            return costCode;
        }

        public void setWarning(String warning) {
            this.warning = warning;
        }
        public String getWarning() {
            return warning;
        }
    }

   public static class User_status implements  Serializable{
        private int is_auto_subscribe;
        private int is_collect;
        public void setIs_auto_subscribe(int is_auto_subscribe) {
            this.is_auto_subscribe = is_auto_subscribe;
        }
        public int getIs_auto_subscribe() {
            return is_auto_subscribe;
        }

        public void setIs_collect(int is_collect) {
            this.is_collect = is_collect;
        }
        public int getIs_collect() {
            return is_collect;
        }
    }

    public static class BookInfo{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ChapterInfo{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
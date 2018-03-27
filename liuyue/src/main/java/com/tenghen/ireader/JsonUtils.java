package com.tenghen.ireader;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.tenghen.ireader.module.Banner;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.BookDetail;
import com.tenghen.ireader.module.BookDetailHeader;
import com.tenghen.ireader.module.CategoryBook;
import com.tenghen.ireader.module.Chapter;
import com.tenghen.ireader.module.ChapterContent;
import com.tenghen.ireader.module.Charts;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.module.Cost;
import com.tenghen.ireader.module.Gift;
import com.tenghen.ireader.module.GiftLog;
import com.tenghen.ireader.module.IndexBanner;
import com.tenghen.ireader.module.LatestBook;
import com.tenghen.ireader.module.MyCommentBean;
import com.tenghen.ireader.module.MyRehargeRecord;
import com.tenghen.ireader.module.OrderInfo;
import com.tenghen.ireader.module.ParentComment;
import com.tenghen.ireader.module.RankBook;
import com.tenghen.ireader.module.Recharge;
import com.tenghen.ireader.module.User;
import com.tenghen.ireader.module.UserInfo;
import com.tenghen.ireader.module.UserRecord;
import com.tenghen.ireader.module.VerifyCode;
import com.tenghen.ireader.module.Wallet;

import java.lang.reflect.Type;

public class JsonUtils {

    public static class ParentCommentDeserializer implements JsonDeserializer<ParentComment> {
        @Override
        public ParentComment deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            ParentComment size = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                size = gson.fromJson(json,ParentComment.class);

            }
            return size;
        }
    }

    public static class TextDeserializer implements JsonDeserializer<ChapterContent.Text> {

        @Override
        public ChapterContent.Text deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            ChapterContent.Text text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,ChapterContent.Text.class);

            }
            return text;
        }
    }

    public static class MsgDeserializer implements JsonDeserializer<ChapterContent.Msg> {

        @Override
        public ChapterContent.Msg deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            ChapterContent.Msg text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,ChapterContent.Msg.class);

            }
            return text;
        }
    }

    public static class UserStatusDeserializer implements JsonDeserializer<ChapterContent.User_status> {

        @Override
        public ChapterContent.User_status deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            ChapterContent.User_status text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,ChapterContent.User_status.class);

            }
            return text;
        }
    }

    public static class BookInfoDeserializer implements JsonDeserializer<ChapterContent.BookInfo> {

        @Override
        public ChapterContent.BookInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            ChapterContent.BookInfo text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,ChapterContent.BookInfo.class);

            }
            return text;
        }
    }

    public static class ChapterInfofoDeserializer implements JsonDeserializer<ChapterContent.ChapterInfo> {

        @Override
        public ChapterContent.ChapterInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            ChapterContent.ChapterInfo text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,ChapterContent.ChapterInfo.class);

            }
            return text;
        }
    }
    public static class BannerDeserializer implements JsonDeserializer<Banner> {

        @Override
        public Banner deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Banner text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,Banner.class);

            }
            return text;
        }
    }

    public static class BookDeserializer implements JsonDeserializer<Book> {

        @Override
        public Book deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Book text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,Book.class);

            }
            return text;
        }
    }

    public static class BookDetailDeserializer implements JsonDeserializer<BookDetail> {

        @Override
        public BookDetail deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            BookDetail text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,BookDetail.class);

            }
            return text;
        }
    }

    public static class RewordsDeserializer implements JsonDeserializer<BookDetail.Rewards> {

        @Override
        public BookDetail.Rewards deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            BookDetail.Rewards text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,BookDetail.Rewards.class);

            }
            return text;
        }
    }

    public static class BookDetailHeaderDeserializer implements JsonDeserializer<BookDetailHeader> {

        @Override
        public BookDetailHeader deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            BookDetailHeader text = null;
            if (json.isJsonObject()) {
                //类型正确
                BookDetailHeader bookDetailHeader = new BookDetailHeader();
                JsonObject jsonObject = json.getAsJsonObject();
                if (jsonObject.get("userRecord")!=null){

                }

            }
            return text;
        }
    }

    public static class UserRecordDeserializer implements JsonDeserializer<UserRecord> {

        @Override
        public UserRecord deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            UserRecord text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,UserRecord.class);

            }
            return text;
        }
    }

    public static class CategoryBookDeserializer implements JsonDeserializer<CategoryBook> {

        @Override
        public CategoryBook deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            CategoryBook text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,CategoryBook.class);

            }
            return text;
        }
    }

    public static class ChapterDeserializer implements JsonDeserializer<Chapter> {

        @Override
        public Chapter deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Chapter text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,Chapter.class);

            }
            return text;
        }
    }


    public static class ChapterContentDeserializer implements JsonDeserializer<ChapterContent> {

        @Override
        public ChapterContent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            ChapterContent text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,ChapterContent.class);

            }
            return text;
        }
    }

    public static class ChartsDeserializer implements JsonDeserializer<Charts> {

        @Override
        public Charts deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Charts text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,Charts.class);

            }
            return text;
        }
    }

    public static class CommentDeserializer implements JsonDeserializer<Comment> {

        @Override
        public Comment deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Comment text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,Comment.class);

            }
            return text;
        }
    }

    public static class CostDeserializer implements JsonDeserializer<Cost> {

        @Override
        public Cost deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Cost text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,Cost.class);

            }
            return text;
        }
    }

    public static class GiftDeserializer implements JsonDeserializer<Gift> {

        @Override
        public Gift deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Gift text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,Gift.class);

            }
            return text;
        }
    }

    public static class GiftLogDeserializer implements JsonDeserializer<GiftLog> {

        @Override
        public GiftLog deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            GiftLog text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,GiftLog.class);

            }
            return text;
        }
    }

    public static class IndexBannerDeserializer implements JsonDeserializer<IndexBanner> {

        @Override
        public IndexBanner deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            IndexBanner text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,IndexBanner.class);

            }
            return text;
        }
    }

    public static class LatestBookDeserializer implements JsonDeserializer<LatestBook> {

        @Override
        public LatestBook deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            LatestBook text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,LatestBook.class);

            }
            return text;
        }
    }

    public static class MyCommentBeanDeserializer implements JsonDeserializer<MyCommentBean> {

        @Override
        public MyCommentBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            MyCommentBean text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,MyCommentBean.class);

            }
            return text;
        }
    }

    public static class MyRehargeRecordDeserializer implements JsonDeserializer<MyRehargeRecord> {

        @Override
        public MyRehargeRecord deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            MyRehargeRecord text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,MyRehargeRecord.class);

            }
            return text;
        }
    }

    public static class OrderInfoDeserializer implements JsonDeserializer<OrderInfo> {

        @Override
        public OrderInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            OrderInfo text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,OrderInfo.class);

            }
            return text;
        }
    }

    public static class RankBookDeserializer implements JsonDeserializer<RankBook> {

        @Override
        public RankBook deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            RankBook text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,RankBook.class);

            }
            return text;
        }
    }

    public static class RechargeDeserializer implements JsonDeserializer<Recharge> {

        @Override
        public Recharge deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Recharge text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,Recharge.class);

            }
            return text;
        }
    }

    public static class UserDeserializer implements JsonDeserializer<User> {

        @Override
        public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            User text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,User.class);

            }
            return text;
        }
    }

    public static class UserInfoDeserializer implements JsonDeserializer<UserInfo> {

        @Override
        public UserInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            UserInfo text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,UserInfo.class);

            }
            return text;
        }
    }

    public static class BaseInfoDeserializer implements JsonDeserializer<UserInfo.BaseInfo> {

        @Override
        public UserInfo.BaseInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            UserInfo.BaseInfo text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,UserInfo.BaseInfo.class);

            }
            return text;
        }
    }

    public static class MonthlyInfoDeserializer implements JsonDeserializer<UserInfo.MonthlyInfo> {

        @Override
        public UserInfo.MonthlyInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            UserInfo.MonthlyInfo text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,UserInfo.MonthlyInfo.class);

            }
            return text;
        }
    }

    public static class VerifyCodeDeserializer implements JsonDeserializer<VerifyCode> {

        @Override
        public VerifyCode deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            VerifyCode text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,VerifyCode.class);

            }
            return text;
        }
    }

    public static class WalletDeserializer implements JsonDeserializer<Wallet> {

        @Override
        public Wallet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Wallet text = null;
            if (json.isJsonObject()) {
                //类型正确
                Gson gson = new Gson();
                text = gson.fromJson(json,Wallet.class);

            }
            return text;
        }
    }

}
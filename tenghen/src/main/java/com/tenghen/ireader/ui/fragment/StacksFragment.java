package com.tenghen.ireader.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tenghen.ireader.net.ResponseCallback;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseListFragment;
import com.tenghen.ireader.module.IndexBanner;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.BookTypeActivity;
import com.tenghen.ireader.ui.activity.RankActivity;
import com.tenghen.ireader.ui.activity.SearchActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class StacksFragment extends BaseListFragment implements View.OnClickListener, XBanner.XBannerAdapter {

    public static final int RANK_CLICK = 1;
    public static final int RANK_SUB = 2;
    public static final int RANK_COLLECT = 3;
    public static final int RANK_REC = 4;
    public static final int RANK_NEW = 5;
    public static final int RANK_COMPLETE = 6;
    public static final int RANK_UPDATE = 7;
    public static final int RANK_REWARD = 8;

    @BindView(R.id.stacksModernBtn)
    public TextView stacksModerBtn;
    @BindView(R.id.stacksAncientBtn)
    public TextView stacksAncientBtn;
    @BindView(R.id.stacksCityBtn)
    public TextView stacksCityBtn;
    @BindView(R.id.stacksFantasyBtn)
    public TextView stacksFantasyBtn;
    @BindView(R.id.stacksFantasyLoveBtn)
    public TextView stacksFantasyLoveBtn;
    @BindView(R.id.stacksSchoolBtn)
    public TextView stacksSchoolBtn;

    @BindView(R.id.clickRankBtn)
    public TextView clickRankBtn;
    @BindView(R.id.subRankBtn)
    public TextView subRankBtn;
    @BindView(R.id.collectRankBtn)
    public TextView collectRankBtn;
    @BindView(R.id.recRankBtn)
    public TextView recRankBtn;
    @BindView(R.id.newRankBtn)
    public TextView newRankBtn;
    @BindView(R.id.completeRankBtn)
    public TextView completeRankBtn;
    @BindView(R.id.updateRankBtn)
    public TextView updateRankBtn;
    @BindView(R.id.rewardRankBtn)
    public TextView rewardRankBtn;

    @BindView(R.id.searchBtn)
    public TextView searchBtn;

    @BindView(R.id.common_Banner)
    XBanner banner;

    List<String> imgs = new ArrayList<>();


    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_stacks;
    }

    @Override
    public void initData() {
        startRequestForBanner();
    }

    private void startRequestForBanner() {
        Api.bannerIndexBanner(new ResponseCallback<List<IndexBanner>>() {
            @Override
            public void onSuccess(List<IndexBanner> data) {
                for (IndexBanner indexBanner : data) {
                    imgs.add(indexBanner.getPicture());
                }
                banner.setData(imgs,null);
            }

            @Override
            public void onFailure(int errCode, String info) {

            }
        });
    }

    @Override
    public void initViews() {
        banner.removeAllViews();
        banner.setPageTransformer(Transformer.Default);
        banner.setmAdapter(this);
    }

    @Override
    public void setListener() {
        clickRankBtn.setOnClickListener(this);
        subRankBtn.setOnClickListener(this);
        collectRankBtn.setOnClickListener(this);
        recRankBtn.setOnClickListener(this);
        newRankBtn.setOnClickListener(this);
        completeRankBtn.setOnClickListener(this);
        updateRankBtn.setOnClickListener(this);
        rewardRankBtn.setOnClickListener(this);

        stacksModerBtn.setOnClickListener(this);
        stacksAncientBtn.setOnClickListener(this);
        stacksCityBtn.setOnClickListener(this);
        stacksFantasyBtn.setOnClickListener(this);
        stacksFantasyLoveBtn.setOnClickListener(this);
        stacksSchoolBtn.setOnClickListener(this);

        searchBtn.setOnClickListener(this);
    }

    @Override
    public Object newPresent() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.stacksModernBtn:
                BookTypeActivity.launch(getContext(),BookTypeActivity.INDEX_TYPE_MODERN_ROMANCE);
                break;
            case R.id.stacksAncientBtn:
                BookTypeActivity.launch(getContext(),BookTypeActivity.INDEX_TYPE_ANCIENT_ROMANCE);
                break;
            case R.id.stacksCityBtn:
                BookTypeActivity.launch(getContext(),BookTypeActivity.INDEX_TYPE_MODERN_CITY);
                break;
            case R.id.stacksFantasyBtn:
                BookTypeActivity.launch(getContext(),BookTypeActivity.INDEX_TYPE_FANTASY_MAGIC);
                break;
            case R.id.stacksFantasyLoveBtn:
                BookTypeActivity.launch(getContext(),BookTypeActivity.INDEX_TYPE_FANTASY_ROMANCE);
                break;
            case R.id.stacksSchoolBtn:
                BookTypeActivity.launch(getContext(),BookTypeActivity.INDEX_TYPE_YOUTH_SCHOOL);
                break;

            case R.id.clickRankBtn:
                RankActivity.launch(getContext(),RANK_CLICK,((TextView)view).getText().toString());
                break;
            case R.id.subRankBtn:
                RankActivity.launch(getContext(),RANK_SUB,((TextView)view).getText().toString());
                break;
            case R.id.collectRankBtn:
                RankActivity.launch(getContext(),RANK_COLLECT,((TextView)view).getText().toString());
                break;
            case R.id.recRankBtn:
                RankActivity.launch(getContext(),RANK_REC,((TextView)view).getText().toString());
                break;
            case R.id.newRankBtn:
                RankActivity.launch(getContext(),RANK_NEW,((TextView)view).getText().toString());
                break;
            case R.id.completeRankBtn:
                RankActivity.launch(getContext(),RANK_COMPLETE,((TextView)view).getText().toString());
                break;
            case R.id.updateRankBtn:
                RankActivity.launch(getContext(),RANK_UPDATE,((TextView)view).getText().toString());
                break;
            case R.id.rewardRankBtn:
                RankActivity.launch(getContext(),RANK_REWARD,((TextView)view).getText().toString());
                break;
            case R.id.searchBtn:
                SearchActivity.launch(getContext(),"");
                break;
        }
    }

    @Override
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(this).load(imgs.get(position)).into((ImageView) view);
    }
}

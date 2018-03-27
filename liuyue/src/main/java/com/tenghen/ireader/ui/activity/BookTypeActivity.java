package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.base.XListPresent;
import com.chengx.mvp.widget.XRecyclerView;
import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.BookTypeAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.CategoryBook;
import com.tenghen.ireader.ui.present.BookTypePresent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：chengx
 * 日期：2017/2/28
 * 描述：
 */

public class BookTypeActivity extends BaseListActivity<BookTypePresent,CategoryBook> implements View.OnClickListener, CommonRecyclerAdapter.OnRecyclerViewItemClickListener<CategoryBook> {


    public static final int INDEX_TYPE_ALL = 0;
    public static final int INDEX_TYPE_FANTASY_MAGIC = 149;
    public static final int INDEX_TYPE_YOUTH_SCHOOL = 150;
    public static final int INDEX_TYPE_MODERN_ROMANCE = 151;
    public static final int INDEX_TYPE_ANCIENT_ROMANCE = 152;
    public static final int INDEX_TYPE_FANTASY_ROMANCE = 153;
    public static final int INDEX_TYPE_GIRL_SUSPENSE = 164;
    public static final int INDEX_TYPE_SCI_FI = 155;
    public static final int INDEX_TYPE_HUMAN_DECIMAL = 156;
    public static final int INDEX_TYPE_LIGHT_NOVEL = 157;
    public static final int INDEX_TYPE_MODERN_CITY = 158;
    public static final int INDEX_TYPE_SUSPENSE_THRILLERS = 159;
    public static final int INDEX_TYPE_GAME = 160;
    public static final int INDEX_TYPE_HISTORY_MILITARY = 161;
    public static final int INDEX_TYPE_KNIGHT_ERRANT = 162;
    public static final int INDEX_TYPE_FANTASY_EXPLORE = 163;
    public static final int INDEX_TYPE_SUPERNATURAL_SUSPENSE = 165;
    public static final int INDEX_TYPE_EMOTIONAL_NOVEL = 166;
    public static final int INDEX_TYPE_LITERATURE_NOVEL = 167;
    public static final int INDEX_TYPE_FILM_SCRIPT = 168;
    public static final int INDEX_TYPE_LIFE_LEISURE = 169;
    public static final int INDEX_TYPE_HISTORY_BIOGRAPHY = 170;
    public static final int INDEX_TYPE_MANAGE_IMPROVE = 171;
    public static final int INDEX_TYPE_SOCIAL_SCIENCE = 172;

    public static final int INDEX_COST_ALL = 0;
    public static final int INDEX_COST_FREE = 1;
    public static final int INDEX_COST_CHARGE = 2;
    public static final int INDEX_COST_MONTH = 3;

    public static final int INDEX_COMPELETE_ALL = 0;
    public static final int INDEX_COMPELETE = 1;
    public static final int INDEX_SERIAL = 2;

    public static final int INDEX_ORDER_NEW = 0;
    public static final int INDEX_ORDER_COLLECT = 1;
    public static final int INDEX_ORDER_LENGTH = 2;



    @BindView(R.id.allTypeBtn)
    public TextView allTypeBtn;
    @BindView(R.id.fantasyMagicTypeBtn)
    public TextView fantasyMagicTypeBtn;
    @BindView(R.id.youthSchoolTypeBtn)
    public TextView youthSchoolTypeBtn;
    @BindView(R.id.modernRomanceTypeBtn)
    public TextView modernRomanceTypeBtn;
    @BindView(R.id.ancientRomanceTypeBtn)
    public TextView ancientRomanceTypeBtn;
    @BindView(R.id.fantasyRomanceTypeBtn)
    public TextView fantasyRomanceTypeBtn;
    @BindView(R.id.girlSuspenseTypeBtn)
    public TextView girlSuspenseTypeBtn;
    @BindView(R.id.sciFiTypeBtn)
    public TextView sciFiTypeBtn;
    @BindView(R.id.humanDecimalTypeBtn)
    public TextView humanDecimalTypeBtn;
    @BindView(R.id.lightNovelTypeBtn)
    public TextView lightNovelTypeBtn;
    @BindView(R.id.modernCityTypeBtn)
    public TextView modernCityTypeBtn;
    @BindView(R.id.suspenseThrillersTypeBtn)
    public TextView suspenseThrillersTypeBtn;
    @BindView(R.id.gameTypeBtn)
    public TextView gameTypeBtn;
    @BindView(R.id.historyMilitaryTypeBtn)
    public TextView historyMilitaryTypeBtn;
    @BindView(R.id.knightErrantTypeBtn)
    public TextView knightErrantTypeBtn;
    @BindView(R.id.fantasyExploreTypeBtn)
    public TextView fantasyExploreTypeBtn;
    @BindView(R.id.supernaturalSuspenseTypeBtn)
    public TextView supernaturalSuspenseTypeBtn;
    @BindView(R.id.emotionalNovelTypeBtn)
    public TextView emotionalNovelTypeBtn;
    @BindView(R.id.literatureNovelTypeBtn)
    public TextView literatureNovelTypeBtn;
    @BindView(R.id.filmScriptTypeBtn)
    public TextView filmScriptTypeBtn;
    @BindView(R.id.lifeLeisureTypeBtn)
    public TextView lifeLeisureTypeBtn;
    @BindView(R.id.historyBiographyTypeBtn)
    public TextView historyBiographyTypeBtn;
    @BindView(R.id.manageImproveTypeBtn)
    public TextView manageImproveTypeBtn;
    @BindView(R.id.socialScienceTypeBtn)
    public TextView socialScienceTypeBtn;
    @BindView(R.id.allCostBtn)
    public TextView allCostBtn;
    @BindView(R.id.freeBtn)
    public TextView freeBtn;
    @BindView(R.id.chargeBtn)
    public TextView chargeBtn;
    @BindView(R.id.monthBtn)
    public TextView monthBtn;
    @BindView(R.id.allCompleteBtn)
    public TextView allCompleteBtn;
    @BindView(R.id.completeBtn)
    public TextView completeBtn;
    @BindView(R.id.serialBtn)
    public TextView serialBtn;
    @BindView(R.id.orderNewBtn)
    public TextView orderNewBtn;
    @BindView(R.id.orderCollectBtn)
    public TextView orderCollectBtn;
    @BindView(R.id.orderLengthBtn)
    public TextView orderLengthBtn;
    @BindView(R.id.typeLayout)
    public LinearLayout typeLayout;
    @BindView(R.id.costLayout)
    public LinearLayout costLayout;
    @BindView(R.id.completeLayout)
    public LinearLayout completeLayout;
    @BindView(R.id.orderLayout)
    public LinearLayout orderLayout;


    int type;






    private List<CategoryBook> data;

    public static void launch(Context context,int type){
        Intent intent = new Intent(context,BookTypeActivity.class);
        intent.putExtra("type",type);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("分类");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_book_type;
    }

    @Override
    public void initData() {
        type = getIntent().getIntExtra("type",INDEX_TYPE_ALL);
        data = new ArrayList<>();
        adapter = new BookTypeAdapter(this,R.layout.item_book_type,data);

    }

    @Override
    public void initViews() {
        super.initViews();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        setTypeSelected(type);
        setCostSelected(INDEX_COST_ALL);
        setCompeleteSelected(INDEX_COMPELETE_ALL);
        setOrderSelected(INDEX_ORDER_NEW);
        getPresent().refresh();
    }

    @Override
    public void setListener() {
        allTypeBtn.setOnClickListener(this);
        fantasyMagicTypeBtn.setOnClickListener(this);
        youthSchoolTypeBtn.setOnClickListener(this);
        modernRomanceTypeBtn.setOnClickListener(this);
        ancientRomanceTypeBtn.setOnClickListener(this);
        fantasyRomanceTypeBtn.setOnClickListener(this);
        girlSuspenseTypeBtn.setOnClickListener(this);
        sciFiTypeBtn.setOnClickListener(this);
        humanDecimalTypeBtn.setOnClickListener(this);
        lightNovelTypeBtn.setOnClickListener(this);
        modernCityTypeBtn.setOnClickListener(this);
        suspenseThrillersTypeBtn.setOnClickListener(this);
        gameTypeBtn.setOnClickListener(this);
        historyMilitaryTypeBtn.setOnClickListener(this);
        knightErrantTypeBtn.setOnClickListener(this);
        fantasyExploreTypeBtn.setOnClickListener(this);
        supernaturalSuspenseTypeBtn.setOnClickListener(this);
        emotionalNovelTypeBtn.setOnClickListener(this);
        literatureNovelTypeBtn.setOnClickListener(this);
        filmScriptTypeBtn.setOnClickListener(this);
        lifeLeisureTypeBtn.setOnClickListener(this);
        historyBiographyTypeBtn.setOnClickListener(this);
        manageImproveTypeBtn.setOnClickListener(this);
        socialScienceTypeBtn.setOnClickListener(this);
        allCostBtn.setOnClickListener(this);
        freeBtn.setOnClickListener(this);
        chargeBtn.setOnClickListener(this);
        monthBtn.setOnClickListener(this);
        allCompleteBtn.setOnClickListener(this);
        completeBtn.setOnClickListener(this);
        serialBtn.setOnClickListener(this);
        orderNewBtn.setOnClickListener(this);
        orderCollectBtn.setOnClickListener(this);
        orderLengthBtn.setOnClickListener(this);
        ((CommonRecyclerAdapter)adapter).setOnItemClickListener(this);

    }

    @Override
    public BookTypePresent newPresent() {
        return new BookTypePresent();
    }

    private void resetTypeBtn(){
        for (int i = 0; i < typeLayout.getChildCount(); i++) {
            typeLayout.getChildAt(i).setSelected(false);
        }

    }
    private void resetCostBtn(){
        for (int i = 0; i < costLayout.getChildCount(); i++) {
            costLayout.getChildAt(i).setSelected(false);
        }

    }
    private void resetCompeleteBtn(){
        for (int i = 0; i < completeLayout.getChildCount(); i++) {
            completeLayout.getChildAt(i).setSelected(false);
        }
    }
    private void resetOrderBtn(){
        for (int i = 0; i < orderLayout.getChildCount(); i++) {
            orderLayout.getChildAt(i).setSelected(false);
        }
    }

    private void setTypeSelected(int index){
        resetTypeBtn();
        switch (index){
            case INDEX_TYPE_ALL:
                allTypeBtn.setSelected(true);
                toolbar.setTitle(allTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_FANTASY_MAGIC:
                fantasyMagicTypeBtn.setSelected(true);
                toolbar.setTitle(fantasyMagicTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_YOUTH_SCHOOL:
                youthSchoolTypeBtn.setSelected(true);
                toolbar.setTitle(youthSchoolTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_MODERN_ROMANCE:
                modernRomanceTypeBtn.setSelected(true);
                toolbar.setTitle(modernRomanceTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_ANCIENT_ROMANCE:
                ancientRomanceTypeBtn.setSelected(true);
                toolbar.setTitle(ancientRomanceTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_FANTASY_ROMANCE:
                fantasyRomanceTypeBtn.setSelected(true);
                toolbar.setTitle(fantasyRomanceTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_GIRL_SUSPENSE:
                girlSuspenseTypeBtn.setSelected(true);
                toolbar.setTitle(girlSuspenseTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_SCI_FI:
                sciFiTypeBtn.setSelected(true);
                toolbar.setTitle(sciFiTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_GAME:
                gameTypeBtn.setSelected(true);
                toolbar.setTitle(gameTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_HUMAN_DECIMAL:
                humanDecimalTypeBtn.setSelected(true);
                toolbar.setTitle(humanDecimalTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_LIGHT_NOVEL:
                lightNovelTypeBtn.setSelected(true);
                toolbar.setTitle(lightNovelTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_MODERN_CITY:
                modernCityTypeBtn.setSelected(true);
                toolbar.setTitle(modernCityTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_SUSPENSE_THRILLERS:
                suspenseThrillersTypeBtn.setSelected(true);
                toolbar.setTitle(suspenseThrillersTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_HISTORY_MILITARY:
                historyMilitaryTypeBtn.setSelected(true);
                toolbar.setTitle(historyMilitaryTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_KNIGHT_ERRANT:
                knightErrantTypeBtn.setSelected(true);
                toolbar.setTitle(knightErrantTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_FANTASY_EXPLORE:
                fantasyExploreTypeBtn.setSelected(true);
                toolbar.setTitle(fantasyExploreTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_SUPERNATURAL_SUSPENSE:
                supernaturalSuspenseTypeBtn.setSelected(true);
                toolbar.setTitle(supernaturalSuspenseTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_LITERATURE_NOVEL:
                literatureNovelTypeBtn.setSelected(true);
                toolbar.setTitle(literatureNovelTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_EMOTIONAL_NOVEL:
                emotionalNovelTypeBtn.setSelected(true);
                toolbar.setTitle(emotionalNovelTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_FILM_SCRIPT:
                filmScriptTypeBtn.setSelected(true);
                toolbar.setTitle(filmScriptTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_LIFE_LEISURE:
                lifeLeisureTypeBtn.setSelected(true);
                toolbar.setTitle(lifeLeisureTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_HISTORY_BIOGRAPHY:
                historyBiographyTypeBtn.setSelected(true);
                toolbar.setTitle(historyBiographyTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_MANAGE_IMPROVE:
                manageImproveTypeBtn.setSelected(true);
                toolbar.setTitle(manageImproveTypeBtn.getText().toString());
                break;
            case INDEX_TYPE_SOCIAL_SCIENCE:
                socialScienceTypeBtn.setSelected(true);
                toolbar.setTitle(socialScienceTypeBtn.getText().toString());
                break;


        }
        ((BookTypePresent)getPresent()).setCategory(index);
    }

    private void setCostSelected(int index){
        resetCostBtn();
        switch (index){
            case INDEX_COST_ALL:
                allCostBtn.setSelected(true);
                break;
            case INDEX_COST_FREE:
                freeBtn.setSelected(true);
                break;
            case INDEX_COST_CHARGE:
                chargeBtn.setSelected(true);
                break;
            case INDEX_COST_MONTH:
                monthBtn.setSelected(true);
                break;
        }
        ((BookTypePresent)getPresent()).setCost(index);
    }

    private void setCompeleteSelected(int index){
        resetCompeleteBtn();
        switch (index){
            case INDEX_COMPELETE_ALL:
                allCompleteBtn.setSelected(true);
                break;
            case INDEX_COMPELETE:
                completeBtn.setSelected(true);
                break;
            case INDEX_SERIAL:
                serialBtn.setSelected(true);
                break;
        }
        ((BookTypePresent)getPresent()).setRate(index);
    }

    private void setOrderSelected(int index){
        resetOrderBtn();
        switch (index){
            case INDEX_ORDER_NEW:
                orderNewBtn.setSelected(true);
                break;
            case INDEX_ORDER_COLLECT:
                orderCollectBtn.setSelected(true);
                break;
            case INDEX_ORDER_LENGTH:
                orderLengthBtn.setSelected(true);
                break;
        }
        ((BookTypePresent)getPresent()).setSort(index);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.allTypeBtn:
                setTypeSelected(INDEX_TYPE_ALL);
                break;
            case R.id.fantasyMagicTypeBtn:
                setTypeSelected(INDEX_TYPE_FANTASY_MAGIC);
                break;
            case R.id.youthSchoolTypeBtn:
                setTypeSelected(INDEX_TYPE_YOUTH_SCHOOL);
                break;
            case R.id.modernRomanceTypeBtn:
                setTypeSelected(INDEX_TYPE_MODERN_ROMANCE);
                break;
            case R.id.ancientRomanceTypeBtn:
                setTypeSelected(INDEX_TYPE_ANCIENT_ROMANCE);
                break;
            case R.id.fantasyRomanceTypeBtn:
                setTypeSelected(INDEX_TYPE_FANTASY_ROMANCE);
                break;
            case R.id.girlSuspenseTypeBtn:
                setTypeSelected(INDEX_TYPE_GIRL_SUSPENSE);
                break;
            case R.id.sciFiTypeBtn:
                setTypeSelected(INDEX_TYPE_SCI_FI);
                break;
            case R.id.humanDecimalTypeBtn:
                setTypeSelected(INDEX_TYPE_HUMAN_DECIMAL);
                break;
            case R.id.lightNovelTypeBtn:
                setTypeSelected(INDEX_TYPE_LIGHT_NOVEL);
                break;
            case R.id.modernCityTypeBtn:
                setTypeSelected(INDEX_TYPE_MODERN_CITY);
                break;
            case R.id.suspenseThrillersTypeBtn:
                setTypeSelected(INDEX_TYPE_SUSPENSE_THRILLERS);
                break;
            case R.id.gameTypeBtn:
                setTypeSelected(INDEX_TYPE_GAME);
                break;
            case R.id.historyMilitaryTypeBtn:
                setTypeSelected(INDEX_TYPE_HISTORY_MILITARY);
                break;
            case R.id.knightErrantTypeBtn:
                setTypeSelected(INDEX_TYPE_KNIGHT_ERRANT);
                break;
            case R.id.fantasyExploreTypeBtn:
                setTypeSelected(INDEX_TYPE_FANTASY_EXPLORE);
                break;
            case R.id.supernaturalSuspenseTypeBtn:
                setTypeSelected(INDEX_TYPE_SUPERNATURAL_SUSPENSE);
                break;
            case R.id.emotionalNovelTypeBtn:
                setTypeSelected(INDEX_TYPE_EMOTIONAL_NOVEL);
                break;
            case R.id.literatureNovelTypeBtn:
                setTypeSelected(INDEX_TYPE_LITERATURE_NOVEL);
                break;
            case R.id.filmScriptTypeBtn:
                setTypeSelected(INDEX_TYPE_FILM_SCRIPT);
                break;
            case R.id.lifeLeisureTypeBtn:
                setTypeSelected(INDEX_TYPE_LIFE_LEISURE);
                break;
            case R.id.historyBiographyTypeBtn:
                setTypeSelected(INDEX_TYPE_HISTORY_BIOGRAPHY);
                break;
            case R.id.manageImproveTypeBtn:
                setTypeSelected(INDEX_TYPE_MANAGE_IMPROVE);
                break;
            case R.id.socialScienceTypeBtn:
                setTypeSelected(INDEX_TYPE_SOCIAL_SCIENCE);
                break;

            case R.id.allCostBtn:
                setCostSelected(INDEX_COST_ALL);
                break;
            case R.id.chargeBtn:
                setCostSelected(INDEX_COST_CHARGE);
                break;
            case R.id.freeBtn:
                setCostSelected(INDEX_COST_FREE);
                break;
            case R.id.monthBtn:
                setCostSelected(INDEX_COST_MONTH);
                break;

            case R.id.allCompleteBtn:
                setCompeleteSelected(INDEX_COMPELETE_ALL);
                break;
            case R.id.completeBtn:
                setCompeleteSelected(INDEX_COMPELETE);
                break;
            case R.id.serialBtn:
                setCompeleteSelected(INDEX_SERIAL);
                break;

            case R.id.orderNewBtn:
                setOrderSelected(INDEX_ORDER_NEW);
                break;
            case R.id.orderCollectBtn:
                setOrderSelected(INDEX_ORDER_COLLECT);
                break;
            case R.id.orderLengthBtn:
                setOrderSelected(INDEX_ORDER_LENGTH);
                break;
        }
        getPresent().refresh();
    }


    @Override
    public void onItemClick(View view, CategoryBook data) {
        BookDetailActivity.launch(this,data.getId());
    }
}

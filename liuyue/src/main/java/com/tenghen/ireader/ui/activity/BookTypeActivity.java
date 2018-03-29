package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.base.XListPresent;
import com.chengx.mvp.widget.XRecyclerView;
import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.BookTypeAdapter;
import com.tenghen.ireader.adapter.TypeAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.CategoryBook;
import com.tenghen.ireader.module.Type;
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



    @BindView(R.id.typeList)
    public RecyclerView typeListView;

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
    @BindView(R.id.costLayout)
    public LinearLayout costLayout;
    @BindView(R.id.completeLayout)
    public LinearLayout completeLayout;
    @BindView(R.id.orderLayout)
    public LinearLayout orderLayout;

    private List<Type> typeList;
    private TypeAdapter typeAdapter;


    int type;

    int position;






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
        type = getIntent().getIntExtra("type",0);
        data = new ArrayList<>();
        adapter = new BookTypeAdapter(this,R.layout.item_book_type,data);
        typeList = new ArrayList<>();
        Type typeAll = new Type();
        typeAll.setSelected(type == 0);
        typeAll.setText("全部");
        typeAll.setId(0);
        typeList.add(typeAll);
        String[] typeNames = getResources().getStringArray(R.array.type_name);
        for (int i = 13; i <=47 ; i++) {
            Type type = new Type();
            type.setId(i);
            type.setText(typeNames[i-13]);
            if (type.getId() == this.type){
                type.setSelected(true);
            }
            typeList.add(type);
        }
        for (int i = 0; i < typeList.size(); i++) {
            if (typeList.get(i).isSelected()){
                position = i;
                break;
            }
        }
        ((BookTypePresent)getPresent()).setCategory(type);
        typeAdapter = new TypeAdapter(this,R.layout.layout_type_item,typeList);

    }

    @Override
    public void initViews() {
        super.initViews();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        typeListView.setLayoutManager(llm);
        typeListView.setAdapter(typeAdapter);
        typeListView.scrollToPosition(position);
        typeAdapter.setOnItemClickListener(new CommonRecyclerAdapter.OnRecyclerViewItemClickListener<Type>() {
            @Override
            public void onItemClick(View view, Type data) {
                for (Type type1 : typeList) {
                    type1.setSelected(false);
                }
                data.setSelected(true);
                typeAdapter.notifyDataSetChanged();
                type = data.getId();
                ((BookTypePresent)getPresent()).setCategory(type);
                getPresent().refresh();
            }
        });
        setCostSelected(INDEX_COST_ALL);
        setCompeleteSelected(INDEX_COMPELETE_ALL);
        setOrderSelected(INDEX_ORDER_NEW);
        getPresent().refresh();
    }

    @Override
    public void setListener() {

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

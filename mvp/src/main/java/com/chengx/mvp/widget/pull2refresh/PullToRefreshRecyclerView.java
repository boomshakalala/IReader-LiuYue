/*******************************************************************************
 * Copyright 2014 Dean Ding.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.chengx.mvp.widget.pull2refresh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.chengx.mvp.R;
import com.chengx.mvp.widget.DividerDecoration;

/**
 *
 * Support RecyclerView
 *
 * @author Dean.Ding
 *
 */
public class PullToRefreshRecyclerView extends PullToRefreshBase<RecyclerView> {

    public PullToRefreshRecyclerView(Context context) {
        super(context);
    }

    public PullToRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefreshRecyclerView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshRecyclerView(Context context, Mode mode, AnimationStyle style) {
        super(context, mode, style);
    }

    @Override
    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    @Override
    protected RecyclerView createRefreshableView(Context context, AttributeSet attrs) {
        RecyclerView recyclerView;
        recyclerView = new RecyclerView(context, attrs);
        recyclerView.setId(R.id.recyclerview);
        recyclerView.addItemDecoration(new DividerDecoration(1,getResources().getColor(R.color.color_spline)));
        return recyclerView;
    }

    @Override
    protected boolean isReadyForPullStart() {
        if (mRefreshableView == null)
            return false;
        if (mRefreshableView.getChildCount() <= 0)
            return true;
        int firstVisiblePosition = mRefreshableView.getChildPosition(mRefreshableView.getChildAt(0));
        if (firstVisiblePosition == 0)
            return mRefreshableView.getChildAt(0).getTop() == mRefreshableView.getPaddingTop();
        else
            return false;

    }

    @Override
    protected boolean isReadyForPullEnd() {
        if (mRefreshableView == null)
            return false;
        int lastVisiblePosition = mRefreshableView.getChildPosition(mRefreshableView.getChildAt(mRefreshableView.getChildCount() -1));
        if (mRefreshableView.getAdapter()==null)
            return false;
        if (lastVisiblePosition >= mRefreshableView.getAdapter().getItemCount()-1) {
            if (mRefreshableView.getChildCount()>=1)
            return mRefreshableView.getChildAt(mRefreshableView.getChildCount() - 1).getBottom() <= mRefreshableView.getBottom();
        }
        return false;
    }

    public void setAdapter(RecyclerView.Adapter adapter){
        getRefreshableView().setAdapter(adapter);
    }

    public void setLayoutManager(RecyclerView.LayoutManager manager){
        getRefreshableView().setLayoutManager(manager);
    }

}
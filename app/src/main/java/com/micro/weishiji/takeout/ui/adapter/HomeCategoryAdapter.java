package com.micro.weishiji.takeout.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.micro.weishiji.common.ui.BaseAdapterRV;
import com.micro.weishiji.common.ui.BaseHolderRV;
import com.micro.weishiji.takeout.model.bean.Home;
import com.micro.weishiji.takeout.ui.holder.HomeCategoryHolder;

import java.util.List;

/**
 * @author WJQ
 */
public class HomeCategoryAdapter extends BaseAdapterRV<Home.PromotionTypesBean> {

    public HomeCategoryAdapter(Context context, List<Home.PromotionTypesBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<Home.PromotionTypesBean> createViewHolder(
            Context context, ViewGroup parent, int viewType) {
        return new HomeCategoryHolder(context, parent, this, viewType);
    }
}

package com.micro.weishiji.takeout.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;


import com.micro.weishiji.common.ui.BaseAdapterRV;
import com.micro.weishiji.common.ui.BaseHolderRV;
import com.micro.weishiji.takeout.model.bean.Home;
import com.micro.weishiji.takeout.model.bean.local.ShopList;
import com.micro.weishiji.takeout.ui.holder.HomeAdHolder;
import com.micro.weishiji.takeout.ui.holder.HomeHeaderHolder;
import com.micro.weishiji.takeout.ui.holder.HomeHolder;
import com.micro.weishiji.takeout.ui.holder.HomeShopHolder;

import java.util.List;

/**
 * @author WJQ
 */
public class HomeAdapter extends BaseAdapterRV<String> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_SHOP_LIST = 1;
    private static final int TYPE_AD = 2;

    public HomeAdapter(Context context, List<String> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<String> createViewHolder(
            Context context, ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {      // 显示头部的Holder
            return new HomeHeaderHolder(context, parent, this, viewType);
        }

        if (viewType == TYPE_SHOP_LIST) {   // 显示商家的Holder
            return new HomeShopHolder(context, parent, this, viewType);
        }

        if (viewType == TYPE_AD) {          // 显示广告的Holder
            return new HomeAdHolder(context, parent, this, viewType);
        }

        return new HomeHolder(context, parent, this, viewType);
    }

    // 返回列表项显示的类型
    @Override
    public int getItemViewType(int position) {
        Object obj = getItem(position);

        if (obj instanceof Home) {                      // 头部item
            return TYPE_HEADER;
        }

        if (obj instanceof ShopList.ShopListBean) {      // 商家item
            return TYPE_SHOP_LIST;
        }

        if (obj instanceof ShopList.RecommendListBean) { // 广告item
            return TYPE_AD;
        }

        return TYPE_SHOP_LIST;
    }
}

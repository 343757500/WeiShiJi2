package com.micro.weishiji.takeout.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;


import com.micro.weishiji.common.ui.BaseAdapterLV;
import com.micro.weishiji.common.ui.BaseHolderLV;
import com.micro.weishiji.takeout.model.bean.OrderBy;
import com.micro.weishiji.takeout.ui.holder.OrderByHolder;

import java.util.List;

/**
 * @author WJQ
 */

public class OrderByAdapter extends BaseAdapterLV<OrderBy.OrderByListBean> {

    /** 选中的排序条件 */
    public OrderBy.OrderByListBean mSelectedOrderBy;

    public OrderByAdapter(Context context, List<OrderBy.OrderByListBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderLV<OrderBy.OrderByListBean> createViewHolder(
            Context context, ViewGroup parent, OrderBy.OrderByListBean bean,
            int position) {
        return new OrderByHolder(context, parent, this, position, bean);
    }
}

package com.micro.weishiji.takeout.ui.holder;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.micro.weishiji.R;
import com.micro.weishiji.common.base.Global;
import com.micro.weishiji.common.ui.BaseAdapterLV;
import com.micro.weishiji.common.ui.BaseHolderLV;
import com.micro.weishiji.takeout.model.bean.OrderBy;
import com.micro.weishiji.takeout.ui.adapter.OrderByAdapter;


/**
 * @author WJQ
 */

public class OrderByHolder extends BaseHolderLV<OrderBy.OrderByListBean> {

    private TextView tvTitle;

    public OrderByHolder(Context context, ViewGroup parent,
                         BaseAdapterLV<OrderBy.OrderByListBean> adapter,
                         int position, OrderBy.OrderByListBean bean) {
        super(context, parent, adapter, position, bean);
    }

    @Override
    public View onCreateView(Context context, ViewGroup parent) {
        View item = Global.inflate(R.layout.item_order_by, parent);
        tvTitle = (TextView) item.findViewById(R.id.tv_title);
        return item;
    }

    @Override
    protected void onRefreshView(OrderBy.OrderByListBean bean, int position) {
        tvTitle.setText(bean.getName());

        // 选中的item要高亮显示
        OrderBy.OrderByListBean selectedBean = ((OrderByAdapter)
                adapter).mSelectedOrderBy;

        Resources resources = context.getResources();
        // 高亮显示
        if (selectedBean != null && selectedBean.getTag() == bean.getTag()) {
            tvTitle.setTextColor(resources.getColor(R.color.shop_category_item_selected));
        } else {
            // 普通项
            tvTitle.setTextColor(resources.getColor(R.color.item_text_02));
        }
    }
}

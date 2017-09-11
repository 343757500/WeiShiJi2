package com.micro.weishiji.takeout.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.micro.weishiji.R;
import com.micro.weishiji.common.base.Global;
import com.micro.weishiji.common.ui.BaseAdapterRV;
import com.micro.weishiji.common.ui.BaseHolderRV;
import com.micro.weishiji.common.util.Utils;
import com.micro.weishiji.takeout.model.bean.local.ShopList;
import com.squareup.picasso.Picasso;

/**
 * 显示首页广告
 *
 * @author WJQ
 */
public class HomeAdHolder extends BaseHolderRV {

    private ImageView ivAdImage;
    private TextView tvAdTitle;

    public HomeAdHolder(Context context, ViewGroup parent,
                        BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_ad);
    }

    @Override
    public void onFindViews(View itemView) {
        ivAdImage = (ImageView) itemView.findViewById(R.id.iv_ad_image);
        tvAdTitle = (TextView) itemView.findViewById(R.id.tv_ad_title);
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        ShopList.RecommendListBean ad = (ShopList.RecommendListBean) bean;
        tvAdTitle.setText(ad.getTitle());

        // 显示商家图标
        String imageUrl = Utils.replaceIp(ad.getImage());
        Picasso.with(context).load(imageUrl).into(ivAdImage);
    }

    // 列表项点击事件
    @Override
    protected void onItemClick(View itemView, int position, Object bean) {
        Global.showToast(((ShopList.RecommendListBean)bean).getTitle());
    }
}

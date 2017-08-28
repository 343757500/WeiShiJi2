package com.micro.weishiji.takeout.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.liaoinstan.springview.container.MeituanFooter;
import com.liaoinstan.springview.container.MeituanHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.micro.weishiji.R;
import com.micro.weishiji.common.base.BaseFragment;
import com.micro.weishiji.common.base.Global;
import com.micro.weishiji.takeout.persenter.HomeFragment1Presenter;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/8/24.
 */

public class MainFragment1 extends BaseFragment {

    private RecyclerView recyclerView;
    //private HomeAdapter homeAdapter;

    private SpringView springView;
    private LinearLayout llTitleBar1;
    private TextView tvLocation;
    private TextView tvSearch01;
    private LinearLayout llTopLayout;
    private LinearLayout llTitleBar2;
    private LinearLayout llTitleBar2Left;
    private CheckBox cbCategory;
    private CheckBox cbOrderby;
    private TextView llTitleBar2Right;
    private LinearLayout llPopRoot01;
    private LinearLayout llPopContent01Category;
    private ListView lvCategory01;
    private ListView lvCategory02;
    private LinearLayout llPopRoot02;
    private LinearLayout llPopContent02OrderBy;
    private ListView lvOrderBy;

    @Inject
    HomeFragment1Presenter presenter;
    @Override
    public int getLayoutRes() {
        return R.layout.fragment_01;
    }

    @Override
    public void initView() {
        springView = (SpringView) findView(R.id.spring_view);
        recyclerView = (RecyclerView) findView(R.id.recycler_view);
        llTitleBar1 = (LinearLayout) findView(R.id.ll_title_bar1);
        tvLocation = (TextView) findView(R.id.tv_location);
        tvSearch01 = (TextView) findView(R.id.tv_search_01);
        llTopLayout = (LinearLayout) findView(R.id.ll_top_layout);
        cbCategory = (CheckBox) findView(R.id.cb_category);
        cbOrderby = (CheckBox) findView(R.id.cb_orderby);
        llPopRoot01 = (LinearLayout) findView(R.id.ll_pop_root_01);
        llPopContent01Category = (LinearLayout) findView(R.id.ll_pop_content_01_category);
        llPopRoot02 = (LinearLayout) findView(R.id.ll_pop_root_02);
        llPopContent02OrderBy = (LinearLayout) findView(R.id.ll_pop_content_02_order_by);

        lvCategory01 = (ListView) findView(R.id.lv_category_01);
        lvCategory02 = (ListView) findView(R.id.lv_category_02);
        lvOrderBy = (ListView) findView(R.id.lv_order_by);

        // 设置顶部padding, 否则沉侵式显示有问题
        Global.setStatusBarPadding(llTitleBar1);
        Global.setStatusBarPadding(llTopLayout);

        // 不显示分割线
        lvCategory01.setDividerHeight(0);
        lvCategory02.setDividerHeight(0);
        lvOrderBy.setDividerHeight(0);



        initSpringView();
    }

    private void initSpringView() {
        // springView.setHeader(new BaiduHeader(mActivity));
        springView.setHeader(new MeituanHeader(mActivity));
        springView.setFooter(new MeituanFooter(mActivity));
        springView.setType(SpringView.Type.FOLLOW);

        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {   // 下拉刷新
                 //showToast("下拉刷新");
                Toast.makeText(getActivity(),"下拉刷新",Toast.LENGTH_SHORT).show();
                if (presenter!=null){
                    presenter.getHomeData();

                }
                // springView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {  // 加载更多
                showToast("加载更多");
                //presenter.getShopList(getShopCategory(), getOrderBy(), false);
            }
        });
    }

    @Override
    public void initListener() {

    }



    @Override
    public void initData() {
        presenter = new HomeFragment1Presenter(this);
    }

    @Override
    public void onClick(View v, int id) {

    }
}

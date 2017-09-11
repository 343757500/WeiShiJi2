package com.micro.weishiji.takeout.ui.fragment;

import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.micro.weishiji.common.base.Const;
import com.micro.weishiji.common.base.Global;
import com.micro.weishiji.takeout.model.IHttpService;
import com.micro.weishiji.takeout.model.bean.Home;
import com.micro.weishiji.takeout.model.bean.OrderBy;
import com.micro.weishiji.takeout.model.bean.local.ShopCategory;
import com.micro.weishiji.takeout.persenter.HomeFragment1Presenter;
import com.micro.weishiji.takeout.ui.adapter.HomeAdapter;
import com.micro.weishiji.takeout.ui.adapter.OrderByAdapter;
import com.micro.weishiji.takeout.ui.adapter.ShopCategoryAdapter;
import com.micro.weishiji.takeout.ui.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/8/24.
 */

public class MainFragment1 extends BaseFragment {

    private RecyclerView recyclerView;
    //private HomeAdapter homeAdapter;
    private HomeAdapter homeAdapter;
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
    private OrderByAdapter mOrderByAdapter;
    private ShopCategoryAdapter mParentCategoryAdapter;


    /** 当前选中的商家类别 */
    private ShopCategory.CategoryListBean mSelectedCategory;
    private OrderBy.OrderByListBean mSelectedOrderBy;

    @Inject
    HomeFragment1Presenter presenter;

    public HomeFragment1Presenter getPresenter() {
        return presenter;
    }

    public List getListData() {
        return listData;
    }


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


        initRecyclerView();
        initSpringView();
    }

    private void initRecyclerView() {
        recyclerView = findView(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        homeAdapter = new HomeAdapter(mActivity, null);
        recyclerView.setAdapter(homeAdapter);
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

    /** RecyclerView显示的数据集合 */
    private List listData = new ArrayList();


    @Override
    public void initData() {
        presenter = new HomeFragment1Presenter(this);

        presenter.getHomeData();
        presenter.getShopCategoryData();
        presenter.getOrderByData();
    }

    @Override
    public void onHttpSuccess(int reqType, Message msg) {
        super.onHttpSuccess(reqType, msg);

        if (reqType== IHttpService.TYPE_HOME){
            Home home=(Home) msg.obj;
            // 显示首页数据
            listData = new ArrayList();
            listData.add(home);


            // homeAdapter.setDatas(listData);

            // 加载商家列表数据
            presenter.getShopList(getShopCategory(), getOrderBy(), true);

            return;
        }



        if (reqType == IHttpService.TYPE_SHOP_CATEGORY) {
            // 所有的商家父类别
            ArrayList<ShopCategory.CategoryListBean> parentCategory =
                    (ArrayList<ShopCategory.CategoryListBean>) msg.obj;
            // 显示父类别
            mParentCategoryAdapter.setDatas(parentCategory);
            return;
        }


        if (reqType == IHttpService.TYPE_ORDER_BY) {
            OrderBy bean = (OrderBy) msg.obj;
            mOrderByAdapter.setDatas(bean.getOrderByList());
            return;
        }



       if (reqType==IHttpService.TYPE_SHOP_LIST){
            ArrayList pageDatas = (ArrayList) msg.obj;
            // 隐藏springView的头部和尾部
            springView.onFinishFreshAndLoad();

            if (msg.what == Const.TYPE_REFRESH) {   // 下拉刷新
                ArrayList newDatas = new ArrayList();
                //  列表头部数据
                newDatas.add(listData.get(0));
                // 第一页数据和广告
                newDatas.addAll(pageDatas);

                listData = newDatas;
            } else { // 加载更多
                listData.addAll(pageDatas);
            }
            // 刷新列表显示
            homeAdapter.setDatas(listData);

            // 刷新商家购物车商品数量
            ((MainActivity) mActivity).updateShopGoodsCount();
            return;
        }
    }

    private int getShopCategory() {
        // 0: 表示获取所有的商家
        return (mSelectedCategory == null) ? 0 : mSelectedCategory.getId();
    }

    private int getOrderBy() {
        return (mSelectedOrderBy == null) ? 0 : mSelectedOrderBy.getTag();
    }

    @Override
    public void onClick(View v, int id) {

    }


    public HomeAdapter getHomeAdapter() {
        return homeAdapter;
    }

}

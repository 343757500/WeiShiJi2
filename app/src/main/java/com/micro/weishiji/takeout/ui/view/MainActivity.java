package com.micro.weishiji.takeout.ui.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.micro.weishiji.R;
import com.micro.weishiji.common.base.BaseActivity;
import com.micro.weishiji.common.base.Global;
import com.micro.weishiji.common.ui.GradientTab;
import com.micro.weishiji.takeout.ui.adapter.MyFragmentAdapter;
import com.micro.weishiji.takeout.ui.fragment.MainFragment1;
import com.micro.weishiji.takeout.ui.fragment.MainFragment2;
import com.micro.weishiji.takeout.ui.fragment.oneFragment;
import com.micro.weishiji.takeout.ui.fragment.thirhFragment;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private LinearLayout llTabLayout;
    private ViewPager viewPager;

    private String[] titles = new String[] {
            "首页", "吃啥", "订单", "我的"
    };

    private int[] icons = new int[] {
            R.drawable.icon_tab_01,
            R.drawable.icon_tab_02,
            R.drawable.icon_tab_03,
            R.drawable.icon_tab_04,
    };

    private int[] iconsSelected = new int[] {
            R.drawable.icon_tab_01_selected,
            R.drawable.icon_tab_02_selected,
            R.drawable.icon_tab_03_selected,
            R.drawable.icon_tab_04_selected,
    };

    /** 选项卡控件 */
    private GradientTab[] mTabs = new GradientTab[4];
    /** 当前选中的选项卡 */
    private GradientTab mCurrentTab;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        llTabLayout = findView(R.id.ll_tab_layout);
        viewPager = findView(R.id.view_pager);

        initTab();

        initViewPager();

        // 状态栏透明
        //Global.setNoStatusBarFullMode(this);
    }

    private void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MainFragment1());
        fragments.add(new MainFragment2());
        fragments.add(new MainFragment2());
        fragments.add(new oneFragment());

        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),fragments));

    }

    private void initTab() {
        int padding = Global.dp2px(5); // 5dp
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.MATCH_PARENT);
        param.weight = 1;   // 宽度平分
        for (int i = 0; i < titles.length; i++) {
            GradientTab tab = new GradientTab(this);
            mTabs[i] = tab;
            tab.setTag(i);  // 设置标识
            // 设置选项卡点击事件
            tab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    // 选项卡切换了
                    // onTabSelected(position);
                    // false： 禁用切换的动画
                    viewPager.setCurrentItem(position, false);
                }
            });

            // 设置标题和图标
            tab.setTextAndIcon(titles[i], icons[i], iconsSelected[i]);
            // 指定高亮显示的颜色
            tab.setHighlightColor(getResources().getColor(R.color.tab_text_pressed));
            tab.setPadding(0, padding, 0, padding);

            // 设置未读条数
            // tab.setUnreadCount(3);
            // 有新消息: 显示红点
            // tab.setRedDotVisible(true);
            llTabLayout.addView(tab, param);
        }
        mCurrentTab = mTabs[0];  // 默认选中第一个
        mCurrentTab.setTabSelected(true);   // 选中，会高亮
    }

    @Override
    public void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                onTabSelected(position);
            }



            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void onTabSelected(int position) {
        mCurrentTab.setTabSelected(false);  // 取消高亮

        mCurrentTab = mTabs[position];

        mCurrentTab.setTabSelected(true);   // 设置为高亮
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {

    }

}
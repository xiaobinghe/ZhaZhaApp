package com.locensate.letnetwork.main.ui.home;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.main.ui.fragments.machine.MachineFragment;
import com.locensate.letnetwork.main.ui.fragments.mine.MineFragment;
import com.locensate.letnetwork.main.ui.fragments.overview.OverviewFragment;
import com.locensate.letnetwork.main.ui.fragments.tools.ToolsFragment;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;
import com.locensate.letnetwork.view.NoScrollViewPager;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;


/**
 * @author xiaobinghe
 */

public class HomeActivity extends BaseActivity<HomePresenter, HomeModel> implements HomeContract.View {
    @BindView(R.id.fl_home_contain)
    FrameLayout flHomeContain;
    @BindView(R.id.bb_home_bottom)
    BottomBar bbHomeBottom;
    @BindView(R.id.vp_home)
    NoScrollViewPager mVpHome;
    private Fragment[] fragments;
    private int currentIndex = 0;
    private long time = 0;
    private HomePagerAdapter mAdapter;

    @Override
    public int getLayoutId() {
        // TODO: 2016/12/22 判断显示bottom的样式，false代表判断依据
        LogUtil.e("HomeActivity", String.valueOf(this.getTaskId()));
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        getFragments();
        mVpHome.setOffscreenPageLimit(4);
        mAdapter = new HomePagerAdapter(getSupportFragmentManager(), fragments);
        mVpHome.setAdapter(mAdapter);

        bbHomeBottom.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_message:
                        mVpHome.setCurrentItem(0, false);
                        break;
                    case R.id.tab_machine:
                        mVpHome.setCurrentItem(1, false);

                        break;
                    case R.id.tab_order:
                        mVpHome.setCurrentItem(2, false);

                        break;
                    case R.id.tab_mine:
                        mVpHome.setCurrentItem(3, false);

                        break;
                    default:
                        mVpHome.setCurrentItem(0, false);
                        break;
                }
            }
        });
      /*  bbHomeBottom.setOnTabSelectListener(new OnTabSelectListener() {
            private int index;

            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_message:
                        index = 0;
                        break;
                    case R.id.tab_machine:
                        index = 1;
                        break;
                    case R.id.tab_order:
                        index = 2;
                        break;
                    case R.id.tab_mine:
                        index = 3;
                        break;
                    default:
                        index = 0;
                        break;
                }
                if (currentIndex != index) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.hide(fragments[currentIndex]);
                    if (!fragments[index].isAdded()) {
                        ft.add(R.id.fl_home_contain, fragments[index]);
                    }
                    ft.show(fragments[index]).commit();
                    currentIndex = index;
                }
            }
        });*/
    }

    @Override
    public void getFragments() {
        fragments = new Fragment[]{new OverviewFragment(), new MachineFragment(), new ToolsFragment(), new MineFragment()};
//        getSupportFragmentManager().beginTransaction().add(R.id.fl_home_contain, fragments[0]).add(R.id.fl_home_contain, fragments[1]).hide(fragments[1]).show(fragments[0]).commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - time > 2000)) {
                ToastUtil.show("再按一次返回桌面");
                time = System.currentTimeMillis();
            } else {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}

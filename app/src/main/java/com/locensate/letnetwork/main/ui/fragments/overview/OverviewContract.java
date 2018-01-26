package com.locensate.letnetwork.main.ui.fragments.overview;

import android.support.v4.app.Fragment;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.bean.OverviewMotor;
import com.locensate.letnetwork.entity.MsgEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;


/**
 * @author xiaobinghe
 */


public interface OverviewContract {
    interface Model extends BaseModel {

        List<MsgEntity> getItemRealEntity();


        /**
         * 获取组织结构
         *
         * @return
         */
        Observable<Organizations> getOrganizations();

        ArrayList<String> getRange();

        /**
         * 获取子集Fragments
         *
         * @param rangeItem
         * @return
         */
        Fragment[] getContainFragment(String rangeItem);

        ArrayList<MultiItemEntity> getGroupTree();

        /**
         * 获取电机概览数据
         *
         * @return
         */
        Observable<OverviewMotor> getBaseDate();
    }

    interface View extends BaseView {
        /**
         * 初始化数据
         * @param overviewMotor
         */
        void initData(OverviewMotor overviewMotor);

        /**
         * 添加子集Fragment
         *
         * @param containFragment
         */
        void fillContain(Fragment[] containFragment);

        /**
         * 获取组织范围（titleText）
         *
         * @return
         */
        String getRangeItem();


        /**
         * 展示组织结构的pop
         *
         * @param groupTree
         */
        void showPop(List<MultiItemEntity> groupTree);


    }

    abstract class Presenter extends BasePresenter<Model, View> {

        /**
         * 弹出组织结构pop
         */
        public abstract void showPop();
    }
}

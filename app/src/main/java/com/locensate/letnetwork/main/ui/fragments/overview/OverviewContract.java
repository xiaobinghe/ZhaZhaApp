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
import java.util.Date;
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
         * @param organizationId
         * @return
         */
        Observable<OverviewMotor> getBaseDate(int organizationId);
    }

    interface View extends BaseView {
        /**
         * 初始化数据
         *
         * @param overviewMotor
         */
        void initData(OverviewMotor overviewMotor);

        /**
         * 添加子集Fragment
         */
        void fillContain();

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


        /**
         * 初始化时间类型和范围值
         *
         * @param type
         * @param initTimeValue
         */
        void initTimeTypeAndValue(String type, Date[] initTimeValue);

        /**
         * 获取fragment的子fragment
         *
         * @return
         */
        Fragment[] getChildFragments();

        /**
         * 设置全局分析数据
         *
         * @param powerConsumptionTotal
         * @param averageEfficiency
         * @param averageLoadRate
         * @param noLoadConsumption
         */
        void fillAllAnalysisData(String powerConsumptionTotal, String averageEfficiency, String averageLoadRate, String noLoadConsumption);

        void setTitleText(String organizationName);
    }

    abstract class Presenter extends BasePresenter<Model, View> {

        /**
         * 弹出组织结构pop
         */
        public abstract void showPop();

        /**
         * 通知子fragment刷新数据
         *
         * @param organizationId
         * @param startMills
         * @param endMills
         */
        public abstract void notifyChildFragments(int organizationId, long startMills, long endMills);

        public abstract void setTimeRange(long startMills, long endMills);

        public abstract void setOrganizationId(int organizationId);
    }
}

package com.locensate.letnetwork.main.ui.fragments.machine;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.bean.MachineDataBean;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.bean.Organizations;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author xiaobinghe
 */

public interface MachineContract {


    interface Model extends BaseModel {

        List<String> getMachines();

        List<MachineDataBean> getMachineList();


        MachineFilterTag getFilterDefault();

        /**
         * 获取组织结构
         *
         * @return
         */
        Observable<Organizations> getOrganizations();

        /**
         * 提交重点设备
         *
         * @param item
         * @return
         */
        Observable postImpotantMachine(MachineDataBean item);

        /**
         * 获取筛选标签
         *
         * @return
         */
        Observable<MachineFilterTag> getFilterTags();
    }

    interface View extends BaseView {
        /**
         * 初始填充数据
         *
         * @param machineList
         */
        void fillData(List<MachineDataBean> machineList);

        /**
         * 填充筛选标签数据
         *
         * @param machineFilterTag
         */
        void fillFilter(MachineFilterTag machineFilterTag);

        /**
         * 弹出组织结构
         *
         * @param groupTree
         */
        void showPop(List<MultiItemEntity> groupTree);


        /**
         * 排序完成
         * @param machineList
         */
        void sortComplete(List<MachineDataBean> machineList);
    }

    abstract class Presenter extends BasePresenter<Model, View> {

        /**
         * 展示组织结构
         */
        public abstract void showPop();

        /**
         * mark important machine
         *
         * @param item
         */
        public abstract void markImportant(MachineDataBean item);

        /**
         * 初始化数据
         */
        public abstract void initData();

        /**
         * 筛选列表数据刷新
         */
        public abstract void refreshFilter();

        /**
         * 标记重点设备
         *
         * @param id
         * @param importantMachine
         * @param important
         */
        public abstract void setImportantMachine(String id, String importantMachine, boolean important);

        public abstract void sort();
    }
}

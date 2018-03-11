package com.locensate.letnetwork.utils;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.view.expandableview.Level0Item;
import com.locensate.letnetwork.view.expandableview.Level1Item;
import com.locensate.letnetwork.view.expandableview.Level2Item;

import java.util.ArrayList;
import java.util.List;


/**
 * @author xiaobinghe
 */


public class OrganizationsOption {


    public static List<MultiItemEntity> handleOrganizations(Organizations data) {
        if (data == null) {
            return new ArrayList<MultiItemEntity>();
        }
        List<Organizations.DataBean> beanList = data.getData();
        ArrayList<MultiItemEntity> entities = new ArrayList<>();

        if (null != beanList && beanList.size() != 0) {
            for (int i = 0; i < beanList.size(); i++) {
                Organizations.DataBean dataBean = beanList.get(i);
                int organizationId = dataBean.getOrganizationId();
                int organizationDepth = dataBean.getOrganizationDepth();
                String organizationName = dataBean.getOrganizationName();
                int organizationParentId = dataBean.getOrganizationParentId();
                String organizationDescription = dataBean.getOrganizationDescription();

                Level0Item level0Item = new Level0Item(organizationName, organizationDescription, organizationId);

                if (!dataBean.isLeaf()) {
                    List<Organizations.DataBean.SubOrganizationBeanX> subOrganization = dataBean.getSubOrganization();

                    if (null != subOrganization && subOrganization.size() != 0) {
                        for (int j = 0; j < subOrganization.size(); j++) {
                            Organizations.DataBean.SubOrganizationBeanX subOrganizationBeanX = subOrganization.get(j);
                            int organizationDepth1 = subOrganizationBeanX.getOrganizationDepth();
                            String organizationDescription1 = subOrganizationBeanX.getOrganizationDescription();
                            int organizationId1 = subOrganizationBeanX.getOrganizationId();
                            String organizationName1 = subOrganizationBeanX.getOrganizationName();
                            int organizationParentId1 = subOrganizationBeanX.getOrganizationParentId();

                            Level1Item subItem = new Level1Item(organizationName1, organizationName1, organizationId1);

                            if (!subOrganizationBeanX.isLeaf()) {
                                List<Organizations.DataBean.SubOrganizationBeanX.SubOrganizationBean> subOrganization1 = subOrganizationBeanX.getSubOrganization();
                                if (null != subOrganization1 && subOrganization1.size() != 0) {
                                    for (int k = 0; k < subOrganization1.size(); k++) {
                                        Organizations.DataBean.SubOrganizationBeanX.SubOrganizationBean subOrganizationBean = subOrganization1.get(k);
                                        subItem.addSubItem(new Level2Item(subOrganizationBean.getOrganizationName(), subOrganizationBean.getOrganizationName(), false, subOrganizationBean.getOrganizationId()));
                                    }
                                }
                            }
                            level0Item.addSubItem(subItem);
                        }
                    }
                }

                entities.add(level0Item);
            }
        }
        return entities;
    }
}

package com.locensate.letnetwork.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * -------------------------------------
 * <p>
 * 项目名称： MotorTesting
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：
 * <p>
 * 作者： xiaobinghe
 * <p>
 * 时间： 2016/12/29 12:25
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class MultiSection extends SectionEntity<String>{


    public MultiSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public MultiSection(String s) {
        super(s);
    }
}

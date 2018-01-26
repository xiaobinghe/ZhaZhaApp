package com.locensate.letnetwork.utils;

import com.locensate.letnetwork.base.InstanceFactories;

/**
 *  
 * @author xiaobinghe
 */

public class InstanceUtil {

    /**
     * 通过实例工厂去实例化相应类
     *
     * @param <T> 返回实例的泛型类型
     * @return
     */
    public static <T> T getInstance(Class clazz) {
        try {
            return (T) InstanceFactories.create(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

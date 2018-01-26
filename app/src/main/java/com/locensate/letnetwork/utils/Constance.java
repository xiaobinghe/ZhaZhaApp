package com.locensate.letnetwork.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class Constance {


    public static String[] timeType = {"小时", "天", "周", "月"};


    public static List<String> array2List(String[] objects) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < objects.length; i++) {
            boolean add = list.add(objects[i]);
        }
        return list;
    }

}

package com.locensate.letnetwork.utils;

import java.lang.reflect.ParameterizedType;

/**
 *
 * @author xiaobinghe
 */

public class TUtil {
    public static <T> T getT(Object o, int i) {

        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Class getClass(Object o, int i) {

        if (o.getClass().getGenericSuperclass() instanceof ParameterizedType
                && ((ParameterizedType) (o.getClass().getGenericSuperclass())).getActualTypeArguments().length > i) {
            return (Class<T>) ((ParameterizedType) (o.getClass().getGenericSuperclass())).getActualTypeArguments()[i];
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

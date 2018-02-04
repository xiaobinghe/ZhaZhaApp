package com.locensate.letnetwork.bean;

import java.io.Serializable;
import java.util.List;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class EquipmentsEntity implements Serializable {

    private List<BaseSubEquipment> data;

    public List<BaseSubEquipment> getData() {
        return data;
    }
}

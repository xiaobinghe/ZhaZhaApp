package com.locensate.letnetwork.entity;

import java.io.Serializable;
import java.util.List;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class FilterEntries implements Serializable {
    private List<FirstLevels> first;

    public class FirstLevels implements Serializable {
        private String key;
        private String value;
        private boolean isOpen;
        private List<SecondLevels> all;
        private List<SecondLevels> selected;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isOpen() {
            return isOpen;
        }

        public void setOpen(boolean open) {
            isOpen = open;
        }

        public List<SecondLevels> getAll() {
            return all;
        }

        public void setAll(List<SecondLevels> all) {
            this.all = all;
        }

        public List<SecondLevels> getSelected() {
            return selected;
        }

        public void setSelected(List<SecondLevels> selected) {
            this.selected = selected;
        }

        public class SecondLevels implements Serializable {
            private boolean isSelected;
            private String value;

            public boolean isSelected() {
                return isSelected;
            }

            public void setSelected(boolean selected) {
                isSelected = selected;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }

    public List<FirstLevels> getFirst() {
        return first;
    }

    public void setFirst(List<FirstLevels> first) {
        this.first = first;
    }
}

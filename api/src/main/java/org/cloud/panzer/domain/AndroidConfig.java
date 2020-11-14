package org.cloud.panzer.domain;

import java.util.List;

public class AndroidConfig {

    private List<Item> androidConfig;

    public AndroidConfig(List<Item> androidConfig) {
        this.androidConfig = androidConfig;
    }

    public List<Item> getAndroidConfig() {
        return androidConfig;
    }

    public void setAndroidConfig(List<Item> androidConfig) {
        this.androidConfig = androidConfig;
    }

    public static class Item {
        private String name;
        private String value;

        public Item(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

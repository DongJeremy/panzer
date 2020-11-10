package org.cloud.panzer.domain;

public class HomeBanner {
    private int id;
    private String image;
    private String type;
    private String data;

    public HomeBanner() {
    }

    public HomeBanner(int id, String image, String type, String data) {
        this.id = id;
        this.image = image;
        this.type = type;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

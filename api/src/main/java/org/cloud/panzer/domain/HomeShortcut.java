package org.cloud.panzer.domain;

public class HomeShortcut {
    private int id;
    private String image;
    private String type;
    private String data;
    private String name;
    private String color;

    public HomeShortcut() {
    }

    public HomeShortcut(int id, String image, String type, String data, String name, String color) {
        this.id = id;
        this.image = image;
        this.type = type;
        this.data = data;
        this.name = name;
        this.color = color;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

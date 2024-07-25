package com.geekofia.phonepolice.models;

public class CardItem {
    private String title;
    private int imageResId;
    private int bgResId;

    public CardItem(String title, int imageResId, int bgResId) {
        this.title = title;
        this.imageResId = imageResId;
        this.bgResId = bgResId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getBgResId() {
        return bgResId;
    }
}

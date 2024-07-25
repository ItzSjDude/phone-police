package com.geekofia.phonepolice.models;

public class SafetyFeatureCardItem {
    private final String title;
    private final int imageResId;
    private final Class<?> activityClass;

    public SafetyFeatureCardItem(String title, int imageResId, Class<?> activityClass) {
        this.title = title;
        this.imageResId = imageResId;
        this.activityClass = activityClass;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public Class<?> getActivityClass() {
        return activityClass;
    }
}

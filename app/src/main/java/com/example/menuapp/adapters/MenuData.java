package com.example.menuapp.adapters;

public class MenuData {
    private String textTitle;
    private String textDescription;
    private String textPrice;
    private Integer textImage;

    public MenuData(String textTitle, String textDescription, String textPrice, Integer textImage) {
        this.textTitle = textTitle;
        this.textDescription = textDescription;
        this.textPrice = textPrice;
        this.textImage = textImage;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getTextPrice() {
        return textPrice;
    }

    public void setTextPrice(String textPrice) {
        this.textPrice = textPrice;
    }

    public Integer getTextImage() {
        return textImage;
    }

    public void setTextImage(Integer textImage) {
        this.textImage = textImage;
    }
}


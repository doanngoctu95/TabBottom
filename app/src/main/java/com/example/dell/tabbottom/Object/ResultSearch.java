package com.example.dell.tabbottom.Object;

/**
 * Created by dell on 08/12/2016.
 */
public class ResultSearch {
    private String title;
    private String urlImg;
    private String description;

    public ResultSearch(String title, String description, String urlImg) {
        this.title = title;
        this.urlImg = urlImg;
        this.description = description;
    }

    public ResultSearch() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.woman.orcas.myapplication;

/**
 * Created by ORCAS_ISLAM on 1/24/2018.
 */

public class albumItem {

    private String image_id;
    private String image_title;
    private String Text;

    public albumItem() {
    }

    public albumItem(String image_id, String image_title, String text) {
        this.image_id = image_id;
        this.image_title = image_title;
        Text = text;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getImage_title() {
        return image_title;
    }

    public void setImage_title(String android_version_name) {
        this.image_title = android_version_name;
    }

    public String getImage_ID() {
        return image_id;
    }

    public void setImage_ID(String android_image_url) {
        this.image_id = android_image_url;
    }
}

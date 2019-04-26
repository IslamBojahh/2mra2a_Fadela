package com.woman.orcas.myapplication;

/**
 * Created by ORCAS_ISLAM on 1/21/2018.
 */

public class product_writtenThought {
    private String image_w;
    private String name_w;
    private String description_w;


    public  product_writtenThought(String image, String name, String description) {
        this.image_w = image;
        this.name_w = name;
        this.description_w = description;
    }

    public String getImage_w() {
        return image_w;
    }

    public void setImage_w(String image_w) {
        this.image_w = image_w;
    }

    public String getName_w() {
        return name_w;
    }

    public void setName_w(String name_w) {
        this.name_w = name_w;
    }

    public String getDescription_w() {
        return description_w;
    }

    public void setDescription_w(String description_w) {
        this.description_w = description_w;
    }
}

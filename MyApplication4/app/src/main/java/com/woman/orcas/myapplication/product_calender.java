package com.woman.orcas.myapplication;

import java.util.Date;

/**
 * Created by ORCAS_ISLAM on 1/22/2018.
 */

public class product_calender {

    private String name;
    private String date;

    public product_calender(String name, String date) {

        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

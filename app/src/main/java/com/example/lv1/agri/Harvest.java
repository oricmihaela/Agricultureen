package com.example.lv1.agri;

import java.util.Date;

public class Harvest {
    private String land;
    private String date;

    public Harvest(String date, String land) {
        this.date = date;
        this.land = land;
    }

    public void setLand(String land) {
        this.land = land;
    }
    public void setDate(String date) {
        this.date = date;
    }

    String getDate() {
        return date;
    }
    String getLand() {
        return land;
    }
}

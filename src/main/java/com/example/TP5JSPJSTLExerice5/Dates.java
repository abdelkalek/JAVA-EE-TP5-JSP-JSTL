package com.example.TP5JSPJSTLExerice5;

import java.util.Date;

public class Dates {
    private String date_seances ;
    private String id_cours ;

    public Dates(String date_seances, String id_cours) {
        this.date_seances = date_seances;
        this.id_cours = id_cours;
    }

    public String getDate_seances() {
        return date_seances;
    }

    public void setDate_seances(String date_seances) {
        this.date_seances = date_seances;
    }

    public String getId_cours() {
        return id_cours;
    }

    public void setId_cours(String id_cours) {
        this.id_cours = id_cours;
    }
}

package com.example.TP5JSPJSTLExerice5;

import java.sql.*;
import java.util.Date;
import java.util.List;


public class Cours {
    private Connection connection = null;
    ResultSet res = null;
    private ResultSet rs = null;
    private Statement st = null;
    String connectionURL = "jdbc:mysql://localhost:3306/bd_emploi";

    public Cours() {
        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver");
            // Get a Connection to the database
            connection = DriverManager.getConnection(connectionURL, "root", "");
        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }

    }

    private int id;
    private String intitule;
    private String intervenant;
    private String duree;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public Cours(int id ,String intitule, String intervenant, String duree) {
        this.id =id;
        this.intitule = intitule;
        this.intervenant = intervenant;
        this.duree = duree;

    }
    public Cours(String intitule, String intervenant, String duree, String date) {
        this.intitule = intitule;
        this.intervenant = intervenant;
        this.duree = duree;
        this.date = date;
    }


    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(String intervenant) {
        this.intervenant = intervenant;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }


    public void insert() {
        try {
            if (!intervenant.equals(null) && !date.equals(null)) {

                String requete = "SELECT * FROM cours where intervenant='" + intervenant + "' ";
                Statement stmt = connection.createStatement();
                res = stmt.executeQuery(requete);
                if (res.next()) {
                    String sql = "insert into dates( date_seances, id_cours) values('" + date + "','" + res.getInt("id")+ "')";
                    Statement s = connection.createStatement();
                    s.executeUpdate(sql);
                    s.close();
                } else {
                    String sql = "insert into cours(intitule,intervenant,duree) values('" + intitule + "','" + intervenant + "','" + duree + "')";
                    Statement s = connection.createStatement();
                    s.executeUpdate(sql);
                    s.close();
                    String sql1 = "insert into dates( date_seances, id_cours) values('" + date + "',(SELECT id FROM cours WHERE intervenant='"+intervenant+"'))";
                    Statement s1 = connection.createStatement();
                    s1.executeUpdate(sql1);
                    s1.close();
                }
            }

        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }
    }


}

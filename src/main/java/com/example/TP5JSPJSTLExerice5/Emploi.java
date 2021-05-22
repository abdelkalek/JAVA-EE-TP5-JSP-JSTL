package com.example.TP5JSPJSTLExerice5;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class Emploi {

    public  List<Cours> c = new ArrayList<Cours>();
    private List<Dates> dates = new ArrayList<Dates>(); ;

    public List<Dates> getDates() {
        return dates;
    }

    public void setDates(List<Dates> dates) {
        this.dates = dates;
    }

    private Connection connection=null;
    private ResultSet rs = null;
    private Statement st = null;
    String connectionURL = "jdbc:mysql://localhost:3306/bd_emploi";
    public Emploi()
    {

        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver");
            // Get a Connection to the database
            connection = DriverManager.getConnection(connectionURL, "root", "");
            this.getallCours();
        }catch(Exception e){
            System.out.println("Exception is ;"+e);
        }

    }
    public List<Cours> getC() {
        return c;
    }
    public void setC(List<Cours> c) {
        this.c = c;
    }
    public void putt(Cours c) {
        this.c.add(c);
    }
    public void puttdate(Dates d) {
        this.dates.add(d);
    }

    public void getallCours()
    {
        try {
            ResultSet res = null;
            String requete = "SELECT * FROM cours";
            Statement stmt = connection.createStatement();
            res = stmt.executeQuery(requete);
            while(res.next()) {
                int id = res.getInt("id");
                String intitule = res.getString("intitule");
                String intervenant = res.getString("intervenant");
                String duree = res.getString("duree");
                Cours c = new Cours(id, intitule,intervenant,duree);
                this.putt(c);
                //ArrayList<User> users
            }
            stmt.close();
        } catch (SQLException e) {
            //traitement de l'exception
            System.out.println("Exception is ;"+e);

        }


        /// get all date
        try {
            ResultSet res = null;
            String requete = "SELECT * FROM dates";
            Statement stmt = connection.createStatement();
            res = stmt.executeQuery(requete);
            while(res.next()) {
                String date_seances = res.getString("date_seances");
                String id_cours = res.getString("id_cours");



                Dates d = new Dates(date_seances , id_cours);
            this.puttdate(d);
                //ArrayList<User> users
            }
            stmt.close();
        } catch (SQLException  e) {
            //traitement de l'exception
            System.out.println("Exception is ;"+e);

        }

    }
}

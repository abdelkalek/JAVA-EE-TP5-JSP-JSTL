<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page language="Java" import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.example.TP5JSPJSTLExerice5.Cours" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.TP5JSPJSTLExerice5.Dates" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container container-fluid">
<div class="row mt-4">
<div class="col-md-4">
    <h1>Ajouter Un cour</h1>
    <form action="index.jsp" method="post">
        <div class="col-md-12">
            <label for="exampleInputEmail1" class="form-label">Intitule</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="intitule">
        </div>
        <div class="col-md-12">
            <label for="exampleInputintervenant1" class="form-label">Intervenant</label>
            <input type="text" class="form-control" id="exampleInputintervenant1" name="intervenant">
        </div>
        <div class="col-md-12">
            <label for="exampleInputDuree1" class="form-label">Duree</label>
            <input type="number" class="form-control" id="exampleInputDuree1" name="duree">
        </div>
        <div class="col-md-12">
            <label for="exampleInputDate1" class="form-label">Date</label>
            <input type="date" class="form-control" id="exampleInputDate1" name="date">
        </div>
        <div class="col-md-12 mt-3">
            <button type="submit" class="btn btn-primary">Enregister Cour</button>
        </div>

        <jsp:useBean id="cours" class="com.example.TP5JSPJSTLExerice5.Cours" scope="page">
            <jsp:setProperty name="cours" property="*"/>
        </jsp:useBean>
    </form>
    <%
        if (request.getMethod().equals("POST")) {
            PrintWriter ot = response.getWriter();
            cours.insert();
        }
    %></div>
<div class="col-md-8">
    <jsp:useBean id="emploi" class="com.example.TP5JSPJSTLExerice5.Emploi" scope="page">
        <jsp:setProperty name="emploi" property="*"/>
    </jsp:useBean>

    <h1>Liste des cours</h1>
    <table class="table ">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Intitulé</th>
            <th scope="col">Intervenant</th>
            <th scope="col">Durée</th>
            <th scope="col">Dates</th>
        </tr>
        </thead>
        <tbody>

        <%
            PrintWriter ot = response.getWriter();

            List<Cours> c = emploi.getC();
            for(Cours cour : c)
            {%>
        <tr>
            <th scope="row"><%= cour.getIntitule()%></th>
            <td><%= cour.getIntervenant()%></td>
            <td><%= cour.getDuree()%> h</td>
            <td><ul>
                <%
                    List<Dates> d = emploi.getDates();
                    for(Dates dates : d)
                    {
                        if (dates.getId_cours().equals(String.valueOf(cour.getId())))
                        {
                           
                %>
                <li><%= dates.getDate_seances().toString()%></li>
                <%
                        }
                    }
                %></ul></td>
        </tr>
        <%
            }%>

        </tbody>
    </table></div>
</div>
</body>
</html>
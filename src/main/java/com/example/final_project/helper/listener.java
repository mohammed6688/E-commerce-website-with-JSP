package com.example.final_project.helper;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            String DB_NAME = (String) sce.getServletContext().getAttribute("DB_NAME");
            String USER = (String) sce.getServletContext().getAttribute("USER_NAME");
            String PASS = (String) sce.getServletContext().getAttribute("USER_PASSWORD");

            Class.forName("org.postgresql.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + DB_NAME, USER, PASS);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            System.out.println("database connection error "+ e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

package com.example;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.DBConnection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class ServiceEntry extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{

        //take input from frontend

        String name = req.getParameter("customerName");
        String cloths = req.getParameter("cloths");
        String service = req.getParameter("service");
        String rate = req.getParameter("ratePerCloth");

        try{
        String sql="INSERT INTO laundry(customer,cloths,service,rate) VALUES(?,?,?,?)";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,name);
            ps.setString(2,cloths);
            ps.setString(3,service);
            ps.setString(4,rate);

            ps.executeUpdate();
        }
        //display to browser
       res.getWriter().println("Entry Saved Successfully");
       res.setStatus(200);

       }catch(SQLException e){
            e.printStackTrace();
            res.setStatus(500);
            res.getWriter().println("Could not saved entry (Internal server Error)");
       }
    }
}
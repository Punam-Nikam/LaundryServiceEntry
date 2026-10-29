package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/retrieve")
public class GetEntry extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{

    PrintWriter out=res.getWriter();

    res.setContentType("text/html; charset=UTF-8");
    String sql="SELECT * FROM laundry ORDER BY id ASC";

    try(Connection con=DBConnection.getConnection();
    PreparedStatement ps=con.prepareStatement(sql)) {
        ResultSet rs=ps.executeQuery();

        //display data on browser
        out.println("<html><body>");
        out.println("<table border='1px solid black' cellPadding='10'>");
        out.println("<h2>All Booked services </h2>");
        out.println("<tr><th>Id</th><th>Customer Name</th><th>Cloths</th><th>Service</th><th>Rate per Cloths</th></tr>");
        
        //fetch data from database
        while(rs.next()){
            out.println("<tr>");

            out.println("<td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("customer") + "</td>");
            out.println("<td>" + rs.getString("cloths") + "</td>");
            out.println("<td>" + rs.getString("service") + "</td>");
            out.println("<td>" + rs.getString("rate") + "</td>");

        }
        // out.println("<td>" + rs.getString("cloths * rate") +"</td>");
        out.println("</tr>");

            out.println("</table>");
            out.println("</body></html>");
            
        }catch(Exception e){
            e.printStackTrace();
            res.setStatus(500);
            out.println("Could not found dataa!");
        }
  }

    
}


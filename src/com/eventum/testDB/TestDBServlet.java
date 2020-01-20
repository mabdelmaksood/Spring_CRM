package com.eventum.testDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user= "springstudent";
		String PW= "springstudent";
		
		String JDBCURL="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver="com.mysql.cj.jdbc.Driver";
		try {
			PrintWriter out=response.getWriter();
			out.println("connecting to db: "+JDBCURL);
			Class.forName(driver);
			Connection myConn=DriverManager.getConnection(JDBCURL, user, PW);
			out.println("\n in connection ");
			
			
		} catch (Exception e) {
			System.out.println("in catch exception: \n"+e.getMessage());
		}
		finally{
			
		}
		
	}

}

package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.dao.DaoException;
import com.dao.TimeDao;
import com.dao.TimeDaoImpl;
import com.demo.*;
import com.model.Meta;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	   public void doGet(HttpServletRequest request,
               HttpServletResponse response)
               throws ServletException,IOException{
		   TimeDao dao = new TimeDaoImpl();
			System.out.println(dao);
			Meta meta = new Meta();
		     float time = Float.parseFloat(request.getParameter("time"));
		     int success;
			try {
				success = dao.deleteTime(time);
				if(success>0) {
			     response.sendRedirect("ShowServlet");
		     }
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		    

	}

}

package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import com.model.Meta;

@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TimeDao dao = new TimeDaoImpl();
		Meta meta = new Meta();
		float time = Float.parseFloat(request.getParameter("time"));
		   try {
				   meta = dao.findByTime(time);
				   System.out.println(meta);
				   if(meta==null) {
					   response.sendRedirect("helloweb/jsp/error2.jsp");
				   }else {
					   request.getSession().setAttribute("meta", meta);
			           response.sendRedirect("helloweb/jsp/display.jsp");
				   }
	        }catch (DaoException e) {
				e.printStackTrace();	
	      }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
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
import com.model.Page;


@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    TimeDao dao = new TimeDaoImpl();
		String pageNow = request.getParameter("pageNow");
		Page metaList = null;
		if (pageNow == null||pageNow.isEmpty()) {//如果当前页为空或者首次使用则pageNow=1
			try {
				metaList = dao.queryPage(5, 1);
				request.setAttribute("metaList", metaList);
	    	     request.getRequestDispatcher("helloweb/jsp/show.jsp").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else {
			try {
				metaList = dao.queryPage(5, Integer.parseInt(pageNow));
				request.setAttribute("metaList", metaList);
	    	     request.getRequestDispatcher("helloweb/jsp/show.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

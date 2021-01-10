package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.model.*;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	String message = null;
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");	
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if("admin".equals(username)&&"123456".equals(password)) {	
				request.getSession().setAttribute("username", username);
			    response.sendRedirect("ShowServlet");
			}
			else {
				request.setAttribute("errorInfo","用户名或者密码不正确");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/helloweb/jsp/login.jsp");
			    rd.forward(request, response);
			}
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request,response);
			
		}
	}



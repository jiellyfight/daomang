package com.demo;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TimeDao;
import com.dao.TimeDaoImpl;
import com.model.Meta;

/**
 * Servlet implementation class AddTimeServlet
 */
@WebServlet("/AddTimeServlet")
public class AddTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Date date = new Date();
	@SuppressWarnings("deprecation")
	int hours = date.getHours();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TimeDao dao = new TimeDaoImpl();
		System.out.println(dao);
		Meta meta = new Meta();
	     String message = "";
	     try{
	    	 System.out.println("hhhhhhh");
	    	 meta.setTime(hours);
//	         meta.setTime(Float.parseFloat(request.getParameter("time")));
	         // 将传递来的字符串重新使用utf-8编码，以免产生乱码
	         meta.setTem(Float.parseFloat(request.getParameter("tem")));
	         System.out.println("温度");
	         meta.setAirhum(Float.parseFloat(request.getParameter("airhum"))); 
	         meta.setSoilhum(Float.parseFloat(request.getParameter("soilhum"))); 
	         meta.setPh(Float.parseFloat(request.getParameter("ph"))); 
	         System.out.println("ph");
	         meta.setLux(Float.parseFloat(request.getParameter("lux"))); 
	         meta.setLtime(Float.parseFloat(request.getParameter("ltime"))); 
	         boolean success = dao.addTime(meta);
	         
	         if(success){
	              message = "<li>成功插入一条记录！</li>";
	         }else{ 
	              message = "<li>插入记录错误！</li>";
	          }
	       }catch(Exception e){
	           System.out.println(e);
	     	  message = "<li>出错！</li>" + e;
	       }
	       request.setAttribute("result", message);
	       RequestDispatcher rd = getServletContext().getRequestDispatcher("/helloweb/jsp/add.jsp");
	       rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

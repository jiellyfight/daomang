package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Meta;
import com.model.Page;


public class TimeDaoImpl implements TimeDao{

	//插入时间点
	   public boolean addTime(Meta meta) 
	              throws DaoException{  	  
	   	   String sql = "INSERT INTO meta VALUES(?,?,?,?,?,?,?)";
	   	   
	   	   try(
	   		 Connection conn = getConnection();
	   		 PreparedStatement pstmt = conn.prepareStatement(sql))
	   	   {   		 
	   	     pstmt.setFloat(1,meta.getTime());
	   	     pstmt.setFloat(2,meta.getTem());
	   	     pstmt.setFloat(3,meta.getAirhum());
	   	     pstmt.setFloat(4,meta.getSoilhum());
	   	     pstmt.setFloat(5,meta.getPh());
	       	 pstmt.setFloat(6,meta.getLux());
	   	     pstmt.setFloat(7,meta.getLtime());
	   	     pstmt.executeUpdate();
			conn.close();
	   	     return true;
	   	   }catch(SQLException se){
		   		System.out.println("sqlERRor");
	   		System.out.println(se);

	   		  return false;
	   	   }
	   }
	   //删除记录
	   public int deleteTime(float time) 
	              throws DaoException{
			 Connection conn = getConnection();
			 String sql="DELETE FROM meta WHERE time=?";
		   try{
				 PreparedStatement pstmt = conn.prepareStatement(sql);		   
				 pstmt.setFloat(1, time);
				 int n = pstmt.executeUpdate();
				 conn.close();
				return n;
				}catch(SQLException e){
				   e.printStackTrace();				
				   return 0;
		   }
	   }
	// 按time查询记录
	   public Meta findByTime(float time) throws DaoException{ 
		      String sql = "SELECT * FROM meta WHERE time =?";
		      
	      try(
	    	   Connection conn = getConnection();
	    	   PreparedStatement pstmt = conn.prepareStatement(sql)){ 
	   	   	   pstmt.setFloat(1,time);
	   	       try(ResultSet rst = pstmt.executeQuery()){
	   	     if(rst.next()){
	   	       Meta meta = new Meta();
	   	       meta.setTime(rst.getFloat("time"));
	   	       meta.setTem(rst.getFloat("tem"));
	   	       meta.setAirhum(rst.getFloat("airhum"));
			   meta.setSoilhum(rst.getFloat("soilhum"));
			   meta.setPh(rst.getFloat("ph"));
			   meta.setLux(rst.getFloat("lux"));
			   meta.setLtime(rst.getFloat("ltime"));
				conn.close();
			   return meta;
	   	     }
	   	    }
	      }catch(SQLException se){
	    	  System.out.println("SQLERROR");
	   	  	return null;
	   	  }
	   	  return null;
	   }
	   //分页查询
	   public Page queryPage(int pageSize, int pageNow) throws DaoException {
			Page page = new Page();
			page.setPageSize(pageSize);
			page.setPageNow(pageNow);
			String sql = "select count(*) from meta";
			try {
				 Connection conn = getConnection();
				 PreparedStatement pstmt = conn.prepareStatement(sql);
		  	     ResultSet rs = pstmt.executeQuery();
				rs.next();
				Integer rowCount = rs.getInt(1);
				page.setRowCount(rowCount);
				List<Meta> pageRow = new ArrayList<Meta>();
				String preparedSql = "select * from meta limit ?,?";
				PreparedStatement pt = conn.prepareStatement(preparedSql);
				pt.setInt(1,page.getPageSize() *( page.getPageNow() - 1));
				pt.setInt(2, page.getPageSize());
				ResultSet res = pt.executeQuery();
				while (res.next()) {
					Meta meta = new Meta(res.getFloat("time"), res.getFloat("tem"), res.getFloat("airhum"),
							res.getFloat("soilhum"), res.getFloat("ph"),res.getFloat("lux"),res.getFloat("ltime"));
					pageRow.add(meta);
				}
				page.setpageRow(pageRow);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return page;
		}



}

package com.dao;
import java.util.ArrayList;
import java.util.List;
import com.model.Meta;
import com.model.Page;

public interface TimeDao extends Dao{
	 //增加时间点
    public boolean addTime (Meta meta) throws DaoException;
    //删除某一个时间点
    public int deleteTime(float time) throws DaoException;
 	// 按time查询客户方法
	public Meta findByTime (float time) throws DaoException;
	//分页查询
    public Page queryPage(int pageSize, int pageNow) throws DaoException;
}

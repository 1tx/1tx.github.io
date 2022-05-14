package com.dao;


import com.entity.Outlets;

import java.util.List;

public interface OutletsDao {
	
	public void insertBean(Outlets bean);
	
	public void deleteBean(int id);
	
	public void updateBean(Outlets bean);

	//根据查询的sql查询数据
	public List<Outlets> queryData(String sql);
}

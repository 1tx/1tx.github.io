package com.dao;


import com.entity.Business;

import java.util.List;

public interface BusinessDao {
	
	public void insertBean(Business bean);
	
	public void deleteBean(int id);
	
	public void updateBean(Business bean);

	//根据查询的sql查询数据
	public List<Business> queryData(String sql);
}

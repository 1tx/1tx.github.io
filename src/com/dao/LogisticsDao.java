package com.dao;



import com.entity.Logistics;

import java.util.List;

public interface LogisticsDao {
	
	public void insertBean(Logistics bean);
	
	public void deleteBean(int id);
	
	public void updateBean(Logistics bean);

	//根据查询的sql查询数据
	public List<Logistics> queryData(String sql);
}

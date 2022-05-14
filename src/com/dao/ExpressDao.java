package com.dao;


import com.entity.Express;

import java.util.List;

public interface ExpressDao {
	
	public void insertBean(Express bean);
	
	public void deleteBean(int id);
	
	public void updateBean(Express bean);

	//根据查询的sql查询数据
	public List<Express> queryData(String sql);
}

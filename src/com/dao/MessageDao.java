package com.dao;


import com.entity.Message;

import java.util.List;

public interface MessageDao {
	
	public void insertBean(Message bean);
	
	public void deleteBean(int id);
	
	public void updateBean(Message bean);

	//根据查询的sql查询数据
	public List<Message> queryData(String sql);
}

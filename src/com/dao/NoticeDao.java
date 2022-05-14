package com.dao;


import com.entity.Notice;

import java.util.List;

public interface NoticeDao {
	
	public void insertBean(Notice bean);
	
	public void deleteBean(int id);
	
	public void updateBean(Notice bean);

	//根据查询的sql查询数据
	public List<Notice> queryData(String sql);
}

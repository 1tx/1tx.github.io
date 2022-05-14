package com.service;

import com.entity.Message;

import java.util.List;
import java.util.Map;

/**
 * 业务层接口 
 */
public interface MessageService {
	
	//添加
	void insertBean(Message bean);
	
	//删除
	public void deleteBean(int id);
	
	//更新
	public void updateBean(Message bean);

	
	//支持数据的分页查询，currentpage表示当前页，pagesize表示每页显示的条数，url表示点击上一页或者下一页跳转的地址
	//sql表示查询的sql语句
	public Map<String,List<Message>> selectBeanMap(int currentpage, int pagesize, String url, String sql);
	
	

	//根据定义的sql语句查询数据
	public List<Message> selectData(String sql);


	//根据定义的sql语句查询单个对象
	public Message selectBean(String sql);
}







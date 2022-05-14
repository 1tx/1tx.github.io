package com.service;

import com.entity.Express;

import java.util.List;
import java.util.Map;

/**
 * 业务层接口 
 */
public interface ExpressService {
	
	//添加
	void insertBean(Express bean);
	
	//删除
	public void deleteBean(int id);
	
	//更新
	public void updateBean(Express bean);

	
	//支持数据的分页查询，currentpage表示当前页，pagesize表示每页显示的条数，url表示点击上一页或者下一页跳转的地址
	//sql表示查询的sql语句
	public Map<String,List<Express>> selectBeanMap(int currentpage, int pagesize, String url, String sql);
	
	

	//根据定义的sql语句查询数据
	public List<Express> selectData(String sql);


	//根据定义的sql语句查询单个对象
	public Express selectBean(String sql);
}







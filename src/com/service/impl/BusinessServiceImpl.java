package com.service.impl;

import com.dao.BusinessDao;
import com.entity.Business;
import com.service.BusinessService;
import com.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
	
	@Resource
	private BusinessDao businessDao;
	
	public void insertBean(Business bean) {
		businessDao.insertBean(bean);
		
	}
	
	public void deleteBean(int id) {
		businessDao.deleteBean(id);
		
	}
	
	public void updateBean(Business bean){
		
		businessDao.updateBean(bean);
		
	}

	public List<Business> selectData(String sql){

		return businessDao.queryData(sql);
	}
	
	//支持数据的分页查询，currentpage表示当前页，pagesize表示每页显示的条数，url表示点击上一页或者下一页跳转的地址
	//sql表示查询的sql语句
	@SuppressWarnings("unchecked")
	public Map<String,List<Business>> selectBeanMap(int currentpage,int	pagesize,String url,String sql){
		
		
		List<Business> list = this.selectData(sql);
		
		Pager pager = new Pager(list, pagesize);
		
		List<Business> pagerlist = pager.getObjects(currentpage);

		int total = list.size();
		
		
		Map<String,List<Business>> map = new HashMap<String,List<Business>>();
		
		map.put(Pager.getPagerNormal(total, pagesize,currentpage, url, "共有" + total + "条记录"), pagerlist);
		String pagerinfo = map.keySet().iterator().next();
		List<Business> list2 = map.get(pagerinfo);
		if(list2==null){
			map.remove(pagerinfo);
			map.put(pagerinfo, list);
		}
		return map;
	}

	public Business selectBean(String sql){

		List<Business> list = this.selectData(sql);

		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}

	}

}












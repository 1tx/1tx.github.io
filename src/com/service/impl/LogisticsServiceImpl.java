package com.service.impl;

import com.dao.LogisticsDao;
import com.entity.Logistics;
import com.service.LogisticsService;
import com.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("logisticsService")
public class LogisticsServiceImpl implements LogisticsService {
	
	@Resource
	private LogisticsDao logisticsDao;
	
	public void insertBean(Logistics bean) {
		logisticsDao.insertBean(bean);
		
	}
	
	public void deleteBean(int id) {
		logisticsDao.deleteBean(id);
		
	}
	
	public void updateBean(Logistics bean){
		
		logisticsDao.updateBean(bean);
		
	}

	public List<Logistics> selectData(String sql){

		return logisticsDao.queryData(sql);
	}
	
	//支持数据的分页查询，currentpage表示当前页，pagesize表示每页显示的条数，url表示点击上一页或者下一页跳转的地址
	//sql表示查询的sql语句
	@SuppressWarnings("unchecked")
	public Map<String,List<Logistics>> selectBeanMap(int currentpage,int	pagesize,String url,String sql){
		
		
		List<Logistics> list = this.selectData(sql);
		
		Pager pager = new Pager(list, pagesize);
		
		List<Logistics> pagerlist = pager.getObjects(currentpage);

		int total = list.size();
		
		
		Map<String,List<Logistics>> map = new HashMap<String,List<Logistics>>();
		
		map.put(Pager.getPagerNormal(total, pagesize,currentpage, url, "共有" + total + "条记录"), pagerlist);
		String pagerinfo = map.keySet().iterator().next();
		List<Logistics> list2 = map.get(pagerinfo);
		if(list2==null){
			map.remove(pagerinfo);
			map.put(pagerinfo, list);
		}
		return map;
	}

	public Logistics selectBean(String sql){

		List<Logistics> list = this.selectData(sql);

		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}

	}

}












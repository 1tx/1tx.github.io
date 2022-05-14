package com.service.impl;

import com.dao.OutletsDao;
import com.entity.Outlets;
import com.service.OutletsService;
import com.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("outletsService")
public class OutletsServiceImpl implements OutletsService {
	
	@Resource
	private OutletsDao outletsDao;
	
	public void insertBean(Outlets bean) {
		outletsDao.insertBean(bean);
		
	}
	
	public void deleteBean(int id) {
		outletsDao.deleteBean(id);
		
	}
	
	public void updateBean(Outlets bean){
		
		outletsDao.updateBean(bean);
		
	}

	public List<Outlets> selectData(String sql){

		return outletsDao.queryData(sql);
	}
	
	//支持数据的分页查询，currentpage表示当前页，pagesize表示每页显示的条数，url表示点击上一页或者下一页跳转的地址
	//sql表示查询的sql语句
	@SuppressWarnings("unchecked")
	public Map<String,List<Outlets>> selectBeanMap(int currentpage,int	pagesize,String url,String sql){
		
		
		List<Outlets> list = this.selectData(sql);
		
		Pager pager = new Pager(list, pagesize);
		
		List<Outlets> pagerlist = pager.getObjects(currentpage);

		int total = list.size();
		
		
		Map<String,List<Outlets>> map = new HashMap<String,List<Outlets>>();
		
		map.put(Pager.getPagerNormal(total, pagesize,currentpage, url, "共有" + total + "条记录"), pagerlist);
		String pagerinfo = map.keySet().iterator().next();
		List<Outlets> list2 = map.get(pagerinfo);
		if(list2==null){
			map.remove(pagerinfo);
			map.put(pagerinfo, list);
		}
		return map;
	}

	public Outlets selectBean(String sql){

		List<Outlets> list = this.selectData(sql);

		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}

	}

}












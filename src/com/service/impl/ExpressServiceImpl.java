package com.service.impl;

import com.dao.ExpressDao;
import com.entity.Express;
import com.service.ExpressService;
import com.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("expressService")
public class ExpressServiceImpl implements ExpressService {
	
	@Resource
	private ExpressDao expressDao;
	
	public void insertBean(Express bean) {
		expressDao.insertBean(bean);
		
	}
	
	public void deleteBean(int id) {
		expressDao.deleteBean(id);
		
	}
	
	public void updateBean(Express bean){
		
		expressDao.updateBean(bean);
		
	}

	public List<Express> selectData(String sql){

		return expressDao.queryData(sql);
	}
	
	//支持数据的分页查询，currentpage表示当前页，pagesize表示每页显示的条数，url表示点击上一页或者下一页跳转的地址
	//sql表示查询的sql语句
	@SuppressWarnings("unchecked")
	public Map<String,List<Express>> selectBeanMap(int currentpage,int	pagesize,String url,String sql){
		
		
		List<Express> list = this.selectData(sql);
		
		Pager pager = new Pager(list, pagesize);
		
		List<Express> pagerlist = pager.getObjects(currentpage);

		int total = list.size();
		
		
		Map<String,List<Express>> map = new HashMap<String,List<Express>>();
		
		map.put(Pager.getPagerNormal(total, pagesize,currentpage, url, "共有" + total + "条记录"), pagerlist);
		String pagerinfo = map.keySet().iterator().next();
		List<Express> list2 = map.get(pagerinfo);
		if(list2==null){
			map.remove(pagerinfo);
			map.put(pagerinfo, list);
		}
		return map;
	}

	public Express selectBean(String sql){

		List<Express> list = this.selectData(sql);

		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}

	}

}












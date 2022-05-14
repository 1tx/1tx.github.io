package com.service.impl;

import com.dao.NoticeDao;
import com.entity.Notice;
import com.service.NoticeService;
import com.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Resource
	private NoticeDao noticeDao;
	
	public void insertBean(Notice bean) {
		noticeDao.insertBean(bean);
		
	}
	
	public void deleteBean(int id) {
		noticeDao.deleteBean(id);
		
	}
	
	public void updateBean(Notice bean){
		
		noticeDao.updateBean(bean);
		
	}

	public List<Notice> selectData(String sql){

		return noticeDao.queryData(sql);
	}
	
	//支持数据的分页查询，currentpage表示当前页，pagesize表示每页显示的条数，url表示点击上一页或者下一页跳转的地址
	//sql表示查询的sql语句
	@SuppressWarnings("unchecked")
	public Map<String,List<Notice>> selectBeanMap(int currentpage,int	pagesize,String url,String sql){
		
		
		List<Notice> list = this.selectData(sql);
		
		Pager pager = new Pager(list, pagesize);
		
		List<Notice> pagerlist = pager.getObjects(currentpage);

		int total = list.size();
		
		
		Map<String,List<Notice>> map = new HashMap<String,List<Notice>>();
		
		map.put(Pager.getPagerNormal(total, pagesize,currentpage, url, "共有" + total + "条记录"), pagerlist);
		String pagerinfo = map.keySet().iterator().next();
		List<Notice> list2 = map.get(pagerinfo);
		if(list2==null){
			map.remove(pagerinfo);
			map.put(pagerinfo, list);
		}
		return map;
	}

	public Notice selectBean(String sql){

		List<Notice> list = this.selectData(sql);

		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}

	}

}












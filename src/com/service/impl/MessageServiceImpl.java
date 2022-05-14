package com.service.impl;

import com.dao.MessageDao;
import com.entity.Message;
import com.service.MessageService;
import com.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("messageService")
public class MessageServiceImpl implements MessageService {
	
	@Resource
	private MessageDao messageDao;
	
	public void insertBean(Message bean) {
		messageDao.insertBean(bean);
		
	}
	
	public void deleteBean(int id) {
		messageDao.deleteBean(id);
		
	}
	
	public void updateBean(Message bean){
		
		messageDao.updateBean(bean);
		
	}

	public List<Message> selectData(String sql){

		return messageDao.queryData(sql);
	}
	
	//支持数据的分页查询，currentpage表示当前页，pagesize表示每页显示的条数，url表示点击上一页或者下一页跳转的地址
	//sql表示查询的sql语句
	@SuppressWarnings("unchecked")
	public Map<String,List<Message>> selectBeanMap(int currentpage,int	pagesize,String url,String sql){
		
		
		List<Message> list = this.selectData(sql);
		
		Pager pager = new Pager(list, pagesize);
		
		List<Message> pagerlist = pager.getObjects(currentpage);

		int total = list.size();
		
		
		Map<String,List<Message>> map = new HashMap<String,List<Message>>();
		
		map.put(Pager.getPagerNormal(total, pagesize,currentpage, url, "共有" + total + "条记录"), pagerlist);
		String pagerinfo = map.keySet().iterator().next();
		List<Message> list2 = map.get(pagerinfo);
		if(list2==null){
			map.remove(pagerinfo);
			map.put(pagerinfo, list);
		}
		return map;
	}

	public Message selectBean(String sql){

		List<Message> list = this.selectData(sql);

		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}

	}

}












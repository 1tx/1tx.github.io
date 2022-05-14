package com.controller;


import com.entity.*;
import com.service.*;
import com.util.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/manage")
public class ManageController {

	@Resource
	private UserService userService;

	@Resource
	private NoticeService noticeService;

	@Resource
	private BusinessService businessService;

	@Resource
	private OutletsService outletsService;

	@Resource
	private ExpressService expressService;

	@Resource
	private LogisticsService logisticsService;

	@Resource
	private MessageService messageService;

	@Value("#{jdbc.pageSize}")
	private int pageSize;


	// 获取输出对象
	public PrintWriter getPrintWriter(HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return writer;
	}



	//管理员登录
	@RequestMapping("/login.do")
	public void login(HttpServletRequest request,HttpServletResponse response,String username,String password){

		PrintWriter writer = this.getPrintWriter(response);

		User user = userService.userlogin(username, password,1);

		if(user==null){

			writer.print("<script language=javascript>alert('用户名或者密码错误');window.location.href='login.jsp';</script>");

		}else{
			HttpSession session = request.getSession();
			session.setAttribute("manage", user);

			writer.print("<script language=javascript>alert('登录成功');window.location.href='index.jsp';</script>");

		}

	}


	//安全退出
	@RequestMapping("/loginout.do")
	public void loginout(HttpServletRequest request,HttpServletResponse response,String username,String password){

		
		PrintWriter writer = this.getPrintWriter(response);

		HttpSession session = request.getSession();
		session.removeAttribute("manage");
		writer.print("<script language=javascript>alert('退出成功');window.location.href='login.jsp';</script>");

	}


	//跳转到修改密码页面
	@RequestMapping("/password.do")
	public String password(HttpServletRequest request){

		request.setAttribute("url", "password2.do");

		request.setAttribute("title", "修改密码");

		return "password.jsp";

	}

	//修改密码操作
	@RequestMapping("/password2.do")
	public void password2(HttpServletRequest request,HttpServletResponse response,String password1,String password2){

		PrintWriter writer = this.getPrintWriter(response);

		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("manage");

		User bean = userService.userlogin(user.getUsername(), password1, user.getRole());

		if(bean!=null){
			bean.setPassword(password2);
			userService.updateBean(bean);

			writer.print("<script language=javascript>alert('修改成功');window.location.href='password.do';</script>");


		}else{

			writer.print("<script language=javascript>alert('用户名或者密码错误');window.location.href='password.do';</script>");

		}
	}

	//公告列表
	@RequestMapping("/noticelist.do")
	public String noticelist(HttpServletRequest request,String pagenum,String ntitle){

		String url = "noticelist.do";//当前访问的地址

		//默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//组装查询的sql语句
		StringBuffer sb = new StringBuffer();

		sb.append(" select * from t_notice where  ");

		//查询条件返回页面
		if (ntitle != null && !"".equals(ntitle)) {

			sb.append(" ntitle like '%"+ntitle+"%' ");
			sb.append(" and ");

			request.setAttribute("ntitle", ntitle);
		}


		sb.append(" 1=1 order by id desc ");

		String sql = sb.toString();


		//查询列表
		Map<String,List<Notice>> map = noticeService.selectBeanMap(currentpage,pageSize,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Notice> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);

		//添加，更新，删除等按钮
		request.setAttribute("url2", "notice");

		request.setAttribute("title", "公告管理");


		return "notice/noticelist.jsp";

	}


	//跳转到添加公告页面
	@RequestMapping("/noticeadd.do")
	public String noticeadd(HttpServletRequest request){

		request.setAttribute("url", "noticeadd2.do");

		request.setAttribute("title", "添加公告");


		return "notice/noticeadd.jsp";

	}


	//添加公告操作
	@RequestMapping("/noticeadd2.do")
	public void noticeadd2(HttpServletRequest request,HttpServletResponse response,com.entity.Notice bean){

		bean.setCtime(Util.getTime());
		noticeService.insertBean(bean);

		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='noticelist.do';</script>");
	}


	//跳转到修改公告页面
	@RequestMapping("/noticeupdate.do")
	public String noticeupdate(HttpServletRequest request,int id){

		Notice bean = noticeService.selectData(" select * from t_notice where id= "+id).get(0);

		request.setAttribute("bean", bean);

		request.setAttribute("url", "noticeupdate2.do?id="+id);

		request.setAttribute("title", "修改公告");

		return "notice/noticeupdate.jsp";

	}

	//修改公告操作
	@RequestMapping("/noticeupdate2.do")
	public void noticeupdate2(HttpServletRequest request,HttpServletResponse response,Notice bean){


		noticeService.updateBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='noticelist.do';</script>");
	}


	//删除操作
	@RequestMapping("/noticedelete.do")
	public void noticedelete(HttpServletResponse response,int id){

		noticeService.deleteBean(id);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='noticelist.do';</script>");
	}



	//跳转到查看详情页面
	@RequestMapping("/noticeshow.do")
	public String noticeshow(HttpServletRequest request,int id){

		Notice bean = noticeService.selectData(" select * from t_notice where id= "+id).get(0);

		request.setAttribute("bean", bean);

		request.setAttribute("title", "查看详情");

		return "notice/noticeshow.jsp";

	}


	//业务介绍列表
	@RequestMapping("/businesslist.do")
	public String businesslist(HttpServletRequest request,String pagenum,String bname){

		String url = "businesslist.do";//当前访问的地址

		//默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//组装查询的sql语句
		StringBuffer sb = new StringBuffer();

		sb.append(" select * from t_business where  ");

		//查询条件返回页面
		if (bname != null && !"".equals(bname)) {

			sb.append(" bname like '%"+bname+"%' ");
			sb.append(" and ");

			request.setAttribute("bname", bname);
		}


		sb.append(" 1=1 order by id desc ");

		String sql = sb.toString();


		//查询列表
		Map<String,List<Business>> map = businessService.selectBeanMap(currentpage,pageSize,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Business> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);

		//添加，更新，删除等按钮
		request.setAttribute("url2", "business");

		request.setAttribute("title", "业务介绍管理");


		return "business/businesslist.jsp";

	}


	//跳转到添加业务介绍页面
	@RequestMapping("/businessadd.do")
	public String businessadd(HttpServletRequest request){

		request.setAttribute("url", "businessadd2.do");

		request.setAttribute("title", "添加业务介绍");


		return "business/businessadd.jsp";

	}


	//添加业务介绍操作
	@RequestMapping("/businessadd2.do")
	public void businessadd2(HttpServletRequest request,HttpServletResponse response,com.entity.Business bean){

		bean.setCtime(Util.getTime());
		businessService.insertBean(bean);

		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='businesslist.do';</script>");
	}


	//跳转到修改业务介绍页面
	@RequestMapping("/businessupdate.do")
	public String businessupdate(HttpServletRequest request,int id){

		Business bean = businessService.selectData(" select * from t_business where id= "+id).get(0);

		request.setAttribute("bean", bean);

		request.setAttribute("url", "businessupdate2.do?id="+id);

		request.setAttribute("title", "修改业务介绍");

		return "business/businessupdate.jsp";

	}

	//修改业务介绍操作
	@RequestMapping("/businessupdate2.do")
	public void businessupdate2(HttpServletRequest request,HttpServletResponse response,Business bean){


		businessService.updateBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='businesslist.do';</script>");
	}


	//删除操作
	@RequestMapping("/businessdelete.do")
	public void businessdelete(HttpServletResponse response,int id){

		businessService.deleteBean(id);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='businesslist.do';</script>");
	}



	//跳转到查看详情页面
	@RequestMapping("/businessshow.do")
	public String businessshow(HttpServletRequest request,int id){

		Business bean = businessService.selectData(" select * from t_business where id= "+id).get(0);

		request.setAttribute("bean", bean);

		request.setAttribute("title", "查看详情");

		return "business/businessshow.jsp";

	}



	//物流网点列表
	@RequestMapping("/outletslist.do")
	public String outletslist(HttpServletRequest request,String pagenum,String oname,String province,String city){

		String url = "outletslist.do";//当前访问的地址

		//默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//组装查询的sql语句
		StringBuffer sb = new StringBuffer();

		sb.append(" select * from t_outlets where  ");

		//查询条件返回页面
		if (oname != null && !"".equals(oname)) {

			sb.append(" oname like '%"+oname+"%' ");
			sb.append(" and ");

			request.setAttribute("oname", oname);
		}
		if (province != null && !"".equals(province)) {

			sb.append(" province like '%"+province+"%' ");
			sb.append(" and ");

			request.setAttribute("province", province);
		}
		if (city != null && !"".equals(city)) {

			sb.append(" city like '%"+city+"%' ");
			sb.append(" and ");

			request.setAttribute("city", city);
		}


		sb.append(" 1=1 order by id desc ");

		String sql = sb.toString();


		//查询列表
		Map<String,List<Outlets>> map = outletsService.selectBeanMap(currentpage,pageSize,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Outlets> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);

		//添加，更新，删除等按钮
		request.setAttribute("url2", "outlets");

		request.setAttribute("title", "物流网点管理");


		return "outlets/outletslist.jsp";

	}


	//跳转到添加物流网点页面
	@RequestMapping("/outletsadd.do")
	public String outletsadd(HttpServletRequest request){

		request.setAttribute("url", "outletsadd2.do");

		request.setAttribute("title", "添加物流网点");


		return "outlets/outletsadd.jsp";

	}


	//添加物流网点操作
	@RequestMapping("/outletsadd2.do")
	public void outletsadd2(HttpServletRequest request,HttpServletResponse response,com.entity.Outlets bean){

		bean.setCtime(Util.getTime());
		outletsService.insertBean(bean);

		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='outletslist.do';</script>");
	}


	//跳转到修改物流网点页面
	@RequestMapping("/outletsupdate.do")
	public String outletsupdate(HttpServletRequest request,int id){

		Outlets bean = outletsService.selectData(" select * from t_outlets where id= "+id).get(0);

		request.setAttribute("bean", bean);

		request.setAttribute("url", "outletsupdate2.do?id="+id);

		request.setAttribute("title", "修改物流网点");

		return "outlets/outletsupdate.jsp";

	}

	//修改物流网点操作
	@RequestMapping("/outletsupdate2.do")
	public void outletsupdate2(HttpServletRequest request,HttpServletResponse response,Outlets bean){


		outletsService.updateBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='outletslist.do';</script>");
	}


	//删除操作
	@RequestMapping("/outletsdelete.do")
	public void outletsdelete(HttpServletResponse response,int id){

		outletsService.deleteBean(id);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='outletslist.do';</script>");
	}



	//跳转到查看详情页面
	@RequestMapping("/outletsshow.do")
	public String outletsshow(HttpServletRequest request,int id){

		Outlets bean = outletsService.selectData(" select * from t_outlets where id= "+id).get(0);

		request.setAttribute("bean", bean);

		request.setAttribute("title", "查看详情");

		return "outlets/outletsshow.jsp";

	}


	//待邮寄快递列表
	@RequestMapping("/expresslist.do")
	public String expresslist(HttpServletRequest request,String pagenum,String expressId,String fromAddress,String toAddress){

		String url = "expresslist.do";//当前访问的地址

		//默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//组装查询的sql语句
		StringBuffer sb = new StringBuffer();

		sb.append(" select * from t_express where  ");

		//查询条件返回页面
		if (expressId != null && !"".equals(expressId)) {

			sb.append(" expressId like '%"+expressId+"%' ");
			sb.append(" and ");

			request.setAttribute("expressId", expressId);
		}
		if (fromAddress != null && !"".equals(fromAddress)) {

			sb.append(" fromAddress like '%"+fromAddress+"%' ");
			sb.append(" and ");

			request.setAttribute("fromAddress", fromAddress);
		}
		if (toAddress != null && !"".equals(toAddress)) {

			sb.append(" toAddress like '%"+toAddress+"%' ");
			sb.append(" and ");

			request.setAttribute("toAddress", toAddress);
		}


		sb.append(" status='待邮寄' order by id desc ");

		String sql = sb.toString();


		//查询列表
		Map<String,List<Express>> map = expressService.selectBeanMap(currentpage,pageSize,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Express> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);

		//添加，更新，删除等按钮
		request.setAttribute("url2", "express");

		request.setAttribute("title", "待邮寄快递");


		return "express/expresslist.jsp";

	}


	//开始邮寄操作
	@RequestMapping("/expressupdate.do")
	public void expressupdate(int id,HttpServletResponse response){

		Express bean = expressService.selectData(" select * from t_express where id= "+id).get(0);

		bean.setStatus("邮寄中");

		expressService.updateBean(bean);

		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');" +
				"window.location.href='expresslist.do';</script>");


	}

	//完成邮寄操作
	@RequestMapping("/expressupdate2.do")
	public void expressupdate2(int id,HttpServletResponse response){

		Express bean = expressService.selectData(" select * from t_express where id= "+id).get(0);

		bean.setStatus("已完成");

		expressService.updateBean(bean);

		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');" +
				"window.location.href='expresslist2.do';</script>");


	}


	//跳转到查看详情页面
	@RequestMapping("/expressshow.do")
	public String expressshow(HttpServletRequest request,int id){

		Express bean = expressService.selectData(" select * from t_express where id= "+id).get(0);

		request.setAttribute("bean", bean);

		request.setAttribute("title", "查看详情");

		List<Logistics> llist = logisticsService.selectData(" select * from t_logistics where expressId= "+bean.getId());

		request.setAttribute("llist",llist);

		return "express/expressshow.jsp";

	}



	//待邮寄快递列表
	@RequestMapping("/expresslist2.do")
	public String expresslist2(HttpServletRequest request,String pagenum,String expressId,String fromAddress,String toAddress){

		String url = "expresslist2.do";//当前访问的地址

		//默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//组装查询的sql语句
		StringBuffer sb = new StringBuffer();

		sb.append(" select * from t_express where  ");

		//查询条件返回页面
		if (expressId != null && !"".equals(expressId)) {

			sb.append(" expressId like '%"+expressId+"%' ");
			sb.append(" and ");

			request.setAttribute("expressId", expressId);
		}
		if (fromAddress != null && !"".equals(fromAddress)) {

			sb.append(" fromAddress like '%"+fromAddress+"%' ");
			sb.append(" and ");

			request.setAttribute("fromAddress", fromAddress);
		}
		if (toAddress != null && !"".equals(toAddress)) {

			sb.append(" toAddress like '%"+toAddress+"%' ");
			sb.append(" and ");

			request.setAttribute("toAddress", toAddress);
		}


		sb.append(" status='邮寄中' order by id desc ");

		String sql = sb.toString();


		//查询列表
		Map<String,List<Express>> map = expressService.selectBeanMap(currentpage,pageSize,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Express> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);

		//添加，更新，删除等按钮
		request.setAttribute("url2", "express");

		request.setAttribute("title", "邮寄中快递");


		return "express/expresslist2.jsp";

	}



	//物流信息列表
	@RequestMapping("/logisticslist.do")
	public String logisticslist(HttpServletRequest request,String pagenum,Integer expressId){

		String url = "logisticslist.do";//当前访问的地址

		//默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//组装查询的sql语句
		StringBuffer sb = new StringBuffer();

		sb.append(" select * from t_logistics where  ");


		request.setAttribute("expressId",expressId);

		sb.append(" expressId="+expressId+" order by id desc ");

		String sql = sb.toString();


		//查询列表
		Map<String,List<Logistics>> map = logisticsService.selectBeanMap(currentpage,pageSize,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Logistics> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);

		//添加，更新，删除等按钮
		request.setAttribute("url2", "logistics");

		request.setAttribute("title", "物流信息管理");


		return "logistics/logisticslist.jsp";

	}


	//跳转到添加物流信息页面
	@RequestMapping("/logisticsadd.do")
	public String logisticsadd(HttpServletRequest request,Integer expressId){

		request.setAttribute("url", "logisticsadd2.do?expressId="+expressId);

		request.setAttribute("title", "添加物流信息");


		return "logistics/logisticsadd.jsp";

	}


	//添加物流信息操作
	@RequestMapping("/logisticsadd2.do")
	public void logisticsadd2(HttpServletRequest request,HttpServletResponse response,com.entity.Logistics bean){

		bean.setCtime(Util.getTime());
		logisticsService.insertBean(bean);

		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='logisticslist.do?expressId="+bean.getExpressId()+"';</script>");
	}





	//删除操作
	@RequestMapping("/logisticsdelete.do")
	public void logisticsdelete(HttpServletResponse response,int id){
		Logistics bean = logisticsService.selectData(" select * from t_logistics where id= "+id).get(0);

		logisticsService.deleteBean(id);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='logisticslist.do?expressId="+bean.getExpressId()+"';</script>");
	}


	//快递查询列表
	@RequestMapping("/expresslist3.do")
	public String expresslist3(HttpServletRequest request,String pagenum,String expressId,String fromAddress,String toAddress){

		String url = "expresslist3.do";//当前访问的地址

		//默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//组装查询的sql语句
		StringBuffer sb = new StringBuffer();

		sb.append(" select * from t_express where  ");

		//查询条件返回页面
		if (expressId != null && !"".equals(expressId)) {

			sb.append(" expressId like '%"+expressId+"%' ");
			sb.append(" and ");

			request.setAttribute("expressId", expressId);
		}
		if (fromAddress != null && !"".equals(fromAddress)) {

			sb.append(" fromAddress like '%"+fromAddress+"%' ");
			sb.append(" and ");

			request.setAttribute("fromAddress", fromAddress);
		}
		if (toAddress != null && !"".equals(toAddress)) {

			sb.append(" toAddress like '%"+toAddress+"%' ");
			sb.append(" and ");

			request.setAttribute("toAddress", toAddress);
		}


		sb.append(" 1=1 order by id desc ");

		String sql = sb.toString();


		//查询列表
		Map<String,List<Express>> map = expressService.selectBeanMap(currentpage,pageSize,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Express> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);

		//添加，更新，删除等按钮
		request.setAttribute("url2", "express");

		request.setAttribute("title", "快递查询");


		return "express/expresslist3.jsp";

	}



	//待回复留言列表
	@RequestMapping("/messagelist.do")
	public String messagelist(HttpServletRequest request,String pagenum,String mtitle){

		String url = "messagelist.do";//当前访问的地址

		//默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//组装查询的sql语句
		StringBuffer sb = new StringBuffer();

		sb.append(" select * from t_message where  ");

		//查询条件返回页面
		if (mtitle != null && !"".equals(mtitle)) {

			sb.append(" mtitle like '%"+mtitle+"%' ");
			sb.append(" and ");

			request.setAttribute("mtitle", mtitle);
		}


		sb.append(" status='待回复' order by id desc ");

		String sql = sb.toString();


		//查询列表
		Map<String,List<Message>> map = messageService.selectBeanMap(currentpage,pageSize,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Message> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);

		//添加，更新，删除等按钮
		request.setAttribute("url2", "message");

		request.setAttribute("title", "待回复留言");


		return "message/messagelist.jsp";

	}




	//跳转到回复留言页面
	@RequestMapping("/messageupdate.do")
	public String messageupdate(HttpServletRequest request,int id){

		Message bean = messageService.selectData(" select * from t_message where id= "+id).get(0);

		request.setAttribute("bean", bean);

		request.setAttribute("url", "messageupdate2.do?id="+id);

		request.setAttribute("title", "回复留言");

		return "message/messageupdate.jsp";

	}

	//回复留言操作
	@RequestMapping("/messageupdate2.do")
	public void messageupdate2(HttpServletRequest request,HttpServletResponse response,Message bean){


		bean.setStatus("已回复");
		bean.setRtime(Util.getTime());

		messageService.updateBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='messagelist.do';</script>");
	}



	//跳转到查看详情页面
	@RequestMapping("/messageshow.do")
	public String messageshow(HttpServletRequest request,int id){

		Message bean = messageService.selectData(" select * from t_message where id= "+id).get(0);

		request.setAttribute("bean", bean);

		request.setAttribute("title", "查看详情");

		return "message/messageshow.jsp";

	}



	//留言查询
	@RequestMapping("/messagelist2.do")
	public String messagelist2(HttpServletRequest request,String pagenum,String mtitle){

		String url = "messagelist2.do";//当前访问的地址

		//默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//组装查询的sql语句
		StringBuffer sb = new StringBuffer();

		sb.append(" select * from t_message where  ");

		//查询条件返回页面
		if (mtitle != null && !"".equals(mtitle)) {

			sb.append(" mtitle like '%"+mtitle+"%' ");
			sb.append(" and ");

			request.setAttribute("mtitle", mtitle);
		}


		sb.append(" 1=1 order by id desc ");

		String sql = sb.toString();


		//查询列表
		Map<String,List<Message>> map = messageService.selectBeanMap(currentpage,pageSize,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Message> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);

		//添加，更新，删除等按钮
		request.setAttribute("url2", "message");

		request.setAttribute("title", "留言查询");


		return "message/messagelist2.jsp";

	}

	//用户列表
	@RequestMapping("/userlist.do")
	public String userlist(HttpServletRequest request,String pagenum,String username){

		String url = "userlist.do";//当前访问的地址

		//默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//组装查询的sql语句
		StringBuffer sb = new StringBuffer();

		sb.append(" select * from t_user where  ");

		//查询条件返回页面
		if (username != null && !"".equals(username)) {

			sb.append(" username like '%"+username+"%' ");
			sb.append(" and ");

			request.setAttribute("username", username);
		}


		sb.append(" role=3 order by id desc ");

		String sql = sb.toString();


		//查询列表
		Map<String,List<User>> map = userService.selectBeanMap(currentpage,pageSize,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<User> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);

		//添加，更新，删除等按钮
		request.setAttribute("url2", "user");

		request.setAttribute("title", "用户管理");


		return "user/userlist.jsp";

	}



	//删除操作
	@RequestMapping("/userdelete.do")
	public void userdelete(HttpServletResponse response,int id){

		userService.deleteBean(id);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='userlist.do';</script>");
	}

}













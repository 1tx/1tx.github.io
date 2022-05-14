package com.controller;


import com.entity.*;
import com.service.*;
import com.util.Util;
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
@RequestMapping("/")
public class IndexController {

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


	//网站首页
	@RequestMapping("/index.do")
	public String index(HttpServletRequest request, HttpServletResponse response){


		Map<String, List<Notice>> noticemap = noticeService.selectBeanMap(1, 5, "index", " select * from t_notice order by id desc ");
		String pagerinfo = noticemap.keySet().iterator().next();
		List<Notice> noticelist = noticemap.get(pagerinfo);

		request.setAttribute("noticelist", noticelist);


		Map<String,List<Business>> businessmap = businessService.selectBeanMap(1, 5, "index", " select * from t_business order by id desc ");
		String pagerinfo2 = businessmap.keySet().iterator().next();
		List<Business> businesslist = businessmap.get(pagerinfo2);

		request.setAttribute("businesslist", businesslist);


		return "index.jsp";

	}

	//网站公告
	@RequestMapping("/noticelist.do")
	public String noticelist(HttpServletRequest request,HttpServletResponse response,String pagenum,String ntitle){


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
		Map<String,List<Notice>> map = noticeService.selectBeanMap(currentpage,10,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Notice> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);


		return "noticelist.jsp";

	}


	//网站公告详情页面
	@RequestMapping("/noticeshow.do")
	public String noticeshow(HttpServletRequest request,int id){

		Notice bean = noticeService.selectData(" select * from t_notice where id= "+id).get(0);

		request.setAttribute("bean", bean);

		return "noticeshow.jsp";

	}


	//业务介绍
	@RequestMapping("/businesslist.do")
	public String businesslist(HttpServletRequest request,HttpServletResponse response,String pagenum,String bname){


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
		Map<String,List<Business>> map = businessService.selectBeanMap(currentpage,10,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Business> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);


		return "businesslist.jsp";

	}


	//业务介绍详情页面
	@RequestMapping("/businessshow.do")
	public String businessshow(HttpServletRequest request,int id){

		Business bean = businessService.selectData(" select * from t_business where id= "+id).get(0);

		request.setAttribute("bean", bean);

		return "businessshow.jsp";

	}


	//物流网点
	@RequestMapping("/outletslist.do")
	public String outletslist(HttpServletRequest request,HttpServletResponse response,String pagenum,String oname,String province,String city){


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
		Map<String,List<Outlets>> map = outletsService.selectBeanMap(currentpage,10,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Outlets> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);


		return "outletslist.jsp";

	}


	//物流网点详情页面
	@RequestMapping("/outletsshow.do")
	public String outletsshow(HttpServletRequest request,int id){

		Outlets bean = outletsService.selectData(" select * from t_outlets where id= "+id).get(0);

		request.setAttribute("bean", bean);

		return "outletsshow.jsp";

	}

	//跳转到用户注册页面
	@RequestMapping("/register.do")
	public String register(HttpServletRequest request){

		return "register.jsp";

	}


	//用户注册操作
	@RequestMapping("/register2.do")
	public void register2(HttpServletRequest request,HttpServletResponse response,User user){

		PrintWriter writer = this.getPrintWriter(response);

		User bean = userService.useryz(user.getUsername());

		if(bean!=null){

			writer.print("<script language=javascript>alert('该用户名已经存在，注册失败！');window.location.href='register.do';</script>");

			return;
		}

		user.setCtime(Util.getTime());
		user.setRole(3);

		userService.insertBean(user);

		writer.print("<script language=javascript>alert('注册成功');window.location.href='login.do';</script>");


	}


	//跳转到用户登录页面
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request){

		return "login.jsp";

	}


	//用户登录操作
	@RequestMapping("/login2.do")
	public void login2(HttpServletRequest request,HttpServletResponse response,String username,String password){

		PrintWriter writer = this.getPrintWriter(response);


		User bean = userService.userlogin(username, password, 3);

		if(bean==null){
			bean = userService.userlogin(username, password, 2);
		}


		if(bean==null){

			writer.print("<script language=javascript>alert('用户名或者密码错误，登录失败！');window.location.href='login.do';</script>");


		}else{

			HttpSession session = request.getSession();
			session.setAttribute("qiantai", bean);

			writer.print("<script language=javascript>alert('登录成功');window.location.href='.';</script>");

		}

	}



	//安全退出操作
	@RequestMapping("/loginout.do")
	public void loginout(HttpServletRequest request,HttpServletResponse response){

		PrintWriter writer = this.getPrintWriter(response);

		HttpSession session = request.getSession();
		session.removeAttribute("qiantai");

		writer.print("<script language=javascript>alert('退出成功');window.location.href='login.do';</script>");


	}



	//跳转到修改密码页面
	@RequestMapping("/password.do")
	public String password(HttpServletRequest request){

		return "password.jsp";

	}


	//修改密码操作
	@RequestMapping("/password2.do")
	public void password2(HttpServletRequest request,HttpServletResponse response,String password1,String password2){

		PrintWriter writer = this.getPrintWriter(response);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("qiantai");


		User bean = userService.userlogin(user.getUsername(), password1, 2);

		if(bean==null){
			bean = userService.userlogin(user.getUsername(), password1, 3);
		}

		if(bean==null){

			writer.print("<script language=javascript>alert('原密码错误，修改失败！');window.location.href='password.do';</script>");


		}else{

			bean.setPassword(password2);

			userService.updateBean(bean);

			writer.print("<script language=javascript>alert('修改成功,请重新登录');window.location.href='loginout.do';</script>");

		}


	}


	//跳转到个人信息维护页面
	@RequestMapping("/userupdate.do")
	public String userupdate(HttpServletRequest request){

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("qiantai");


		User bean = userService.selectBeanById(user.getId());

		request.setAttribute("bean", bean);

		return "userupdate.jsp";

	}


	//个人信息维护操作
	@RequestMapping("/userupdate2.do")
	public void userupdate2(HttpServletRequest request,HttpServletResponse response,String name,String phone,String address){

		PrintWriter writer = this.getPrintWriter(response);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("qiantai");


		User bean = userService.selectBeanById(user.getId());


		bean.setPhone(phone);
		bean.setName(name);

		userService.updateBean(bean);

		writer.print("<script language=javascript>alert('修改成功');window.location.href='userupdate.do';</script>");


	}


	//跳转到寄快递页面
	@RequestMapping("/expressadd.do")
	public String expressadd(HttpServletRequest request,HttpServletResponse response) {

		PrintWriter writer = this.getPrintWriter(response);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("qiantai");

		if (user == null) {
			writer.print("<script  language='javascript'>alert('请先登录');window.location.href='login.do';</script>");
			return  null;
		}

		return "expressadd.jsp";

	}


	//寄快递操作
	@RequestMapping("/expressadd2.do")
	public void expressadd2(HttpServletRequest request, HttpServletResponse response,Express bean ) throws IOException{

		PrintWriter writer = this.getPrintWriter(response);

		String expressId = Util.getBianhao(expressService.selectData(" select * from t_express  ").size());


		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("qiantai");


		bean.setExpressId(expressId);
		bean.setStatus("待邮寄");
		bean.setCtime(Util.getTime());
		bean.setUserid(user.getId());

		expressService.insertBean(bean);

		writer.print("<script  language='javascript'>alert('操作成功');window.location.href='expresslist.do'; </script>");


	}



	//我的快递
	@RequestMapping("/expresslist.do")
	public String expresslist(HttpServletRequest request,HttpServletResponse response,String pagenum,String expressId,String fromAddress,String toAddress){


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

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("qiantai");

		sb.append(" userid="+user.getId()+" order by id desc ");

		String sql = sb.toString();


		//查询列表
		Map<String,List<Express>> map = expressService.selectBeanMap(currentpage,10,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Express> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);

		return "expresslist.jsp";

	}


	//取消邮寄操作
	@RequestMapping("/expressupdate.do")
	public void expressupdate(HttpServletResponse response,int id){

		Express bean = expressService.selectData(" select * from t_express where id= "+id).get(0);

		bean.setStatus("已取消");

		expressService.updateBean(bean);

		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');" +
				"window.location.href='expresslist.do';</script>");
	}


	//快递详情页面
	@RequestMapping("/expressshow.do")
	public String expressshow(HttpServletRequest request,int id){

		Express bean = expressService.selectData(" select * from t_express where id= "+id).get(0);

		request.setAttribute("bean", bean);

		List<Logistics> llist = logisticsService.selectData(" select * from t_logistics where expressId= "+bean.getId());

		request.setAttribute("llist",llist);

		return "expressshow.jsp";

	}

	//删除快递操作
	@RequestMapping("/expressdelete.do")
	public void expressdelete(HttpServletResponse response,int id){


		expressService.deleteBean(id);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');" +
				"window.location.href='expresslist.do';</script>");
	}



	//跳转到在线留言页面
	@RequestMapping("/messageadd.do")
	public String messageadd(HttpServletRequest request,HttpServletResponse response) {

		PrintWriter writer = this.getPrintWriter(response);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("qiantai");

		if (user == null) {
			writer.print("<script  language='javascript'>alert('请先登录');window.location.href='login.do';</script>");
			return  null;
		}

		return "messageadd.jsp";

	}


	//在线留言操作
	@RequestMapping("/messageadd2.do")
	public void messageadd2(HttpServletRequest request, HttpServletResponse response,Message bean ) throws IOException{

		PrintWriter writer = this.getPrintWriter(response);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("qiantai");


		bean.setStatus("待回复");
		bean.setCtime(Util.getTime());
		bean.setUserid(user.getId());

		messageService.insertBean(bean);

		writer.print("<script  language='javascript'>alert('操作成功');window.location.href='messagelist.do'; </script>");


	}



	//我的留言
	@RequestMapping("/messagelist.do")
	public String messagelist(HttpServletRequest request,HttpServletResponse response,String pagenum,String mtitle){


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

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("qiantai");

		sb.append(" userid="+user.getId()+" order by id desc ");

		String sql = sb.toString();


		//查询列表
		Map<String,List<Message>> map = messageService.selectBeanMap(currentpage,10,url,sql);
		String pagerinfo = map.keySet().iterator().next();
		List<Message> list = map.get(pagerinfo);

		//列表返回页面
		request.setAttribute("list", list);

		//分页信息返回页面
		request.setAttribute("pagerinfo", pagerinfo);

		//查询按钮
		request.setAttribute("url", url);

		return "messagelist.jsp";

	}


	//留言详情页面
	@RequestMapping("/messageshow.do")
	public String messageshow(HttpServletRequest request,int id){

		Message bean = messageService.selectData(" select * from t_message where id= "+id).get(0);

		request.setAttribute("bean", bean);



		return "messageshow.jsp";

	}

	//删除留言操作
	@RequestMapping("/messagedelete.do")
	public void messagedelete(HttpServletResponse response,int id){

		messageService.deleteBean(id);

		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');" +
				"window.location.href='messagelist.do';</script>");
	}

}













<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML>
<html>
<head>
    <title>物流网站管理后台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="assets/js/bui-min.js"></script>
	<script type="text/javascript" src="assets/js/common/main-min.js"></script>
	<script type="text/javascript" src="assets/js/config-min.js"></script>
</head>
<body>

<div class="header">

    <div class="dl-title">
       物流网站管理后台
    </div>

    <div class="dl-log">欢迎您，
    <span class="dl-log-user">${manage.username }</span>
     <a href="loginout.do" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>


<!-- 管理员功能 -->


<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统主界面</div></li>	

            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">公告&业务介绍</div></li>
            
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">物流网点</div></li>
            
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">快递物流</div></li>
            
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">留言回复</div></li>

            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">用户管理</div></li>

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">
    </ul>
</div>


<script>
    BUI.use('common/main',function(){
        var config = [
        {id:'1',homePage : '11',menu:[{text:'系统管理',
        							 items:[{id:'11',text:'系统主界面',href:'main.jsp'},
        									{id:'12',text:'密码管理',href:'password.do'}
        									]}]},
       
        									
         {id:'2',homePage : '21',menu:[{text:'公告&业务介绍',
         							  items:[{id:'21',text:'公告管理',href:'noticelist.do'},
                                             {id:'22',text:'业务介绍管理',href:'businesslist.do'}
        									]}]},	
        									
        									
         {id:'3',homePage : '31',menu:[{text:'物流网点',
         							  items:[{id:'31',text:'物流网点管理',href:'outletslist.do'}
        									]}]},	
         {id:'4',homePage : '41',menu:[{text:'快递物流',
         							  items:[{id:'41',text:'待邮寄快递',href:'expresslist.do'},
         							  		 {id:'42',text:'邮寄中快递',href:'expresslist2.do'},
                                          {id:'42',text:'快递查询',href:'expresslist3.do'}
        									]}]},	
         {id:'5',homePage : '51',menu:[{text:'留言回复',
         							  items:[{id:'51',text:'待回复留言',href:'messagelist.do'},
                                          {id:'51',text:'留言查询',href:'messagelist2.do'}
        									]}]},
            {id:'6',homePage : '61',menu:[{text:'用户管理',
                    items:[{id:'61',text:'用户管理',href:'userlist.do'}
                    ]}]},
        																	
        																									
        
        ];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>










<div style="text-align:center;">

</div>
</body>
</html>

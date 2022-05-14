<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物流网站</title>
<link href="css/public.css" rel="stylesheet" type="text/css" />
<link href="css/ny.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/png.js"></script>



<script type="text/javascript" src="js/javascript100.min.js"></script>

</head>
<body>

<%@ include file="head.jsp" %>


<div class="nymain">



         <%@ include file="left.jsp" %>
         
         <div class="nyright right">
                          <div class="nybt">
                                  <h2>网站公告</h2>
                                 
                          </div>
                          <div class="ny_list">
                                  <ul>
                                  		<c:forEach items="${noticelist}" var="notice">
                                  
                                         <li>
                                         
                                         <a href="noticeshow.do?id=${notice.id }">
 										<c:if test="${fn:length(notice.ntitle)>20}">${fn:substring(notice.ntitle,0, 20)}...</c:if>
        								<c:if test="${fn:length(notice.ntitle)<=20}">${notice.ntitle }</c:if>
                                         </a>
                                         <span>${notice.ctime }</span>
                                         
                                         </li>
                                         
                                         
                                         </c:forEach>
                                         
                                  </ul>
                                 
                                  
                          </div>
                          
                        
          </div>
          
          
          <div class="nyright right">
                          <div class="nybt">
                                  <h2>业务介绍</h2>
                                 
                          </div>
                          <div class="ny_list">
                                  <ul>
                                  		<c:forEach items="${businesslist}" var="business">
                                  
                                         <li>
                                         
                                         <a href="businessshow.do?id=${business.id }">
 										<c:if test="${fn:length(business.bname)>20}">${fn:substring(business.bname,0, 20)}...</c:if>
        								<c:if test="${fn:length(business.bname)<=20}">${business.bname }</c:if>
                                         </a>
                                         <span>${business.ctime }</span>
                                         
                                         </li>
                                         
                                         
                                         </c:forEach>
                                         
                                  </ul>
                                 
                                  
                          </div>
                          
                        
          </div>

</div>


<%@ include file="footer.jsp" %>


</body>
</html>


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
<!--------------daohang-------------------->

<!------------over---------------->


<script type="text/javascript" src="js/javascript100.min.js"></script>

</head>
<body>

<script>  

function  fenye(pagenum){

	form2.action = form2.action+"?pagenum="+pagenum;
	form2.submit();

}
 
</script>
<form action="${url }" method="post"  name="form2">

<input type="hidden"  name="bname" value="${bname }" />

</form>

<%@ include file="head.jsp" %>


<div class="nymain">



         <%@ include file="left.jsp" %>
         
         <br/>
         <form action="businesslist.do" method="post">

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <span style="font-weight: bold;font-size: 15px;">业务名称</span>
       
       <input name="bname" type="text"  value="${bname }" style="height: 25px;">
       &nbsp;&nbsp;&nbsp;
       <input type="submit"  value="查&nbsp;&nbsp;询" style="height: 25px;width: 60px;" />     
      </form>
         
         <div class="nyright right">
                          <div class="nybt">
                                  <h2>业务介绍</h2>
                                 
                          </div>
                          
                          <div class="ny_list">
                                  <ul>
                                  		<c:forEach items="${list}" var="bean">
                                  
                                         <li>
                                         
                                         <a href="businessshow.do?id=${bean.id }">
 										 <c:if test="${fn:length(bean.bname)>20}">${fn:substring(bean.bname,0, 20)}...</c:if>
        								 <c:if test="${fn:length(bean.bname)<=20}">${bean.bname }</c:if>
                                         </a>
                                         <span>${bean.ctime }</span>
                                         
                                         </li>
                                         
                                         
                                         </c:forEach>
                                         
                                  </ul>
                                 
                                  
                          </div>
                          
                           <div align="center"><br/> ${pagerinfo }</div>
          </div>

</div>


<%@ include file="footer.jsp" %>


</body>
</html>


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

<input type="hidden"  name="zname" value="${zname }" /> 
                 
</form>

<%@ include file="head.jsp" %>


<div class="nymain">



         <%@ include file="left.jsp" %>
         
         <br/>
         <form action="expresslist.do" method="post">

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <span style="font-weight: bold;font-size: 15px;">快递单号</span>
       <input name="expressId" type="text"  value="${expressId }" style="height: 25px;">

             <span style="font-weight: bold;font-size: 15px;">出发地</span>
             <input name="fromAddress" type="text"  value="${fromAddress }" style="height: 25px;">

             <span style="font-weight: bold;font-size: 15px;">目的地</span>
             <input name="toAddress" type="text"  value="${toAddress }" style="height: 25px;">

       
       <input type="submit"  value="查&nbsp;&nbsp;询" style="height: 25px;width: 60px;" />     
      </form>
         
         <div class="nyright right">
                          <div class="nybt">
                                  <h2>我的快递</h2>
                                 
                          </div>
                          
                          <div class="ny_list">
                                  
                                  <table width="100%" border="1">
                                  <tr>
                                  <td><span style="font-weight: bold;font-size: 14px;">快递单号</span></td>
                                  <td><span style="font-weight: bold;font-size: 14px;">出发地</span></td>
                                  <td><span style="font-weight: bold;font-size: 14px;">目的地</span></td>
                                  <td><span style="font-weight: bold;font-size: 14px;">快递状态</span></td>
                                  <td><span style="font-weight: bold;font-size: 14px;">添加时间</span></td>
                                  <td><span style="font-weight: bold;font-size: 14px;">操作</span></td>
                                  </tr>
                                  
                                  <c:forEach items="${list}" var="bean">
                                 
                                  <tr>
                                  <td><span style="font-weight: bold;font-size: 14px;">${bean.expressId }</span></td>
                                  <td><span style="font-weight: bold;font-size: 14px;">
                                  <c:if test="${fn:length(bean.fromAddress)>10}">${fn:substring(bean.fromAddress,0, 10)}...</c:if>
                                      <c:if test="${fn:length(bean.fromAddress)<=10}">${bean.fromAddress }</c:if>
                                  </span></td>
                                  <td><span style="font-weight: bold;font-size: 14px;">
                                  <c:if test="${fn:length(bean.toAddress)>10}">${fn:substring(bean.toAddress,0, 10)}...</c:if>
                                      <c:if test="${fn:length(bean.toAddress)<=10}">${bean.toAddress }</c:if>
                                  </span></td>
                                      <td><span style="font-weight: bold;font-size: 14px;">${bean.status }</span></td>
                                      <td><span style="font-weight: bold;font-size: 14px;">${bean.ctime }</span></td>

                                  <td>

                                  &nbsp;&nbsp;&nbsp;
                                  <a href="expressshow.do?id=${bean.id }">
                                  <span style="font-weight: bold;font-size: 14px;">查看详情</span>
                                  </a>
                                      <c:if test="${bean.status=='待邮寄'}">&nbsp;&nbsp;&nbsp;
                                  <a href="expressupdate.do?id=${bean.id }" onclick="{if(confirm('确认取消邮寄?')){return true;}return false;}" >
                                  <span style="font-weight: bold;font-size: 14px;">取消邮寄</span>
                                  </a>
                                      </c:if>
                                      <c:if test="${bean.status=='已取消'}">&nbsp;&nbsp;&nbsp;
                                          <a href="expressdelete.do?id=${bean.id }" onclick="{if(confirm('确认删除?')){return true;}return false;}" >
                                              <span style="font-weight: bold;font-size: 14px;">删除</span>
                                          </a>
                                      </c:if>
                                  </td>
                                  </tr>
                                  
                                  </c:forEach>
                                  
                                  
                                  </table>
                                  
                                 
                                  
                          </div>
                          
                           <div align="center"><br/> ${pagerinfo }</div>
          </div>

</div>


<%@ include file="footer.jsp" %>


</body>
</html>


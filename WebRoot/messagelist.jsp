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
         <form action="messagelist.do" method="post">

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <span style="font-weight: bold;font-size: 15px;">留言标题</span>
       <input name="mtitle" type="text"  value="${mtitle }" style="height: 25px;">



       
       <input type="submit"  value="查&nbsp;&nbsp;询" style="height: 25px;width: 60px;" />     
      </form>
         
         <div class="nyright right">
                          <div class="nybt">
                                  <h2>我的留言</h2>
                                 
                          </div>
                          
                          <div class="ny_list">
                                  
                                  <table width="100%" border="1">
                                  <tr>
                                  <td><span style="font-weight: bold;font-size: 14px;">留言标题</span></td>
                                  <td><span style="font-weight: bold;font-size: 14px;">留言时间</span></td>
                                  <td><span style="font-weight: bold;font-size: 14px;">留言状态</span></td>
                                  <td><span style="font-weight: bold;font-size: 14px;">回复时间</span></td>
                                  <td><span style="font-weight: bold;font-size: 14px;">操作</span></td>
                                  </tr>
                                  
                                  <c:forEach items="${list}" var="bean">
                                 
                                  <tr>

                                  <td><span style="font-weight: bold;font-size: 14px;">
                                  <c:if test="${fn:length(bean.mtitle)>10}">${fn:substring(bean.mtitle,0, 10)}...</c:if>
                                      <c:if test="${fn:length(bean.mtitle)<=10}">${bean.mtitle }</c:if>
                                  </span></td>

                                      <td><span style="font-weight: bold;font-size: 14px;">${bean.ctime }</span></td>
                                      <td><span style="font-weight: bold;font-size: 14px;">${bean.status }</span></td>
                                      <td><span style="font-weight: bold;font-size: 14px;">${bean.rtime }</span></td>

                                  <td>

                                  &nbsp;&nbsp;&nbsp;
                                  <a href="messageshow.do?id=${bean.id }">
                                  <span style="font-weight: bold;font-size: 14px;">查看详情</span>
                                  </a>
                                      &nbsp; &nbsp; &nbsp;
                                      <a href="messagedelete.do?id=${bean.id }" onclick="{if(confirm('确认删除?')){return true;}return false;}" >
                                              <span style="font-weight: bold;font-size: 14px;">删除</span>
                                      </a>

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


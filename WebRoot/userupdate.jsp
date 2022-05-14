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

<%@ include file="head.jsp" %>


<div class="nymain">



         <%@ include file="left.jsp" %>
         
         <div class="nyright right">
                          <div class="nybt">
                                  <h2>个人信息</h2>
                                 
                          </div>
                          <div class="ny_list">
                                  <script type="text/javascript">
function checkfrom()
{
	 
	if (document.getElementById('nameid').value=="")
	{
		alert("姓名不能为空");
		return false;
	}
	
	if (document.getElementById('phoneid').value=="")
	{
		alert("手机不能为空");
		return false;
	}
	
	valid=/^0?1[3,4,5,6,7,8,9][0,1,2,3,4,5,6,7,8,9]\d{8}$/;  
	if(!valid.test(document.getElementById('phoneid').value)){
		alert("请输入正确的手机格式");
		return false;
	}
	
	
	return true;
}
</script>
							
							
<form method="post"  onSubmit="return checkfrom()" action="userupdate2.do">		

<table width="100%" border="1" align="center" >



<tr  bgcolor="#f6f6f6">
<td  height="30px" align="right" width="40%">
<span style="font-size: 18px;font-weight: bold;">
用户名：
</span>
</td>
<td >${bean.username }</td>
</tr>




<tr  bgcolor="#f6f6f6">
<td  height="30px" align="right" width="40%">
<span style="font-size: 18px;font-weight: bold;">
姓名：
</span>
</td>
<td ><input name="name" type="text" id="nameid" value="${bean.name }"   style="width: 300px;height: 25px;"/></td>
</tr>


<tr  bgcolor="#f6f6f6">
<td  height="30px" align="right" width="40%">
<span style="font-size: 18px;font-weight: bold;">
手机：
</span>
</td>
<td ><input name="phone" type="text" id="phoneid" value="${bean.phone }"   style="width: 300px;height: 25px;"/></td>
</tr>





<tr  bgcolor="#f6f6f6">
<td  height="30px" align="right" width="40%">
<span style="font-size: 18px;font-weight: bold;">
操作：
</span>
</td>
<td  >
 <input type="submit" value="提&nbsp;&nbsp;&nbsp;&nbsp;交" style="width: 100px;height: 25px;" /> 
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" value="重&nbsp;&nbsp;&nbsp;&nbsp;置" style="width: 100px;height: 25px;"/>
   
</td>
</tr>


</table>
</form>	
                                 
                                  
                          </div>
                          
          </div>

</div>


<%@ include file="footer.jsp" %>


</body>
</html>


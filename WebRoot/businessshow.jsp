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

		<%@ include file="head.jsp"%>
		

		<div class="nymain">



			<%@ include file="left.jsp"%>

			<div class="nyright right">
				<div class="nybt">
					<h2>
						业务详情
					</h2>
					
				</div>
				<div class="ny_list_new_zw left">

					<h2>
						${bean.bname }
						
					</h2>
					<p class="nei">

						<span>添加时间:</span><span>${bean.ctime }</span>
					</p>
					<div class="nr left">
						
							${bean.intro }
						
					</div>

				</div>

				
<table width="100%" border="1" align="center" >


<tr  bgcolor="#f6f6f6">


<td  colspan="3" align="center">
 <input type="button" value="&nbsp;返&nbsp;&nbsp;&nbsp;&nbsp;回&nbsp;" style="width: 100px;height: 25px;" onclick="window.location.href='businesslist.do';" />
    
   
</td>
</tr>




</table>



			</div>

		</div>


		<%@ include file="footer.jsp"%>


	</body>
</html>


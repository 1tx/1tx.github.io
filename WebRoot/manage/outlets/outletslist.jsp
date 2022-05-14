<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<script>  

function  fenye(pagenum){

	form2.action = form2.action+"?pagenum="+pagenum;
	form2.submit();

}
 
</script>
<form action="${url }" method="post"  name="form2">

<input type="hidden"  name="biaoti" value="${biaoti }" /> 
                 
</form>


<form class="form-inline definewidth m20" action="${url }" method="post">    
 <button type="button" class="btn btn-success" id="addnew" 
 onclick="javascript:window.location.href='${url2 }add.do';">添加物流网点</button>&nbsp;&nbsp;
    物流网点名称：
    <input type="text" name="oname" value="${oname }" class="abc input-default" placeholder="" >&nbsp;&nbsp;
    省：
    <input type="text" name="province" value="${province }" class="abc input-default" placeholder="" >&nbsp;
    市：
    <input type="text" name="city" value="${city }" class="abc input-default" placeholder="" >&nbsp;
    
    <button type="submit" class="btn btn-primary">查询</button>
   
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>物流网点名称</th>
        <th>省</th>
        <th>市</th>
        <th>详细地址</th>
        <th>联系电话</th>
        <th>物流网点负责人</th>
      
    
        <th>操作</th>
    </tr>
    </thead>

	   
	     <c:forEach items="${list}" var="bean">
	       <tr>
	      	<td>${bean.oname }&nbsp;</td>
          	<td>${bean.province }&nbsp;</td>
               <td>${bean.city }&nbsp;</td>
               <td>${bean.address }&nbsp;</td>
               <td>${bean.phone }&nbsp;</td>
               <td>${bean.personincharge }&nbsp;</td>
            
            <td>

                <a class="btn btn-info btn-sm" href="${url2 }show.do?id=${bean.id }">查看</a>&nbsp;&nbsp;&nbsp;
                <a class="btn btn-warning btn-sm" href="${url2 }update.do?id=${bean.id }">修改</a>&nbsp;&nbsp;&nbsp;
                <a class="btn btn-danger btn-sm" href="${url2 }delete.do?id=${bean.id }" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a> &nbsp;&nbsp;

            </td>
             </tr>	
	     </c:forEach>
           
       
</table>
<div class="inline pull-right page">
${pagerinfo }</div>
</body>
</html>


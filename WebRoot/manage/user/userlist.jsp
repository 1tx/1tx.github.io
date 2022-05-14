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

<input type="hidden"  name="username" value="${username }" />
                 
</form>


<form class="form-inline definewidth m20" action="${url }" method="post">    
&nbsp;用户名：
    <input type="text" name="username" value="${username }" class="abc input-default" placeholder="" >&nbsp;&nbsp;
    
    <button type="submit" class="btn btn-primary">查询</button>
   
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>姓名</th>
        <th>手机号码</th>
        <th>注册时间</th>
      
    
        <th>操作</th>
    </tr>
    </thead>

	   
	     <c:forEach items="${list}" var="bean">
	       <tr>
	      	<td>${bean.username }&nbsp;</td>
          	<td>${bean.password }&nbsp;</td>
               <td>${bean.name }&nbsp;</td>
               <td>${bean.phone }&nbsp;</td>
               <td>${bean.ctime }&nbsp;</td>
            
            <td>

                <a class="btn btn-danger btn-sm" href="${url2 }delete.do?id=${bean.id }" onclick="{if(confirm('确认删除?')){return true;}return false;}">删除</a> &nbsp;&nbsp;
                
            </td>
             </tr>	
	     </c:forEach>
           
       
</table>
<div class="inline pull-right page">
${pagerinfo }</div>
</body>
</html>


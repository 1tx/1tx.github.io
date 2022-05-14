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
&nbsp;
    留言标题：
    <input type="text" name="mtitle" value="${mtitle }" class="abc input-default" placeholder="" >&nbsp;&nbsp;
    
    <button type="submit" class="btn btn-primary">查询</button>
   
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>留言标题</th>
        <th>留言时间</th>
        <th>回复时间</th>
        <th>留言状态</th>
      
    
        <th>操作</th>
    </tr>
    </thead>

	   
	     <c:forEach items="${list}" var="bean">
	       <tr>
	      	<td>${bean.mtitle }&nbsp;</td>
          	<td>${bean.ctime }&nbsp;</td>
               <td>${bean.rtime }&nbsp;</td>
               <td>${bean.status }&nbsp;</td>
            
            <td>

            	<a class="btn btn-info btn-sm" href="${url2 }show.do?id=${bean.id }">查看详情</a>&nbsp;&nbsp;&nbsp;

            </td>
             </tr>	
	     </c:forEach>
           
       
</table>
<div class="inline pull-right page">
${pagerinfo }</div>
</body>
</html>


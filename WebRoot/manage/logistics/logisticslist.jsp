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

<input type="hidden"  name="expressId" value="${expressId }" />
                 
</form>


<form class="form-inline definewidth m20" action="expresslist2.do" method="post">
 <button type="button" class="btn btn-success" id="addnew" 
 onclick="javascript:window.location.href='${url2 }add.do?expressId=${expressId}';">添加物流信息</button>&nbsp;&nbsp;

    
    <button type="submit" class="btn btn-primary">返回</button>
   
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>物流信息内容</th>
        <th>添加时间</th>

      
    
        <th>操作</th>
    </tr>
    </thead>

	   
	     <c:forEach items="${list}" var="bean">
	       <tr>
	      	<td>${bean.lcontent }&nbsp;</td>
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


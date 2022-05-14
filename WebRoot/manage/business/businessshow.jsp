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
<form method="post" action="${url }"  onsubmit="return checkform()"  class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    

    
    
    
    <tr>
        <td width="10%" class="tableleft">业务名称</td>
        <td><input type="text" name="bname"  id="bnameid" style="width: 300px;" value="${bean.bname}" readonly="readonly"  /></td>
    </tr>
    
    
    <tr>
        <td class="tableleft">业务介绍</td>
        <td>
        <textarea style="width: 500px;height: 250px;" name="intro" readonly="readonly" >${bean.intro}</textarea>
        </td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>

            <button type="button" class="btn btn-success" name="backid" onclick="javascript:history.go(-1);">返回</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>


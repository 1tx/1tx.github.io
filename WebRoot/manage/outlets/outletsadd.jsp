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
    
    
<script language="javascript" type="text/javascript">

function checkform()
{

	if (document.getElementById('onameid').value=="")
	{
		alert("物流网点名称不能为空");
		return false;
	}
    if (document.getElementById('provinceid').value=="")
    {
        alert("省不能为空");
        return false;
    }
    if (document.getElementById('cityid').value=="")
    {
        alert("市不能为空");
        return false;
    }
    if (document.getElementById('addressid').value=="")
    {
        alert("详细地址不能为空");
        return false;
    }
    if (document.getElementById('phoneid').value=="")
    {
        alert("联系电话不能为空");
        return false;
    }
    if (document.getElementById('personinchargeid').value=="")
    {
        alert("物流网点负责人不能为空");
        return false;
    }

	return true;	
}

</script>
    
</head>
<body>
<form method="post" action="${url }"  onsubmit="return checkform()"  class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    

    
    
    
    <tr>
        <td width="10%" class="tableleft">物流网点名称</td>
        <td><input type="text" name="oname"  id="onameid" style="width: 300px;"  /></td>
    </tr>

    <tr>
        <td width="10%" class="tableleft">省</td>
        <td><input type="text" name="province"  id="provinceid" style="width: 300px;"  /></td>
    </tr>

    <tr>
        <td width="10%" class="tableleft">市</td>
        <td><input type="text" name="city"  id="cityid" style="width: 300px;"  /></td>
    </tr>

    <tr>
        <td width="10%" class="tableleft">详细地址</td>
        <td><input type="text" name="address"  id="addressid" style="width: 300px;"  /></td>
    </tr>

    <tr>
        <td width="10%" class="tableleft">联系电话</td>
        <td><input type="text" name="phone"  id="phoneid" style="width: 300px;"  /></td>
    </tr>

    <tr>
        <td width="10%" class="tableleft">物流网点负责人</td>
        <td><input type="text" name="personincharge"  id="personinchargeid" style="width: 300px;"  /></td>
    </tr>

    <tr>
        <td width="10%" class="tableleft">备注</td>
        <td><input type="text" name="remark"  id="remarkid" style="width: 300px;"  /></td>
    </tr>

    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">提交</button> &nbsp;&nbsp;
            
            <button type="button" class="btn btn-success" name="backid" onclick="javascript:history.go(-1);">返回</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>


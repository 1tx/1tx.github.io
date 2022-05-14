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
                                  <h2>寄快递</h2>
                                 
                          </div>
                          <div class="ny_list">
                                  <script type="text/javascript">
function checkfrom()
{
	 if (document.getElementById('fromAddressid').value=="")
	{
		alert("出发地不能为空");
		return false;
	}

    if (document.getElementById('toAddressid').value=="")
    {
        alert("目的地不能为空");
        return false;
    }

    if (document.getElementById('senderid').value=="")
    {
        alert("寄件人不能为空");
        return false;
    }

    if (document.getElementById('senderPhoneid').value=="")
    {
        alert("寄件人手机号码不能为空");
        return false;
    }

    if (document.getElementById('addresseeid').value=="")
    {
        alert("收件人不能为空");
        return false;
    }

    if (document.getElementById('addresseePhoneid').value=="")
    {
        alert("收件人手机号码不能为空");
        return false;
    }


	
	
	return true;
}
</script>
							
							
<form method="post"  onSubmit="return checkfrom()" action="expressadd2.do" >

<table width="100%" border="1" align="center" >



<tr  bgcolor="#f6f6f6">
<td  height="30px" align="right" width="40%">
<span style="font-size: 18px;font-weight: bold;">
出发地：
</span>
</td>
<td ><input name="fromAddress" type="text" id="fromAddressid"    style="width: 300px;height: 25px;"/></td>
</tr>

    <tr  bgcolor="#f6f6f6">
        <td  height="30px" align="right" width="40%">
<span style="font-size: 18px;font-weight: bold;">
目的地：
</span>
        </td>
        <td ><input name="toAddress" type="text" id="toAddressid"    style="width: 300px;height: 25px;"/></td>
    </tr>

    <tr  bgcolor="#f6f6f6">
        <td  height="30px" align="right" width="40%">
<span style="font-size: 18px;font-weight: bold;">
寄件人：
</span>
        </td>
        <td ><input name="sender" type="text" id="senderid"    style="width: 300px;height: 25px;"/></td>
    </tr>

    <tr  bgcolor="#f6f6f6">
        <td  height="30px" align="right" width="40%">
<span style="font-size: 18px;font-weight: bold;">
寄件人手机号码：
</span>
        </td>
        <td ><input name="senderPhone" type="text" id="senderPhoneid"    style="width: 300px;height: 25px;"/></td>
    </tr>

    <tr  bgcolor="#f6f6f6">
        <td  height="30px" align="right" width="40%">
<span style="font-size: 18px;font-weight: bold;">
收件人：
</span>
        </td>
        <td ><input name="addressee" type="text" id="addresseeid"    style="width: 300px;height: 25px;"/></td>
    </tr>

    <tr  bgcolor="#f6f6f6">
        <td  height="30px" align="right" width="40%">
<span style="font-size: 18px;font-weight: bold;">
收件人手机号码：
</span>
        </td>
        <td ><input name="addresseePhone" type="text" id="addresseePhoneid"    style="width: 300px;height: 25px;"/></td>
    </tr>

    <tr  bgcolor="#f6f6f6">
        <td  height="30px" align="right" width="40%">
<span style="font-size: 18px;font-weight: bold;">
备注：
</span>
        </td>
        <td ><input name="remark" type="text" id="remarkid"    style="width: 300px;height: 25px;"/></td>
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


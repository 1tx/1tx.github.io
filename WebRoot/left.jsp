<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="nymainl left">


<div class="fenlei left">
                                    <h2>网站导航</h2>
                                    <ul>
                                    
                                   
                                    
                                    <li><a href=".">网站首页</a></li>
                                    <c:if test="${qiantai==null}">
                                    <li><a href="register.do">用户注册</a></li>
                                    <li><a href="login.do">用户登录</a></li>
                                  	</c:if>
                                    
                                    <c:if test="${qiantai!=null}">
                                    <li><a href="loginout.do">安全退出</a></li>
                                  	</c:if>     
                                           
                                          
                                    </ul>
                          </div>




<c:if test="${qiantai!=null}">


	<div class="fenlei left">
             <h2>用户中心</h2>             
             <div class="lx">
             <br/>    

<input onclick="window.location.href='expressadd.do';" type="button" value="寄快递" style="width: 100px;height: 25px;"  />
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input onclick="window.location.href='expresslist.do';" type="button" value="我的快递" style="width: 100px;height: 25px;"  />
<br/><br/>
<input onclick="window.location.href='messageadd.do';" type="button" value="在线留言" style="width: 100px;height: 25px;"  />
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input onclick="window.location.href='messagelist.do';" type="button" value="我的留言" style="width: 100px;height: 25px;"  />
<br/><br/>






                       
      <input onclick="window.location.href='userupdate.do';" type="button" value="个人信息" style="width: 100px;height: 25px;"  /> 
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input onclick="window.location.href='password.do';" type="button" value="个人密码" style="width: 100px;height: 25px;"  /> 
      <br/><br/>
      <input onclick="window.location.href='loginout.do';" type="button" value="安全退出" style="width: 100px;height: 25px;"  /> 
     
      
      <br/>       
      <br/>
                                    
       </div>
      </div>
</c:if>                          
                          

                          
                          
                           
         </div>


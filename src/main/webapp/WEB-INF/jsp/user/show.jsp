<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
<br/>
<div class="container">
<nav class="navbar navbar-default" role="navigation">
   <div >
      <ul class="nav navbar-nav">
         <li ><a >您好！ ${loginUser.nickname }</a></li>
         <li ><a href="/user/first">首页</a></li>
         <li class="active"><a href="/user/show">个人信息</a></li>
         <c:if test="${loginUser.id eq 1 }">
         <li><a href="/user/users">用户列表</a></li>
         </c:if>
         <c:if  test="${empty account.name }">
         <li><a href="/account/${loginUser.username }/addaccount">注册账户</a></li>
         </c:if>
         <li><a href="/user/loginOut">退出</a></li>
      </ul>
   </div>
</nav>

<div class="col-md-4" align="center"></div>
<div class="col-md-4" align="center">
   <h2 class="page-header">${loginUser.nickname } 个人信息</h2>
   <div class="col-md-12" align="center">
   <table class="table table-striped table-bordered">
   <tr align="center">
   <td>Username:</td><td>${loginUser.username }</td>
   </tr>
   <tr align="center">
   <td>Nickname:</td><td>${loginUser.nickname }</td>
   </tr>
   <tr align="center">
   <td>Email:</td><td>${loginUser.email }</td>
   </tr>
   <tr align="center">
   <td colspan="2"><a  class="btn btn-default" href="${loginUser.username}/update">修改</a>
   <a  class="btn btn-default" href="/account/${loginUser.username }/list">查看个人账户</a></td>
   </tr>
   </table>
   </div>
   </div>
</body>
</html>
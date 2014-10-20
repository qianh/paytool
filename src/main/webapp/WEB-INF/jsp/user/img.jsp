<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>头像更改</title>
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
         <li ><a>您好！ ${loginUser.nickname }</a></li>
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
<div class="col-md-3" align="center"></div>
<sf:form method="post" modelAttribute="user" enctype="multipart/form-data">
<div class="col-md-6">
   <h2 class="page-header" align="center">头像更改</h2>

   <h3>选择需要更换的头像:</h3>
   <div class="col-md-2"></div>
   <div class="col-md-10" align="center">
    <h4 ><input type="file" name="image" class="btn btn-default"></h4>
    </div>
   <br/>
   <div class="col-md-2"></div>
  <div class="col-md-8" align="center">
  <br/>
   <button class="btn btn-primary">确认并修改</button>
    <a class="btn btn-default" href="/user/first">返回</a>
  </div>
  <div class="col-md-2"></div>

 </div>
</sf:form>
</div>
</body>
</html>
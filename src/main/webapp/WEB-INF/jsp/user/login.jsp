<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="col-md-4" align="center"></div>
<div class="col-md-4" align="center">
<form method="post" >
   <h3 class="page-header">用户登录  </h3>
   <label>Username</label>
   <input type="text" placeholder="输入您的用户名" name="username"/><br/>
   <label>Password</label>
   <input type="password" placeholder="输入您的密码" name="password"/><br/>
   <button type="submit" class="btn btn-default">登录</button>
   <button type="reset" class="btn btn-default">重置</button>
   <button  class="btn btn-default"><a href="add">用户注册</a></button>
</form>
</div>
</body>
</html>
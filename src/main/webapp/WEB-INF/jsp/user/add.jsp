<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>add user</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>
<body>

<sf:form method="post" modelAttribute="user">
<div class="col-md-4" align="center"></div>
<div class="col-md-4" align="center">
   <h1 class="page-header">用户注册</h1>
   <div class="col-md-12" align="center">
   <table class="table table-striped">
   <tr align="center">
   <td>Username:</td><td><sf:input path="username" placeholder="填写登录用户名"/><sf:errors path="username"/></td>
   </tr>
   <tr align="center">
   <td>Password:</td><td><sf:password path="password" placeholder="填写登录密码"/><sf:errors path="password"/></td>
   </tr>
   <tr align="center">
   <td>Nickname:</td><td><sf:input path="nickname" placeholder="填写用户昵称"/><sf:errors path="nickname"/></td>
   </tr>
   <tr align="center">
   <td>Email:</td><td><sf:input path="email" placeholder="填写用户邮箱"/><sf:errors path="email"/></td>
   </tr>
   <tr>
   <td colspan="2" align="center"><button class="btn btn-primary">确认并提交</button>
                   <button type="reset" class="btn btn-primary">重置</button>
                   <a class="btn btn-default" href="/user/login">登录</a>
   </tr>
   </table>
   </div>
    
   </div>
</sf:form>
</body>
</html>
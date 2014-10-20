<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>转账</title>
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
         <li ><a href="/user/show">个人信息</a></li>
         <c:if test="${loginUser.id eq 1 }">
         <li ><a href="/user/users">用户列表</a></li>
         </c:if>
        <c:if  test="${empty account.name }">
         <li><a href="/account/${loginUser.username }/addaccount">注册账户</a></li>
         </c:if>
         <li><a href="/user/loginOut">退出</a></li>
      </ul>
   </div>
</nav>
<form method="post">
<div class="col-md-3" align="center"></div>
<div class="col-md-6" >
  <h2 class="page-header" align="center">转账</h2>
  <div class="col-md-12" align="center">
   <h4><label>要转账的账号： </label><input type="text" name="name" placeholder="输入转账的账号"/></h4>
   <br/>
   <h4><label>转入金额： </label><input type="text" name="wallet" placeholder="输入想要转入的金额"/>
   <input type="submit" value="提交"/></h4>
  </div>
</div>
</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>个人账户信息</title>
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

<input type="hidden" name="username" value="${loginUser.username }">
<br/>
<div class="col-md-3" align="center"></div>
<div class="col-md-6" align="center">
  <h3 class="page-header" >${loginUser.nickname } 个人账户信息
  </h3>
  <table class="table table-bordered">
     <thead>
        <tr>
        <th>用户账号</th><th>余额显示</th><th>操作</th>
        </tr>
     </thead>

     <c:if test="${empty account.name}">
     <td colspan="3">您还没有账户，请前往——<a href="/account/${loginUser.username }/addaccount">注册</a></td>
     </c:if>
     <c:if test="${not empty account.name}">
     <tbody>
     <tr>
     <td>${account.name }</td>
     <td>${account.wallet }</td>
     <td><a class="btn btn-default" href="/account/${loginUser.username}/${account.name }/add">充值</a>
         <a class="btn btn-default" href="/account/${loginUser.username}/${account.name }/reduce">转账</a>
         <a class="btn btn-default" href="/account/${loginUser.username}/${account.name }/accountlist">查看账户清单</a>
     </td>
     </tr>
     </tbody>
     </c:if>

  </table>
</div>
</div>
</body>
</html>
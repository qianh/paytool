<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户列表</title>
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
         <li ><a >您好！ ${loginUser.nickname}</a></li>
         <li ><a href="/user/first">首页</a></li>
         <li ><a href="/user/show">个人信息</a></li>
         <c:if test="${loginUser.id eq 1 }">
         <li class="active"><a href="/user/users">用户列表</a></li>
         </c:if>
         <c:if  test="${empty account.name }">
         <li><a href="/account/${loginUser.username }/addaccount">注册账户</a></li>
         </c:if>
         <li><a href="/user/loginOut">退出</a></li>
      </ul>
   </div>
</nav>

<div class="col-md-2" align="center"></div>
<div class="col-md-8" align="center">
<h3 class="page-header">用户列表</h3>
   <table class="table table-hover table-striped">
   <thead>
    <tr>
	<th>#</th><th>用户名称</th><th>用户昵称</th>
	<th>用户邮箱</th>
	</tr>
	</thead>
   <tbody>
   <c:forEach items="${users.datas }" var="um">
    <tr>
	<td>${um.id }</td><td>${um.username }</td>
	<td>${um.nickname }</td><td>${um.email}</td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="4">
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="users" name="url"/>
			<jsp:param value="${users.totalRecord }" name="items"/>
			<jsp:param value="name" name="params"/>
		</jsp:include>
	</td>
	</tr>
	</tbody>
   </table>
   </div>
</div>
</body>
</html>
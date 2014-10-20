<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>个人账户清单</title>
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

<br/>
   <p><h2>当前账户余额： ${account.wallet }</h2></p>
   <table class="table table-striped" align="center">
     <thead>
       <tr><th>账户清单</th><th></th><th></th></tr>
     </thead>
     <tbody>
     <c:forEach items="${message.datas }" var="m">
       <tr>
       <td>${m.date }</td><td>${m.message }</td><td>具体金额： ${m.money }</td>
       </tr>
     </c:forEach>
     <tr>
     <td colspan="3">
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="accountlist" name="url"/>
			<jsp:param value="${message.totalRecord }" name="items"/>
			<jsp:param value="name" name="params"/>
		</jsp:include>
	</td>
     </tr>
     </tbody>
   </table>
</div>
</body>
</html>
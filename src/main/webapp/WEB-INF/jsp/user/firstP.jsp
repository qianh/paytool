<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录首页</title>
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
         <li class="active"><a>首页</a></li>
         <li><a href="/user/show">个人信息</a></li>
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
 
<div class="container" >
    <div class="col-md-1" align="center">
    <br/><br/>
    <img src="<%=request.getContextPath()%>/resources/img/${loginUser.img}" 
              alt="Responsive image" class="img-responsive img-circle"  >
    </div>
    <div class="col-md-4">
     <h4 class="page-header" align="center">您好！ ${loginUser.nickname }</h4>
     <div class="col-md-5"><a href="/user/${loginUser.username}/img">头像更改</a></div>
     <div class="col-md-7">  账户名：${account.name }</div>
     </div>
     <br/>
     <div class="col-md-6"  style="background-color: #fff;box-shadow: 
         inset 1px -1px 1px #000, inset -1px 1px 1px #000;">
         <br/>
       <div class="col-md-3" align="center">
          <h5>账户余额</h5>
          <h5>${account.wallet }</h5>
       </div>
       <br/>  
       <div class="col-md-9">
       <a class="btn btn-default" href="/account/${loginUser.username}/${account.name }/add">充值</a>&nbsp;
       <a class="btn btn-default" href="/account/${loginUser.username}/${account.name }/reduce">转账</a>&nbsp;
       <a class="btn btn-default" href="/account/${loginUser.username}/list">查看</a>
       </div>
     </div>
   </div>
   <br/>
   
   <table class="table table-striped">
     <thead>
       <tr><th>账户清单</th><th></th><th>
     </thead>
     <tbody>
     <c:forEach items="${message.datas }" var="m">
       <tr>
       <td>${m.date }</td><td>${m.message }</td><td>具体金额： ${m.money }</td>
       </tr>
     </c:forEach>
     </tbody>
   </table>
</div>
</body>
</html>
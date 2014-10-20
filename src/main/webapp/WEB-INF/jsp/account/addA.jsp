<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加账号</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
<sf:form method="post" modelAttribute="account">
<div class="col-md-4" align="center"></div>
<div class="col-md-4" >
  <h3 class="page-header" align="center">注册账号</h3>
  <div class="col-md-12" >
  <table class="table table-striped">
   <tr align="center">
   <td>账户名称:</td><td><sf:input path="name" placeholder="填写账户名"/><sf:errors path="name"/></td>
   </tr>
   <tr>
   <td colspan="2" align="center"><button class="btn btn-primary">确认并提交</button>
                   <button type="reset" class="btn btn-primary">重置</button>
               <a  class="btn btn-default" href="/user/first">返回</a>
   </tr>
   </table>
   
  </div>
</div>
</sf:form>

</body>

</html>
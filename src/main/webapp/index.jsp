<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/register/register.js"></script>
	
  </head>

<body>
	这是首页
	<br>
	<s:if test="hasFieldErrors()">
		<s:iterator value="fieldErrors">
			<font color="#FF0000"><s:property value="value[0]" /></font>
			<br>
		</s:iterator>
	</s:if>

	<form action="<%=basePath%>register/register.action" method="post" id="formid">
		用户名：<input type="text" name="userName" id="userName" class="mark"/><br /> 
		密码：<input type="password" name="passWord" id="passWord"/><br /> 
		<input type="submit" value="提交" /><br />
	</form>
</body>
</html>

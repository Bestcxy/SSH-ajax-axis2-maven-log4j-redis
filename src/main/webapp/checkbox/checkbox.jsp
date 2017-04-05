<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> checkbox 测试</title>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/checkbox/checkbox.js"></script>
</head>
<body>

	<input type="checkbox" id="checkboxAll" name="checkboxAll" value="checkall">全选<br>
	
	<input type="checkbox" name="checkboxStr" value="001" id="001" class="checkboxStr">001<br>
	<input type="checkbox" disabled="disabled" value="002" id="002" class="checkboxStr">002<br><!-- 不会被计算在内，无name属性 -->
	<input type="checkbox" name="checkboxStr" value="003" id="003" class="checkboxStr">003<br>
	<input type="checkbox" name="checkboxStr" value="004" id="004" class="checkboxStr">004<br>
	<input type="checkbox" name="checkboxStr" value="005" id="005" class="checkboxStr">005<br>
	<input type="checkbox" name="checkboxStr" value="006" id="006" class="checkboxStr">006<br>
	<input type="button" value="提交" id="checkboxSub">
	
</body>
</html>
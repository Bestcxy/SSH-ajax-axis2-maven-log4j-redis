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
<title> jstl 测试</title>
</head>
<body>
<%-- <c:import url="http://www.yiibai.com/jstl/jstl_function_indexof.html"></c:import> --%>
<h2>  &lt;c:forEach&gt; 遍历 List 测试 &lt;/c:forEach&gt;</h2>
<c:forEach var="item" items="${forEachStr}">
  <c:out value="${item}"/><br>
</c:forEach>
<hr>

<h2>${fn:substring(string, 1, 2)} 测试</h2>
<c:set var="subStr" value="${fn:substring(containStr, 12, 15)}" />
<c:out value="${subStr}"/>
<hr>

<h2>字符串转整形</h2>
<c:choose>
	<c:when test="${strToIntStr}>99">
		前端直接识别 后台 字符串 为 整数
	</c:when>
	<c:otherwise>
		前端无法直接识别 后台 字符串 为 整数
	</c:otherwise>
</c:choose>

<hr>
字符串原值为 ${strToIntStr}
<br>转化为整形
<fmt:parseNumber var="parseNum" type="number" integerOnly="true" value="${strToIntStr}" />
<c:out value="${parseNum}"></c:out>

<hr>
<c:set var="flag" value='${fn:contains(containStr, "World")}'></c:set>
<c:if test='${flag}'>
	fn:contains 判断 字符串包含 "world"
</c:if>

</body>
</html>
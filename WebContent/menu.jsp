<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<%
	String admin = (String) session.getAttribute("admin");
	if ("".equals(admin) || null == admin) {
		response.sendRedirect("index.jsp");
	}
%>
<%
	session.removeAttribute("id");
%>
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>${fn:escapeXml(admin)}さん、こんにちは</p>

	<p>
		<a href="select.jsp">検索</a>
	</p>
	<p>
		<a href="insert.jsp">登録</a>
	</p>
	<p>
		<a href="update.jsp">更新</a>
	</p>
	<p>
		<a href="delete.jsp">削除</a>
	</p>
	<form action="logout" method="post">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>

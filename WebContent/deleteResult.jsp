<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>削除結果確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>実行者：${fn:escapeXml(admin)}</p>
	<p>正常に削除されました</p>
	<form action="select.jsp">
		<input type="submit" value="検索">
	</form>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>削除確認画面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/commons.css">
</head>
<body>
	<p>これでよろしいですか？</p>

	<form action="deleteConfirm" method="post">
		<fieldset>
			<div>
				<label>ID</label><input type="text" name="id"
					value="${fn:escapeXml(id)}" readonly>
			</div>
			<div>
				<label>名前</label><input type="text" name="name"
					value="${fn:escapeXml(name)}" readonly>
			</div>
			<div>
				<label>TEL</label><input type="text" name="tel"
					value="${fn:escapeXml(tel)}" readonly>
			</div>
		</fieldset>
		<div>
			<input type="submit" name="button" value="削除"> <input
				type="submit" name="button" value="戻る"
				onclick="location.href='delete.jsp'; return false;">
		</div>
	</form>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>

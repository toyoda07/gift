<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>更新内容入力画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p style="color: red">${error}</p>
	<p>
		１箇所以上の項目を変更してください<br> ※IDは変更できません
	</p>

	<form action="updateInput" method="post">
		<fieldset>
			<div>
				<label>ID</label><input type="text" name="id"
					value="${fn:escapeXml(id)}" readonly>
			</div>
			<div>
				<label>名前</label><input type="text" name="newName"
					value="${fn:escapeXml(name)}">
			</div>
			<div>
				<label>TEL</label><input type="text" name="newTel"
					value="${fn:escapeXml(tel)}">
			</div>
			<div>
				<label>PASS</label><input type="password" name="newPass"
					value="${fn:escapeXml(pass)}">
			</div>
		</fieldset>
		<div>
			<input type="submit" name="button" value="確認"> <input
				type="submit" name="button" value="戻る"
				onclick="location.href='update.jsp'; return false;">
		</div>
	</form>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>

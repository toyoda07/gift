<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>削除画面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/commons.css">
</head>
<body>
	<p style="color: red">${error}</p>
	<p>
		削除を行うデータのIDを入力してください<br> <span class="required"></span>は必須です
	</p>

	<form action="delete" method="post">
		<fieldset>
			<div>
				<label class="required">ID</label><input type="text" name="id">
			</div>
		</fieldset>
		<input type="submit" value="確認">
	</form>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>

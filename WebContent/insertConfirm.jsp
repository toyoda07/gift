<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>登録確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>これでよろしいですか？</p>
	<p style="color: red">${error}</p>
	<form action="insertConfirm" method="post">
		<fieldset class="label-110">
			<div>
				<label>名前</label><input type="text" name="name" value="${name}"
					readonly>
			</div>
			<div>
				<label>TEL</label><input type="text" name="tel" value="${tel}"
					readonly>
			</div>
			<div>
				<label>PASS（再入力）</label><input type="password" name="rePass">
			</div>
		</fieldset>
		<div>
			<input type="submit" name="button" value="登録"> <input
				type="submit" name="button" value="戻る"
				onclick="location.href='insert.jsp'; return false;">
		</div>
	</form>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>

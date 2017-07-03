<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>ログイン画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p style="color: red">${error}</p>
	<form action="login" method="post">
		<fieldset>
			<div>
				<label>ID</label><input type="text" name="id">
			</div>
			<div>
				<label>PASS</label><input type="password" name="pass">
			</div>
		</fieldset>
		<input type="submit" value="ログイン">
	</form>
	<div>
		<a href="index.jsp">TOP画面へ</a>
	</div>
</body>
</html>

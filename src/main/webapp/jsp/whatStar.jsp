<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="../static/style.css" rel="stylesheet">
    <title>Яка зірка?</title>
</head>
<body>
<div id="container">
    <img src="${pageContext.request.contextPath}/img/4.jpg" alt="Image4">
</div>
<h2>Правильно. Наступне питання.</h2>
<h1>Яка зірка являється найближчою до нашої планети?</h1>
<form action="logic" method="get">
    <input type="hidden" name="source" value="quest4">
    <input type="submit" name="button" value="Проксима Центавра">
    <input type="submit" name="button" value="Сіріус">
</form>
</body>
</html>

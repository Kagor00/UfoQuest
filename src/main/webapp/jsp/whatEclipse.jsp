<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="../static/style.css" rel="stylesheet">
    <title>Яке затемнення?</title>
</head>
<body>
<div id="container">
    <img src="${pageContext.request.contextPath}/img/6.jpg" alt="Image6">
</div>
<h1>Що відбувається під час екліпсу,</h1>
<h1>коли місяць знаходиться між Землею та Сонцем?</h1>
<form action="logic" method="get">
    <input type="hidden" name="source" value="quest6">
    <input type="submit" name="button" value="Місячне затемнення">
    <input type="submit" name="button" value="Сонячне затемнення">
</form>
</body>
</html>

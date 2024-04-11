<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="../static/processCall.css" rel="stylesheet">
    <title>Прийняти виклик НЛО?</title>
</head>
<body>
<div id="container">
    <img src="${pageContext.request.contextPath}/img/1.jpg" alt="Image1">
</div>
<h1>Прийняти виклик НЛО?</h1>
<form action="logic" method="get">
    <input type="hidden" name="source" value="quest1">
    <input type="submit" name="button" value="Прийняти виклик">
</form>
<form action="logic" method="get">
    <input type="hidden" name="source" value="quest1">
    <input type="submit" name="button" value="Відхилити виклик">
</form>
</body>
</html>

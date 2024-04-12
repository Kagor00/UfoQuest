<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="../static/style.css" rel="stylesheet">
    <title>Яка планета?</title>
</head>
<body>
<div id="container">
    <img src="${pageContext.request.contextPath}/img/3.jpg" alt="Image3">
</div>
<h2>Ви піднялися на місток. Отже, перше питання.</h2>
<h1>Яка планета має найбільший об'єм серед всіх планет в Сонячній системі?</h1>
<form action="logic" method="get">
    <input type="hidden" name="source" value="quest3">
    <input type="submit" name="button" value="Сатурн">
    <input type="submit" name="button" value="Юпітер">
</form>
</body>
</html>

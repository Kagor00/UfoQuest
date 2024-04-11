<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="../static/style.css" rel="stylesheet">
    <title>Як називається об'єкт?</title>
</head>
<body>
<div id="container">
    <img src="${pageContext.request.contextPath}/img/7.jpg" alt="Image7">
</div>
<h1>Як називається теоретичний об'єкт,</h1>
<h1>який оточує чорну діру і впливає на рух матерії навколо неї?</h1>

<form action="logic" method="get">
    <input type="hidden" name="source" value="quest7">
    <input type="submit" name="button" value="Гравітаційна лінза">
    <input type="submit" name="button" value="Горизонт подій">
</form>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="../static/style.css" rel="stylesheet">
    <title>Перемога</title>
<body>
<div id="container">
    <img src="/img/victory.jpg" alt="victory">
</div>
<h2>Ви відповіли правильно на всі питання.</h2>
<h1>Вітаємо з перемогою!</h1>
<form action="logic" method="get">
    <input type="hidden" name="source" value="victory">
    <input type="submit" name="button" value="Продовжити">
</form>
</body>
</html>

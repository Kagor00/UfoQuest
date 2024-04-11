<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="../static/style.css" rel="stylesheet">
    <title>Відповідь неправильна</title>
</head>
<body>
<div id="container">
    <img src="/img/gameover2.jpg" alt="gameover2">
</div>
<div class="text">
    <h3>Ви відповіли неправильно і програли.</h3>
    <h2>ПОРАЗКА...</h2>
    <form action="stats.jsp" method="get">
        <input type="hidden" name="losses" value="<%= session.getAttribute("losses") %>">
        <input type="submit" name="button" value="Переглянути статистику">
    </form>
</div>
</body>
</html>

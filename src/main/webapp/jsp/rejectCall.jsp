<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="../static/style.css" rel="stylesheet">
    <title>Відхилили дзвінок</title>
</head>
<body>
<div id="container">
    <img src="/img/gameover.jpg" alt="gameover">
</div>
<div class="text">
    <h3>Ви відхилили виклик.</h3>
    <h2>ПОРАЗКА...</h2>
    <form action="stats.jsp" method="get">
        <input type="hidden" name="losses" value="<%= session.getAttribute("losses") %>">
        <input type="submit" name="button" value="Переглянути статистику">
    </form>
</div>
</body>
</html>

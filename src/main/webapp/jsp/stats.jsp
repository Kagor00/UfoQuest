<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <link href="../static/stats.css" rel="stylesheet">
    <title>Статистика</title>
</head>
<body>
<div id="container">
    <div class="content">
        <h1>Статистика</h1>
        <c:set var="victories" value="${empty sessionScope.victories ? 0 : sessionScope.victories}" />
        <c:set var="losses" value="${empty sessionScope.losses ? 0 : sessionScope.losses}" />
        <h2>Кількість перемог: ${victories}</h2>
        <h2>Кількість поразок: ${losses}</h2>
    </div>
    <div class="centered">
        <form action="processCall.jsp" method="get">
            <input type="hidden" name="source" value="index">
            <input type="submit" name="button" value="Перезапустити квест">
        </form>
        <form action="resetStats" method="post">
            <input type="submit" name="reset" value="Обнулити статистику">
        </form>
    </div>
</div>
</body>
</html>

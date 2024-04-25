<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <c:set var="victories" value="${session.getAttribute('victories')}" />
        <c:set var="losses" value="${session.getAttribute('losses')}" />
        <h2>Кількість перемог: ${not empty victories ? victories : 0}</h2>
        <h2>Кількість поразок: ${not empty losses ? losses : 0}</h2>
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

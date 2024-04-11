<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <%
            // Отримуємо значення перемог і поразок з атрибутів сесії
            Integer victories = (Integer) session.getAttribute("victories");
            Integer losses = (Integer) session.getAttribute("losses");

            // Якщо значення null, ініціалізуємо їх нулями
            if (victories == null) victories = 0;
            if (losses == null) losses = 0;
        %>
        <h2>Кількість перемог: <%= victories %></h2>
        <h2>Кількість поразок: <%= losses %></h2>
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

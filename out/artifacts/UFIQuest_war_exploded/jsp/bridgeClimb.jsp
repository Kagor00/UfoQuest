<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="../static/style.css" rel="stylesheet">
    <title>Піднятися на місток?</title>
</head>
<body>
<div id="container">
    <img src="${pageContext.request.contextPath}/img/2.jpg" alt="Image2">
</div>
<h2>Ви прийняли виклик.</h2>
<h1>Піднятися на капітанський місток?</h1>
<form action="logic" method="get">
    <input type="hidden" name="source" value="quest2">
    <input type="submit" name="button" value="Піднятися на місток">
    <input type="submit" name="button" value="Відмовитись підніматися на місток">
</form>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="imgPath" value="${contextPath}/img/2.jpg" />
</body>
</html>

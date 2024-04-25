<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/static/index.css" rel="stylesheet">
    <title>Start</title>
</head>
<body>
<div class="centered">
    <form action="jsp/processCall.jsp" method="get">
        <input type="hidden" name="source" value="index">
        <input type="submit" name="button" value="Почати квест">
    </form>
</div>
</body>
</html>

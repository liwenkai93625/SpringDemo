<%--
  Created by IntelliJ IDEA.
  User: lianjia
  Date: 2017-5-18
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Spittr</title>
</head>
<body>
    <h1>Welcome to Spittr</h1>
    <a href="<c:url value="/spittles" />">Spittles</a> &nbsp;
    <a href="<c:url value="/register" />">Register</a>
</body>
</html>
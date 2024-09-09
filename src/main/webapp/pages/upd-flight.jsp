<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Flight</title>
</head>
<body>
    You are trying to update flight ${updFlight.number}.
    You can change the airplane only.<br>
    <form method="post" action="/saveFlight">
        <input type="hidden" name="id" value="${updFlight.id}">
        <input type="hidden" name="number" value="${updFlight.number}">
        <input type="hidden" name="direction" value="${updFlight.direction}">
        <select name="planeId">
            <c:forEach var="plane" items="${currentPlanes}">
                <option value="${plane.id}" ${plane.id eq updFlight.airplane.id
                    ? 'selected' : ''}>${plane.model}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Update Flight">
    </form>
</body>
</html>
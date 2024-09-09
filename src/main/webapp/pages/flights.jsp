<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Flights Page</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Number</th>
            <th>Direction</th>
            <th>Plain Model</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="flight" items="${flights}">
            <tr>
                <td>${flight.number}</td>
                <td>${flight.direction}</td>
                <td>${flight.airplane.model}</td>
                <td>

                </td>
            </tr>
        </c:forEach>
    </table>

    <p>
        <a href="/addFlight">Open new Direction</a>
    </p>
</body>
</html>
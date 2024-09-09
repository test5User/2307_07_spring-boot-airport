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
                    <a href="/viewFlight/${flight.id}">View</a>
                    <c:if test="${empty flight.passengers}">
                        <a href="/delFlight/${flight.id}">Delete</a>
                    </c:if>
                    <a href="/updFlight/${flight.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p>
        <a href="/addFlight">Open new Direction</a>
    </p>

    <p>
        <a href="/">Main Page</a>
    </p>
</body>
</html>
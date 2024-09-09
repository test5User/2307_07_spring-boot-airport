<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Flight Info</title>
</head>
<body>
    <h1>Flight number : ${flight.number}</h1>
    <h2>Airplane : ${flight.airplane.model}</h2>
    <h1>Passengers:</h1>

    <p>
        <a href="/pages/add-pass.jsp?flightId=${flight.id}">Add passenger</a>
    </p>

    <table border="1">
        <tr>
            <th>FIO</th>
            <th>Place</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="passenger" items="${flight.passengers}">
            <tr>
                <td>${passenger.fio}</td>
                <td>${passenger.place}</td>
                <td>
                    <a href="/delPass/${flight.id}/${passenger.id}">Delete</a>
                    <a href="/updPass/${passenger.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
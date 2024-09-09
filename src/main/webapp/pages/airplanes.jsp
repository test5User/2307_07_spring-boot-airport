<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Airplanes Page</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Model</th>
            <th>Places</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="plane" items="${airplanes}">
            <tr>
                <td>${plane.model}</td>
                <td>${plane.places}</td>
                <td>

                </td>
            </tr>
        </c:forEach>
    </table>

    <p>
        <a href="/pages/add-plane.jsp">Buy new Airplane</a>
    </p>
</body>
</html>
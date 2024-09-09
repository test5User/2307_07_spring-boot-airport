<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Passenger</title>
</head>
<body>
You are trying to update passenger ${passenger.fio}.
You can change the place only.<br>
<form method="post" action="/savePass">
    <input type="hidden" name="passengerId" value="${passenger.id}">
    <input type="hidden" name="fio" value="${passenger.fio}">
    <input name="place" value="${passenger.place}">
    <input type="hidden" name="flightId" value="${passenger.flight.id}">
    <input type="submit" value="Update Passenger">
</form>
</body>
</html>
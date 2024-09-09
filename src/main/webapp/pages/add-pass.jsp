<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>
        Add Passenger
    </title>
</head>
<body>
    <form method="post" action="/savePass">
        <input type="hidden" name="flightId" value="${param.flightId}">
        <input name="fio" placeholder="FIO"><br>
        <input name="place" placeholder="Place"><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
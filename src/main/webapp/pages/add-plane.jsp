<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>
        Add Airplane Page
    </title>
</head>
<body>
    <form method="post" action="/addPlane">
        <input name="model" placeholder="Airplane Model" required>
        <input name="places" type="number" placeholder="Airplane Places" required>
        <input type="submit" value="Add Plane">
    </form>
</body>
</html>
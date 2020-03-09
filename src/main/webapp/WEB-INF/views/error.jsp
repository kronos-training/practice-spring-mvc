<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            background: yellow;
        }
    </style>
</head>
<body>
    <h1>Error: ${exception.message}</h1>
</body>
</html>
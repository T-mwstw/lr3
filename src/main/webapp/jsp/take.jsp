<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Добавить кота</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<div>
    <input type="text" id="Name" placeholder="Имя">
    <input type="text" id="Poroda" placeholder="Порода">
    <input type="text" id="Age" placeholder="Возраст">
    <input type="text" id="Color" placeholder="Окрас">
    <input type="text" id="Warning" placeholder="Особые приметы">

    <input type="button"  class="button" name="data" onclick="req()" value="Добавить">
</div>

<script src="js/takeJSON.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</body>
</html>


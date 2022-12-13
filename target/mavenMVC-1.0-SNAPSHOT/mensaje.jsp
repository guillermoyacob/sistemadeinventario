<%-- 
    Document   : mensaje
    Created on : 25 oct. 2022, 05:27:15
    Author     : Guiye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema de inventario - Mensaje</title>
        <link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-4">
            <div class="${config}" role="alert">
                ${mensaje}!
            </div>
            <a href="Controlador?accion=listar">Volver</a>
        </div>
        <<script src="./Bootstrap/js/bootstrap.bundle.js"></script>
    </body>
</html>

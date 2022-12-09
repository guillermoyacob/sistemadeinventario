<%-- 
    Document   : login
    Created on : 16 nov. 2022, 04:08:35
    Author     : Guiye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema de inventario de productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-4 col-lg-3">
            <h1>Bienvenidos al sistema de inventario de productos</h1>
            <form action="Validar" method="post">
                
                <div class="form-group m-4">
                    <label>Nombre: </label>
                    <input class="form-control" type="text" name="txtNombre" placeholder="Ingrese nombre"/>
                </div>
                <div class="form-group m-4">
                <label>Contraseña: </label>
                    <input class="form-control" type="password" name="txtContrasenia" placeholder="Ingrese contraseña"/>
                </div>
                <input class="btn btn-danger btn-block m-4" type="submit" name="accion" value="ingresar">
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </body>
</html>
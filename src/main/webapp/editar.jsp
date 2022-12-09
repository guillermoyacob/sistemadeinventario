<%-- 
    Document   : editar
    Created on : 1 nov. 2022, 03:45:13
    Author     : Guiye
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema de inventario - Editar producto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
        
        <% 
            HttpSession sesion = request.getSession();
            Usuario usuario = (Usuario) sesion.getAttribute("usuarioLogueado");
            
            if (usuario == null){
                response.sendRedirect("index.jsp");
            }
        %>
        
        <div class="container mt-4">
            <form action="Controlador" method="POST">
                <div class="card border-info mb-4" style="width: 18rem;">
                    <div class="card-header">
                        ACTUALIZAR PRODUCTO
                    </div>

                    <div class="card-body text-info">
                        <div class="form-group">
                            <label>ID</label>
                            <input type="text" value="${producto.id}" name="txtId" readonly="" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>NOMBRE</label>
                            <input type="text" value="${producto.nombre}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>DESCRIPCION</label>
                            <input type="text" value="${producto.descripcion}" name="txtDescripcion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>UNIDADES</label>
                            <input type="text" value="${producto.unidades}" name="txtUnidades" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>COSTO</label>
                            <input type="text" value="${producto.costo}" name="txtCosto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>PRECIO</label>
                            <input type="text" value="${producto.precio}" name="txtPrecio" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>CATEGORIA</label>
                            <input type="text" value="${producto.categoria}" name="txtCategoria" class="form-control">
                        </div>
                    </div>
                    <div class="card-footer">
                        <input type="submit" value="Actualizar" name="accion" class="btn btn-outline-success">
                        <a href="Controlador?accion=listar" class="btn-link ms-2">Volver</a>
                    </div>
                </div>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </body>
</html>
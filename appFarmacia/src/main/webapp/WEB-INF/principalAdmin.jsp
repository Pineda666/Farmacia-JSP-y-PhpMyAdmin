<%@page import="farmacia.modelo.bean.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmacia</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        
        <style>
            body{
                background-image: url('css/Olive Smith.jpg');
                background-repeat: no-repeat;
                background-position: center;
                background-size: cover;
                height: 85vh;
            }
        </style>
        
    </head>
    <body>
        <% usuario user1 = (usuario) request.getSession().getAttribute("user");%>

        <div id = "menu"> 
            <h4 style="text-align: right" id="usuario"> 
                <%= user1.getNOMBRE() + " " + user1.getAPEPATERNO() + " " + user1.getAPEMATERNO()%> <a style="text-decoration: none" href="cerrarSesion">CERRAR SESION</a>
            </h4> 
            <nav>
                <h4>
                    <ul class="nav justify-content-center">
                        <li class="nav-item">
                            <a style="color: lightsalmon" class="nav-link" href="listarProductos"><strong>PRODUCTOS</strong></a>
                        </li>
                        <li class="nav-item">
                            <a style="color: lightsalmon" class="nav-link" href="listarFacturas"><strong>HISTORIAL DE COMPRAS</strong></a>
                        </li>
                        <li class="nav-item">
                            <a style="color: lightsalmon" class="nav-link" href = "listarTransacciones"><strong>COMPRAS DE CLIENTES</strong></a>
                        </li>
                    </ul>    
                </h4>
            </nav>
        </div>
            
            
    </body>
</html>

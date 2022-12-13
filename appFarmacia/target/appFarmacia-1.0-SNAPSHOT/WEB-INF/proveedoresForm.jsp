<%@page import="farmacia.modelo.bean.usuario"%>
<%@page import="farmacia.modelo.bean.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta h ttp-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmacia</title>
        <link rel="stylesheet" href="css/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    
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

        <form class="row g-3" action = "grabarProveedor" method="post"">

            <div class="mb-3">
                <center><label class="form-label" style="width: 20%">NOMBRE: </label></center>
                <center><input type="hidden" class="form-control" style="width: 20%" name = "id" value = "${proveedor.IDPROVEEDOR}"></center>
                <center><input type="text" class="form-control" style="width: 20%" name = "nombre" value = "${proveedor.NOMBRE}"></center>
            </div>

            <div class="mb-3">
                <center><label class="form-label" style="width: 20%">CODIGO: </label></center>
                <center><input type="text" class="form-control" style="width: 20%" name = "codigo" value = "${proveedor.CODIGO}"></center>
            </div>

            <div class="col-12">
                <center><button type="submit" class="btn btn-primary" style="width: 20%">Grabar</button></center>
            </div>
        </form>

    </body>
</html>

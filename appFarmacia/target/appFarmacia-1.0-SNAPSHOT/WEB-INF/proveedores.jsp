<%@page import="farmacia.modelo.bean.usuario"%>
<%@page import="farmacia.modelo.bean.proveedor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
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


        <% ArrayList<proveedor> lista = (ArrayList<proveedor>) request.getAttribute("proveedor"); %>

        <div id = "lista_pro">
            <table class = "table table-hover">
                <thead>
                    <tr>
                        <td><strong>IDPROVEEDOR</strong></td>
                        <td><strong>NOMBRE</strong></td>
                        <td><strong>CODIGO</strong></td>  
                        <td colspan = "2" style="text-align: center"><strong><a style="text-decoration: none" href="nuevoProveedor">NUEVO</a></strong></td>
                    </tr>
                </thead>

                <tbody>
                    <% for (proveedor x : lista) {%>
                    <tr>
                        <td><%=x.getIDPROVEEDOR()%></td>
                        <td><%=x.getNOMBRE()%></td>
                        <td><%=x.getCODIGO()%></td>
                        <td><A href="editarProveedor?id=<%=x.getIDPROVEEDOR()%>">EDITAR</A></td>
                        <td><A onclick= "return confirm('¿DESEA ELMINAR??')" href="eliminarProveedor?id=<%=x.getIDPROVEEDOR()%>">ELIMINAR</A></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>

    </body>
</html>

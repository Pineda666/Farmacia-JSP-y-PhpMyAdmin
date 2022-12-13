<%-- 
    Document   : datosTransaccion
    Created on : 22-jul-2022, 19:53:27
    Author     : user
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="farmacia.modelo.bean.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://kit.fontawesome.com/88c588c76e.js" crossorigin="anonymous"></script>
        <style>
             button{
        background:none;
        border: none;
        font-size: 22px;
        cursor:pointer;
        margin-right: 10px;
        color:#27AE60;
       
        }
        p{
            text-align: center;
            margin-top: 15px;
        }
        
        .but-off{
          
          color:#1A5276;
          padding: 0%;
          font-size: 30px;
          margin-top: 22px;
          margin-right: 15px;
          
        }
        h6{
            margin-top:5px;
            margin-left: 15px;
        }
        
        .table{
            margin-top: 1%;
            margin-left:30%;
            width:500px;
            heidth:500px;
            text-align: center;
           
        }
        td {
            text-align: center;
            font-size:18px;
            
        }
        .blockquote{
            font-size:13px;
        }
        
       .usertexto{
            color:#fff;
        }
        .btn{
            margin-right: 100px;
        }
        
        .titulo{
            margin:0 auto;
            padding: 0%;
            margin-right: 490px;
            margin-top: 30px;
            text-decoration: none;
            color:#17202A;
            font-weight: 700;
            font-family:cursive;
            font-size:30px;
            cursor:pointer;
        }
        .titulo:hover{
            color:#17202A;
        }
        .casita{
            font-size:40px;
            margin-top: 22px;
           margin-left: 115px;
           
        }
        .nameusuario{
            margin-top: 30px;
            text-decoration: none;
            color:#fff;
           
        }
        .nameusuario:hover{
            color:#fff;
        }
        
        .usuariolog{
            margin-top: 32px;
            margin-right: 5px;
            
        }
        
        </style>
    </head>
    <body>

        <%
            usuario user1 = (usuario) request.getSession().getAttribute("user");
        %>

        <div id = "menu"> 
            <h4  style="text-align:right; display:flex" class="usertexto"> 
                <i class="fa-solid fa-house-medical casita"></i><a class="titulo">FARM SERVICES</a><i class="fa-solid fa-user usuariolog"></i> <a class="nameusuario"><%=user1.getNOMBRE() + " " + user1.getAPEPATERNO() + " " + user1.getAPEMATERNO()%></a> <a style="text-decoration: none" href="cerrarSesion"><button class="but-off"><i class="fa-solid fa-power-off"></i><h6>sesion</h6></button></a>
            </h4> 
            <nav>
                <h4>
                    <ul class="nav justify-content-center">
                        <li class="nav-item">
                            <a style="color: #76D7C4" class="nav-link" href="listarProductosCliente"><strong>PRODUCTOS</strong></a>
                        </li>
                        <li class="nav-item">
                            <a style="color: #76D7C4" class="nav-link" href="listarCompras"><strong>CARRITO DE COMPRAS</strong></a>
                        </li>
                    </ul>    
                </h4>
            </nav>
        </div>

        <div>
            <P><strong>DATOS TRANSACCIÓN</strong></P>
            <form action = "agregarTransaccion" method="post">
                <table class="table table-success table-striped">
                    <tr>
                        <th class="blockquote">NOMBRE:</th>
                        <th><input type = "text"  name = "NOMBRE" value="${producto.NOMBRE}" disabled></th>
                        <th><input type="hidden" name="idUser" value="${user.getIDUSUARIO()}"></th>
                        <th><input type = "hidden"  name = "IDPRODUCTO" value="${producto.IDPRODUCTO}"></th>

                    </tr>
                    <tr>
                        <th class="blockquote">CANTIDAD DISPONIBLE: </th>
                        <th><input type = "text" name = "cantidad1" value = "${producto.CANTIDAD}" disabled></th>
                        <th><input type = "hidden" name = "cantidad" value = "${producto.CANTIDAD}"></th>
                        <th></th>
                    </tr>
                    <tr>
                        <th class="blockquote">PRECIO: </th>
                        <th><input type = "text" name = "precio1" value = "${producto.PRECIO_VENTA}" disabled></th>
                        <th><input type = "hidden" name = "precio" value = "${producto.PRECIO_VENTA}"></th>
                        <th></th>
                    </tr> 
                    <tr>
                        <th class="blockquote">FECHA: </hd>
                        <%
                            Date date = new Date();
                            SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                            String fechastring = formato.format(date);
                        %>
                        <td><input type = "text" name = "fecha1" value="<%=fechastring%>" disabled></td>
                        <td><input type = "hidden" name = "fecha" value="<%=fechastring%>"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th class="blockquote">CANTIDAD A COMPRAR: </th>       
                        <td><input type = "text" name = "cantidadComprar"></td>
                        <td></td>
                        <td></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><input type = "submit" value = "AÑADIR AL CARRITO" class="btn btn-success"></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>

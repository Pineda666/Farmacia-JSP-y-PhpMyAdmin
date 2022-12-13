
<%@page import="farmacia.modelo.DAO.productoDAO"%>
<%@page import="farmacia.modelo.bean.producto"%>
<%@page import="farmacia.modelo.bean.ventaProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
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
            body{
            background-image: url('css/farmacia.jpg');
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
            height: 115vh;
        }
        button{
        background:none;
        border: none;
        font-size: 22px;
        cursor:pointer;
        margin-right: 10px;
        color:#27AE60;
       
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
            margin-left: 10%;
            width:1000px;
            heidth:1000px;
            text-align: center;
           
        }
        td{
            text-align: center;
            
        }
       .usertexto{
            color:#fff;
           
        }
        .btn{
            margin-left: 25%
        }
        
        .titulo{
            margin:0 auto;
            padding: 0%;
            margin-top: 30px;
            margin-right: 360px;
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
        <% usuario user1 = (usuario) request.getSession().getAttribute("user");%>

        <div id = "menu"> 
            <h4 style="text-align:right; display:flex" class="usertexto"> 
                <i class="fa-solid fa-house-medical casita"></i><a class="titulo">FARM SERVICES</a><i class="fa-solid fa-user usuariolog"></i> <a class="nameusuario"><%=user1.getNOMBRE() + " " + user1.getAPEPATERNO() + " " + user1.getAPEMATERNO()%></a> <a style="text-decoration: none" href="cerrarSesion"><button class="but-off"><i class="fa-solid fa-power-off"></i><h6>sesion</h6></button></a>
            </h4> 
            <nav>
                <h4>
                    <ul class="nav justify-content-center">
                        <li class="nav-item">
                            <a style="color: #76D7C4" class="nav-link" href="listarProductos"><strong>PRODUCTOS</strong></a>
                        </li>
                        <li class="nav-item">
                            <a style="color: #76D7C4" class="nav-link" href="listarFacturas"><strong>HISTORIAL DE COMPRAS</strong></a>
                        </li>
                        <li class="nav-item">
                            <a style="color:#76D7C4" class="nav-link" href = "listarTransacciones"><strong>COMPRAS DE CLIENTES</strong></a>
                        </li>
                    </ul>    
                </h4>
            </nav>
        </div>
            
       <% ArrayList<ventaProducto> lista = (ArrayList<ventaProducto>) request.getAttribute("comprasC"); %>

        <div id = "lista_pro">
            <table class = "table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <td><strong>Nombre del produtco</strong></td>
                        <td><strong>Cantidad</strong></td>
                        <td><strong>Costo Unitario</strong></td>
                        <td><strong>Fecha de Compra</strong></td>
                        <td><strong>Total A Pagar</strong></td>
                    </tr>
                </thead>

                <tbody>
                    <% for (ventaProducto x : lista) {%>
                    <tr>
                        <%producto product = productoDAO.buscar(x.getIDPRODUCTO());%>
                        <td class="blockquote"><%=product.getNOMBRE()%></td>
                        <td class="blockquote"><%=x.getCANTIDAD()%></td>
                        <td class="blockquote"><%=product.getPRECIO_VENTA()%></td>
                        <td class="blockquote"><%=x.getFECHA()%></td>
                        <td class="blockquote"><%=x.getTOTALMONETARIO()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>     
            
            
            
    </body>
</html>

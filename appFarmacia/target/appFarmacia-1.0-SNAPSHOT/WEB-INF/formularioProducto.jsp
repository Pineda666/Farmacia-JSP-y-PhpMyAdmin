<%@page import="farmacia.modelo.bean.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmacia</title>
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
        .but-off{
          
          color:#1A5276;
          padding: 0%;
          font-size: 25px;
          margin-top: 22px;
         
          
        }
       
        h6{
            margin-top:5px;
            margin-left: 15px;
        }
        .usertexto{
            color:#fff;
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
        .casita{
            font-size:40px;
            margin-top: 22px;
           
           
        }
        
            
        </style>
        
    </head>
    <body>
        <% usuario user1 = (usuario) request.getSession().getAttribute("user");%>

        <div id = "menu"> 
            <h4 style="text-align:right; display:flex" class="usertexto"> 
               <i class="fa-solid fa-house-medical casita"></i><a class="titulo">FARM SERVICES</a>
               <i class="fa-solid fa-user usuariolog"></i> <a class="nameusuario">
                   <%=user1.getNOMBRE() + " " + user1.getAPEPATERNO() + " " + user1.getAPEMATERNO()%></a> 
                   <a style="text-decoration: none" href="cerrarSesion"><button class="but-off">
                           <i class="fa-solid fa-power-off"></i><h6>sesion</h6></button></a>
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
                            <a style="color: #76D7C4" class="nav-link" href = "listarTransacciones"><strong>COMPRAS DE CLIENTES</strong></a>
                        </li>
                    </ul>    
                </h4>
            </nav>
        </div>

        <form class="row g-3" action="grabarProducto" method="post">

            <div class="mb-3">
                <center><label class="form-label">Nombre:</label></center>
                <center><input type="hidden" class="form-control" style="width: 20%" name="IDPRODUCTO" value="${producto.IDPRODUCTO}"></center>
                <center> <input type="text" class="form-control" style="width: 20%" name="NOMBRE" value="${producto.NOMBRE}"> </center>
            </div>

            <div class="mb-3">
                <center><label class="form-label" style="width: 20%">Stock:</label></center>
                <center><input type="text" class="form-control" style="width: 20%" name="CANTIDAD" value="${producto.CANTIDAD}"></center>
            </div>

            <div class="mb-3">
                <center><label class="form-label" style="width: 20%">Precio de Venta:</label></center>
                <center><input type="text" class="form-control" style="width: 20%" name="PRECIO_VENTA" value="${producto.PRECIO_VENTA}"></center>
            </div>

            <div class="mb-3">
                <center><label class="form-label" style="width: 20%">Precio de compra:</label></center>
                <center><input type="text" class="form-control" style="width: 20%" name="PRECIO_COMPRA" value="${producto.PRECIO_COMPRA}"></center>
            </div>

            <div class="col-12">
                <center><button type="submit" class="btn btn-primary" style="width: 20%">Grabar</button></center>
            </div>
        </form>
    </body>
</html>

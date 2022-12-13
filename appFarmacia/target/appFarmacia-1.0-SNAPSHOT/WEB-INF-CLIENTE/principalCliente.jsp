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
            body{
                margin: 0;
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
            margin-right: 500px;
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
        .font_7{
            font: normal normal normal 16px/1.4em helveticaneuew01-75bold,helveticaneuew02-75bold,helveticaneuew10-75bold,sans-serif;
    color: rgb(0, 0, 0);
    letter-spacing: 0em;
        }
        .flex-center{
            display:flex;
            justify-content: center;
            align-items: center;
           
            
                
        }
        #fondo{
            
            width: 200px;
            height: 265px;
            background-image: url('css/farms.jpg');
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
            color:black;
           
           
            
            border-radius: 0.8em;
            
           
        }
        #fondo h1{
            margin-top: 95%;
            color:#D8FF00 ;
            font-family: Arial,Helvetica,sans-serif;
            font-size:20px;
            font-weight: bold;
            
        }
        .conten{
            text-align: center;
        }
        .parraf{
         font-family: serif;   
        }
        
    
           
        

        </style>
    </head>
    <body>
        <% usuario user1 = (usuario) request.getSession().getAttribute("user");%>

        <div id = "menu"> 
            <h4 style="text-align:right; display:flex" class="usertexto"> 
                <i class="fa-solid fa-house-medical casita"></i><a class="titulo" >FARM SERVICES</a><i class="fa-solid fa-user usuariolog"></i> <a class="nameusuario"><%=user1.getNOMBRE() + " " + user1.getAPEPATERNO() + " " + user1.getAPEMATERNO()%></a> <a style="text-decoration: none" href="cerrarSesion"><button class="but-off"><i class="fa-solid fa-power-off"></i><h6>sesion</h6></button></a>
            </h4> 
            <nav>
                <h4>
                    <ul class="nav justify-content-center">
                        <li class="nav-item">
                            <a style="color: #76D7C4" class="nav-link" href="listarProductosCliente"><strong>PRODUCTOS</strong></a>
                        </li>
                        <li class="nav-item">
                            <a style="color: #76D7C4" class="nav-link" href="listarCompras"><strong>Mi CARRITO DE COMPRAS</strong></a>
                        </li>
                    </ul>    
                </h4>
            </nav>
        </div>
            <div>
                <h1>
                    <p class="font_7" style="font-size:32px; line-height:1.6em; text-align:center;">
                        <span style="font-size:32px">
                            <span style="font-family:wfont_375882_4d4ee36ef0af476caf4563d1f55b6e03,wf_4d4ee36ef0af476caf4563d1f,orig_wix_madefor_text_bold_italic;">
                                BIENVENIDO A FARM SERVICES ESTAMOS AGRADECIDOS POR SER PARTE DE NUESTRA FAMILIA 
                            </span>
                             
                        </span>
                       
                    </p>
                </h1>
            </div  >
            <div class="conten">
                <p class="parraf">El 43% de personas realizan compras online aqui podra encontrar sus productos y realizar su primera compra.</p>
            </div>
            <div class="flex-center">
                <div id="fondo" class="flex-center">
                    <h1> Estacion Grau</h1>
                </div>
            </div>
        
               
    </body>
</html>

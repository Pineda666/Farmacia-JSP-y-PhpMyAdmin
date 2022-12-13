<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

        <style>

            body{
            background-image: url('css/logg.png');
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
            height: 70vh;
            }
            :root{
                --colorfondo: #FFFf;
            }


            form{
                border-radius: 0.8em;
                margin-left: auto;
                margin-right: auto;
                width: 20%;
                
                background: rgba(5,7,12,0.40);
                
            }


            table{
                
                text-align: center;
                margin-top: 80px;
                margin-left: auto;
                margin-right: auto;
            }

            th, td{
                padding: 10px;
            }

            p{
                color: white;
                font-weight: bold;
                font-size: 18px;
                
            }
            

        </style>



    </head>
    <body>

        <%String msg = (String) request.getAttribute("msg");%>


        <div>
            <form action="validarUsuario" method="post">
                <table>
                    <tr>
                        <td> 
                            <p style="text-align: center"><strong>INICIO DE SESIÓN</strong></p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="form-floating">
                                <input type = "text" class = "form-control" id ="floatingUser" placeholder="USUARIO" name = "usuario" >
                                <label for="floatingUser">Usuario</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="form-floating">
                                <input type = "password" class="form-control" id="floatingPassword" placeholder="CONTRASEÑA" name = "password" >
                                <label for="floatingPassword">Contraseña</label>
                            </div>
                        </td>
                          
                    </tr>
                    
        
                    <tr>
                    
                        <td><input class="btn btn-dark" type = "submit" value = "INGRESAR" ></td>
                    </tr>   
                </table>
        <center style="color: #fff">
            <%=msg != null ? msg : ""%>
        </center>
            </form>
        </div>
        
    </body>
</html>

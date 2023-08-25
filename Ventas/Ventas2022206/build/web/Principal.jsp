<%-- 
    Document   : principal
    Created on : 14/07/2023, 05:15:28 PM
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Menu Principal</title>
    </head>
    <body>
                <nav class="navbar navbar-expand-lg nvbar-light bg-info">
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                       <li class="nav-item active">
                  <a style="margin-left: 10px; border: none" class="btn btn-outline-light"  href="#">Home</a>
                    </li>
                <li class="nav-item a">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=listar" target="myFrame">Producto</a>
                </li>
               <li class="nav-item">
                   <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=listar" target="myFrame">Empleado</a>
                </li>
                <li class="nav-item">    
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Clientes&accion=listar" target="myFrame">Clientes</a>
                </li>
                
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=RegistrarVenta" target="myFrame">Registrar Venta</a>
                </li>
                
                
              </ul>
            </div>
                
                    <div class="dropdown">
                        <button style="border: none"  class="btn btn-outline-light dropdown-toggle" type="button" id="dropDownMenuButton" data-toggle="dropdown" aria-expanded="true">
                            ${usuario.getNombresEmpleado()}
                        </button>
                        <div class="dropdown-menu text-center"arail-labellebdy="dropDownMenuButton" >
                            <a class="dropdown-item" href="#">
                                <img src="img/Programador.jpeg" alt="" width="60"
                            </a>    
                                <a class="dropdown-item" href="#">${usuario.getUsuario()} </a>
                                <a class="dropdown-item" href="#">jdomingo-2022206@kinal.edu.gt</a>
                                <div class="dropdown-divider"></div>
                                <form action="Validar" method="POST">
                                    <button name="accion" name="Salir" class="dropdown-item" href="#">Salir</button>
                                </form>
                                
                        </div>    
                    </div>
                </nav>
                    <div class="m-4" style="height: 850px">
                        <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>               
                </div>                
                                
        
 
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>

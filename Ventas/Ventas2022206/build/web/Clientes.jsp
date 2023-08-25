<%-- 
    Document   : Clientes
    Created on : 14/07/2023, 05:24:33 PM
    Author     : informatica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Clientes</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Clientes" method="POST">

                        <div class="form-group">
                            <label>DPI</label>
                            <input type="text" value="${cliente.getDPICliente()}" name="txtDPICliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${cliente.getNombresCliente()}" name="txtNombresCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Dirección</label>
                            <input type="text" value="${cliente.getDireccionCliente()}" name="txtDireccionCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${cliente.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info" href="Controlador?menu=Clientes&accion=Agregar">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success" href="">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hober">
                    <thead>
                        <tr>
                            <td>Codigo</td>
                            <td>DPI</td>
                            <td>Nombre</td>
                            <td>Direccion</td>
                            <td>Estado</td>
                            <td>Acciones</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cliente" items="${clientes}">
                            <tr>
                                <td>${cliente.getCodigoCliente()}</td>
                                <td>${cliente.getDPICliente()}</td>
                                <td>${cliente.getNombresCliente()}</td>
                                <td>${cliente.getDireccionCliente()}</td>
                                <td>${cliente.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Clientes&accion=Editar&codigoCliente=${cliente.getCodigoCliente()}">Editar</a>
                                    <a class="btn btn-danger" onclick="return confirm('¿Quiere eliminar este registro?')" href="Controlador?menu=Clientes&accion=Eliminar&codigoCliente=${cliente.getCodigoCliente()}" >Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>            
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>














<! -- 



/*

drop database if exists DBJavaEEVentas_2022206;
create database DBJavaEEVentas_2022206;
Use DBJavaEEVentas_2022206;

Create table Cliente(
codigoCliente int not null auto_increment,
DPICliente varchar(15) not null,
nombresCliente varchar(200) not null,
direccionCliente varchar(150) not null,
estado varchar(1) not null,
primary key PK_codigoCliente (codigoCliente)
);

Create table Empleado(
codigoEmpleado int not null auto_increment,
DPIEmpleado varchar(15) not null,
nombresEmpleado varchar(200) not null,
telefonoEmpleado varchar(10) not null,
estado varchar(1) not null,
usuario varchar(15) not null,
primary key PK_codigoEmpleado (codigoEmpleado)
);

Create table Producto(
codigoProducto int not null auto_increment,
nombreProducto varchar(200) not null,
precio double not null,
stock int not null,
estado varchar(1) not null,
primary key PK_codigoProducto (codigoProducto)
);

create table Venta(
codigoVenta int not null auto_increment,
numeroSerie varchar(55) not null,
fechaVenta date not null,
monto double not null,
estado varchar(1) not null,
codigoCliente int not null,
codigoEmpleado int not null,
primary key PK_codigoVenta (codigoVenta),
constraint FK_Venta_Cliente foreign key(codigoCliente)
references Cliente(codigoCliente),
constraint FK_Venta_Empleado foreign key (CodigoEmpleado)
references Empleado(codigoEmpleado)
);

Create table DetalleVenta(
codigoDetalleVenta int not null auto_increment,

cantidad int not null,
precioVenta double not null,
codigoProducto int not null,
codigoVenta int not null,
primary key PK_codigoDetalleVenta (codigoDetalleVenta),
constraint FK_DetalleVenta_Producto foreign key (codigoProducto)
references Producto(codigoProducto),
constraint FK_DetalleVenta_Venta foreign key (codigoVenta)
references Venta(codigoVenta)
);


insert into Cliente (DPICliente, nombresCliente, direccionCliente, estado) values ('1579420230101', 'Pedro Armas', 'Mixco, Guatemala', '1');
insert into Cliente (DPICliente, nombresCliente, direccionCliente, estado) values ('1579123450108', 'Luis Olmedo', 'Guatemala, Guatemala', '1');
insert into Cliente (DPICliente, nombresCliente, direccionCliente, estado) values ('1579987450102', 'Jorge Tala', 'Sacatepequez, Guatemala', '1');
insert into Cliente (DPICliente, nombresCliente, direccionCliente, estado) values ('1579257410107', 'Mario Rodriguez', 'Villa Nueva, Guatemala', '1');

insert into Empleado (DPIEmpleado, nombresEmpleado, telefonoEmpleado, estado, usuario) values ('1579663520108', 'Pedro Hernandez', '54879632','1', 'phernandez01');
insert into Empleado (DPIEmpleado, nombresEmpleado, telefonoEmpleado, estado, usuario) values ('1579457820107', 'Rony Godinez', '43210509','1', 'rgod15');
insert into Empleado (DPIEmpleado, nombresEmpleado, telefonoEmpleado, estado, usuario) values ('1579558740106', 'Palermo Suarez', '24587963','1', 'psuarez25');
insert into Empleado (DPIEmpleado, nombresEmpleado, telefonoEmpleado, estado, usuario) values ('1579663520108', 'Luisa Aragon', '36251478','1', 'laragon40');

insert into Producto (nombreProducto, precio, stock, estado) values('Teclado Durabrand', 105.00,25,'1');
insert into Producto (nombreProducto, precio, stock, estado) values('Mouse inhalambrico Microfost', 74.50,15,'1');
insert into Producto (nombreProducto, precio, stock, estado) values('Laptop Acer Nitro 5', 9850.00,5,'1');
insert into Producto (nombreProducto, precio, stock, estado) values('Monitor Haier 32"', 1225.80,60,'1');

select * from Producto;




*/

-->



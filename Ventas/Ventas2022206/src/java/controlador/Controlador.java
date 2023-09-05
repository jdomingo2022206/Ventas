/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Venta;

/**
 *
 * @author informatica
 */
public class Controlador extends HttpServlet {
    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    
    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    
    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    
    Venta venta = new Venta();
    List <Venta> lista = new ArrayList<>();
    int item=0;
    int codPro, cantid;
    String descripcion;
    Double precio, subTotal, totalPagar;
    
    
    //Empleado home 
    Empleado empl = new Empleado();
    
    int codEmpleado;
    int codProducto;
    int codCliente;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }else if(menu.equals("Empleado")){
            switch(accion){
                case "listar":
                    List listaEmpleado = empleadoDAO.listar();
                    request.setAttribute("empleados", listaEmpleado);
                    break;
                case "Agregar":
                    String DPI = request.getParameter("txtDPIEmpleado");
                    String nombres = request.getParameter("txtNombreEmpleado");
                    String telefono = request.getParameter("txtTelefonoEmpleado");
                    String est = request.getParameter("txtEstadoEmpleado");
                    String user = request.getParameter("txtUsuarioEmpleado");
                    empleado.setDPIEmpleado(DPI);
                    empleado.setNombresEmpleado(nombres);
                    empleado.setTelefonoEmpleado(telefono);
                    empleado.setEstado(est);
                    empleado.setUsuario(user);
                    empleadoDAO.agregar(empleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=listar").forward(request, response);
                    break;
                case "Editar":
                    codEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    Empleado e = empleadoDAO.listarCodigoEmpleado(codEmpleado);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=listar").forward(request, response);
                    break;  
                case "Actualizar":
                    DPI = request.getParameter("txtDPIEmpleado");
                    nombres = request.getParameter("txtNombreEmpleado");
                    telefono = request.getParameter("txtTelefonoEmpleado");
                    est = request.getParameter("txtEstadoEmpleado");
                    user = request.getParameter("txtUsuarioEmpleado");
                    empleado.setCodigoEmpleado(codEmpleado);
                    empleado.setDPIEmpleado(DPI);
                    empleado.setNombresEmpleado(nombres);
                    empleado.setTelefonoEmpleado(telefono);
                    empleado.setEstado(est);
                    empleado.setUsuario(user);
                    empleadoDAO.actualizar(empleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=listar").forward(request, response);
                    break;
                    
                case "Eliminar":
                    codEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    empleadoDAO.eliminar(codEmpleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }else if(menu.equals("Producto")){
            switch(accion){
                        
                case "listar":
                    List listaProducto = productoDAO.listar();
                    System.out.println("size " + listaProducto.size());
                    request.setAttribute("productos", listaProducto);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtNombreProducto");
                    String precio = request.getParameter("txtPrecio");
                    String stock = request.getParameter("txtStock");
                    String est = request.getParameter("txtEstado");                    
                    producto.setNombreProducto(nombre);
                    producto.setPrecio(Double.parseDouble(precio));
                    producto.setStock(Integer.parseInt(stock));
                    producto.setEstado(est);
                    productoDAO.agregar(producto);                     
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=listar").forward(request, response);
                    break;
                case "Editar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    Producto p = productoDAO.listarCodigoProducto(codProducto);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=listar").forward(request, response);
                    break;
                
                case "Actualizar":
                    nombre = request.getParameter("txtNombreProducto");
                    precio = request.getParameter("txtPrecio");
                    stock = request.getParameter("txtStock");
                    est = request.getParameter("txtEstado");     
                    
                    producto.setCodigoProducto(codProducto);
                    producto.setNombreProducto(nombre);
                    producto.setPrecio(Double.parseDouble(precio));
                    producto.setStock(Integer.parseInt(stock));
                    producto.setEstado(est);
                    productoDAO.actualizar(producto);                     
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=listar").forward(request, response);
                    break;
                
                case "Eliminar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    productoDAO.eliminar(codProducto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=listar").forward(request, response);
                    break;
                }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }else if(menu.equals("Clientes")){
            switch(accion){
                    case "listar":
                        List listaCliente = clienteDAO.listar();
                        request.setAttribute("clientes", listaCliente);
                        break;
                        
                    case "Agregar":
                        String DPI = request.getParameter("txtDPICliente");
                        String nombres = request.getParameter("txtNombresCliente");
                        String direccion = request.getParameter("txtDireccionCliente");
                        String est = request.getParameter("txtEstado");
                        
                        cliente.setDPICliente(DPI);
                        cliente.setNombresCliente(nombres);
                        cliente.setDireccionCliente(direccion);
                        cliente.setEstado(est);
                        clienteDAO.agregar(cliente);
                        
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=listar").forward(request, response);
                        break;
                    case "Editar":
                        codCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                        Cliente c = clienteDAO.listarCodigoCliente(codCliente);
                        request.setAttribute("cliente", c);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=listar").forward(request, response);
                        break;
                    case "Actualizar":
                        
                        DPI = request.getParameter("txtDPICliente");
                        nombres = request.getParameter("txtNombresCliente");
                        direccion = request.getParameter("txtDireccionCliente");
                        est = request.getParameter("txtEstado");
                        
                        cliente.setCodigoCliente(codCliente);
                        cliente.setDPICliente(DPI);
                        cliente.setNombresCliente(nombres);
                        cliente.setDireccionCliente(direccion);
                        cliente.setEstado(est);
                        clienteDAO.actualizar(cliente);
                        
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=listar").forward(request, response);
                        break;
                    
                    case "Eliminar":
                        codCliente = Integer.parseInt(request.getParameter("codigoCliente"));
               
                        clienteDAO.eliminar(codCliente);
                        
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=listar").forward(request, response);
                        break;
                }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }else if(menu.equals("RegistrarVenta")){
            // request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            
            switch (accion) {
                case "BuscarCliente":
                    int id = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    cliente.setCodigoCliente(id);
                    cliente = clienteDAO.buscarCliente(id);
                    request.setAttribute("cliente", cliente);
                break;
                case "BuscarProducto":
                    int codProduc = Integer.parseInt(request.getParameter("txtCodigoProducto"));
                    producto.setCodigoProducto(codProduc);
                    producto = productoDAO.listarCodigoProducto(codProduc);
                    request.setAttribute("producto", producto);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("cliente", cliente);
//                    request.getRequestDispatcher("Controlador?menu=RegistrarVenta&accion=BuscarProducto").forward(request, response);
                    break;
                case "Agregar":
                    request.setAttribute("cliente", cliente);
                    totalPagar = 0.0;
                    item = item +1;
                    codPro = producto.getCodigoProducto();
                    descripcion = request.getParameter("txtNombreProducto");
                    precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    cantid = Integer.parseInt(request.getParameter("txtCantidad"));
                    subTotal = precio * cantid;
                    venta = new Venta();
                    venta.setItem(item);
                    venta.setCodigoProducto(codPro);
                    venta.setDescripcionProd(descripcion);
                    venta.setPrecio(precio);
                    venta.setCantidad(cantid);
                    venta.setSubTotal(subTotal);
                    lista.add(venta);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubTotal();
                        
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }else if(menu.equals("Home")){
            // Empleado empl = new Empleado ();
            // request.setAttribute("usuario", empl);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

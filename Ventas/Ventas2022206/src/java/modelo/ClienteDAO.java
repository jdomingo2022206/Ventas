
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    
    
    public List listar(){
        String sql = "Select * from cliente";
        List <Cliente> listaCliente = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setCodigoCliente(rs.getInt(1));
                cl.setDPICliente(rs.getString(2));
                cl.setNombresCliente(rs.getString(3));
                cl.setDireccionCliente(rs.getString(4));
                cl.setEstado(rs.getString(5));
                listaCliente.add(cl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaCliente;
    }
    
        public int agregar(Cliente cl){
            String sql = "insert into Cliente (DPICliente, nombresCliente, direccionCliente, estado) values (?, ?, ?, ?);";
            
            try{
                
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.setString(1, cl.getDPICliente());
                ps.setString(2, cl.getNombresCliente());
                ps.setString(3, cl.getDireccionCliente());
                ps.setString(4, cl.getEstado());
                ps.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("No se pudo establecer conexion");
            }
            return resp;
        }
    
        
        public Cliente listarCodigoCliente(int id){
            
            Cliente cl = new Cliente();
            String sql = "select * from cliente where codigoCliente = "+id;
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    cl.setCodigoCliente(rs.getInt(1));
                    cl.setDPICliente(rs.getString(2));
                    cl.setNombresCliente(rs.getString(3));
                    cl.setDireccionCliente(rs.getString(4));
                    cl.setEstado(rs.getString(5));
                    
                    
                }
                
            }catch(Exception e){
                e.printStackTrace();
                
            }
            return cl;
        }
    
        
        public int actualizar(Cliente cl){
            String sql = "update cliente set DPICliente = ?, nombresCliente = ?, direccionCliente = ?, estado = ? where codigoCliente = ?";
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.setString(1, cl.getDPICliente());
                ps.setString(2, cl.getNombresCliente());
                ps.setString(3, cl.getDireccionCliente());
                ps.setString(4, cl.getEstado());
                ps.setInt(5, cl.getCodigoCliente());
                ps.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
            }
            return resp;
        }

        
        public void eliminar(int id){
            String sql = "delete from cliente where codigoCliente ="+id;
            try{
                con=cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
        public Cliente buscarCliente(int codCl){
            
            Cliente cl = new Cliente();
            String sql = "select * from Cliente where codigoCliente= "+codCl;
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                //ps.setString(1, dpi);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    cl.setCodigoCliente(rs.getInt(1));
                    cl.setDPICliente(rs.getString(2));
                    cl.setNombresCliente(rs.getString(3));
                    cl.setDireccionCliente(rs.getString(4));
                    cl.setEstado(rs.getString(5));
                    
                    
                }
                
            }catch(Exception e){
                e.printStackTrace();
                
            }
            return cl;
        }
    
}


package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection conexion;
    
    public Connection Conexion(){
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBJavaEEVentas_2022206?useSSL=false", "quinto", "admin");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBJavaEEVentas_2022206?useSSL=false", "quinto", "admin");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo establecer la conexión");
        }
        
        return conexion;
    }
}


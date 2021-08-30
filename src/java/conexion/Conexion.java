/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ALUMNO
 */
public class Conexion {
    
    static String db = "dbbiblioteca";
    static String user = "root";
    static String pass = "root";
    static String url = "jdbc:mysql://localhost:3306/"+ db +"?autoReconnect=true&useSSL=false";
    
    Connection conn = null;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            
            if(conn != null){
                System.out.println("Conectado Correctamente");
            }
            
        }catch(Exception e){
            System.err.println(" ERROR conectandose " + e);
        }
    }
    
    
    public Connection Conectar (){
        return conn;
    }
    
    public void Desconectar () throws Exception{
        conn.close();
    }
    
    
    public static void main(String[] args) {
        Conexion c = new Conexion();
        
        c.Conectar();
        try{
            c.Desconectar();
        }catch(Exception e ){
            System.err.println("ERROR CONECTANDOSE " + e);
        }
        
    }
    
}

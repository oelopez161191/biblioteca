/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.text.html.HTMLDocument;
import modelo.Editorial;

public class EditorialDao {
    
    Conexion conn;
    
    public EditorialDao(Conexion conn){
        this.conn = conn;
    }
    
    public List<Editorial> mostrarTodo() throws SQLException{
        
        List<Editorial> editoriales = new LinkedList<>();
        Editorial editorial;
        
        String sql = "SELECT * FROM editorial";
        try{
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                editorial = new Editorial(rs.getInt("idEditorial"));
                editorial.setNombre(rs.getString("nombre_editorial"));
                editoriales.add(editorial);
                
            }
            
            return editoriales;
        }catch(Exception e ){
            System.err.println(" Excepcion " + e );
            return null;
        }
        
    }
    
}

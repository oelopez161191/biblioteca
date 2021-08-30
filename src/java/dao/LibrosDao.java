
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.Libros;

/**
 *
 * @author Oscar Ernesto Lopez
 */
public class LibrosDao {
    
    Conexion conn;
    
    public LibrosDao(Conexion conn){
        this.conn = conn;
    }
    
    public boolean insert(Libros libros){
        
        String sql = "INSERT INTO libros VALUES(?,?,?,?,?)";
        
        try{
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, libros.getIdLibros());
            ps.setString(2, libros.getNombreLibros());
            ps.setDate(3, libros.getFechaLanzamiento());
            ps.setInt(4,libros.getEditorial());
            ps.setString(5, libros.getCategoria());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    public List<Libros> mostrarTodosLibros() throws SQLException{
        
        List<Libros> libros = new LinkedList<>();
        Libros lib;
        
        String sql = "SELECT l.idLibros, l.nombre_libros, l.fecha_lanzamiento, e.nombre_editorial, l.categoria FROM libros l INNER JOIN editorial e WHERE e.idEditorial = l.cod_editorial";
        try{
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                lib = new Libros(rs.getInt("idLibros"));
                lib.setNombreLibros(rs.getString("nombre_libros"));
                lib.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));
                lib.setNombre_editorial(rs.getString("nombre_editorial"));
                lib.setCategoria(rs.getString("categoria"));
                libros.add(lib);
            }
            
            return libros;
        }catch(SQLException e ){
            System.err.println(" Excepcion " + e );
            return null;
        }
    }
    
    public List<Libros> mostrarPorId(int id) throws SQLException{
        String sql = "SELECT l.idLibros, l.nombre_libros, l.fecha_lanzamiento, l.cod_editorial, e.nombre_editorial, l.categoria FROM libros l INNER JOIN editorial e ON  l.cod_editorial = e.idEditorial WHERE idLibros = ?";
        
        try{
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Libros lib;
            List<Libros> lista = new LinkedList<>();
            while(rs.next()){
                lib = new Libros(rs.getInt("idLibros"));
                lib.setNombreLibros(rs.getString("nombre_libros"));
                lib.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));
                lib.setEditorial(rs.getInt("cod_editorial"));
                lib.setNombre_editorial(rs.getString("nombre_editorial"));
                lib.setCategoria(rs.getString("categoria"));
                lista.add(lib);
            }
            return lista;
        } catch(Exception e){
            return null;
        }
    }
}


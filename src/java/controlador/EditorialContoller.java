
package controlador;

import conexion.Conexion;
import dao.EditorialDao;
import dao.LibrosDao;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Editorial;
import modelo.Libros;

public class EditorialContoller {
    
        public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Conexion c = new Conexion();
        LibrosDao librod = new LibrosDao(c);
        EditorialDao editd = new EditorialDao(c);

        Libros libro = new Libros(0);
        
        System.out.println("");

    }

    public void ConsultarLibroPorID() {

        //PROBANDO SELECCIONAR POR ID
        Libros libro = new Libros(0);
        Conexion c = new Conexion();
        LibrosDao librod = new LibrosDao(c);
        Scanner scan = new Scanner(System.in);
        System.out.println("Indique el id del libro que desea consultar: ");
        libro.setIdLibros(scan.nextInt());
        System.out.println("INFORMACION DE LIBRO ID: " + libro.getIdLibros());

        try {
            for (Libros l : librod.mostrarPorId(libro.getIdLibros())) {
                System.out.println("Titulo: " + l.getNombreLibros());
                System.out.println("Fecha de lanzamiento" + l.getFechaLanzamiento());
                System.out.println("Codigo Editorial: " + l.getEditorial());
                System.out.println("Editorial: " + l.getNombre_editorial());
                System.out.println("Categoria: " + l.getCategoria());

            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ListarLibros() {
        //PROBANDO LISTAR
        Scanner scan = new Scanner(System.in);
        Conexion c = new Conexion();
        LibrosDao librod = new LibrosDao(c);
        EditorialDao editd = new EditorialDao(c);

        Libros libro = new Libros(0);
        try {
            for (Libros l : librod.mostrarTodosLibros()) {
                System.out.println(l.getIdLibros() + " | " + l.getNombreLibros() + " | " + l.getFechaLanzamiento() + " | " + l.getNombre_editorial() + " | " + l.getCategoria());
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void InsertarLibros(){
        Scanner scan = new Scanner(System.in);
        Conexion c = new Conexion();
        LibrosDao librod = new LibrosDao(c);
        EditorialDao editd = new EditorialDao(c);
        
        Libros libro = new Libros(0);
        
        //// PROBANDO INSERTAR
        
        libro.getIdLibros();
        
        System.out.println("Ingrese Nombre del libro: ");
        libro.setNombreLibros(scan.nextLine());
        
        System.out.println("Ingrese fecha de lanzamiento: (aaaa-mm-dd)");
        libro.setFechaLanzamiento(Date.valueOf(scan.nextLine()));
        
        System.out.println("Categoria del libro: ");
        libro.setCategoria(scan.nextLine());
        
        System.out.println("Ingrese codigo de editorial a la que pertenece: ");
        try {
            for(Editorial e: editd.mostrarTodo()){
                System.out.println(e.getId()+ " " + e.getNombre());
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        libro.setEditorial(scan.nextInt());
        
        boolean r = librod.insert(libro);
        
        if(r){
            System.out.println("Insertado correctamente");
        }else{
            System.err.println("Problemas al insertar");
        }
    }
    
    
}

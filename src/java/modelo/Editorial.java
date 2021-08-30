
package modelo;

import conexion.Conexion;

/**
 *
 * @author Oscar Lopez Suarez
 */
public class Editorial {

    public int id;
    public String nombre;
    
    public Editorial(int id){
        this.id = id;
        this.nombre = nombre;
    }

    public Editorial(Conexion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Editorial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

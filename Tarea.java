/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopo;
import java.util.*;

/**
 *
 * @author Pizza Dude
 */
public class Tarea implements java.io.Serializable{
    private int estado;
    private Map<String,Desarrollador> usuarios;
    private LiderProyecto lider;
    private String nombre;
    private String descripcion;
    
    public Tarea(int estado, LiderProyecto lider, String nombre, Map<String,Desarrollador> usuarios){
        this.estado = estado;
        this.lider = lider;
        this.nombre = nombre;
        
        //Se agrega la tarea en el campo de cada usuario al cual se le asigno
        usuarios.entrySet().forEach(usuario -> usuario.getValue().getTareas().put(this.nombre,this));
        
        
        this.usuarios = usuarios;
    }
    public Tarea(int estado, LiderProyecto lider, String nombre, String descripcion, Map<String,Desarrollador> usuarios){
        this.estado = estado;
        this.lider = lider;
        this.nombre = nombre;
        this.descripcion = descripcion;
        
        //Se agrega la tarea en el campo de cada usuario al cual se le asigno
        usuarios.entrySet().forEach(usuario -> usuario.getValue().getTareas().put(this.nombre,this));
        
        this.usuarios = usuarios;
    }
    public void setEstado(int estado){
        this.estado = estado;
    }
    public int getEstado(){
        return estado;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(String Descripcion){
        return descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setUsuarios(Map<String,Desarrollador> usuarios){
        this.usuarios = usuarios;
    }
    public Map<String,Desarrollador> getUsuarios(){
        return usuarios;
    }
}

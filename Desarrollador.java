/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;
import java.util.*;
/**
 *
 * @author essmo
 */
public class Desarrollador implements java.io.Serializable {
    private String usuario;
    private String password;
    private Map<String,Tarea> tareas;
    
    public Desarrollador(String usuario, String password){
        this.usuario = usuario;
        this.password = password;
        tareas = new HashMap<>();
    }
    public void setTarea(Tarea tarea){
        this.tareas.put(tarea.getNombre(), tarea);
        actualizarArchivo();
    }
    public void setTarea(Tarea tarea, String nombre){
        this.tareas.put(nombre, tarea);
        actualizarArchivo();
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
        actualizarArchivo();
    }
    public String getUsuario(){
        return usuario;
    }
    public void setPassword(String password){
        this.password = password;
        
        actualizarArchivo();
    }
    public String getPassword(){
        return password;
    }
    public Map getTareas(){
        return tareas;
    }
    
    private void actualizarArchivo(){
        Files f = new Files();
        Map<String,Desarrollador> bUsuarios = f.getMap("users.ser"); 
        
        bUsuarios.replace(usuario, this);
        
        f.saveMap("users.ser", bUsuarios);
    }
}

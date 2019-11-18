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
public class LiderProyecto extends Desarrollador{
    private Map<String,Tarea> tareasMonitoreadas;

    public LiderProyecto(String usuario, String password) {
        super(usuario, password);
        tareasMonitoreadas = new HashMap<String,Tarea>();        
    }
    /*public void crearTarea(int estado, String nombre, Desarrollador usuario){    
        Tarea tarea = new Tarea(estado,this,nombre,usuario);
        tareasMonitoreadas.put(nombre, tarea);
    }*/
    public Tarea crearTarea(String nombre, String descripcion){    
        Tarea tarea = new Tarea(nombre,descripcion);
        Files f = new Files();
        Map<String,Desarrollador> bUsuarios = f.getMap("users.ser");
        Desarrollador user = bUsuarios.get("Administrador");
        user.setTarea(tarea);
        //f.saveMap("users.ser", bUsuarios);
        return tarea;
    }
    public void eliminarTarea(String nombre){
        tareasMonitoreadas.remove(nombre);
    }
    public void asignarTarea(String desarrollador, Tarea tarea){
        Files f = new Files();
        Map<String,Desarrollador> bUsuarios = f.getMap("users.ser");
        Desarrollador user = bUsuarios.get(desarrollador);
        user.setTarea(tarea);
        //f.saveMap("users.ser", bUsuarios);
    }
    /*public HashMap getTareas(){
        Files f = new Files();
        Map<String,Desarrollador> bUsuarios = f.getMap("users.ser");
        LiderProyecto user = (LiderProyecto) bUsuarios.get("Administrador");
        return user.getTareas();
    }*/
}

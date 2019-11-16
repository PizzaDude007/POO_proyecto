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
public class LiderProyecto extends Desarrollador{
    private Map<String,Tarea> tareasMonitoreadas;

    public LiderProyecto(String usuario, char[] password) {
        super(usuario, password);
        Files f = new Files();
        //Se lee el archivo que guarda a la base de datos de los usuarios
        Map<String,Desarrollador> bUsuarios = f.getMap("usuarios.ser"); 
        
        if(!bUsuarios.containsKey(usuario)){
            tareasMonitoreadas = new HashMap<String,Tarea>();
            bUsuarios.put(usuario, this); //Si el usuario no existe lo crea
        }else{
            LiderProyecto hola = (LiderProyecto)bUsuarios.get(usuario); //Si ya existe carga sus tareas
        }
        
        //Se vuelve a guardar "usuarios" a un archivo
        f.saveMap("usuarios.ser", bUsuarios);
    }
    public void crearTarea(int estado, String nombre, Map<String,Desarrollador> usuarios){    
        Tarea tarea = new Tarea(estado,this,nombre,usuarios);
        tareasMonitoreadas.put(nombre, tarea);
    }
    public void crearTarea(int estado, String nombre, String descripcion, Map<String,Desarrollador> usuarios){    
        Tarea tarea = new Tarea(estado,this,nombre,descripcion,usuarios);
        tareasMonitoreadas.put(nombre, tarea);
    }
    public void eliminarTarea(String nombre){
        tareasMonitoreadas.remove(nombre);
    }
    public void setTarea(int estado, String lider, String nombreAct, String nombreNew, Map<String,Desarrollador> usuarios){
        Tarea tarea = tareasMonitoreadas.get(nombreAct);
        tarea.setEstado(estado);
        tarea.setNombre(nombreNew);
        tarea.setUsuarios(usuarios);
        tareasMonitoreadas.remove(nombreAct);
        tareasMonitoreadas.put(nombreNew, tarea);
    }
}

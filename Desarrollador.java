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
public class Desarrollador implements java.io.Serializable{
    private String usuario;
    private char[] password;
    private Map<String,Tarea> tareas = new HashMap<String,Tarea>();
    
    public Desarrollador(String usuario, char[] password){
        Files f = new Files();
        //Se lee el archivo que guarda a la base de datos de los usuarios
        Map<String,Desarrollador> bUsuarios = f.getMap("usuarios.ser"); 
        this.usuario = usuario;
        this.password = password;
        
        if(!bUsuarios.containsKey(usuario)){
            bUsuarios.put(usuario, this); //Si el usuario no existe lo crea
        }else{
            this.tareas = bUsuarios.get(usuario).tareas; //Si ya existe carga sus tareas
        }
        
        //Se vuelve a guardar "usuarios" a un archivo
        f.saveMap("usuarios.ser", bUsuarios); 
    }
    public void setEstado(int estado, String nombre){
        Tarea tarea = tareas.get(nombre);
        tarea.setEstado(estado);
        
        actualizarArchivo();
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
        
        actualizarArchivo();
    }
    public String getUsuaraio(){
        return usuario;
    }
    public void setPassword(char[] password){
        this.password = password;
        
        actualizarArchivo();
    }
    public char[] getPassword(){
        return password;
    }
    public Map getTareas(){
        return tareas;
    }
    
    private void actualizarArchivo(){
        Files f = new Files();
        Map<String,Desarrollador> bUsuarios = f.getMap("usuarios.ser"); 
        
        bUsuarios.replace(usuario, this);
        
        f.saveMap("usuarios.ser", bUsuarios);
    }
}

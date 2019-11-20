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
public class Tarea implements java.io.Serializable {
    private int estado=0;
    //String status;
    //private Desarrollador usuario;
    //private LiderProyecto lider;
    private String nombre;
    private String descripcion;
    
    /*public Tarea(int estado, LiderProyecto lider, String nombre, Desarrollador usuario){
        this.estado = estado;
        //this.lider = lider;
        this.nombre = nombre;
        this.usuario = usuario;
        this.usuario.setEstado(estado, nombre);
    }*/
    public Tarea(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        //this.usuario = usuario;
    }
    public void setEstado(int estado){
        this.estado = estado;
        if (estado == 3){
            String nombre = this.nombre;
            this.nombre += "(Entregada)";
            Files f = new Files();
            HashMap<String,Desarrollador> usuarios = f.getMap("users.ser");
            
            LiderProyecto admin = (LiderProyecto) usuarios.get("Administrador");
            admin.setTarea(this, nombre);
            usuarios.put("Administrador", admin);
            f.saveMap("users.ser", usuarios);
        }
    }
    public String getEstado(){
        if(estado==1){
            return "En progreso";
        }else if(estado==2){
            return "Terminada";
        }else if(estado==3){
            return "Entregada";
        }
        return "Pendiente";
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setDescripcion(String Descripcion){
       this.descripcion = Descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public String toString(){
        return this.nombre;
    }
    /*public void setUsuario(Desarrollador usuario){
        this.usuario = usuario;
    }*/
    /*public Desarrollador getUsuario(){
        return usuario;
    }*/
}
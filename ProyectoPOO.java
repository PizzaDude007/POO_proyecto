/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopo;

import java.util.*;
import javax.swing.JFrame;
/**
 *
 * @author Pizza Dude
 */
public class ProyectoPOO {
    public static void main(String[] args) {
        Map<String,Desarrollador> usuarios = new HashMap();
        Map<String,Tarea> tareas = new HashMap();
        Files f = new Files();
        
        f.saveMap("usuarios.ser", usuarios);
        
        LiderProyecto lider = new LiderProyecto("Juan",new char[]{1,2,3,4,5});
        Desarrollador d1 = new Desarrollador("Manuel",new char[]{1,2,3,4,5});
        
        usuarios.put("Juan", lider);
        usuarios.put("Manuel", d1);
        
        Iterator us = usuarios.entrySet().iterator();
        while(us.hasNext())
            System.out.println(us.next());
        
        Tarea t1 = new Tarea(1,lider,"Tarea 1","Descripcion ...",(HashMap)usuarios);
        
        f.saveMap("usuarios.ser", usuarios);
        
        
        Iterator it = f.getMap("usuarios.ser").entrySet().iterator();
        while(it.hasNext())
            System.out.println(it.next());
        
        
        
        //Interfaz aplicacion = new Interfaz();
        //System.out.println(aplicacion.getUsuario());
        //aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

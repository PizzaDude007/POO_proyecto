package proyectopo;

import java.util.*;

/**
 *
 * @author Pizza Dude
 */
public class Desarrollador {
    private String usuario;
    private char[] password;
    private Map<String,Tarea> tareas = new HashMap<String,Tarea>();
    
    public Desarrollador(String usuario, char[] password){
        this.usuario = usuario;
        this.password = password;
    }
    public void setEstado(int estado, String nombre){
        Tarea tarea = tareas.get(nombre);
        tarea.setEstado(estado);
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public String getUsuaraio(){
        return usuario;
    }
    public void setPassword(char[] password){
        this.password = password;
    }
    public char[] getPassword(){
        return password;
    }
}

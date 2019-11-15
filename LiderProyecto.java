package proyectopo;

import java.util.*;

/**
 *
 * @author Pizza Dude
 */
public class LiderProyecto extends Desarrollador{
    private Map<String,Tarea> tareasMonitoreadas = new HashMap();

    public LiderProyecto(String usuario, char[] password) {
        super(usuario, password);
    }
    public void crearTarea(int estado, String usuario, String nombre){    
        Tarea tarea = new Tarea(estado,usuario,usuario,nombre);
        tareasMonitoreadas.put(nombre, tarea);
    }
    public void eliminarTarea(String nombre){
        tareasMonitoreadas.remove(nombre);
    }
    public void setTarea(int estado, HashMap<Integer,String> usuarios, String nombreAct, String nombreNew){
        Tarea tarea = tareasMonitoreadas.get(nombreAct);
        tarea.setEstado(estado);
        tarea.setNombre(nombreNew);
        tarea.setUsuarios(usuarios);
        tareasMonitoreadas.remove(nombreAct);
        tareasMonitoreadas.put(nombreNew, tarea);
    }
}

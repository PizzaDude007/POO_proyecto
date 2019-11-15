package proyectopo;
import java.io.*;
import java.util.*;

/**
 *
 * @author Pizza Dude
 */
public class Files {
    public void saveMap(String nombre, HashMap hmap){
        try{
            FileOutputStream fOut = new FileOutputStream(nombre);
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            
            out.writeObject(hmap);
            
            out.close();
            fOut.close();
        }catch(IOException e){
            System.out.println("Error");
        }
    }
    public Map getMap(String nombre){
        Map map = null;
        try {
            FileInputStream fInput = new FileInputStream(nombre);
            ObjectInputStream input = new ObjectInputStream(fInput);
            
            map = (HashMap) input.readObject();
            
            input.close();
            fInput.close();
        } catch(Exception e){
            System.out.println("error");
            //pueden ir IOException y ClassNotFoundException
        }
        return map;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopo;
import java.io.*;
import java.util.*;

/**
 *
 * @author Pizza Dude
 */
public class Files {
    public void saveMap(String nombre, Map hmap){
        try{
            FileOutputStream fOut = new FileOutputStream(nombre);
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            
            out.writeObject(hmap);
            
            out.close();
            fOut.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    public HashMap getMap(String nombre){
        HashMap map = null;
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

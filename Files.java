/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.File;

/**
 *
 * @author essmo
 */
public class Files {
    Map<String, Desarrollador> usuarios = new HashMap<>();
    Map<String, Desarrollador> usuariosR = null;
    File file = new File("users.ser");
    public void registrar(Desarrollador usuario){
        if(!file.exists()){
            usuarios.put(usuario.getUsuario(), usuario);
            saveMap("users.ser",usuarios);
        }else{
            usuariosR = getMap("users.ser");
            usuariosR.put(usuario.getUsuario(), usuario);
            saveMap("users.ser", usuariosR);
        }
    }
    public boolean iniciarSesion(String usuario, String password){
        boolean i = false;
        if(file.exists()){
            usuariosR = getMap("users.ser");
            if(usuariosR.containsKey(usuario)){
                Desarrollador user = usuariosR.get(usuario);
                if(user.getPassword().equals(password)){
                    i = true;
                }
            }
        }
        return i;
    }
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

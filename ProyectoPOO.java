/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import javax.swing.JFrame;

/**
 *
 * @author osva_
 */
public class ProyectoPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interfaz aplicacion = new Interfaz();
        System.out.println(aplicacion.getUsuario());
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

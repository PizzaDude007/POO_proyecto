/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Pizza Dude
 */
public class Interfaz extends JFrame{
    private JButton ingresar;
        private JLabel letrero,usu,con;
        private JTextField usuario;
        private JPasswordField contra;
        public String textUs,textCo;
	// Configurar la GUI
	public Interfaz(){
            super ( "Inicio de Sesion" );
            setLayout(null);
            // Obtener panel de contenido
            Container contenedor = getContentPane();
            contenedor.setLayout( new FlowLayout() );
            //Letrero
            letrero = new JLabel("BIENVENIDO",SwingConstants.CENTER);
            letrero.setBounds(10,10,130,130);
            usu = new JLabel("Usuario",SwingConstants.CENTER);
            con = new JLabel("Contraseña",SwingConstants.CENTER);

            //Texto
            usuario = new JTextField(30);
            contra = new JPasswordField(30);

            //Boton
            ingresar = new JButton( "INGRESAR");

            // Manejo de eventos de botones
            ManejadorBoton manejador = new ManejadorBoton();
            ingresar.addActionListener( manejador );
            contenedor.add(letrero);
            contenedor.add(usu);
            contenedor.add(con);
            contenedor.add(usuario);
            contenedor.add(contra);
            contenedor.add(ingresar);


            setLocation(150,100);
            setSize(1000, 500);
            setVisible(true);
	}	


	// Clase interna para eventos de boton
	private class ManejadorBoton implements ActionListener{
            // manejar evento de boton
            public void actionPerformed(ActionEvent evento){
                //JOptionPane.showMessageDialog(Interfaz.this, "Usted oprimio: " + evento.getActionCommand());
                String textUs = usuario.getText();
                String textCo = new String(contra.getPassword());    
                JOptionPane.showMessageDialog(Interfaz.this, "Usuario: " + textUs+"Contra :"+textCo);
            }       
	}
        
        public String getUsuario(){
            return textUs;
        }
}

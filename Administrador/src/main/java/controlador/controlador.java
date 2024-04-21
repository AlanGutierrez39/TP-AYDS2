/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Administrador;
import vista.IVista;
import vista.Ventana_Estadisticas;

/**
 *
 * @author ignacio
 */
public class controlador implements ActionListener{
 
    private IVista vista;
    Administrador admin;
    
    
    public controlador(Administrador adm){
        this.admin=adm;
        vista=new Ventana_Estadisticas();
       
        vista.setActionListener(this);
        vista.setKeyListener();
    }
    
    public void ejecutar(){
        vista.ejecutar();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()) {
            case "SALIR":
                vista.cerrarVentana();
            break;
  
        }
    }
}

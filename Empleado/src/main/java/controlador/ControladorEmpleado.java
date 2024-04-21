/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Empleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.IVista;
import vista.Ventana_Operador;

/**
 *
 * @author ignacio
 */
public class ControladorEmpleado implements ActionListener{
    private IVista vista;
    Empleado empleado;
    
    
    public ControladorEmpleado(Empleado empleado){
        this.empleado=empleado;
        vista=new Ventana_Operador();
       
        vista.setActionListener(this);
        vista.setKeyListener();
    }
    
    public void ejecutar(){
        vista.ejecutar();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()) {
            case "LLAMAR":
                empleado.ingresa();
            break;
            case "SALIR":
                vista.cerrarVentana();
            break;
  
        }
    }
}

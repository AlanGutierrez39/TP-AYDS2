/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Empleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.DefaultListModel;

import vista.IVista;
import vista.Ventana_Operador;

/**
 *
 * @author ignacio
 */
public class ControladorEmpleado implements ActionListener, Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
        this.empleado.ingresa();
        this.cargarDNIEnPantalla();
    }
    
    public void cargarDNIEnPantalla() {
    	DefaultListModel<String> listModel = new DefaultListModel<String>();
    	for(int i=0; i<this.empleado.getDnis().size(); i++) {
    	    listModel.addElement(this.empleado.getDnis().get(i));
    	}
	    System.out.println(this.empleado.getDnis());
	    System.out.println(listModel);
    	//Asociar el modelo de lista al JList
    	this.vista.getjList1().setModel(listModel);
	}
    
    @Override
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()) {
            case "LLAMAR":
                empleado.ingresa();
                this.cargarDNIEnPantalla();
            break;
            case "SALIR":
                vista.cerrarVentana();
            break;
  
        }
    }
}

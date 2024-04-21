/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mycompany.televisor.Televisor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import vista.IVista;
import vista.Ivista_turnos;
import vista.Ventana_Turnos;

/**
 *
 * @author ignacio
 */
public class ControladorTelevisor implements ActionListener{
    private Ivista_turnos vista;
    Televisor televisor;
    
    
    public ControladorTelevisor(Televisor televisor){
        this.televisor=televisor;
        this.vista=new Ventana_Turnos();
       
        this.vista.setActionListener(this);
        this.vista.setKeyListener();
    }
    
    public void ejecutar(){
        this.vista.ejecutar();
        televisor.comienza();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
    
    public void Actualiza(ArrayList<String> dnis,ArrayList<String> boxes){
        vista.actualiza(dnis, boxes);
    }
}

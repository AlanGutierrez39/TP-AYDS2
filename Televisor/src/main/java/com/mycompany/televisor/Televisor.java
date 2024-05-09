/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.televisor;

import controlador.ControladorTelevisor;
import modelo.Empleado;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author ignacio
 */
public class Televisor implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = -8432622592732844803L;
	private ArrayList<String> dnis=new ArrayList<String>();
	private ArrayList<String> boxes=new ArrayList<String>();
   private transient BufferedReader entrada;
   private transient BufferedWriter salida;
   private transient SocketTelevisor nuevo;
   private final int MAX_REINTENTOS = 4;
   
   public Televisor() {
	super();
   }

   public Televisor(SocketTelevisor nuevo){
        this.nuevo = nuevo;
    
    }

    public void iniciar() {
        ControladorTelevisor controladorTelevisor=new ControladorTelevisor(this);
        this.nuevo = new SocketTelevisor(controladorTelevisor);
        controladorTelevisor.ejecutar();
    }
    
    public void comienza(int i){
    	try {
			System.out.println("pre envio televisor");
			nuevo.envio(this, "Televisor");
			System.out.println("post envio televisor");
		} catch (Exception e) {
			// maneja la excepción
			System.err.println("No se pudo conectar. Reintentando…");    // registrar la excepción
        	//JOptionPane.showMessageDialog(null, "No se pudo conectar. Reintentando…");
            // dormir el thread durante 5 segundos antes de volver a intentarlo
            try {
				Thread.sleep(5000);
				i++;
				if (i == MAX_REINTENTOS) {
					System.err.println("No se pudo conectar.");
					//JOptionPane.showMessageDialog(null, "No se pudo conectar.");
				}
				else
					comienza(i);
			} catch (InterruptedException e1) {
				if (i == MAX_REINTENTOS) {
					System.err.println("No se pudo conectar.");
					//JOptionPane.showMessageDialog(null, "No se pudo conectar.");
				}
            }
		}
    }
    
	public ArrayList<String> getDnis() {
		return dnis;
	}

	public void setDnis(ArrayList<String> dnis) {
		this.dnis = dnis;
	}

	public BufferedReader getEntrada() {
		return entrada;
	}

	public void setEntrada(BufferedReader entrada) {
		this.entrada = entrada;
	}

	public BufferedWriter getSalida() {
		return salida;
	}

	public void setSalida(BufferedWriter salida) {
		this.salida = salida;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SocketTelevisor getNuevo() {
		return nuevo;
	}

	public void setNuevo(SocketTelevisor nuevo) {
		this.nuevo = nuevo;
	}

	public ArrayList<String> getBoxes() {
		return boxes;
	}

	public void setBoxes(ArrayList<String> boxes) {
		this.boxes = boxes;
	}
	
}

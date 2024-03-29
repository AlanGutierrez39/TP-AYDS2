package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class VentanaIngresoDeDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnBorrar;
	private JButton btnAceptar;
	private JPanel panel_3;
	private JLabel lblBienvenida;
	private JPanel panel_4;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngresoDeDatos frame = new VentanaIngresoDeDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaIngresoDeDatos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 640);//setBounds(100, 100, 1080, 1920);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel);
		this.panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panel_1 = new JPanel();
		this.panel.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_3 = new JPanel();
		this.panel_1.add(this.panel_3);
		
		this.lblBienvenida = new JLabel("¡Bienvenido! Ingrese su DNI");
		this.panel_3.add(this.lblBienvenida);
		
		this.panel_4 = new JPanel();
		this.panel_1.add(this.panel_4);
		
		this.textField = new JTextField();
		this.textField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		this.textField.setEditable(false);
		this.textField.setColumns(10);
		this.panel_4.add(this.textField);
		
		this.panel_2 = new JPanel();
		this.panel.add(this.panel_2);
		this.panel_2.setLayout(new GridLayout(4, 3, 0, 0));
		
		this.btn1 = new JButton("1");
		this.panel_2.add(this.btn1);
		
		this.btn2 = new JButton("2");
		this.panel_2.add(this.btn2);
		
		this.btn3 = new JButton("3");
		this.panel_2.add(this.btn3);
		
		this.btn4 = new JButton("4");
		this.panel_2.add(this.btn4);
		
		this.btn5 = new JButton("5");
		this.panel_2.add(this.btn5);
		
		this.btn6 = new JButton("6");
		this.panel_2.add(this.btn6);
		
		this.btn7 = new JButton("7");
		this.panel_2.add(this.btn7);
		
		this.btn8 = new JButton("8");
		this.panel_2.add(this.btn8);
		
		this.btn9 = new JButton("9");
		this.panel_2.add(this.btn9);
		
		this.btnBorrar = new JButton("BORRAR");
		this.panel_2.add(this.btnBorrar);
		
		this.btn0 = new JButton("0");
		this.panel_2.add(this.btn0);
		
		this.btnAceptar = new JButton("ACEPTAR");
		this.panel_2.add(this.btnAceptar);
	}

}

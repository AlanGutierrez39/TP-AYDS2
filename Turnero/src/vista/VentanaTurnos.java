package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class VentanaTurnos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_publicidad;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTurnos frame = new VentanaTurnos();
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
	public VentanaTurnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);//setBounds(100, 100, 1920, 1080);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.lblNewLabel = new JLabel("TURNO");
		this.panel.add(this.lblNewLabel);
		
		this.lblNewLabel_1 = new JLabel("PUESTO");
		this.panel.add(this.lblNewLabel_1);
		
		this.lblNewLabel_2 = new JLabel("11111111");
		this.panel.add(this.lblNewLabel_2);
		
		this.lblNewLabel_3 = new JLabel("1");
		this.panel.add(this.lblNewLabel_3);
		
		this.lblNewLabel_4 = new JLabel("22222222");
		this.panel.add(this.lblNewLabel_4);
		
		this.lblNewLabel_5 = new JLabel("2");
		this.panel.add(this.lblNewLabel_5);
		
		this.lblNewLabel_6 = new JLabel("33333333");
		this.panel.add(this.lblNewLabel_6);
		
		this.lblNewLabel_7 = new JLabel("3");
		this.panel.add(this.lblNewLabel_7);
		
		this.lblNewLabel_8 = new JLabel("44444444");
		this.panel.add(this.lblNewLabel_8);
		
		this.lblNewLabel_9 = new JLabel("4");
		this.panel.add(this.lblNewLabel_9);
		
		this.lblNewLabel_10 = new JLabel("55555555");
		this.panel.add(this.lblNewLabel_10);
		
		this.lblNewLabel_11 = new JLabel("5");
		this.panel.add(this.lblNewLabel_11);
		
		this.panel_publicidad = new JPanel();
		this.contentPane.add(this.panel_publicidad, BorderLayout.WEST);
	}

}

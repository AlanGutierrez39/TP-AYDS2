package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

public class VentanaPuesto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPuesto frame = new VentanaPuesto();
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
	public VentanaPuesto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		
		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1, BorderLayout.EAST);
		this.panel_1.setLayout(new GridLayout(4, 0, 0, 0));
		
		this.panel_2 = new JPanel();
		this.panel_1.add(this.panel_2);
		
		this.btnNewButton = new JButton("New button");
		this.panel_2.add(this.btnNewButton);
		
		this.panel_3 = new JPanel();
		this.panel_1.add(this.panel_3);
		
		this.btnNewButton_1 = new JButton("New button");
		this.panel_3.add(this.btnNewButton_1);
		
		this.panel_4 = new JPanel();
		this.panel_1.add(this.panel_4);
		
		this.btnNewButton_2 = new JButton("New button");
		this.panel_4.add(this.btnNewButton_2);
		
		this.panel_5 = new JPanel();
		this.panel_1.add(this.panel_5);
		
		this.btnNewButton_3 = new JButton("New button");
		this.panel_5.add(this.btnNewButton_3);
	}

}

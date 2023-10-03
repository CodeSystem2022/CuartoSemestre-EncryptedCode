package utn.tienda_libros.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utn.tienda_libros.servicios.LibroServicio;

public class LibroForm extends JFrame {
	
	LibroServicio libroServicio;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	@Autowired
	public libroForm(libroServicio libroServicio) {
		this.libroServicio = libroServicio;
		iniciarForma();
	}
	
	private void iniciarForma() {
		setContentPane(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(900, 700);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibroForm frame = new LibroForm();
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
	public LibroForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}

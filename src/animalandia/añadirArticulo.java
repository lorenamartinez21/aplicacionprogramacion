package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class añadirArticulo extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField cantidad;
	private JTextField precio;

	
	public añadirArticulo(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		/*creamos un boton desplegable para elegir el 
		tipo del articulo que vamos a crear*/
		
		JComboBox tipo = new JComboBox();
		tipo.setForeground(new Color(255, 0, 255));
		tipo.addItem("comida");
		tipo.addItem("juguetes y premios");
		tipo.addItem("animales");
		tipo.setBounds(301, 69, 123, 20);
		panel.add(tipo);
		
		//creamos los textos NO modificables correspondientes
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 44, 46, 14);
		panel.add(lblNombre);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(103, 44, 68, 14);
		panel.add(lblCantidad);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(197, 44, 46, 14);
		panel.add(lblPrecio);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(303, 44, 46, 14);
		panel.add(lblTipo);
		
		//creamos los paneles de texto para rellenar los datos correspondientes
		
		nombre = new JTextField();
		nombre.setBounds(13, 69, 86, 20);
		panel.add(nombre);
		nombre.setColumns(10);

		cantidad = new JTextField();
		cantidad.setBounds(103, 69, 86, 20);
		panel.add(cantidad);
		cantidad.setColumns(10);

		precio = new JTextField();
		precio.setBounds(198, 69, 86, 20);
		panel.add(precio);
		precio.setColumns(10);
		
		//añadimos nuestro boton de volver
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 0, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal o = new principal(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(10, 11, 89, 23);
		panel.add(btnVolver);
		
		//creamos el boton de añadir
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setForeground(new Color(255, 0, 255));
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Tipo = (String) tipo.getSelectedItem();
				
				//y con esta sentencia completamos la accion para añadir el articulo
				
				try {
					conexion.EjecutarUpdate(
							"INSERT INTO `artículos`(`tipo`, `id`, `nombre`, `cantidad`, `precio`) VALUES ('" + Tipo
									+ "',null,'" + nombre.getText() + "','" + cantidad.getText() + "','"
									+ precio.getText() + "')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "El artículo se ha añadido correctamente ");
			}
		});
		btnAadir.setBounds(325, 217, 89, 23);
		panel.add(btnAadir);
	}
}

package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class añadirArticulo extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField cantidad;
	private JTextField precio;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public añadirArticulo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JComboBox tipo = new JComboBox();
		tipo.addItem("comida");
		tipo.addItem("juguetes y premios");
		tipo.addItem("animales");
		tipo.setBounds(301, 38, 113, 20);
		panel.add(tipo);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		panel.add(lblNombre);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(102, 11, 46, 14);
		panel.add(lblCantidad);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(198, 11, 46, 14);
		panel.add(lblPrecio);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(301, 13, 46, 14);
		panel.add(lblTipo);

		nombre = new JTextField();
		nombre.setBounds(10, 38, 86, 20);
		panel.add(nombre);
		nombre.setColumns(10);

		cantidad = new JTextField();
		cantidad.setBounds(102, 38, 86, 20);
		panel.add(cantidad);
		cantidad.setColumns(10);

		precio = new JTextField();
		precio.setBounds(198, 38, 86, 20);
		panel.add(precio);
		precio.setColumns(10);

		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Tipo = (String) tipo.getSelectedItem();
				try {
					conexion.EjecutarUpdate(
							"INSERT INTO `artículos`(`tipo`, `id`, `nombre`, `cantidad`, `precio`) VALUES ('" + Tipo
									+ "',null,'" + nombre.getText() + "','" + cantidad.getText() + "','"
									+ precio.getText() + "')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAadir.setBounds(325, 217, 89, 23);
		panel.add(btnAadir);
	}
}

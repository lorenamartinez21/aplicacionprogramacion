package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class editando extends JFrame {

	private JPanel contentPane;
	private JTextField precio;
	private JTextField cantidad;
	private JTextField nombre;

	public editando(String Articulo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(20, 22, 46, 14);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Cantidad");
		label_2.setBounds(112, 22, 46, 14);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Precio");
		label_3.setBounds(208, 22, 46, 14);
		panel.add(label_3);

		JLabel label_4 = new JLabel("Tipo");
		label_4.setBounds(311, 24, 46, 14);
		panel.add(label_4);

		JComboBox tipo = new JComboBox();
		tipo.addItem("comida");
		tipo.addItem("juguetes y premios");
		tipo.addItem("animales");
		tipo.setBounds(311, 49, 113, 20);
		panel.add(tipo);

		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(208, 49, 86, 20);
		panel.add(precio);

		cantidad = new JTextField();
		cantidad.setColumns(10);
		cantidad.setBounds(112, 49, 86, 20);
		panel.add(cantidad);

		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(20, 49, 86, 20);
		panel.add(nombre);

		JButton button = new JButton("Editar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Tipo = (String) tipo.getSelectedItem();
				try {
					conexion.EjecutarUpdate("UPDATE `artículos` SET `tipo`='" + tipo + "',`nombre`='" + nombre.getText()
							+ "',`cantidad`='" + cantidad.getText() + "',`precio`='" + precio.getText() + "' WHERE "
							+"nombre='"+Articulo+"'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(335, 228, 89, 23);
		panel.add(button);
	}
}

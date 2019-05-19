package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class editando extends JFrame {

	private JPanel contentPane;
	private JTextField precio;
	private JTextField cantidad;
	private JTextField nombre;

	public editando(String Articulo, String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 0, 255));
		panel.setBackground(new Color(255, 228, 196));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//creamos los textos NO editables correspondientes
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(20, 45, 46, 14);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Cantidad");
		label_2.setBounds(115, 45, 68, 14);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Precio");
		label_3.setBounds(209, 45, 46, 14);
		panel.add(label_3);

		JLabel label_4 = new JLabel("Tipo");
		label_4.setBounds(317, 45, 46, 14);
		panel.add(label_4);
		
		//creamos un boton desplegable con los tres tipos de articulos a elegir
		
		JComboBox tipo = new JComboBox();
		tipo.setModel(new DefaultComboBoxModel(new String[] {"comida", "juguetes y premios", "animales"}));
		tipo.setForeground(new Color(255, 0, 255));
		tipo.addItem("comida");
		tipo.addItem("juguetes y premios");
		tipo.addItem("animales");
		tipo.setBounds(311, 68, 113, 20);
		panel.add(tipo);
		
		//creamos los textos correspondientes
		
		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(208, 68, 86, 20);
		panel.add(precio);

		cantidad = new JTextField();
		cantidad.setColumns(10);
		cantidad.setBounds(112, 68, 86, 20);
		panel.add(cantidad);

		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(20, 68, 86, 20);
		panel.add(nombre);
		
		//añadimos nuestro boton de volver
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 0, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarArticulo o;
				try {
					o = new editarArticulo(usuario);
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnVolver.setBounds(10, 11, 89, 23);
		panel.add(btnVolver);
		
		/*aqui creamos el boton de editar, que al pulsarlo nos modificara el 
		articulo que hayamos elegido de la base de datos*/
		
		JButton button = new JButton("Editar");
		button.setForeground(new Color(255, 0, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Tipo = (String) tipo.getSelectedItem();
				try {
					//aqui ponemos la sentencia para modificarlo
					
					conexion.EjecutarUpdate("UPDATE `artículos` SET `tipo`='" + Tipo + "',`nombre`='" + nombre.getText()
							+ "',`cantidad`='" + cantidad.getText() + "',`precio`='" + precio.getText()
							+ "' WHERE `nombre`='" + Articulo + "'");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "El artículo se ha modificado correctamente ");
			}
		});
		button.setBounds(317, 217, 89, 23);
		panel.add(button);
	}
}

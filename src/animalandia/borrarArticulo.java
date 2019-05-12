package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class borrarArticulo extends JFrame {

	private JPanel contentPane;

	
	public borrarArticulo() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Art\u00EDculos:");
		label.setBounds(74, 98, 46, 14);
		contentPane.add(label);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(130, 95, 102, 20);
		String[] articulos=eliminar.eliminar();
		for (int i = 0; i < articulos.length; i++) {
			comboBox.addItem(articulos[i]);
		
		}
		contentPane.add(comboBox);
		JButton btnEliminar = new JButton("Eliminar");
		
		btnEliminar.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				String Articulo = (String) comboBox.getSelectedItem();
				try {
					conexion.EjecutarUpdate(
							"DELETE * FROM `artículos` WHERE nombre='"+Articulo+"'");
					JOptionPane.showMessageDialog(null, "Se ha borrado "+ Articulo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	
			
		});
		btnEliminar.setBounds(250, 94, 89, 23);
		contentPane.add(btnEliminar);
	}
	}


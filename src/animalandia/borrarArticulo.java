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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class borrarArticulo extends JFrame {

	private JPanel contentPane;

	
	public borrarArticulo(String usuario) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setForeground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Art\u00EDculos:");
		label.setBounds(56, 98, 64, 14);
		contentPane.add(label);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 11, 89, 23);
		btnVolver.setForeground(new Color(0, 0, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal o = new principal(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		contentPane.add(btnVolver);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(130, 95, 136, 20);
		comboBox.setForeground(new Color(255, 0, 255));
		String[] articulos=eliminar.eliminar();
		for (int i = 0; i < articulos.length; i++) {
			comboBox.addItem(articulos[i]);
		
		}
		contentPane.add(comboBox);
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(276, 94, 89, 23);
		btnEliminar.setForeground(new Color(255, 0, 255));
		
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
				JOptionPane.showMessageDialog(null, "El artículo se ha eliminado correctamente ");
			}
	
			
		});
		contentPane.add(btnEliminar);
	}
	}


package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class editarArticulo extends JFrame {

	private JPanel contentPane;

	public editarArticulo(String usuario) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEditar = new JLabel("Art\u00EDculos:");
		lblEditar.setBounds(38, 93, 76, 14);
		panel.add(lblEditar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 0, 255));
		comboBox.setBounds(124, 90, 161, 20);
		String[] articulos=editar.editar();
		for (int i = 0; i < articulos.length; i++) {
			comboBox.addItem(articulos[i]);
		}
		panel.add(comboBox);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(255, 0, 255));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Articulo = (String) comboBox.getSelectedItem();
				editando o = new editando(Articulo, usuario);
				dispose();
				o.setVisible(true);
			}
		});
		
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
		
		btnEditar.setBounds(295, 89, 89, 23);
		panel.add(btnEditar);
	}
}

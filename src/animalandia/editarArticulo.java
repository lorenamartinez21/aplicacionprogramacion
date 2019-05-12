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

public class editarArticulo extends JFrame {

	private JPanel contentPane;

	public editarArticulo() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEditar = new JLabel("Art\u00EDculos:");
		lblEditar.setBounds(68, 93, 46, 14);
		panel.add(lblEditar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, 90, 102, 20);
		String[] articulos=editar.editar();
		for (int i = 0; i < articulos.length; i++) {
			comboBox.addItem(articulos[i]);
		}
		panel.add(comboBox);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Articulo = (String) comboBox.getSelectedItem();
				editando o = new editando(Articulo);
				dispose();
				o.setVisible(true);
			}
		});
		btnEditar.setBounds(240, 89, 89, 23);
		panel.add(btnEditar);
	}
}

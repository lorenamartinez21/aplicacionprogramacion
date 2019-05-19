package animalandia;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTabbedPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Color;

public class comida extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public comida(String usuario) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//le damos formato a la tabla
		table = new JTable();
		table.setEnabled(false);
		table.setBackground(new Color(255, 228, 196));
		table.setBounds(0, 51, 435, 62);
		panel.add(table);
		
		//añadimos la informacion de la base de datos igual que en la tabla animales
		
		Object[][] datos = new Object[0][0];
		String[] titulo = {"nombre", "cantidad", "precio"};
		DefaultTableModel comida = new DefaultTableModel(datos,titulo);
		table.setModel(comida);
		JTable tabla =new JTable(comida);

		
		String consulta = "Select nombre, cantidad, precio from artículos where tipo=?";
		PreparedStatement sentencia = (PreparedStatement) conexion.conexionBBDD().prepareStatement (consulta);
		sentencia.setString(1, "comida");
		ResultSet rs = sentencia.executeQuery();
		try {
			while (rs.next()) {
			String [] comidas = new String[3];
			for (int i = 0; i<3; i++) {
				comidas[i] = rs.getString(i+1);
			}
		
		
			comida.addRow(comidas);
			panel.add(table);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(table);
		
		//añadimos el boton de volver a la anterior
		
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
		
		//añadimos su correspondiente scroll
		
		JScrollPane scrollPane = new JScrollPane(table);
		 scrollPane.setBounds(0, 74, 424, 81);
		 panel.add(scrollPane);
		 scrollPane.setEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);
	}

}
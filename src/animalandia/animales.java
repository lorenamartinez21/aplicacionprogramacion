package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class animales extends JFrame {

	private JPanel contentPane;

	private JTable table;

	
	
	public animales(String usuario)  throws SQLException {
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
		
		
		
		Object[][] datos = new Object[0][0];
		String[] titulo = {"nombre", "cantidad", "precio"};
		DefaultTableModel animales = new DefaultTableModel(datos,titulo);
	
		
		
		
		
		String consulta = "Select nombre, cantidad, precio from artículos where tipo=?";
		PreparedStatement sentencia = (PreparedStatement) conexion.conexionBBDD().prepareStatement (consulta);
		sentencia.setString(1, "animales");
		ResultSet rs = sentencia.executeQuery();
		try {
			while (rs.next()) {
			String [] animal = new String[3];
			for (int i = 0; i<3; i++) {
				animal[i] = rs.getString(i+1);
			}
		
			
			animales.addRow(animal);
			//panel.add(table);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    table = new JTable();
	    panel.add(table);
	    table.setEnabled(false);
	    table.setBackground(new Color(255, 228, 196));
	    

	    table.setBounds(0, 56, 100, 144);
	    table.setModel(animales);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 0, 255));
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal o = new principal(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(10, 11, 89, 23);
		panel.add(btnVolver);
		
		 //add(scrollPane);
		 JScrollPane scrollPane = new JScrollPane(table);
		 scrollPane.setBounds(0, 65, 424, 83);
		 panel.add(scrollPane);
		 scrollPane.setEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);
	
		
		//panel.add(table);
	}
	
}

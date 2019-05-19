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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;

public class juguetes extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public juguetes(String usuario) throws SQLException {
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
		table.setBounds(0, 50, 435, 64);
		panel.add(table);
		
		/*ponemos sus titulos y le damos los datos de la base de datos, 
		como en las otras dos tablas*/
		
		Object[][] datos = new Object[0][0];
		String[] titulo = {"nombre", "cantidad", "precio"};
		DefaultTableModel juguetes = new DefaultTableModel(datos,titulo);
		table.setModel(juguetes);
		JTable tabla =new JTable(juguetes);
		
		String consulta = "Select nombre, cantidad, precio from artículos where tipo=?";
		PreparedStatement sentencia = (PreparedStatement) conexion.conexionBBDD().prepareStatement (consulta);
		sentencia.setString(1, "juguetes y premios");
		ResultSet rs = sentencia.executeQuery();
		try {
			while (rs.next()) {
				
			String [] juguete = new String[3];
			for (int i = 0; i<3; i++) {
				juguete[i] = rs.getString(i+1);
			}
		
			
			juguetes.addRow(juguete);
			panel.add(table);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(table);
		
		//añadimos el boton de volver a la anterior ventana
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 0, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal o = new principal(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(10, 11, 106, 23);
		panel.add(btnVolver);
		
		//añadimos a la tabla el scroll
		
		JScrollPane scrollPane = new JScrollPane(table);
		 scrollPane.setBounds(0, 65, 424, 86);
		 panel.add(scrollPane);
		 scrollPane.setEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);
	}
	}



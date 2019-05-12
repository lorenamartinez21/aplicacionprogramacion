package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

public class juguetes extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public juguetes() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 24, 425, 256);
		panel.add(table);
		
		Object[][] datos = new Object[0][0];
		String[] titulo = {"nombre", "cantidad", "precio"};
		DefaultTableModel juguetes = new DefaultTableModel(datos,titulo);
		table.setModel(juguetes);
		JTable tabla =new JTable(juguetes);
		
		String consulta = "Select nombre, cantidad, precio from art�culos where tipo=?";
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
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(60, -1, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(200, -1, 70, 14);
		panel.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("precio");
		lblPrecio.setBounds(340, -1, 46, 14);
		panel.add(lblPrecio);
		
		
		
	}
	private static void addColumn(String string) {
		// TODO Auto-generated method stub
		
	}
	}


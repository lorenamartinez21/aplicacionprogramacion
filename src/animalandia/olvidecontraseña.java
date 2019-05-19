package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class olvidecontraseña extends JFrame {

	private JPanel contentPane;

	public olvidecontraseña() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ponemos el texto "correo de recuperacion"
		
		JTextPane txtpnCorreoDeRecuperacin = new JTextPane();
		txtpnCorreoDeRecuperacin.setEditable(false);
		txtpnCorreoDeRecuperacin.setBackground(new Color(176, 224, 230));
		txtpnCorreoDeRecuperacin.setBounds(24, 116, 138, 20);
		txtpnCorreoDeRecuperacin.setText("Correo de recuperaci\u00F3n");
		contentPane.add(txtpnCorreoDeRecuperacin);
		
		//aqui escribiriamos ese correo
		
		JTextPane email = new JTextPane();
		email.setBounds(172, 116, 154, 20);
		contentPane.add(email);
		
		//creamos el boton de enviar
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setForeground(new Color(255, 0, 255));
		btnEnviar.setBackground(UIManager.getColor("Button.background"));
		btnEnviar.addActionListener(new ActionListener() {
			
			/*aqui haremos que nos genere una nueva contraseña, dandole el string
			 de la clase nuevaContraseña, donde se almacenan todos las correos 
			 de la base de datos. Si el correo existe, generara la contraseña
			 */
			
			public void actionPerformed(ActionEvent e) {
			try {
				String contraseñaNueva=nuevaContraseña.nuevaContraseña(email.getText());
				JOptionPane.showMessageDialog(null, "su nueva contraseña es: "+ contraseñaNueva);
				
				//y con esto, esa contraseña generada se actualizara en la base de datos
				
				conexion.EjecutarUpdate("UPDATE usuarios SET contraseña='"+contraseñaNueva+"' WHERE email='"+email.getText()+"'" ); 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
	
		btnEnviar.setBounds(206, 147, 89, 23);
		contentPane.add(btnEnviar);
		
		//añadimos al panel nuestro boton de volver a la ventana anterior
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		btnVolver.setForeground(Color.BLUE);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login o = new login();
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(10, 11, 89, 23);
		contentPane.add(btnVolver);
		
		//asi añadimos el texto "CREAR NUEVA CONTRASEÑA" al panel
		
		JLabel lblCrearNuevaContrasea = new JLabel("CREAR NUEVA CONTRASE\u00D1A");
		lblCrearNuevaContrasea.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		lblCrearNuevaContrasea.setForeground(new Color(0, 0, 0));
		lblCrearNuevaContrasea.setBounds(104, 43, 235, 50);
		contentPane.add(lblCrearNuevaContrasea);
	}
}

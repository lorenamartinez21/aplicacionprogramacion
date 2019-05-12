package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class nuevousuario extends JFrame {

	private JPanel contentPane;
	private JPasswordField contraseña;

	
	public nuevousuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setText("REGISTRARSE");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(154, 11, 144, 32);
		contentPane.add(textPane);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Usuario");
		textPane_1.setEditable(false);
		textPane_1.setBackground(SystemColor.menu);
		textPane_1.setBounds(70, 69, 70, 20);
		contentPane.add(textPane_1);

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Contrase\u00F1a");
		textPane_2.setEditable(false);
		textPane_2.setBackground(SystemColor.menu);
		textPane_2.setBounds(70, 100, 70, 20);
		contentPane.add(textPane_2);

		JTextPane users = new JTextPane();
		users.setBounds(150, 69, 117, 20);
		contentPane.add(users);

		contraseña = new JPasswordField();
		contraseña.setBounds(150, 100, 117, 20);
		contentPane.add(contraseña);

		JTextPane txtpnCorreoElectrnico = new JTextPane();
		txtpnCorreoElectrnico.setText("Correo electr\u00F3nico");
		txtpnCorreoElectrnico.setEditable(false);
		txtpnCorreoElectrnico.setBackground(SystemColor.menu);
		txtpnCorreoElectrnico.setBounds(70, 134, 111, 20);
		contentPane.add(txtpnCorreoElectrnico);

		JTextPane email = new JTextPane();
		email.setBounds(191, 134, 153, 20);
		contentPane.add(email);

		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				try {
					int i = 0;
					String[] usuaria = usuarios.usuario();
					String[] correos = correo.correoelectronico();
					while (i < usuaria.length) {
						if (users.getText().equals(usuaria[i])) {
							JOptionPane.showMessageDialog(null, "error", "El usuario ya existe",JOptionPane.ERROR_MESSAGE);
						}else {
							if (contraseña.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "error", "Campo obligatorio no completado", JOptionPane.ERROR_MESSAGE);
							}else {
								if(email.getText().equals("") || email.getText().equals(correos[i])) {
									JOptionPane.showMessageDialog(null, "error", "email ya en uso o vacío", JOptionPane.ERROR_MESSAGE);
									}else {
								conexion.EjecutarUpdate("INSERT INTO `usuarios`(`usuario`, `contraseña`, `email`) VALUES ('"+users.getText()+"','"+contraseña.getText()+"','"+email.getText()+"')");
							}
					}
					i++;	
						
					}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(175, 183, 89, 23);
		contentPane.add(btnNewButton);
		
	}
}

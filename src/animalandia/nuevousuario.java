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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;

public class nuevousuario extends JFrame {

	private JPanel contentPane;
	private JPasswordField contrase�a;

	
	public nuevousuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setText("REGISTRARSE");
		textPane.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		textPane.setEditable(false);
		textPane.setBackground(new Color(176, 224, 230));
		textPane.setBounds(154, 11, 144, 32);
		contentPane.add(textPane);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Usuario");
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(176, 224, 230));
		textPane_1.setBounds(70, 69, 70, 20);
		contentPane.add(textPane_1);

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Contrase\u00F1a");
		textPane_2.setEditable(false);
		textPane_2.setBackground(new Color(176, 224, 230));
		textPane_2.setBounds(70, 100, 70, 20);
		contentPane.add(textPane_2);

		JTextPane users = new JTextPane();
		users.setBounds(150, 69, 117, 20);
		contentPane.add(users);

		contrase�a = new JPasswordField();
		contrase�a.setBounds(150, 100, 117, 20);
		contentPane.add(contrase�a);

		JTextPane txtpnCorreoElectrnico = new JTextPane();
		txtpnCorreoElectrnico.setText("Correo electr\u00F3nico");
		txtpnCorreoElectrnico.setEditable(false);
		txtpnCorreoElectrnico.setBackground(new Color(176, 224, 230));
		txtpnCorreoElectrnico.setBounds(70, 134, 111, 20);
		contentPane.add(txtpnCorreoElectrnico);

		JTextPane email = new JTextPane();
		email.setBounds(191, 134, 153, 20);
		contentPane.add(email);

		JButton btnNewButton = new JButton("Crear");
		btnNewButton.setForeground(new Color(255, 0, 255));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
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
							if (contrase�a.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "error", "Campo obligatorio no completado", JOptionPane.ERROR_MESSAGE);
							}else {
								if(email.getText().equals("") || email.getText().equals(correos[i])) {
									JOptionPane.showMessageDialog(null, "error", "email ya en uso o vac�o", JOptionPane.ERROR_MESSAGE);
									}else {
								conexion.EjecutarUpdate("INSERT INTO `usuarios`(`usuario`, `contrase�a`, `email`) VALUES ('"+users.getText()+"','"+contrase�a.getText()+"','"+email.getText()+"')");
							}
					}
					i++;	
						
					}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "El usuario se ha creado correctamente ");
			}
		});
		btnNewButton.setBounds(175, 183, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.BLUE);
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login o = new login();
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(10, 11, 89, 23);
		contentPane.add(btnVolver);
	}
}

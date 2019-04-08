package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class nuevousuario extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nuevousuario frame = new nuevousuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(150, 69, 117, 20);
		contentPane.add(textPane_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 100, 117, 20);
		contentPane.add(passwordField);
		
		JTextPane txtpnCorreoElectrnico = new JTextPane();
		txtpnCorreoElectrnico.setText("Correo electr\u00F3nico");
		txtpnCorreoElectrnico.setEditable(false);
		txtpnCorreoElectrnico.setBackground(SystemColor.menu);
		txtpnCorreoElectrnico.setBounds(70, 134, 101, 20);
		contentPane.add(txtpnCorreoElectrnico);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(175, 131, 153, 20);
		contentPane.add(textPane_4);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.setBounds(175, 183, 89, 23);
		contentPane.add(btnNewButton);
	}
}

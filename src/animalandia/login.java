package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 94, 117, 20);
		panel.add(passwordField);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(128, 52, 117, 20);
		panel.add(textPane);
		
		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setEditable(false);
		txtpnUsuario.setBackground(UIManager.getColor("Button.background"));
		txtpnUsuario.setText("Usuario");
		txtpnUsuario.setBounds(37, 52, 70, 20);
		panel.add(txtpnUsuario);
		
		JTextPane txtpnContrasea = new JTextPane();
		txtpnContrasea.setEditable(false);
		txtpnContrasea.setBackground(UIManager.getColor("Button.background"));
		txtpnContrasea.setText("Contrase\u00F1a");
		txtpnContrasea.setBounds(37, 94, 70, 20);
		panel.add(txtpnContrasea);
		
		JTextPane txtpnIniciarSesin = new JTextPane();
		txtpnIniciarSesin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpnIniciarSesin.setText("INICIAR SESI\u00D3N");
		txtpnIniciarSesin.setEditable(false);
		txtpnIniciarSesin.setBackground(SystemColor.menu);
		txtpnIniciarSesin.setBounds(148, 11, 224, 20);
		panel.add(txtpnIniciarSesin);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setBounds(156, 129, 89, 23);
		panel.add(btnLogin);
		
		JButton btnHeOlvidadoMi = new JButton("He olvidado mi contrase\u00F1a");
		btnHeOlvidadoMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHeOlvidadoMi.setBounds(111, 164, 179, 23);
		panel.add(btnHeOlvidadoMi);
		
		JButton btnNuevoUsuario = new JButton("Nuevo usuario");
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevoUsuario.setBounds(297, 217, 117, 23);
		panel.add(btnNuevoUsuario);
	}
}

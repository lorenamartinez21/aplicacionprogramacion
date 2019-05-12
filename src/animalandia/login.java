package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JComboBox;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField contraseña;

	/**
	 * Launch the application.
	 */

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

		contraseña = new JPasswordField();
		contraseña.setBounds(128, 94, 117, 20);
		panel.add(contraseña);

		JTextPane usuario = new JTextPane();
		usuario.setBounds(128, 52, 117, 20);
		panel.add(usuario);

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

		JButton Login = new JButton("LOGIN");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean entra = usuarioaceptado.usuariocorrecto(usuario.getText(), contraseña.getText());
					if (entra) {
						principal a = new principal();
						dispose();
						a.setVisible(true);
					} else {
						System.out.println("error");
						JOptionPane.showMessageDialog(null, "error", "Usuario no encontrado", JOptionPane.ERROR_MESSAGE);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		});
		Login.setBounds(156, 129, 89, 23);
		panel.add(Login);

		JButton btnHeOlvidadoMi = new JButton("He olvidado mi contrase\u00F1a");
		btnHeOlvidadoMi.setForeground(Color.BLUE);
		btnHeOlvidadoMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				olvidecontraseña a = new olvidecontraseña();
				dispose();
				a.setVisible(true);
			}

		});
		btnHeOlvidadoMi.setBounds(99, 163, 211, 23);
		panel.add(btnHeOlvidadoMi);

		JButton btnNuevoUsuario = new JButton("Nuevo usuario");
		btnNuevoUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevousuario o = new nuevousuario();
				dispose();
				o.setVisible(true);
			}
		});
		btnNuevoUsuario.setBounds(297, 217, 117, 23);
		panel.add(btnNuevoUsuario);

	}
}

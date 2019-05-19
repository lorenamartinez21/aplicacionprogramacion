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

//aqui hemos creado un jfame para el login

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField contraseña;
	
//aqui ponemos el panel donde añadiremos los botones, etc.
	
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setForeground(Color.PINK);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//aqui añadimos un espacio que sirve para poner contraseñas en modo cifrado
		contraseña = new JPasswordField();
		contraseña.setBounds(128, 94, 117, 20);
		panel.add(contraseña);
		
		/*aqui añadimos un espacio de texto, donde pondremos el nombre del 
		  usuario*/
		
		JTextPane usuario = new JTextPane();
		usuario.setBackground(Color.WHITE);
		usuario.setForeground(Color.BLACK);
		usuario.setBounds(128, 52, 117, 20);
		
		//con esta linea indicamos que el espacio de texto anterior esta dentro del panel
		
		panel.add(usuario);
		
		//aqui escribimos el texto "usuario", el cual no sera editable
		
		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setEditable(false);
		txtpnUsuario.setBackground(new Color(176, 224, 230));
		txtpnUsuario.setText("Usuario");
		txtpnUsuario.setBounds(37, 52, 70, 20);
		
		//aqui lo añadimos al panel
		
		panel.add(txtpnUsuario);

		//aqui escribimos el texto "contraseña", el cual no sera editable
		
		JTextPane txtpnContrasea = new JTextPane();
		txtpnContrasea.setEditable(false);
		txtpnContrasea.setBackground(new Color(176, 224, 230));
		txtpnContrasea.setText("Contrase\u00F1a");
		txtpnContrasea.setBounds(37, 94, 70, 20);
		
		//aqui lo añadimos al panel
		
		panel.add(txtpnContrasea);
		
		//aqui ponemos el texto "INICIAR SESION", que no se podra editar
		
		JTextPane txtpnIniciarSesin = new JTextPane();
		txtpnIniciarSesin.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnIniciarSesin.setText("INICIAR SESI\u00D3N");
		txtpnIniciarSesin.setEditable(false);
		txtpnIniciarSesin.setBackground(new Color(176, 224, 230));
		txtpnIniciarSesin.setBounds(138, 11, 150, 30);
		
		//aqui lo añadimos al panel
		
		panel.add(txtpnIniciarSesin);
		
		//aqui creamos un boton, con el texto "LOGIN", el cual decoramos
		
		JButton Login = new JButton("LOGIN");
		Login.setBackground(UIManager.getColor("Button.background"));
		Login.setForeground(Color.MAGENTA);
		
		//con esta linea le indicamos la accion que queremos que haga
		
		Login.addActionListener(new ActionListener() {
			
			/*aqui programamos que si el usuario y la contraseña son correctos, 
			que muestre la siguiente ventana, que sera la principal*/
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					//aqui usamos la clase usuarioaceptado
					
					boolean entra = usuarioaceptado.usuariocorrecto(usuario.getText(), contraseña.getText());
					if (entra) {
						principal a = new principal(usuario.getText());
						dispose();
						a.setVisible(true);
						//aqui le indicamos que si alguno de esos campos son incorrectos, de un error
					} else {
						//aqui le añadimos un panel con el texto de error
						
						JOptionPane.showMessageDialog(null, "error", "Usuario no encontrado", JOptionPane.ERROR_MESSAGE);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		});
		Login.setBounds(156, 129, 89, 23);
		
		//aqui lo añadimos al panel
		
		panel.add(Login);
		
		//aqui añadimos un boton con el texto "he olvidado mi contraseña", y le damos diseño
		
		JButton btnHeOlvidadoMi = new JButton("He olvidado mi contrase\u00F1a");
		btnHeOlvidadoMi.setBackground(UIManager.getColor("Button.background"));
		btnHeOlvidadoMi.setForeground(Color.BLUE);
		
		//aqui le decimos la accion que queremos que haga
		
		btnHeOlvidadoMi.addActionListener(new ActionListener() {
			
			//aqui e indicamos que con este boton vaya a la siguente ventana, llamada "olvidecontraseña"
			
			public void actionPerformed(ActionEvent e) {
				olvidecontraseña a = new olvidecontraseña();
				dispose();
				a.setVisible(true);
			}

		});
		btnHeOlvidadoMi.setBounds(99, 163, 211, 23);
		
		//aqui añadimos el boton al panel
		
		panel.add(btnHeOlvidadoMi);
		
		//aqui creamos el boton con el texto "nuevo usuario", y lo decoramos
		
		JButton btnNuevoUsuario = new JButton("Nuevo usuario");
		btnNuevoUsuario.setBackground(UIManager.getColor("Button.background"));
		btnNuevoUsuario.setForeground(Color.MAGENTA);
		
		//le decimos su accion
		
		btnNuevoUsuario.addActionListener(new ActionListener() {
			
			//y le decimos que nos mande a la siguente ventana, que sera "nuevousuario"
			
			public void actionPerformed(ActionEvent e) {
				nuevousuario o = new nuevousuario();
				dispose();
				o.setVisible(true);
			}
		});
		btnNuevoUsuario.setBounds(297, 217, 117, 23);
		
		//aqui lo añadimos al panel
		
		panel.add(btnNuevoUsuario);

	}
}

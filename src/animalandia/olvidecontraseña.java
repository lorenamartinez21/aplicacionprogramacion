package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class olvidecontraseña extends JFrame {

	private JPanel contentPane;

	public olvidecontraseña() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnCorreoDeRecuperacin = new JTextPane();
		txtpnCorreoDeRecuperacin.setEditable(false);
		txtpnCorreoDeRecuperacin.setBackground(UIManager.getColor("Button.background"));
		txtpnCorreoDeRecuperacin.setBounds(10, 50, 138, 20);
		txtpnCorreoDeRecuperacin.setText("Correo de recuperaci\u00F3n");
		contentPane.add(txtpnCorreoDeRecuperacin);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(162, 50, 92, 20);
		contentPane.add(textPane);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	
		btnEnviar.setBounds(165, 105, 89, 23);
		contentPane.add(btnEnviar);
	}

}

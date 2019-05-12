package animalandia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class principal extends JFrame {

	private JPanel articulos;

	
	public principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		articulos = new JPanel();
		articulos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(articulos);
		articulos.setLayout(null);
		
		JLabel lblAnimalandia = new JLabel("ANIMALANDIA");
		lblAnimalandia.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 17));
		lblAnimalandia.setBounds(185, 27, 116, 14);
		articulos.add(lblAnimalandia);
		
		JButton btnComida = new JButton("comida");
		btnComida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				comida c;
				try {
					c = new comida();
					c.setVisible(true);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			

			}
		});
		btnComida.setBounds(41, 86, 89, 23);
		articulos.add(btnComida);
		
		JButton btnJuguetes = new JButton("juguetes");
		btnJuguetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				juguetes c;
				try {
					c = new juguetes();
					c.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			

			}
			
		});
		btnJuguetes.setBounds(41, 120, 89, 23);
		articulos.add(btnJuguetes);
		
		JButton btnAnimales = new JButton("animales");
		btnAnimales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				animales c;
				try {
					c = new animales();
					c.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			

			}
			
		});
		btnAnimales.setBounds(41, 155, 89, 23);
		articulos.add(btnAnimales);
		JButton btnAadirArtculo = new JButton("A\u00F1adir art\u00EDculo");
		btnAadirArtculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				añadirArticulo o = new añadirArticulo();
				dispose();
				o.setVisible(true);
			}
		});
		btnAadirArtculo.setBounds(18, 217, 111, 23);
		articulos.add(btnAadirArtculo);
		
		JButton btnEditarArtculo = new JButton("Editar art\u00EDculo");
		btnEditarArtculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarArticulo o;
				try {
					o = new editarArticulo();
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEditarArtculo.setBounds(151, 217, 116, 23);
		articulos.add(btnEditarArtculo);
		
		JButton btnBorrarArtculo = new JButton("Borrar art\u00EDculo");
		btnBorrarArtculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					borrarArticulo o = new borrarArticulo();
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBorrarArtculo.setBounds(295, 217, 116, 23);
		articulos.add(btnBorrarArtculo);
		
		}	
}

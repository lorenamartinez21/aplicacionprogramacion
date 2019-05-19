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
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class principal extends JFrame {

	private JPanel articulos;

	//aqui iniciamos el panel y lo decoramos
	
	public principal(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		articulos = new JPanel();
		articulos.setForeground(Color.MAGENTA);
		articulos.setBackground(new Color(176, 224, 230));
		articulos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(articulos);
		articulos.setLayout(null);

		//aqui ponemos el texto "ANIMALANDIA", que sera el nombre de la tienda, y lo decoramos
		
		JLabel lblAnimalandia = new JLabel("ANIMALANDIA");
		lblAnimalandia.setForeground(new Color(0, 0, 0));
		lblAnimalandia.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblAnimalandia.setBounds(156, 21, 156, 27);
		
		//lo añadimos al panel
		
		articulos.add(lblAnimalandia);

		//creamos un boton con el texto "comida" y lo decoramos
		
		JButton btnComida = new JButton("comida");
		btnComida.setForeground(new Color(255, 0, 255));
		btnComida.setBackground(UIManager.getColor("Button.background"));
		
		//le decimos la accion que queremos que haga
		
		btnComida.addMouseListener(new MouseAdapter() {
			@Override
			
			//aqui llamamos a la siguiente ventana "comida"
			
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				comida c;
				try {
					c = new comida(usuario);
					c.setVisible(true);
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
		});
		btnComida.setBounds(41, 86, 89, 23);
		
		//aqui añadimos el boton comida al panel
		
		articulos.add(btnComida);
		
		//aqui añadimos el boton "juguetes"
		
		JButton btnJuguetes = new JButton("juguetes");
		btnJuguetes.setForeground(new Color(255, 0, 255));
		btnJuguetes.setBackground(UIManager.getColor("Button.background"));
		btnJuguetes.addActionListener(new ActionListener() {
			
			//y le decimos que nos lleve a la ventana "juguetes"
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				juguetes c;
				try {
					c = new juguetes(usuario);
					c.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		btnJuguetes.setBounds(41, 121, 89, 23);
		
		//aqui lo añadimos al panel
		
		articulos.add(btnJuguetes);
		
		//creamos el boton "animales"
		
		JButton btnAnimales = new JButton("animales");
		btnAnimales.setForeground(new Color(255, 0, 255));
		btnAnimales.setBackground(UIManager.getColor("Button.background"));
		btnAnimales.addMouseListener(new MouseAdapter() {
			
			//le decimos que nos lleve a la ventana "animales"
			
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				animales c;
				try {
					c = new animales(usuario);
					c.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		btnAnimales.setBounds(41, 155, 89, 23);
		
		//lo añadimos al panel
		
		articulos.add(btnAnimales);
		
		//creamos el boton "volver"
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		btnVolver.setForeground(new Color(0, 0, 255));
		btnVolver.addActionListener(new ActionListener() {
			
			//este boton estara en todos los jframes y nos llevara siempre a la ventana anterior
			
			public void actionPerformed(ActionEvent arg0) {
				login o = new login();
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(10, 11, 89, 23);
		
		//lo añadimos al panel
		
		articulos.add(btnVolver);
		
		/*aqui le indicamos que SOLO el usuario "lorena" pueda ver los 
		 botones que estan dentro de este if, por tanto sera el unico 
		 que podra ejecutar esas funciones*/
		
		if (usuario.equals("lorena")) {
		
			/*creamos el boton "informe de usuarios", el cual, al hacer click en el, 
			se nos actualizara toda la informacion de los usuarios, que podremos ver 
			en el fichero "usuarios.csv"*/
			
		JButton btnInformeDeUsuarios = new JButton("Informe de usuarios");
		btnInformeDeUsuarios.setForeground(Color.MAGENTA);
		btnInformeDeUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//aqui le indicamos la tabla de la que queremos sacar informacion de la base de datos
				
				ResultSet rs=conexion.ejecutarSentencia("Select * from usuarios");
				try {
					//aqui le indicamos la ruta del fichero donde queremos guardar los datos
					
					String ruta= "src/animalandia/usuarios.csv";
					FileWriter fichero1=new FileWriter(ruta);
					
					//la info que queremos ver
					
					fichero1.write("usuario; contraseña; email\n");
					
					while(rs.next()) {
						fichero1.write(rs.getString("usuario")+";"+rs.getString("contraseña")+";"+rs.getString("email")+"\n");
					}
					fichero1.close();
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnInformeDeUsuarios.setBounds(227, 215, 175, 23);
		
		//añadimos el boton al panel
		
		articulos.add(btnInformeDeUsuarios);
		
		/* ahora hacemos lo mismo que hemos hecho con los usuarios, 
		pero con la tabla de los articulos, para tener asi la informacion 
		de las dos tablas actualizadas en ficheros con solo darle a un boton 
		si hacemos cualquien modificacion, o añadimos, o borramos*/
		
		JButton btnInformeDeArtculos = new JButton("Informe de art\u00EDculos");
		btnInformeDeArtculos.setForeground(Color.MAGENTA);
		btnInformeDeArtculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs=conexion.ejecutarSentencia("Select * from artículos");
				try {
					String ruta= "src/animalandia/articulos.csv";
					FileWriter fichero2=new FileWriter(ruta);
					fichero2.write("tipo; id; nombre; cantidad; precio\n");
					while(rs.next()) {
						fichero2.write(rs.getString("tipo")+";"+rs.getString("id")+";"+rs.getString("nombre")+";"+rs.getString("cantidad")+";"+rs.getString("precio")+"\n");
					}
					fichero2.close();
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
			
		});
		btnInformeDeArtculos.setBounds(41, 215, 175, 23);
		articulos.add(btnInformeDeArtculos);

		
		// creamos el boton "añadir articulo"
		
			JButton btnAadirArtculo = new JButton("A\u00F1adir art\u00EDculo");
			btnAadirArtculo.setForeground(new Color(255, 0, 255));
			btnAadirArtculo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//con esta accion hacemos que nos lleve a la ventana "añadirArticulo"
					añadirArticulo o = new añadirArticulo(usuario);
					dispose();
					o.setVisible(true);
				}
			});
			btnAadirArtculo.setBounds(268, 86, 134, 23);
			
			//lo añadimos al panel
			
			articulos.add(btnAadirArtculo);
			
			//creamos el boton "editar articulo"
			
			JButton btnEditarArtculo = new JButton("Editar art\u00EDculo");
			btnEditarArtculo.setForeground(new Color(255, 0, 255));
			btnEditarArtculo.addActionListener(new ActionListener() {
				
				//con esta accion hacemos que nos lleve a la ventana "editarArticulo"
				public void actionPerformed(ActionEvent e) {
					
					editarArticulo o;
					try {
						o = new editarArticulo(usuario);
						dispose();
						o.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			btnEditarArtculo.setBounds(268, 120, 134, 23);
			
			//y lo añadimos al panel
			
			articulos.add(btnEditarArtculo);

			// y por ultimo, hacemos lo msmo con el boton de "borrar articulo"
			JButton btnBorrarArtculo = new JButton("Borrar art\u00EDculo");
			btnBorrarArtculo.setForeground(new Color(255, 0, 255));
			btnBorrarArtculo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						borrarArticulo o = new borrarArticulo(usuario);
						dispose();
						o.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			btnBorrarArtculo.setBounds(268, 155, 132, 23);
			articulos.add(btnBorrarArtculo);
		}
		
		/*aqui añadimos una imagen que , por el contrario que antes, 
		la veran todos los usuarios excepto lorena(root)*/
		
		if (!usuario.equals("lorena")) {
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(principal.class.getResource("/imagen/puppy.jpg")));
			label.setBounds(182, 74, 189, 119);
			articulos.add(label);
		}
		}
	}


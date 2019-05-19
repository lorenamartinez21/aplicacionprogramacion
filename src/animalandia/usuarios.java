package animalandia;

import java.sql.ResultSet;

import java.sql.SQLException;

//seleccionamos todos los usuarios de la tabla usuarios, igual que con las contraseñas

public class usuarios {
	public static String[] usuario() throws SQLException {
		ResultSet usuarios;
		int i = 0;
		int a = 0;
		usuarios = conexion.ejecutarSentencia("Select usuario from usuarios");
		while (usuarios.next()) {
			a++;
		}
		String[] usuario = new String[a];
		usuarios.beforeFirst();
		while(usuarios.next()) {
			usuario[i]=usuarios.getString("usuario");
			i++;
		}
		return usuario;
	}
	//el string usuario, mas tarde sera llamado en la clase "usuarioaceptado"
	
}

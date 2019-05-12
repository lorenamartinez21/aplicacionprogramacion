package animalandia;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	
}

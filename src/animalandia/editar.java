package animalandia;

import java.sql.ResultSet;
import java.sql.SQLException;

//aqui hacemos una seleccion del nombre de todos los articulos, como en "contraseñas"

public class editar {
	public static String[] editar() throws SQLException {
		ResultSet usuarios;
		int i = 0;
		int a = 0;
		usuarios = conexion.ejecutarSentencia("Select nombre from artículos");
		while (usuarios.next()) {
			a++;
		}
		String[] usuario = new String[a];
		usuarios.beforeFirst();
		while(usuarios.next()) {
			usuario[i]=usuarios.getString("nombre");
			i++;
		}
		return usuario;
		//mas tarde usaremos el string editar para la clase "editarArticulo"
	}
}

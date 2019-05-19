package animalandia;

import java.sql.ResultSet;
import java.sql.SQLException;

//hacemos lo mismo que con la clase "editar"
public class eliminar {
	public static String[] eliminar() throws SQLException {
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
		//mas tarde usaremos el string eliminar para la clase "borrarArticulo"
	}
}



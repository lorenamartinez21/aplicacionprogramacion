package animalandia;

import java.sql.ResultSet;
import java.sql.SQLException;

//en esta clase reuniremos todas las contraseñas de la base de datos

public class contraseñas {
	public static String[] contraseña() throws SQLException {
		ResultSet contraseñas;
		int i = 0;
		int a = 0;
		
		// hacemos la sentencia k las busca
		
		contraseñas = conexion.ejecutarSentencia("Select contraseña from usuarios");
		while (contraseñas.next()) {
			
			//aqui hacemos un contador para las contraseñas
			a++;
		}
		contraseñas.beforeFirst();
		
		//metemos todas las contraseñas en un string con una variable nueva
		
		String[] contraseña = new String[a];
		while(contraseñas.next()) {
			contraseña[i]=contraseñas.getString("contraseña");
			i++;
		}
		return contraseña;
	}
	
}



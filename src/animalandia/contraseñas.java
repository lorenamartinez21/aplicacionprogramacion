package animalandia;

import java.sql.ResultSet;
import java.sql.SQLException;

//en esta clase reuniremos todas las contraseņas de la base de datos

public class contraseņas {
	public static String[] contraseņa() throws SQLException {
		ResultSet contraseņas;
		int i = 0;
		int a = 0;
		
		// hacemos la sentencia k las busca
		
		contraseņas = conexion.ejecutarSentencia("Select contraseņa from usuarios");
		while (contraseņas.next()) {
			
			//aqui hacemos un contador para las contraseņas
			a++;
		}
		contraseņas.beforeFirst();
		
		//metemos todas las contraseņas en un string con una variable nueva
		
		String[] contraseņa = new String[a];
		while(contraseņas.next()) {
			contraseņa[i]=contraseņas.getString("contraseņa");
			i++;
		}
		return contraseņa;
	}
	
}



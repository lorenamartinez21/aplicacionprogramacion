package animalandia;

import java.sql.ResultSet;
import java.sql.SQLException;

public class contraseņas {
	public static String[] contraseņa() throws SQLException {
		ResultSet contraseņas;
		int i = 0;
		int a = 0;
		contraseņas = conexion.ejecutarSentencia("Select contraseņa from usuarios");
		while (contraseņas.next()) {
			a++;
		}
		contraseņas.beforeFirst();
		String[] contraseņa = new String[a];
		while(contraseņas.next()) {
			contraseņa[i]=contraseņas.getString("contraseņa");
			i++;
		}
		return contraseņa;
	}
	
}



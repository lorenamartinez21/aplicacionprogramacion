package animalandia;

import java.sql.ResultSet;
import java.sql.SQLException;

//en esta clase reuniremos todas las contrase�as de la base de datos

public class contrase�as {
	public static String[] contrase�a() throws SQLException {
		ResultSet contrase�as;
		int i = 0;
		int a = 0;
		
		// hacemos la sentencia k las busca
		
		contrase�as = conexion.ejecutarSentencia("Select contrase�a from usuarios");
		while (contrase�as.next()) {
			
			//aqui hacemos un contador para las contrase�as
			a++;
		}
		contrase�as.beforeFirst();
		
		//metemos todas las contrase�as en un string con una variable nueva
		
		String[] contrase�a = new String[a];
		while(contrase�as.next()) {
			contrase�a[i]=contrase�as.getString("contrase�a");
			i++;
		}
		return contrase�a;
	}
	
}



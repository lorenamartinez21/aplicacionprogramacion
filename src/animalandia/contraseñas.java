package animalandia;

import java.sql.ResultSet;
import java.sql.SQLException;

public class contrase�as {
	public static String[] contrase�a() throws SQLException {
		ResultSet contrase�as;
		int i = 0;
		int a = 0;
		contrase�as = conexion.ejecutarSentencia("Select contrase�a from usuarios");
		while (contrase�as.next()) {
			a++;
		}
		contrase�as.beforeFirst();
		String[] contrase�a = new String[a];
		while(contrase�as.next()) {
			contrase�a[i]=contrase�as.getString("contrase�a");
			i++;
		}
		return contrase�a;
	}
	
}



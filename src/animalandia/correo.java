package animalandia;

import java.sql.ResultSet;
import java.sql.SQLException;

public class correo {
	public static String[] correoelectronico() throws SQLException {
	ResultSet correo;
	int i = 0;
	int a = 0;
	correo = conexion.ejecutarSentencia("Select email from usuarios");
	while (correo.next()) {
		a++;
	}
	String[] email = new String[a];
	correo.beforeFirst();
	while(correo.next()) {
		email[i]=correo.getString("email");
		i++;
	}
	return email;
}
}

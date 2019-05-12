package animalandia;

import java.sql.SQLException;

public class usuarioaceptado {
public static boolean usuariocorrecto(String usuario, String claves) throws SQLException {
	int i = 0;
	String[] usuaria = usuarios.usuario();
	String[] clave = contraseñas.contraseña();
	while(i<usuaria.length) {
		if(usuario.equals(usuaria[i])) {
			if(claves.equals(clave[i])) {
				return true;
			}
		
		}
		i++;
	}
	return false;
}
}

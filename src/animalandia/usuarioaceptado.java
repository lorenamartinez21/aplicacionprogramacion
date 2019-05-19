package animalandia;

import java.sql.SQLException;

/*en esta clase estamos creando dos strings que contengan todas las contraseñas
y todos los usuarios almacenados en la base de datos*/

public class usuarioaceptado {
public static boolean usuariocorrecto(String usuario, String claves) throws SQLException {
	int i = 0;
	String[] usuaria = usuarios.usuario();
	String[] clave = contraseñas.contraseña();
	while(i<usuaria.length) {
		
		/*aqui le decimos que primero mire si el usuario es correcto, si es asi,
		que mire la contraseña, si uno de los dos falla, dara error*/
		
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

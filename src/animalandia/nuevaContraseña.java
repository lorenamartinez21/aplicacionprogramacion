package animalandia;

import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;

public class nuevaContrase�a {
public static String nuevaContrase�a(String Correo) throws SQLException {
	
	/*creamos un string con los correos, porque es lo que nos pedira 
	para generarnos la nueva contrase�a*/
	
 String[] correos = correo.correoelectronico();
 int a = 0;
 String nuevaContrase�a="";
 while (a < correos.length) {
	 
	 /*aqui nos genera la contrase�a con caracteres aleatorios mientras 
	 le demos un correo que este en la base de datos*/
	 
  for (int i = 0; i < correos.length; i++) {
   a++;
   if (correos[i].equals(Correo)) {
    Random r = new Random();
    int n;
    int num;
    char caracter;
    for (int o = 0; o < 8; o++) {

     n = r.nextInt(3) + 1;
     switch (n) {
     case 1:
      num = r.nextInt(10) + 48;
      break;
     case 2:
      num = r.nextInt(25) + 65;
      break;
     default:
      num = r.nextInt(25) + 97;
      break;
     }
     caracter = (char) num;
     nuevaContrase�a += Character.toString(caracter);

    }
    return nuevaContrase�a;

   }

  }
 }
 return "0";

}
}
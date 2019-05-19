package animalandia;
//en esta clase estoy llamando a la funcion conectar de la clase conexion
//tambien llamamos a la ventana de login para que se abra la primera
public class main {
	public static void main(String[] args) {
		conexion.Conectar();
		login o = new login();
		o.setVisible(true);
	}
}

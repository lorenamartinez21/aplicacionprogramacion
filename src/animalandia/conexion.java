package animalandia;


import java.sql.*;
import javax.swing.JOptionPane;

// con esta clase nos conectamos a la base de datos

public class conexion {
	
	//aqui le indicamos el nombre, el usuario, la contraseña, el localhost,etc
	
	static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String dbName = "Animalandia";
	static String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone;
	static String user = "root";
	static String pass = "mysql";
	//static String driver = "com.mysql.cj.jdbc.Driver";
    
    static Connection conexion;
    static Statement consulta;
    static ResultSet resultado;
    
    public static void Conectar(){
    	try {
           //Class.forName(driver) ;
           conexion = DriverManager.getConnection(url, user, pass);
           System.out.println("Base de datos clientes.fdb situada en :\n "+url);
           consulta = conexion.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    public static Connection conexionBBDD() throws SQLException {
    	 String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    	 String dbName = "Animalandia";
    	 String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone;
    	 String user = "root";
    	 String pass = "mysql";
    	 Connection conexion2;
    	 Statement consulta;
    	 ResultSet resultado;
    	conexion2 = DriverManager.getConnection(url, user, pass);
		return conexion2;
    	
    }
    
    public static ResultSet ejecutarSentencia(String Sentencia){
        try {
        	resultado = consulta.executeQuery(Sentencia);
        }catch(Exception e){
           
        }
        return resultado;
    }
      
    public static void EjecutarUpdate(String Sentencia) throws SQLException{
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    	}catch(SQLException e){
    		//JOptionPane.showMessageDialog(null, e.getMessage());1
    	} 
    }
    
    public static void CerrarConexion(){
        try{
        	consulta.close();
        }catch(Exception e){}
    }
    
}

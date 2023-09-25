package MasterDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MasterDAO {
	
protected Connection conexion = null;
	
	protected void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_videojuegos", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[-] Error en el try/catch de conectar(). /n No se encontro la librería de mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[-] Error en el try/catch de conectar(). /n No se pudo conectar con la base de datos");
		}
	} // end conectar()
	
	
	protected void desconectar() {
		try {
			this.conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[-] Error en el metodo desconectar(). No se pudo cerrar la conexion");
		}
	} // end desconectar()

}

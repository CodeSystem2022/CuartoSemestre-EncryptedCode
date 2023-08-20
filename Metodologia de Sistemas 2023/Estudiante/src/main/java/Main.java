
import conexion.Conexion;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var conexion = Conexion.getConnection();
		if(conexion != null) {
			System.out.println("Conexion exitosa: "+conexion);
		}
		else
			System.out.println("Error al conectarse");
				
		
	}

}

package UTN;

import java.util.Scanner;

import servicios.EstudianteServicio;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner{

	@Autowired
	private EstudianteServicio estudianteServicio;
	private static final Logger = LoggerFactory.getLogger(EstudianteApplication.class);
	
	String nl = System.lineSeparator();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		logger.info("Iniciando la aplicacion...");
		//Levantar fabrica de Spring
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion finalizada!");
	}
	@Override
	public void run(String...strings args) throws Exception {
		logger.info("Ejecutando el metodo run de Spring..."+nl);
		var salir = false;
		var consola = new Scanner (System.in);
		while(!salir) {
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			salir = ejecutarOpciones(consola);
			logger.info(nl);
			
		}//Fin ciclo while
		

		
		}
		private void mostrarMenu() {
			logger.info(nl);
			logger.info("""
					********* Sistema de Estudiantes ********
					1. Listar Estudiantes
					2. Buscar Estudiante
					3. Agregar Estudiante
					4. Modificar Estudiante
					5. Eliminar Estudiante
					6. Salir
					Elige una opcion: """
					);
		}
		
		private boolean ejecutarOpciones(Scanner consola) {
			var opcion = Integer.parseInt(consola.nextLine());
			var salir = false;
			switch(opcion) {
			case 1 -> {//Listar estudiantes
				logger.info(nl+"Listado de estudiantes: "+nl);
				List<Estudiantes2023> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString()+nl)));
				
				
			}
			case 2 -> {//Buscar estudiante por id
				logger.info("Digite el id estudiante a buscar: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiante2023 estudainte =
						estudiante Servicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null)
					logger.info("Estudiante encontrado: "+ estudiante + nl);
				else
					logger.info("Estudiante no encontrado: "+ estudiante +nl);
				
			}
			case 3 -> {//Agregar estudainte
				logger.info("Agregar estudiante: "+nl);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Telefono: ");
				var telefono = consola.nextLine();
				logger.info("Email: ");
				var email = consola.nextLine();
				//Crear el objeto estudiante sin el id
				var estudiante = new Estudiantes2023();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante agregado: "+estudiante+nl);
				
			}
			case 4 -> {// Modificar estudiante
				logger.info("Modificar estudiante: "+nl);
				logger.info("Ingrese el id estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//Buscamos el estudiante a modificar
				Estudiantes2023 estudiante =
						estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null) {
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Telefono: ");
					var telefono = consola.nextLine();
					logger.info("Email: ");
					var email = consola.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante modificado: "+estudiante+nl);
				}
				else
					logger.info("Estudainte no encontrado con el id: "+idEstudiante+nl);
				
			}
			case 5-> {//Eliminar estudiante
				logger.info("Eliminar estudiante: "+nl);
				logger.info("Digite el id estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//Buscamos el id estudainte a eliminar
				var estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null) {
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado: " +estudiante+nl);
				}
				else
					logger.info("Estudiante eliminado: "+estudiante+nl);
			}
			case -> 6 {// Salir
				logger.info("Hasta pronto: "+nl+nl);
				salir = true;
				
			}
			default -> logger.info("Opcion no reconocida: "+ opcion+nl);
			}//Fin switch
			return salir;
		}
	}

}

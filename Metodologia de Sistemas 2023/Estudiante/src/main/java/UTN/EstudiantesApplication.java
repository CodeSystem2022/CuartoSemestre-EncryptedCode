package UTN;

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
		logger.info("Ejecutando el metodo run de Spring...");
	}

}

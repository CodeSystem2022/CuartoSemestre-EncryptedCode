package servicios;

import java.util.List;

import modelo.Estudiante;
@Service

public class EstudianteServicio implements IEstudianteServicio {

	@Autowired
	private EstudianteRepositorio estudianteRepositorio;
	
	public List<Estudiante> listarEstudiante() {
		// TODO Auto-generated method stub
		List<Estudiante> estudiantes = estudianteRepositorio.findAll();
		return estudiantes;
	}

	public Estudiante buscarEstudiantePorId(Integer idEstudiante) {
		// TODO Auto-generated method stub
		Estudiante estudiante = estudianteRepositorio.findById(idEstudiante).orElse(null);
		return estudiante; 
	}

	public void guardarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		estudianteRepositorio.save(estudiante);
		
	}
	@Override
	public void eliminarEstudiante(Estudiante estudiante) {
		estudianteRepositorio.delete(estudiante);
	}

}

package servicios;
import java.util.List;

import modelo.Estudiante;

public interface IEstudianteServicio {
	public List<Estudiante> listarEstudiante();
	public Estudiante buscarEstudiantePorId(Integer idEstudiante);
	public void guardarEstudiante(Estudiante estudiante);
}

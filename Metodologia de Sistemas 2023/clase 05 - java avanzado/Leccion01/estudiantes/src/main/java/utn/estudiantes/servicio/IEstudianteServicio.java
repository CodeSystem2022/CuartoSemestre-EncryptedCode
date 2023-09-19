package utn.estudiantes.servicio;

import utn.estudiantes.modelo.Estudiantes2022;

import java.util.List;

public interface IEstudianteServicio {
    // va a tener los métodos básicos para trabajar con la entidad Estudiante
    // usando la interface repositorio
    public List<Estudiantes2022> listarEstudiantes();
    public Estudiantes2022 buscarEstudiantePorId(Integer idEstudiantes2022);
    public void guardarEstudiante(Estudiantes2022 estudiante);
    public void eliminarEstudiante(Estudiantes2022 estudiante);

}

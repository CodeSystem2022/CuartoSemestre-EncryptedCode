package modelo;
import jakarta.persistance.Entity;
import jakarta.persistance.Id;
import jakarta.persistance.GeneratedValue;
import lombok.Data;

@Entity

//boilerplate = Repetitivo
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstudiante;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	
	
}

package utn.tienda_libros.modelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@ToString
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idLibro;
	String nombreLibro;
	String autor;
	Double precio;
	Integer existencias;
}

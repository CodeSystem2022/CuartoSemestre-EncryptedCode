package utn.estudiantes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
// Boilerplate - Código Repetitivo
@Data // Métodos Get & Set
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
@ToString // Método To String de Lombok
public class Estudiantes2022 { //tiene que tener el mismo nombre de la bd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestudiantes2022; //mismo nombre de la primary key de la tabla
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}

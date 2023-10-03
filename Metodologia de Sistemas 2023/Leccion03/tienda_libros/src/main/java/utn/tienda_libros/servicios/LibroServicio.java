package utn.tienda_libros.servicios;
import org.springframework.stereotype.*;
import java.util.list;

@Service
public class LibroServicio implements ILibroServicio {
	
	@Autowired
	private LibroRepositorio libroRepositorio;
	
	@Override
	public List<libro> listarLibros(){
		return libroRepositorio.findAll();
	}
	@Override
	public Libro buscarLibroPorId(Integer idLibro) {
		Libro libro = libroRepositorio.findById(idLibro).orElse(null);
		return libro;
	}
	@Override
	public void guardarLibro(libro libro) {
		libroRepositorio.save(libro);
	}
	@Override
	public void eliminarLibro(libro libro) {
		libroRepositorio.delete(libro);
	}
}

package utn.tienda_libros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import utn.tienda_libros.vista.LibroFrom;

import java.awt.*; // la importación que hace el porfe es import java.awt.EventQueue

@SpringBootApplication
public class TiendaLibrosApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext contextoSpring = new SpringApplicationBuilder(TiendaLibrosApplication.class)
				.headless(false)
				.web(WebApplicationType.NONE) //indicamos que NO es una aplicación web
				.run(args); //pasamos los argumentos que recibimos en este método

		//Ejecutamos el código para cargar el formulario
		EventQueue.invokeLater(() -> { //Metodo Lambda
			//obtenemos el objeto form a través de spring
			LibroFrom libroFrom = contextoSpring.getBean(LibroFrom.class); //instanciamos la clase a través de la fábrica de spring
			libroFrom.setVisible(true);
		});

	}

}

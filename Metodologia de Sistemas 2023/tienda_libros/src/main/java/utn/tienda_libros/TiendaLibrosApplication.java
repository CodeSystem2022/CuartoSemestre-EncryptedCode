package utn.tienda_libros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import utn.tienda_libros.vista.libroForm;

import java.awt.*;

@SpringBootApplication
public class TiendaLibrosApplication {

	public static void main(String[] args) {


    ConfigurableApplicationContext  contextSpring =
            new SpringApplicationBuilder(TiendaLibrosApplication.class)
                    .headless(false)
                    .web(WebApplicationType.NONE)
                    .run(args);
    //Ejecutamos el codigo para cargar el formulario
   EventQueue.invokeLater(() -> { //Metodo Lambda
       //Obtenemos el objeto form a traves del spring
        libroForm lform = contextSpring.getBean(libroForm.class);
        lform.setVisible(true);
    });
}
}

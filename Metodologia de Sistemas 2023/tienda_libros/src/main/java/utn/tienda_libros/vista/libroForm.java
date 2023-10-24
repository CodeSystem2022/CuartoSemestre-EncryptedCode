package utn.tienda_libros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utn.tienda_libros.modelo.Libro;
import utn.tienda_libros.servicio.LibroServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

@Component
public class libroForm extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;
    private JTable TablaLibros;
    private JTextField idTexto;
    private JTextField libroTextoTextField;
    private JTextField autorTextoTextField;
    private JPanel PrecioTexto;
    private JTextField precioTextoTextField;
    private JTextField existenciastextoTextField;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private DefaultTableModel tablaModeloLibros;


    @Autowired
    public libroForm(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciarForma();

        agregarButton.addActionListener(e -> agregarLibro());
        TablaLibros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarLibroSeleccionado();
            }
        });
        TablaLibros.addComponentListener(new ComponentAdapter() {
        });
        modificarButton.addActionListener((e -> modificarLibro());
        eliminarButton.addActionListener((e -> eliminarLibro());
    }

    private void eliminarLibro() {
        var renglon = TablaLibros.getSelectedRow();
        if(renglon != -1){
            String idLibro =
                    TablaLibros.getModel().getValueAt(renglon, 0).toString();
            var libro = new Libro();
            libro.setIdLibro(Integer.parseInt(idLibro));
            libroServicio.eliminarLibro(libro);
            mostrarMensaje("Libro "+idLibro+" Eliminado");
            limpiarFormulario();
            listarLibros()
        }
        else {
            mostrarMensaje("No se ha seleccionado ningun libro de la tabla a eliminar");
        }
    }

    private void modificarLibro() {
        if(this.idTexto.equals("")){
            mostrarMensaje("Debes seleccionar un registro en la tabla");
        }
        else {
            //Verificamos que nombre del libro no sea nulo
            if(libroTextoTextField.getText().equals("")){
                mostrarMensaje("Digite el nombre del libro...");
                libroTextoTextField.requestFocusInWindow();
                return;
            }
            //Llenamos el objeto libro a actualizar
            int idLibro = Integer.parseInt(idTexto.getText());
            var nombreLibro = libroTextoTextField.getText();
            var autor = autorTextoTextField.getText();
            var precio = Double.parseDouble(precioTextoTextField.getText());
            var existencias = Integer.parseInt(existenciastextoTextField.getText());
            var libro = new Libro(idLibro, nombreLibro, autor, precio, existencias);
            libroServicio.guardarLibro(libro);
            mostrarMensaje("Se modifico el libro...");
            limpiarFormulario();
            listarLibros();


        }
    }

    private void agregarLibro() {
        //Leer los valores del formulario
        if(libroTextoTextField.getText().equals("")){
            mostrarMensaje("Ingresa el nombre del libro");
            libroTextoTextField.requestFocusInWindow();
            return;
        }
        var nombreLibro = libroTextoTextField.getText();
        var autor = autorTextoTextField.getText();
        var precio = Double.parseDouble(precioTextoTextField.getText());
        var existencias = Integer.parseInt(existenciastextoTextField.getText());
        //Creamos el objeto libro
        var libro = new Libro(null, nombreLibro, autor, precio, existencias);
        //libro.setNombreLibro(nombreLibro);
        //libro.setAutor(autor);
        //libro.setPrecio(precio);
        //libro.setExistencias(existencias);
        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("Se agrego el libro...");
        limpiarFormulario();
        listarLibros();



    }

    private void limpiarFormulario() {
        libroTextoTextField.setText("");
        autorTextoTextField.setText("");
        precioTextoTextField.setText("");
        existenciastextoTextField.setText("");
    }
    private void cargarLibroSeleccionado(){
        // los indices de las columnas inician en 0
        var renglon = TablaLibros.getSelectedRow();
        if(renglon != -1){
            String idlibro = TablaLibros.getModel().getValueAt(renglon, 0).toString();
            idTexto.setText(idlibro);
            String nombreLibro =
                    TablaLibros.getModel().getValueAt(renglon, 1).toString();
            libroTextoTextField.setText(nombreLibro);
            String autor =
                    TablaLibros.getModel().getValueAt(renglon, 2).toString();
            autorTextoTextField.setText(autor);
            String precio =
                    TablaLibros.getModel().getValueAt(renglon, 3).toString();
            precioTextoTextField.setText(precio);
            String existencias =
                    TablaLibros.getModel().getValueAt(renglon, 4).toString();
            existenciastextoTextField.setText(existencias);

        }
    }
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void iniciarForma(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900, 700);
        //Para obtener las dimensiones de la ventana
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = toolkit.getScreenSize();
        int x = (tamanioPantalla.width - getWidth()/2);
        int y = (tamanioPantalla.height - getHeight()/2);
        setLocation(x, y);
    }

    private void createUIComponents() {
        idTexto = new JTextField("");
        idTexto.setVisible(false);
        this.tablaModeloLibros = new DefaultTableModel(0, 5) {
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String[] cabecera = {"Id", "Libro", "Autor", "Precio", "Existencias"};
        this.tablaModeloLibros.setColumnIdentifiers(cabecera);
        //Instanciamos el objeto de JTable
        this.TablaLibros = new JTable(tablaModeloLibros);
        // Evitamos que se seleccionen varios registros
        TablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listarLibros();

    }
    private void listarLibros(){
        //Limpiar la tabla
        tablaModeloLibros.setRowCount(0);
        //Obtener los libros de la BD
        var libros = libroServicio.listarLibros();
        //Iteramos cada libro
        libros.forEach((libro) -> {//Funcion lambda
            //Creamos cada registro para agregarlos a la tabla
            Object [] renglonLibro = {
                    libro.getIdLibro(),
                    libro.getNombreLibro(),
                    libro.getAutor(),
                    libro.getPrecio(),
                    libro.getExistencias()
            };
            this.tablaModeloLibros.addRow(renglonLibro);
        });

    }
}

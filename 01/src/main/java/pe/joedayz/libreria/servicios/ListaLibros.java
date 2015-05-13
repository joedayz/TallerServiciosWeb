package pe.joedayz.libreria.servicios;

import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import pe.joedayz.libreria.daos.LibroDAO;
import pe.joedayz.libreria.modelos.Libro;


@WebService  //JAX-WS
public class ListaLibros {

	
	public List<Libro> listarLibros() {
		LibroDAO libroDAO = obtenerDAO();
		return libroDAO.listarLibros();
	}
	
	private LibroDAO obtenerDAO() {
		return new LibroDAO();
	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/libros", new ListaLibros());
		System.out.println("Servicio inicializado!");
	
	}

}

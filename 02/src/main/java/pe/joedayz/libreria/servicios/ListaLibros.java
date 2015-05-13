package pe.joedayz.libreria.servicios;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import pe.joedayz.libreria.daos.LibroDAO;
import pe.joedayz.libreria.modelos.Libro;


@WebService  //Contract Last
public class ListaLibros {

	@WebResult(name="libro")
	public List<Libro> listarLibros() {
		LibroDAO libroDAO = obtenerDAO();
		return libroDAO.listarLibros();
	}
	

	@RequestWrapper(className="pe.joedayz.libreria.servicios.jaxws.ListarLibrosPaginacion", 
			localName="listarLibrosPaginacion")
	@ResponseWrapper(className="pe.joedayz.libreria.servicios.jaxws.ListarLibrosPaginacionResponse", 
		localName="listarLibrosPaginacionResponse")
	@WebResult(name="libro")
	@WebMethod(operationName="listarLibrosPaginacion")
	public List<Libro> listarLibros(int numeroDePagina, int tamanhoDePagina) {
		LibroDAO libroDAO = obtenerDAO();
		return libroDAO.listarLibros(numeroDePagina, tamanhoDePagina);
	}
	
	private LibroDAO obtenerDAO() {
		return new LibroDAO();
	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/libros", new ListaLibros());
		System.out.println("Servicio inicializado!");
	
	}

}

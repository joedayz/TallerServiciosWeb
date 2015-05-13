package pe.joedayz.libreria.servicios;

import java.util.List;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ListaLibrosService listaLibrosService = 
				new ListaLibrosService(Client.class.getResource("/libros.wsdl"));
		
		ListaLibros listaLibros = listaLibrosService.getListaLibrosPort();
		
		List<Libro> libros = 
				listaLibros.listarLibrosPaginacion(0, 2);
		
		for(Libro libro: libros){
			System.out.println("Nombre del libro : " + libro.getNombre());
		}


	}

}

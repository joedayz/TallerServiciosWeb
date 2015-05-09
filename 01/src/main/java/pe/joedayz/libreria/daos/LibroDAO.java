package pe.joedayz.libreria.daos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pe.joedayz.libreria.modelos.Libro;

public class LibroDAO {

	public List<Libro> listarLibros() {
		List<Libro> libros = new ArrayList<Libro>();
		libros.add(new Libro(2012, new ArrayList<String>(Arrays.asList("Maximo Perez", 
				"Minimo Perez")), "Atlas", "Guia del Programador", 
				"La biblia del programador ..."));
		libros.add(new Libro(2012, new ArrayList<String>(Arrays.asList("Rudy Rails")), 
				"RubyPeru", "Ruby on Rails", "Cree rapidamente aplicaciones web"));
		return libros;
	}

}

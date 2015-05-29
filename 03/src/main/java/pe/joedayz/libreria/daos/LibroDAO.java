package pe.joedayz.libreria.daos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import pe.joedayz.libreria.modelos.Autor;
import pe.joedayz.libreria.modelos.EBook;
import pe.joedayz.libreria.modelos.Libro;

public class LibroDAO {

	private static List<Libro> libros;

	static {
		libros = new ArrayList<>();
		libros.add(new Libro(2012, new ArrayList<>(Arrays.asList(new Autor(
				"Max Alvarez", new Date()), new Autor("Juan Perez",
				new Date()))), "Peru JUG", "Guia del Programador",
				"Si Ud. nunca programo\" ..."));

		libros.add(new Libro(2012, new ArrayList<>(Arrays.asList(new Autor(
				"Roberto Carlos", new Date()))), "Ruby Peru",
				"Ruby on Rails", "Construya rapidamente aplicaciones Web"));

		EBook soaBook = new EBook(2012, new ArrayList<>(
				Arrays.asList(new Autor("Daniel Orihuela", new Date()))),
				"PUCP Publicaciones", "SOA Aplicado",
				"Aprenda SOA de forma práctica");
		libros.add(soaBook);
	}

	public List<Libro> listarLibros() {
		return libros;
	}

	public List<Libro> listarLibros(Integer numeroDePagina,
			Integer tamanhoDePagina) {
		List<Libro> libros = listarLibros();

		int indiceInicial = numeroDePagina * tamanhoDePagina;
		int indiceFinal = indiceInicial + tamanhoDePagina;

		indiceFinal = indiceFinal > libros.size() ? libros.size() : indiceFinal;
		indiceInicial = indiceInicial > indiceFinal ? indiceFinal
				: indiceInicial;

		return libros.subList(indiceInicial, indiceFinal);

	}

	public void crearLibro(Libro libro) {
		libros.add(libro);
	}

}

package pe.joedayz.libreria.modelos;

import java.util.List;

public class EBook extends Libro {

	private FormatoArchivo formato = FormatoArchivo.PDF;

	public EBook() {
		super();
	}

	public EBook(Integer anoDePublicacion, List<Autor> autores, String editora,
			String nombre, String resumen) {
		super(anoDePublicacion, autores, editora, nombre, resumen);
	}

	public FormatoArchivo getFormato() {
		return formato;
	}

	public void setFormato(FormatoArchivo formato) {
		this.formato = formato;
	}

}

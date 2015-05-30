package pe.joedayz.libreria.modelos;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Libro {

	private Integer anoDePublicacion;

	@XmlElementWrapper(name = "autores")
	@XmlElement(name = "autor")
	@XmlJavaTypeAdapter(value = AdaptadorAutores.class)
	private List<Autor> autores;
	private String editora;
	private String nombre;
	private String resumen;
	private Date fechaDeCreacion = new Date();

	public Libro() {
	}

	public Libro(Integer anoDePublicacion, List<Autor> autores, String editora,
			String nombre, String resumen) {
		this();
		this.anoDePublicacion = anoDePublicacion;
		this.autores = autores;
		this.editora = editora;
		this.nombre = nombre;
		this.resumen = resumen;
	}

	public Integer getAnoDePublicacion() {
		return anoDePublicacion;
	}

	public void setAnoDePublicacion(Integer anoDePublicacion) {
		this.anoDePublicacion = anoDePublicacion;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public static class AdaptadorAutores extends XmlAdapter<String, Autor> {

		@Override
		public String marshal(Autor autor) throws Exception {
			return autor.getNombre();
		}

		@Override
		public Autor unmarshal(String autor) throws Exception {
			return new Autor(autor, null);
		}

	}
}

package pe.joedayz.libreria.modelos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;


@XmlAccessorType(XmlAccessType.FIELD)
public class Libro {
	
	private Integer anoDePublicacion;
	
	@XmlElementWrapper(name="autores")
	@XmlElement(name="autor")
	private List<String> autores;
	private String editora;
	private String nombre;
	private String resumen;
	
	public Libro() {}
	
	public Libro(Integer anoDePublicacao, List<String> autores, String editora,
			String nome, String resumo) {
		super();
		this.anoDePublicacion = anoDePublicacao;
		this.autores = autores;
		this.editora = editora;
		this.nombre = nome;
		this.resumen = resumo;
	}

	public Integer getAnoDePublicacion() {
		return anoDePublicacion;
	}

	public void setAnoDePublicacion(Integer anoDePublicacion) {
		this.anoDePublicacion = anoDePublicacion;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
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
	
	
	
	

}

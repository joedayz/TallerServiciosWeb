package pe.joedayz.libreria.modelos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario {
	
	private String nombre;
	private String login;
	private String password;
	public String getNombre() {
		if (nombre != null)
			return nombre;
		return "";
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLogin() {
		if (login != null)
			return login;
		return "";
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		if (password != null)
			return password;
		return "";
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

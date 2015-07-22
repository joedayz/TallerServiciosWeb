package pe.joedayz.libreria.servicios.seguridad;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import java.util.Date;

import javax.crypto.Cipher;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.codec.binary.Base64;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
class Usuario {

	private String nombre;
	private String login;
	private String password;
	private Date fechaActualizacion;

	private static Cipher cipher;

	static {
		try {
			InputStream keyStream = Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("private.key");
			ObjectInputStream ois = new ObjectInputStream(keyStream);
			Key decodeKey = (Key) ois.readObject();
			ois.close();
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, decodeKey);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public Usuario() {
	}

	public Usuario(String login) {
		this.login = login;
	}


	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getPasswordDecodificado() {
		try {
			return new String(cipher.doFinal(Base64.decodeBase64(password
					.getBytes())));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

}

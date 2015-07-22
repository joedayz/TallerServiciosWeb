package pe.joedayz.libreria.modelos;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.methods.GetMethod;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Date fechaNacimiento;

	public Autor() {
	}

	public Autor(String nombre, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<URL> refs() throws HttpException, IOException {

		String autor = nombre.replace(" ", "+");
		String searchString = new StringBuilder(
				"/ajax/services/search/web?v=1.0&q=%22").append(autor)
				.append("%22").toString();

		GetMethod getMethod = new GetMethod(searchString);
		HttpState httpState = new HttpState();
		HttpConnection httpConnection = new HttpConnection(
				"ajax.googleapis.com", 80);
		httpConnection.open();
		getMethod.setFollowRedirects(true);
		int result = getMethod.execute(httpState, httpConnection);

		if (result == 200) {
			List<URL> responseList = new ArrayList<>();
			JSONObject jsonObject = JSONObject.fromObject(getMethod
					.getResponseBodyAsString());
			JSONArray results = jsonObject.getJSONObject("responseData")
					.getJSONArray("results");
			for (int i = 0; i < results.size(); i++) {
				String urlCrua = results.getJSONObject(i).getString(
						"unescapedUrl");
				URL url = new URL(urlCrua);
				responseList.add(url);
			}
			return responseList;
		}

		return Collections.emptyList();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}

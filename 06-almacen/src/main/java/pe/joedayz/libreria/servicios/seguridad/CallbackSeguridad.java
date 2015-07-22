package pe.joedayz.libreria.servicios.seguridad;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.ws.security.WSPasswordCallback;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.Base64;

public class CallbackSeguridad implements CallbackHandler {

	private static String USUARIO = "admin";

	private static String PASSWORD = "admin";

	private static LlaveRSA llaveRSA;

	static {
		try {
			llaveRSA = LlaveRSA.cargar();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String DIRECCION_SERVICIO_USUARIOS = "https://localhost:8443/soa-06-usuarios-0.0.1-SNAPSHOT/services/";

	private static Map<String, Usuario> cache = new ConcurrentHashMap<>();

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			if (callbacks[i] instanceof WSPasswordCallback) {
				WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
				Usuario usuario = encontrarUsuario(pc.getIdentifier());
				if (usuario == null)
					return;
				pc.setPassword(usuario.getPasswordDecodificado());
			}
		}

	}

	private Usuario encontrarUsuario(String login) throws IOException {
		Usuario usuario = null;
		try {

			ClientRequest request = new ClientRequest(DIRECCION_SERVICIO_USUARIOS
					+ "usuarios/{login}").pathParameters(login)
					.header("Authorization", getAuth())
					.body(MediaType.APPLICATION_XML, llaveRSA)
					.accept(MediaType.APPLICATION_XML);

			if (cache.containsKey(login)) {
				usuario = cache.get(login);
				request.header("If-Modified-Since",
						org.jboss.resteasy.util.DateUtil.formatDate(usuario
								.getFechaActualizacion()));
			}

			@SuppressWarnings("unchecked")
			ClientResponse<Usuario> response = request.post();
			if (response.getStatus() == Status.NOT_MODIFIED.getStatusCode()) {
				return usuario;
			}

			if (response.getStatus() == Status.OK.getStatusCode()) {
				usuario = response.getEntity(Usuario.class);

				Date date = org.jboss.resteasy.util.DateUtil.parseDate(response
						.getHeaders().getFirst("Date"));
				usuario.setFechaActualizacion(date);
				cache.put(login, usuario);
				return usuario;
			}

			if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
				return null;
			}

			throw new Exception("Usuario no localizado");
		} catch (Exception e) {
			throw new IOException(
					"No fue posible recuperar la información del usuario");
		}

	}

	private String getAuth() {
		return "Basic "
				+ Base64.encodeBytes((USUARIO + ":" + PASSWORD).getBytes());
	}

}

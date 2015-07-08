package pe.joedayz.usuarios.servicios.tests.integracion;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pe.joedayz.usuarios.modelos.Usuario;
import pe.joedayz.usuarios.modelos.Usuarios;
import pe.joedayz.usuarios.servicios.UsuariosServiceInterface;

public class UsuariosServiceIT {

	public static String SERVICES_CONTEXT = "http://localhost:8080/soa-05-0.0.1-SNAPSHOT/services";

	public static String USUARIOS_CONTEXT = SERVICES_CONTEXT + "/usuarios";

	private byte[] fotoSaudate;

	@Before
	public void setup() throws IOException {
		BufferedImage bufferedImage = ImageIO.read(UsuariosServiceIT.class
				.getResourceAsStream("/saudate.png"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "png", baos);
		this.fotoSaudate = baos.toByteArray();
	}

	@Test
	public void testeRecepcionImagenes() throws Exception {
		ClientResponse<byte[]> clientResponse = new ClientRequest(
				USUARIOS_CONTEXT + "/{id}").pathParameters(1).accept("image/*")
				.get(byte[].class);
		byte[] image = clientResponse.getEntity();
		int status = clientResponse.getStatus();

		Assert.assertEquals(200, status);
		Assert.assertArrayEquals(fotoSaudate, image);

		String descricao = clientResponse.getHeaders().getFirst(
				UsuariosServiceInterface.CAMPO_DESCRIPCION_IMAGEN);

		Assert.assertEquals("Alexandre Saudate", descricao);
	}

	@Test
	public void testCreacionImagenes() throws Exception {
		ClientResponse<?> clientResponse = new ClientRequest(USUARIOS_CONTEXT
				+ "/{id}")
				.pathParameters(1)
				.header(UsuariosServiceInterface.CAMPO_DESCRIPCION_IMAGEN,
						"Alexandre Saudate").body("image/png", fotoSaudate).put();

		Assert.assertEquals(204, clientResponse.getStatus());

		clientResponse = new ClientRequest(USUARIOS_CONTEXT + "/{id}")
				.pathParameters(1).accept("image/*").get(byte[].class);
		byte[] image = (byte[]) clientResponse.getEntity();
		int status = clientResponse.getStatus();

		Assert.assertEquals(200, status);
		Assert.assertArrayEquals(fotoSaudate, image);

		String descripcion = clientResponse.getHeaders().getFirst(
				UsuariosServiceInterface.CAMPO_DESCRIPCION_IMAGEN);

		Assert.assertEquals("Alexandre Saudate", descripcion);

	}

	@Test
	public void testRecepcionUsuarios() {
		UsuariosServiceInterface usuariosService = ProxyFactory.create(
				UsuariosServiceInterface.class, SERVICES_CONTEXT);

		@SuppressWarnings("unchecked")
		ClientResponse<Usuarios> response = (ClientResponse<Usuarios>) usuariosService
				.listarUsuarios(null, null, null, null);

		Assert.assertEquals(200, response.getStatus());

		Usuarios usuarios = response.getEntity(Usuarios.class);

		Assert.assertNotNull(usuarios);
		Assert.assertNotNull(usuarios.getUsuarios());
		Assert.assertEquals(5, usuarios.getUsuarios().size());
	}

	@Test
	public void testRecepcionUsuariosClientRequest() throws Exception {
		ClientResponse<Usuario> response = new ClientRequest(USUARIOS_CONTEXT
				+ "/{id}").pathParameters(1).get(Usuario.class);

		Usuario usuario = response.getEntity();

		Assert.assertNotNull(usuario);
	}

}

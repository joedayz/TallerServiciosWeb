package pe.joedayz.libreria.servicios.seguridad;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RSA")
@XmlAccessorType(XmlAccessType.FIELD)
public class LlaveRSA {

	private BigInteger modulus;

	private BigInteger publicExponent;

	public static LlaveRSA cargar() throws IOException,
			ClassNotFoundException {

		try (InputStream inputStream = LlaveRSA.class
				.getResourceAsStream("/public.key")) {
			ObjectInputStream ois = new ObjectInputStream(inputStream);
			RSAPublicKey rsaPublicKey = (RSAPublicKey) ois.readObject();
			LlaveRSA chaveRSA = new LlaveRSA();
			chaveRSA.modulus = rsaPublicKey.getModulus();
			chaveRSA.publicExponent = rsaPublicKey.getPublicExponent();
			return chaveRSA;
		}
	}

}

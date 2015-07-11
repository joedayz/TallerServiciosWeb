package pe.joedayz.soa;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

/**
 * 
 * Este codigo nos dara un para de claves que siguen
 * el algoritmo RSA (compresion de  2048 bytes). Dos archivos seran generados
 * : uno llamado private.key (llave privada) y otro llamado
 * public.key (llave publica). La llave publica encripta datos y 
 * la privada desencripta, guarde en lugar seguro.
 * 
 * @author JoeDayz
 * 
 */

public class GeneradorLlaves {

	public static void main(String[] args) throws Exception {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(2048);

		KeyPair kp = kpg.generateKeyPair();
		Key publicKey = kp.getPublic();
		Key privateKey = kp.getPrivate();

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"public.key"));
		oos.writeObject(publicKey);
		oos.flush();
		oos.close();

		oos = new ObjectOutputStream(new FileOutputStream("private.key"));
		oos.writeObject(privateKey);
		oos.flush();
		oos.close();

	}

}

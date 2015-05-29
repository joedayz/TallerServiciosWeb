package pe.joedayz.libreria.servicos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import pe.joedayz.libreria.modelos.Autor;

@WebService
public class AutoresService {

   public List<Autor> listarAutores() {
      Autor maxAlvarez = new Autor("Max Alvarez", new Date());
      Autor juanPerez = new Autor("Juan Perez", new Date());
      Autor danielOrihuela = new Autor("Daniel Orihuela", new Date());
      return new ArrayList<>(Arrays.asList(maxAlvarez, juanPerez,
            danielOrihuela));
   }

   public static void main(String[] args) {
      Endpoint.publish("http://localhost:28080/autores", new AutoresService());

   }

}

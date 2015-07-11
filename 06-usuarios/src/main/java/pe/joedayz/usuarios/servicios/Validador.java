package pe.joedayz.usuarios.servicios;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import pe.joedayz.usuarios.modelos.AlgoritmoValidacionCPF;

@Path("/validador")
public class Validador {

   @GET
   @Path("/cpf/{valor : [0-9]{11}}")
   public Response validaCPF(
         @PathParam("valor") String valor,
         @QueryParam("algoritmo") @DefaultValue("TODOS") AlgoritmoValidacionCPF algoritmo) {


      if (algoritmo.esValido(valor)) {
         return Response.ok().build();
      }
      return Response.status(Status.BAD_REQUEST).build();

   }
}

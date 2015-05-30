package pe.joedayz.libreria.servicios;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPFaultException;

import pe.joedayz.libreria.daos.LibroDAO;
import pe.joedayz.libreria.modelos.Libro;
import pe.joedayz.libreria.modelos.Usuario;

@WebService
public class LibrosService {

   @WebResult(
         name = "libro")
   public List<Libro> listarLibros() {
      LibroDAO libroDAO = obtenerDAO();
      return libroDAO.listarLibros();
   }

   @WebResult(
         name = "libro")
   public List<Libro> listarLibrosPaginacion(int numeroDePagina,
         int tamanhoDePagina) {
      LibroDAO libroDAO = obtenerDAO();
      return libroDAO.listarLibros(numeroDePagina, tamanhoDePagina);
   }

   public void crearLibro(@WebParam(
         name = "libro") Libro libro, @WebParam(
         name = "usuario", header = true) Usuario usuario)
         throws UsuarioNoAutorizadoException, SOAPException {
      if (usuario.getLogin().equals("soa")
            && usuario.getPassword().equals("soa")) {
         obtenerDAO().crearLibro(libro);
      } else if (usuario.getNombre().equals("faultCode")) {
         SOAPFault soapFault = SOAPFactory.newInstance().createFault(
               "Usuario no autorizado",
               new QName(SOAPConstants.URI_NS_SOAP_1_1_ENVELOPE,
                     "Client.autorizacion"));
         soapFault
               .setFaultActor("http://pe.joedayz.libreria.servicios/LibrosService");
         throw new SOAPFaultException(soapFault);
      } else {
         throw new UsuarioNoAutorizadoException(
               "Usuario no autorizado");
      }
   }

   private LibroDAO obtenerDAO() {
      return new LibroDAO();
   }

   public static void main(String[] args) {
      Endpoint.publish("http://localhost:28080/libros",
            new LibrosService());
      System.out.println("Servicio inicializado!");

   }

}

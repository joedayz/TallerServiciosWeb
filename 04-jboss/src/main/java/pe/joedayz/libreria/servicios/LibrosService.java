package pe.joedayz.libreria.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import pe.joedayz.libreria.modelos.Libro;
import pe.joedayz.libreria.modelos.Usuario;

@WebService
@Stateless
public class LibrosService {

   @PersistenceContext
   private EntityManager em;

   @WebResult(
         name = "libro")
   public List<Libro> listarLibros() {
      return em.createQuery(
            "select distinct l from Libro l left join FETCH l.autores",
            Libro.class).getResultList();
   }

   @WebResult(
         name = "libro")
   public List<Libro> listarLibrosPaginacion(int numeroDePagina,
         int tamanhoDePagina) {

      TypedQuery<Libro> query = em.createQuery(
            "select distinct l from Libro l left join FETCH l.autores",
            Libro.class);
      query.setFirstResult(numeroDePagina * tamanhoDePagina);
      query.setMaxResults(tamanhoDePagina);
      return query.getResultList();
   }

   public void crearLibro(@WebParam(
         name = "libro") Libro libro, @WebParam(
         name = "usuario", header = true) Usuario usuario)
         throws UsuarioNoAutorizadoException, SOAPException {
      if (usuario.getLogin().equals("soa") && usuario.getPassword().equals("soa")) {
         em.persist(libro);
      } else if (usuario.getNombre().equals("faultCode")) {
         SOAPFault soapFault = SOAPFactory.newInstance().createFault(
               "Usuario no autorizado",
               new QName(SOAPConstants.URI_NS_SOAP_1_1_ENVELOPE,
                     "Client.autorizacion"));
         soapFault
               .setFaultActor("http://pe.joedayz.libreria.servicios/LibrosService");
         throw new SOAPFaultException(soapFault);
      } else {
         throw new UsuarioNoAutorizadoException("Usuario no autorizado");
      }
   }

}

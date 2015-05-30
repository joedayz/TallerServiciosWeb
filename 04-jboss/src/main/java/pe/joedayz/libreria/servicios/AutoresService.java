package pe.joedayz.libreria.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.joedayz.libreria.modelos.Autor;

@WebService
@Stateless
public class AutoresService {

   @PersistenceContext
   private EntityManager em;

   public List<Autor> listarAutores() {
      return em.createQuery("select a from Autor a", Autor.class)
            .getResultList();
   }

}

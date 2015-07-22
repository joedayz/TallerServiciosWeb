package pe.joedayz.libreria.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.xml.soap.SOAPException;

import pe.joedayz.libreria.modelos.Libro;

@WebService
@Stateless
public class LibrosService {

	@PersistenceContext
	private EntityManager em;

	@WebResult(name = "libro")
	public List<Libro> listarLibros() {
		return em.createQuery(
				"select distinct l from Libro l left join FETCH l.autores",
				Libro.class).getResultList();
	}

	@WebResult(name = "libro")
	public List<Libro> listarLibrosPaginacion(int numeroDaPagina,
			int tamanhoDaPagina) {

		TypedQuery<Libro> query = em.createQuery(
				"select distinct l from Libro l left join FETCH l.autores",
				Libro.class);
		query.setFirstResult(numeroDaPagina * tamanhoDaPagina);
		query.setMaxResults(tamanhoDaPagina);
		return query.getResultList();
	}

	public void crearLibro(@WebParam(name = "libro") Libro livro)
			throws UsuarioNoAutorizadoException, SOAPException {
		em.persist(livro);

	}

}

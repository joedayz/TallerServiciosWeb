
package pe.joedayz.libreria.servicios;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.joedayz.libreria.servicios package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListarLibros_QNAME = new QName("http://servicios.libreria.joedayz.pe/", "listarLibros");
    private final static QName _ListarLibrosResponse_QNAME = new QName("http://servicios.libreria.joedayz.pe/", "listarLibrosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.joedayz.libreria.servicios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListarLibrosResponse }
     * 
     */
    public ListarLibrosResponse createListarLibrosResponse() {
        return new ListarLibrosResponse();
    }

    /**
     * Create an instance of {@link ListarLibros }
     * 
     */
    public ListarLibros createListarLibros() {
        return new ListarLibros();
    }

    /**
     * Create an instance of {@link Libro }
     * 
     */
    public Libro createLibro() {
        return new Libro();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarLibros }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios.libreria.joedayz.pe/", name = "listarLibros")
    public JAXBElement<ListarLibros> createListarLibros(ListarLibros value) {
        return new JAXBElement<ListarLibros>(_ListarLibros_QNAME, ListarLibros.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarLibrosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios.libreria.joedayz.pe/", name = "listarLibrosResponse")
    public JAXBElement<ListarLibrosResponse> createListarLibrosResponse(ListarLibrosResponse value) {
        return new JAXBElement<ListarLibrosResponse>(_ListarLibrosResponse_QNAME, ListarLibrosResponse.class, null, value);
    }

}

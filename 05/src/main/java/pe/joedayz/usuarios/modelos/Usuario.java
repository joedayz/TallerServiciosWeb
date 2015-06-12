package pe.joedayz.usuarios.modelos;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import pe.joedayz.usuarios.modelos.rest.Link;
import pe.joedayz.usuarios.modelos.rest.RESTEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
public class Usuario extends EntidadModelo implements RESTEntity {

   @Id
   @GeneratedValue(
         strategy = GenerationType.IDENTITY)
   private Long id;

   private String nombre;
   private String login;
   private String password;

   @OneToOne(
         cascade = { CascadeType.ALL }, orphanRemoval = true)
   @XmlTransient
   private Imagen imagen;

   @XmlElement(
         name = "link")
   @Transient
   private Collection<Link> links;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNombre() {
      if (nombre != null)
         return nombre;
      return "";
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getLogin() {
      if (login != null)
         return login;
      return "";
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public String getPassword() {
      if (password != null)
         return password;
      return "";
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Imagen getImagen() {
      return imagen;
   }

   public void setImagen(Imagen imagen) {
      this.imagen = imagen;
   }

   @Override
   public void agregarLink(Link link) {
      if (links == null) {
         links = new ArrayList<>();
      }
      links.add(link);
   }

}

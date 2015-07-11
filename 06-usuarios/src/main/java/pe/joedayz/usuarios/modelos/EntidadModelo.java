package pe.joedayz.usuarios.modelos;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@MappedSuperclass
public abstract class EntidadModelo {

   @Temporal(TemporalType.TIMESTAMP)
   private Date fechaActualizacion;

   @XmlTransient
   public Date getFechaActualizacion() {
      return fechaActualizacion;
   }

   public void setFechaActualizacion(Date fechaActualizacion) {
      this.fechaActualizacion = fechaActualizacion;
   }

   @PreUpdate
   @PrePersist
   protected void ajustarFechaActualizacion() {
      this.fechaActualizacion = new Date();
   }

}

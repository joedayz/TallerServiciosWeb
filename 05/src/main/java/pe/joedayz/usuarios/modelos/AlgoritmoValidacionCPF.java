package pe.joedayz.usuarios.modelos;

import java.util.ArrayList;
import java.util.Collection;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public enum AlgoritmoValidacionCPF {

   MODULO11 {
      public boolean esValido(String valor) {
         CPFValidator cpfValidator = new CPFValidator(false);
         try {
            cpfValidator.assertValid(valor);
            return true;
         } catch (InvalidStateException invalidStateException) {
            return false;
         }
      }
   },
   RECETA {

      private Collection<String> valoresValidos = new ArrayList<String>();

      {
         valoresValidos.add("53389399321");
         valoresValidos.add("64573128530");
         valoresValidos.add("53783947677");
         valoresValidos.add("79780901671");
         valoresValidos.add("75538117774");
      }

      public boolean esValido(String valor) {
         return valoresValidos.contains(valor);
      }
   },
   TODOS {
      public boolean esValido(String valor) {
         return MODULO11.esValido(valor) && RECETA.esValido(valor);
      }
   };

   public abstract boolean esValido(String valor);

}

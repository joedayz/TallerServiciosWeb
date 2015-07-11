package pe.joedayz.usuarios.servicios.seguridad;

public class ExcepcionCriptografia extends Exception {

	private static final long serialVersionUID = 1L;

	public ExcepcionCriptografia() {
		super();

	}

	public ExcepcionCriptografia(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ExcepcionCriptografia(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionCriptografia(String message) {
		super(message);
	}

	public ExcepcionCriptografia(Throwable cause) {
		super(cause);
	}

}

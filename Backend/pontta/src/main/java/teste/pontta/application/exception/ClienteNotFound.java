package teste.pontta.application.exception;

public class ClienteNotFound extends RuntimeException {
  public ClienteNotFound(String message) {
    super(message);
  }
}

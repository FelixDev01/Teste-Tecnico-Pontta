package teste.pontta.application.exception;

public class ClienteNotFound extends RuntimeException {
    public ClienteNotFound(Long id) {

        super("O cliente do Id: " + id + " não foi encontrado");
    }
}

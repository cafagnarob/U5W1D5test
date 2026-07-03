package roberto.cafagna.U5W1D5test.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("La risorsa con id " + id + " non è stata trovata!");
    }
}

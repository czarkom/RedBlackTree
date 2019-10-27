public class NoKeyInTreeException extends RuntimeException {
    NoKeyInTreeException(){
        super("There's no given key in tree");
    }
}

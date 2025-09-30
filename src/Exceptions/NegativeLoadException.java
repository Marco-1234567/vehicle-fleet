package Exceptions;

public class NegativeLoadException extends Exception {
    public NegativeLoadException(int load) {
        super("Load " + load + " is negative");
    }
}

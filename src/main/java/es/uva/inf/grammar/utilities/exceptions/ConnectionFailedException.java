package es.uva.inf.grammar.utilities.exceptions;

public class ConnectionFailedException extends RuntimeException {

    public ConnectionFailedException(Throwable ex){
        super(ex);
    }
}

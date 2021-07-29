package exception;

public class InvalidExpressionException extends Exception{

    public InvalidExpressionException(String errorMessage, Throwable e){
      super(errorMessage, e);
    }

    public InvalidExpressionException(String errorMessage){
        super(errorMessage);
    }
}

package Model.Error;

import java.io.IOException;


public class KuruException extends RuntimeException{

    private String message;
    private  ErrorType typeError;
    public KuruException(String message, ErrorType type) {
        super(message);
        this.message = message;
        this.typeError = type ;
    }


    public ErrorType getTypeError() {
        return typeError;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

package exceptions;

public class MyEmptyException extends Exception {

    public MyEmptyException() {
        super("Stack is cashed ... can't do that!");
    }

}

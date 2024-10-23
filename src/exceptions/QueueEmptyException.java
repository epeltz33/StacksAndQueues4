
package exceptions;

public class QueueEmptyException extends Exception { // Custom exception for empty queue scenarios
    public QueueEmptyException() {
        super("Alas, poor queue! I knew it well - but now it's empty.");
    }
}
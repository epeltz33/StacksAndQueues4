// QueueFullException.java
package exceptions;

public class QueueFullException extends Exception {
  public QueueFullException() {
    super("I am become death, destroyer of queues - capacity reached!");
  }
}

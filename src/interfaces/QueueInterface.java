package interfaces;

import exceptions.QueueEmptyException;
import exceptions.QueueFullException;

public interface QueueInterface<E> {

    void enqueue(E element) throws QueueFullException; // add an element to the queue - always at the end of the queue

    E dequeue() throws QueueEmptyException; // remove and return the front of the queue

    boolean isEmpty();

    boolean isFull();

}

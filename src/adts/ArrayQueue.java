package adts;

import interfaces.QueueInterface;
import exceptions.QueueFullException;
import exceptions.QueueEmptyException;

public class ArrayQueue<E> implements QueueInterface<E> { // ArrayQueue class implements QueueInterface
    protected E[] queue; // array to hold the queue elements
    protected int front;
    protected int rear;
    protected int size;
    protected final int DEFAULT_CAPACITY = 5;


    public ArrayQueue() {
        queue = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    public ArrayQueue(int capacity) {
        queue = (E[]) new Object[capacity]; // create a new array of the specified capacity
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(E element) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException();
        }
        rear = (rear + 1) % queue.length; // queue.length is the size of the array (circular behavior)
        queue[rear] = element;
        size++;
    }

    @Override
public E dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        E element = queue[front];
        queue[front] = null; // clear the reference to the dequeued element
        front = (front + 1) % queue.length;
        size--;
        return element;
}

@Override
    public boolean isEmpty() {
        return size == 0;
}
@Override
    public boolean isFull() { //
        return size == queue.length;
}

@Override
    public String toString() {
    StringBuilder qStr = new StringBuilder("Queue: "); // Initialize the string builder
    if (!isEmpty()) { // Check if the queue is not empty, if it is, return just "Queue: "
        int current = front;
        for (int i = 0; i < size; i++) {
            qStr.append(queue[current]).append(" "); // Append each element to the string
            current = (current + 1) % queue.length;
        }
    }
    return qStr.toString();
 }

}
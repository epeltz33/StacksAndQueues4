package adts;

import interfaces.QueueInterface;

public class ArrayQueueFF0<E> implements QueueInterface<E> {

    protected E[] queue;  // underlying data structure

    protected final int FRONT = 0;
    protected int rear = -1;

    protected final int DEFAULT_CAPACITY = 5;

    public ArrayQueueFF0() {
        queue = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayQueueFF0(int capacity) {
        queue = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) {
        rear++;
        queue[rear] = element;
    }

    @Override
    public E dequeue() {
        E temp = queue[FRONT];
        for (int i = FRONT; i < rear; i++) {
            queue[i] = queue[i+1];
        }
        queue[rear] = null;
        rear--;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return rear == -1;
    }

    @Override
    public boolean isFull() {
        return rear == queue.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder qStr = new StringBuilder("\nqueue: ");
        for (int i = FRONT; i <= rear; i++) {
            qStr.append(queue[i] + " ");
            // qStr = qStr + queue[i];
        }
        return qStr.toString();
    }


}


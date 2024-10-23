package adts;

public class ArrayQofStringsFF0 {

    protected String[] queue;  // underlying data structure

    protected final int FRONT = 0;
    protected int rear = -1;

    protected final int DEFAULT_CAPACITY = 5;

    public ArrayQofStringsFF0() {
        queue = new String[DEFAULT_CAPACITY];
    }

    public ArrayQofStringsFF0(int capacity) {
        queue = new String[capacity];
    }

    public void enqueue(String element) {
        rear++;
        queue[rear] = element;
    }

    public String dequeue() {
        String temp = queue[FRONT];
        for (int i = FRONT; i < rear; i++) {
            queue[i] = queue[i+1];
        }
        queue[rear] = null;
        rear--;
        return temp;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

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





package adts;

import interfaces.QueueInterface;
import nodes.LLNode;

public class LLQueue<E> implements QueueInterface<E> {

    LLNode<E> front;  // i.e., head
    LLNode<E> rear;   // i.e., tail

    @Override
    public void enqueue(E element) {
        LLNode<E> newNode = new LLNode<>(element);
		/*
		if (front == null) {  // queue is empty
			front = rear = newNode;
		}
		else {
			rear.setNext(newNode);
			rear = newNode;
		}
		*/
        if (front == null) {  // queue is empty
            front = newNode;
        }
        else {
            rear.setNext(newNode);
        }
        rear = newNode;
    }

    @Override
    public E dequeue() {
        E temp = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    public String toString() {
        StringBuilder qStr = new StringBuilder();
        LLNode<E> ptr = front;
        while (ptr != null) {
            qStr.append(ptr.getData() + " ");
            ptr = ptr.getNext();
        }
        return qStr.toString();
    }
}

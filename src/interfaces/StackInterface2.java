package interfaces;

import exceptions.MyEmptyException;

public interface StackInterface2<E> {

    void push(E element);  // add an element to the stack - always at the "top"

    E pop() throws MyEmptyException;   // remove and return the top of the stack

    E peek();  // return the top of the stack ... without removing

    boolean isEmpty();

    boolean isFull();

}

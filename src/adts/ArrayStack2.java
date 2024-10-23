package adts;

import interfaces.StackInterface2;
import exceptions.MyEmptyException;

public class ArrayStack2<E> implements StackInterface2<E> {

    protected E[] stack;    // array that holds the stack's elements

    protected int top = -1;  // array index of element at the top of the stack
    // top == -1 means the stack is empty

    protected final int DEFAULT_CAPACITY = 7;

    public ArrayStack2( ) {
        stack = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayStack2(int capacity) {
        stack = (E[]) new Object[capacity];
    }


    // PRECONDITION: application code will not attempt
    //   a push() when the stack is full
    @Override
    public void push(E element) {
        stack[++top] = element;
    }


    // PRECONDITION: application code will not attempt
    //   a pop() when the stack is empty
    /**/
    @Override
    public E pop() throws MyEmptyException {
        if (!isEmpty()) {
            E temp = stack[top];
            stack[top] = null;
            top--;
            return temp;
        }
        else {
            throw new MyEmptyException();
        }
    }
    /**/

	/* alternative quick & dirty pop that leaves
	 * popped elements in the array -
	 * not an efficient use of heap space /

	   public E pop() {
		   return stack[top--];
	   }

	/**/


    // PRECONDITION: application code will not attempt
    //   a peek() when the stack is empty
    @Override
    public E peek() {
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == (stack.length - 1);
    }

    public String toString() {
        String stackString = "stack, top to bottom:\n---------------------\n";
        int index = top;
        while (index >= 0) {
            stackString = stackString + stack[index--] + "\n";
        }
        return stackString;
    }

}


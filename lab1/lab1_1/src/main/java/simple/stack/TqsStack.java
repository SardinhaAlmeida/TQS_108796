package simple.stack;

import java.util.*;

public class TqsStack<T> {

    private LinkedList<T> stack;
    private int fullsize = 0;

    public TqsStack() {
        stack = new LinkedList<T>();
    }

    public TqsStack(int fullsize) {
        this.fullsize = fullsize;
        stack = new LinkedList<T>();
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        } else {
            return stack.removeFirst();
        }
    }

    public int size() {
        return stack.size();
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        } else {
            return stack.getFirst();
        }
    }

    public void push(T element) {
        if (fullsize > 0 && stack.size() >= fullsize) {
            throw new IllegalStateException("Stack is full");
        } else{
            stack.addFirst(element);
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    
}

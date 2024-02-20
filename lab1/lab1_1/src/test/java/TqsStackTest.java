import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import simple.stack.TqsStack;


public class TqsStackTest {

    TqsStack<String> wordsStack;

    @BeforeEach //antes da execução de cada teste
    public void setup() {
        wordsStack = new TqsStack<>(); //garante que a stack está vazia
    }

    @DisplayName("A stack is empty on construction")
    @Test
    void isEmpty() {
        assertTrue(wordsStack.isEmpty());
    }

    @DisplayName("A stack has size 0 on construction")
    @Test
    void sizeIsZero() {
        assertEquals(0, wordsStack.size());
    }

    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    @Test
    void sizeAfterPush(){
        wordsStack.push("olá");
        wordsStack.push("adeus");

        assertEquals(2, wordsStack.size());
    }

    @DisplayName("If one pushes x then pops, the value popped is x")
    @Test
    void pushAndPop(){
        wordsStack.push("olá");
        wordsStack.push("adeus");

        assertEquals("adeus", wordsStack.pop());
    }

    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    @Test
    void pushAndPeek(){
        wordsStack.push("olá");
        wordsStack.push("adeus");

        int size = wordsStack.size();

        assertEquals("adeus", wordsStack.peek());
        assertEquals(size, wordsStack.size());
    }

    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    @Test
    void size(){
        wordsStack.push("olá");
        wordsStack.push("adeus");
        wordsStack.push("ciao");

        int size = wordsStack.size();
        for (int i = 0; i < size; i++) {
            wordsStack.pop();
        }

        assertTrue(wordsStack.isEmpty());
        assertEquals(0, wordsStack.size());
    }

    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    @Test
    void popEmpty(){

        NoSuchElementException exception = Assertions.assertThrows(java.util.NoSuchElementException.class, () -> {
            wordsStack.pop();
        });

        assertEquals("Stack is empty", exception.getMessage());
    }

    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    @Test
    void peekEmpty(){

        NoSuchElementException exception = Assertions.assertThrows(java.util.NoSuchElementException.class, () -> {
            wordsStack.peek();
        });

        assertEquals("Stack is empty", exception.getMessage());
    }

    @DisplayName("pushing onto a full stack does throw an IllegalStateException")
    @Test
    void pushFull(){
        wordsStack = new TqsStack<>(2);

        wordsStack.push("olá");
        wordsStack.push("adeus");

        IllegalStateException exception = Assertions.assertThrows(java.lang.IllegalStateException.class, () -> {
            wordsStack.push("ciao");
        });

        assertEquals("Stack is full", exception.getMessage());
    }

    
}

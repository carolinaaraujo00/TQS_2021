import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack<String> test;

    @BeforeEach
    void before(){
        this.test = new Stack();
    }

    // a) A stack is empty on construction.
    @Test
    void testIsEmpty(){
        assertTrue(this.test.isEmpty(), "Empty stack is not returning as empty.");
    }

    // b) A stack has size 0 on construction.
    @Test
    void testSizeOnConstruction(){
        assertEquals(0, this.test.size(), "New stack size is not returning 0");
    }

    // c) After n pushes to an empty stack, n > 0, the stack is not empty and its size is n
    @Test
    void testSizeAfterPushes(){
        this.test.push("primeiro");
        this.test.push("segundo");
        this.test.push("terceiro");

        assertEquals(3, this.test.size(), "After 3 pushes the stack's size isn't returning 3");

    }

    // d) If one pushes x then pops, the value popped is x.
    @Test
    void testPop(){
        this.test.push("primeiro");
        this.test.push("segundo");
        this.test.push("terceiro");

        assertEquals("terceiro", this.test.pop(), "Popped value doesn't match the last value added");

    }

    // e) If one pushes x then peeks, the value returned is x, but the size stays the same
    @Test
    void testPeek(){
        this.test.push("primeiro");
        this.test.push("segundo");
        this.test.push("terceiro");

        // a diferença entre assertAll e dois asserts separados é que o assertAll tem sempre de verificar
        // as duas condições, e apenas se as duas passarem é que o teste passa
        // SOURCE: https://stackoverflow.com/questions/40796756/assertall-vs-multiple-assertions-in-junit5

        assertAll(
                () -> assertEquals("terceiro", this.test.peek(), "Peeked value doesn't match the last value added."),
                () -> assertEquals(3, this.test.size(), "The size after peeking doesn't stay the same as before peeking.")
        );
    }

    // f) If the size is n, then after n pops, the stack is empty and has a size 0
    @Test
    void testSizeAndEmptyAfterPops(){
        this.test.push("primeiro");
        this.test.push("segundo");
        this.test.push("terceiro");

        this.test.pop();
        this.test.pop();
        this.test.pop();

        assertAll(
                () -> assertEquals(0, this.test.size(), "After popping all the items in the stack, it didn't return as size 0"),
                () -> assertTrue(this.test.isEmpty(), "After popping all the items, it didn't return as being empty")
        );
    }

    // g) Popping from an empty stack does throw a NoSuchElementException
    // https://howtodoinjava.com/junit5/expected-exception-example/
    @Test
    void testExceptionWhenPoppingEmptyStack(){
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            this.test.pop();
        });
    }

    // h) Peeking into an empty stack does throw a NoSuchElementException
    @Test
    void testExceptionWhenPeekingEmptyStack(){
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            this.test.peek();
        });
    }

    // i) For bounded stacks only, pushing onto a full stack does throw an IllegalStateException
    @Test
    void testBoundedStack(){
        this.test = new Stack(3);
        this.test.push("primeiro");
        this.test.push("segundo");
        this.test.push("terceiro");

        Assertions.assertThrows(IllegalStateException.class, () -> {
            this.test.push("quarto");
        });
    }
}
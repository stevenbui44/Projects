package structures;

import static org.junit.Assert.*;
import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for LinkedStack.
 * Checks the expected outputs of the Stack abstract data type behaviors when using
 * a singly-linked list data structure
 *
 * @author Dr. King
 * @author Steven Bui
 */
public class ArrayBasedStackTest {

	/** Holds the stack to test */
    private ArrayBasedStack<String> stack;
    
    /**
     * Create a new instance of a linked list-based stack before each test case executes
     */
    @Before
    public void setUp() {
        stack = new ArrayBasedStack<String>();
    }
    
    /**
     * Test the output of the push(e) behavior
     */ 
    @Test
    public void testPush() {
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        
        stack.push("one");
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals("one", stack.top());
        
        stack.push("two");
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals("two", stack.top());
    }

    /**
     * Test the output of the pop() behavior, including expected exceptions
     */
    @Test
    public void testPop() {
        assertEquals(0, stack.size());
        
        try {
            stack.pop();
            fail("EmptyStackException should have been thrown.");
        } catch (Exception e) {
            assertTrue(e instanceof EmptyStackException);
        }
        
        stack.push("one");
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals("one", stack.top());
        
        stack.push("two");
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals("two", stack.top());
        
        String s1 = stack.pop();
        assertEquals("two", s1);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        
        String s2 = stack.pop();
        assertEquals("one", s2);
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        
        try {
            stack.pop();
            fail("EmptyStackException should have been thrown.");
        } catch (Exception e) {
            assertTrue(e instanceof EmptyStackException);
        }
        
    }

    /**
     * Test the output of the top() behavior, including expected exceptions
     */
    @Test
    public void testTop() { 
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        
        try {
            stack.top();
            fail("EmptyStackException should have been thrown.");
        } catch (Exception e) {
            assertTrue(e instanceof EmptyStackException);
        }
        
        stack.push("one");
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals("one", stack.top());
        
        stack.push("two");
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals("two", stack.top());
        
        String s1 = stack.pop();
        assertEquals("two", s1);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals("one", stack.top());
        
        String s2 = stack.pop();
        assertEquals("one", s2);
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        
        try {
            stack.top();
            fail("EmptyStackException should have been thrown.");
        } catch (Exception e) {
            assertTrue(e instanceof EmptyStackException);
        }
    }

}
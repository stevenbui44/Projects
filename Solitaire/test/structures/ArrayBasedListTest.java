package structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for ArrayBasedList.
 * Checks the expected outputs of the List abstract data type behaviors when using
 * an array-based list data structure
 *
 * @author Dr. King
 * @author Steven Bui
 */
public class ArrayBasedListTest {

	/**
	 * List of Strings to test ArrayBasedList implementation.
	 */
    private ArrayBasedList<String> list;

    /**
     * Create a new instance of an array-based list before each test case executes
     */
    @Before
    public void setUp() {
        list = new ArrayBasedList<String>();
    }

    /**
     * Test the output of the add(index, e) behavior, including expected exceptions
     */
    @Test
    public void testAddIndex() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());        

        list.add(0, "one");
        assertEquals(1, list.size());
        assertEquals("one", list.get(0));
        assertFalse(list.isEmpty());
        
        // Use the statements above to help guide your test cases
        // for data structures: Start with an empty data structure, then
        // add an element and check the accessor method return values.
        // Then add another element and check again. Continue to keep checking
        // for special cases. For example, for an array-based list, you should
        // continue adding until you trigger a resize operation to make sure
        // the resize operation worked as expected.
        
        try{
            list.add(15,  "fifteen");
            fail("An IndexOutOfBoundsException should have been thrown");
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
        
        list.add(1, "two");
        assertEquals(2, list.size());
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertFalse(list.isEmpty());
        
        list.add(0, "three");
        assertEquals(3, list.size());
        assertEquals("three", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertFalse(list.isEmpty());        
        
    }

    /**
     * Test the output of the addLast behavior
     */
    @Test
    public void testAddLast() {
    	assertEquals(0, list.size());
        assertTrue(list.isEmpty());        

        list.add(0, "one");
        assertEquals(1, list.size());
        assertEquals("one", list.get(0));
        assertFalse(list.isEmpty());
        
        list.add(1, "two");
        assertEquals(2, list.size());
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertFalse(list.isEmpty());
        
        list.add(2, "three");
        assertEquals(3, list.size());
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
        assertFalse(list.isEmpty());
        
        list.addLast("four");
        assertEquals(4, list.size());
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
        assertEquals("four", list.get(3));
        assertFalse(list.isEmpty());
    }

    /**
     * Test the output of the last() behavior, including expected exceptions
     */
    @Test
    public void testLast() {
    	assertEquals(0, list.size());
        assertTrue(list.isEmpty());        

        list.add(0, "one");
        assertEquals(1, list.size());
        assertEquals("one", list.get(0));
        assertEquals("one", list.last());
        assertFalse(list.isEmpty());
        
        list.add(1, "two");
        assertEquals(2, list.size());
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("two", list.last());
        assertFalse(list.isEmpty());
        
        list.add(0, "three");
        assertEquals(3, list.size());
        assertEquals("three", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("two", list.last());
        assertFalse(list.isEmpty());
    }

    /**
     * Test the output of the addFirst behavior
     */
    @Test
    public void testAddFirst() {
    	assertEquals(0, list.size());
        assertTrue(list.isEmpty());        

        list.add(0, "one");
        assertEquals(1, list.size());
        assertEquals("one", list.get(0));
        assertFalse(list.isEmpty());
        
        list.addFirst("two");
        assertEquals(2, list.size());
        assertEquals("two", list.get(0));
        assertEquals("one", list.get(1));
        assertFalse(list.isEmpty());
    }

    /**
     * Test the output of the first() behavior, including expected exceptions
     */
    @Test
    public void testFirst() {
        assertEquals(0, list.size());
	    assertTrue(list.isEmpty());        
	
	    list.add(0, "one");
	    assertEquals(1, list.size());
	    assertEquals("one", list.get(0));
	    assertEquals("one", list.first());
	    assertFalse(list.isEmpty());
	    
	    list.add(1, "two");
	    assertEquals(2, list.size());
	    assertEquals("one", list.get(0));
	    assertEquals("two", list.get(1));
	    assertEquals("one", list.first());
	    assertFalse(list.isEmpty());
	    
	    list.add(0, "three");
	    assertEquals(3, list.size());
	    assertEquals("three", list.get(0));
	    assertEquals("one", list.get(1));
	    assertEquals("two", list.get(2));
	    assertEquals("three", list.first());
	    assertFalse(list.isEmpty());
    }

    /**
     * Test the output of the remove(index) behavior, including expected exceptions
     */
    @Test
    public void testRemoveIndex() {
    	assertEquals(0, list.size());
	    assertTrue(list.isEmpty());       
	    
	    Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-10));
	    assertEquals(null, e1.getMessage());
	    Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(10));
	    assertEquals(null, e2.getMessage());
	
	    list.add(0, "one");
	    list.add(1, "two");
	    list.add(2, "three");
	    list.add(3, "four");
	    assertEquals(4, list.size());
	    assertFalse(list.isEmpty());
	    
	    list.remove(1);
	    assertEquals(3, list.size());
	    assertEquals("one", list.get(0));
	    assertEquals("three", list.get(1));
	    assertEquals("four", list.get(2));
	    
	    list.remove(0);
	    assertEquals(2, list.size());
	    assertEquals("three", list.get(0));
	    assertEquals("four", list.get(1));
	    
	    list.remove(1);
	    assertEquals(1, list.size());
	    assertEquals("three", list.get(0));
	    
	    list.remove(0);
	    assertEquals(0, list.size());
    }

    /**
     * Test the output of the removeFirst() behavior, including expected exceptions
     */
    @Test
    public void testRemoveFirst() {
    	assertEquals(0, list.size());
	    assertTrue(list.isEmpty());       
	    
	    list.add(0, "one");
	    list.add(1, "two");
	    list.add(2, "three");
	    list.add(3, "four");
	    assertEquals(4, list.size());
	    assertFalse(list.isEmpty());
	    
	    list.removeFirst();
	    assertEquals(3, list.size());
	    assertEquals("two", list.get(0));
	    assertEquals("three", list.get(1));
	    assertEquals("four", list.get(2));
	    
	    list.removeFirst();
	    assertEquals(2, list.size());
	    assertEquals("three", list.get(0));
	    assertEquals("four", list.get(1));
	    
	    list.removeFirst();
	    assertEquals(1, list.size());
	    assertEquals("four", list.get(0));
	    
	    list.removeFirst();
	    assertEquals(0, list.size());
    }

    /**
     * Test the output of the removeLast() behavior, including expected exceptions
     */
    @Test
    public void testRemoveLast() {
    	assertEquals(0, list.size());
	    assertTrue(list.isEmpty());       
	    
	    list.add(0, "one");
	    list.add(1, "two");
	    list.add(2, "three");
	    list.add(3, "four");
	    assertEquals(4, list.size());
	    assertFalse(list.isEmpty());
	    
	    list.removeLast();
	    assertEquals(3, list.size());
	    assertEquals("one", list.get(0));
	    assertEquals("two", list.get(1));
	    assertEquals("three", list.get(2));
	    
	    list.removeLast();
	    assertEquals(2, list.size());
	    assertEquals("one", list.get(0));
	    assertEquals("two", list.get(1));	 
	    
	    list.removeLast();
	    assertEquals(1, list.size());
	    assertEquals("one", list.get(0));

	    list.removeLast();
	    assertEquals(0, list.size());
    }

    /**
     * Test the output of the set(index, e) behavior, including expected exceptions
     */
    @Test
    public void testSet() {
    	assertEquals(0, list.size());
	    assertTrue(list.isEmpty());       
	    
	    list.add(0, "one");
	    list.add(1, "two");
	    list.add(2, "three");
	    list.add(3, "four");
	    assertEquals(4, list.size());
	    assertFalse(list.isEmpty());
	    
	    assertEquals("one", list.get(0));
	    assertEquals("two", list.get(1));
	    assertEquals("three", list.get(2));
	    assertEquals("four", list.get(3));
	    
	    Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> list.get(-10));
	    assertEquals(null, e1.getMessage());
	    Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
	    assertEquals(null, e2.getMessage());
	    
	    list.set(0, "five");
	    assertEquals(4, list.size());
	    assertFalse(list.isEmpty());
	    assertEquals("five", list.get(0));
	    assertEquals("two", list.get(1));
	    assertEquals("three", list.get(2));
	    assertEquals("four", list.get(3));
	    
	    list.set(0, "five");
	    assertEquals(4, list.size());
	    assertFalse(list.isEmpty());
	    assertEquals("five", list.get(0));
	    assertEquals("two", list.get(1));
	    assertEquals("three", list.get(2));
	    assertEquals("four", list.get(3));
	    
	    list.set(1, "six");
	    assertEquals(4, list.size());
	    assertFalse(list.isEmpty());
	    assertEquals("five", list.get(0));
	    assertEquals("six", list.get(1));
	    assertEquals("three", list.get(2));
	    assertEquals("four", list.get(3));
	    
	    list.set(2, "seven");
	    assertEquals(4, list.size());
	    assertFalse(list.isEmpty());
	    assertEquals("five", list.get(0));
	    assertEquals("six", list.get(1));
	    assertEquals("seven", list.get(2));
	    assertEquals("four", list.get(3));
	    
	    list.set(3, "eight");
	    assertEquals(4, list.size());
	    assertFalse(list.isEmpty());
	    assertEquals("five", list.get(0));
	    assertEquals("six", list.get(1));
	    assertEquals("seven", list.get(2));
	    assertEquals("eight", list.get(3));
    }
}
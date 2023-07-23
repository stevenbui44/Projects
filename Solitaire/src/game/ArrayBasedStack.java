package game;
import java.util.EmptyStackException;

/**
 * The Linked Stack is implemented as a singly-linked list data structure to
 * support efficient, O(1) worst-case Stack abstract data type behaviors.
 * 
 * @author Dr. King
 * @author Steven Bui
 *
 * @param <E> the type of elements stored in the stack
 */
public class ArrayBasedStack<E> {

    /** Delegate to our existing singly linked list class **/
    private ArrayBasedList<E> list;

    /**
     * Construct a new singly-linked list to use when modeling the last-in-first-out
     * paradigm for the stack abstract data type.
     */
    public ArrayBasedStack() {
        list = new ArrayBasedList<E>();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

	public void push(E element) {
		list.add(0, element);
		
	}

	public E pop() {
		if (size() == 0) {
			throw new EmptyStackException();
		}
		E element = list.get(0);
		list.remove(0);
		return element;
	}

	public E top() {
		if (size() == 0) {
			throw new EmptyStackException();
		}
		return list.get(0);
	}

	public int size() {
		return list.size();
	}
}

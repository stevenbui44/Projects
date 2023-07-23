package game;
import java.util.Arrays;

/**
 * An array-based list is a contiguous-memory representation of the List
 * abstract data type. This array-based list dynamically resizes to ensure O(1)
 * amortized cost for adding to the end of the list. Size is maintained as a
 * global field to allow for O(1) size() and isEmpty() behaviors.
 * 
 * @author Steven Bui
 *
 * @param <E> the type of elements stored in the list
 */
public class ArrayBasedList<E> {

    /**
     * The initial capacity of the list if the client does not provide a capacity
     * when constructing an instance of the array-based list
     **/
    private final static int DEFAULT_CAPACITY = 0;

    /** The array in which elements will be stored **/
    private E[] data;

    /** The number of elements stored in the array-based list data structure **/
    private int size;

    /**
     * Constructs a new instance of an array-based list data structure with the
     * default initial capacity of the internal array
     */
    public ArrayBasedList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a new instance of an array-based list data structure with the
     * provided initial capacity
     * 
     * @param capacity the initial capacity of the internal array used to store the
     *                 list elements
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedList(int capacity) {
        data = (E[]) (new Object[capacity]);
        size = 0;
    }

	/**
	 * This adds an element at a specific index
	 */
	public void add(int index, E element) {
		ensureCapacity(size + 1);
		checkIndexForAdd(index);
		
		// if adding in the middle of the list, move everything after the insertion point forward
		if (index < size) {
			for (int i = size - 1; i >= index; i--) {
				data[i + 1] = data[i];
			}
			data[index] = element;
			size++;
		}

		// if adding at the end of the list, add at the end
		if (index == size && size < data.length) {
			data[index] = element;
			size++;
		}		
	}

	public void add(E element) {
		ensureCapacity(size + 1);
		data[size] = element;
		size++;
	}

	/**
	 * To ensure amortized O(1) cost for adding to the end of the array-based list,
	 * use the doubling strategy on each resize. Here, we add +1 after doubling to
	 * handle the special case where the initial capacity is 0 (otherwise, 0*2 would
	 * still produce a capacity of 0).
	 * 
	 * @param minCapacity the minimium capacity that must be supported by the
	 *                    internal array
	 */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = data.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2 + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }
	
	public E get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		return data[index];

	}

	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E rtn = data[index];
		// remove from the end of the list = do not shift anything
		if (index == size - 1 && size < data.length) {
			data[size - 1] = null;
		}
		// start at the index to remove, move the value that is one space ahead to that 
		// index, do this until you get to the end = left shift
		if (index < size - 1) {
			for (int i = index; i < size - 1; i++) {
				data[i] = data[i + 1];
			}
			data[size - 1] = null;
		}
		size--;
		return rtn;

	}

	public E set(int index, E element) {
		checkIndex(index);
		E rtn = data[index];
		if (index < size) {
			data[index] = element;
		}
		return rtn;

	}

	public int size() {
		return size;
	}

    protected void checkIndexForAdd(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index is invalid: " + index + " (size=" + size() + ")");
        }
    }

    protected void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is invalid: " + index + " (size=" + size() + ")");
        }
    }
    
}

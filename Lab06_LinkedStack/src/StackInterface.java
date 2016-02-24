import java.util.EmptyStackException;

public interface StackInterface<E> {
	/**
	 * Check if stack is empty to help avoid popping an empty stack.
	 * 
	 * @returns true if there are 0 elements on this stack
	 */
	public boolean isEmpty();

	/**
	 * Put element on "top" of this Stack object.
	 * 
	 * @param element
	 *            to be placed at the top of this stack
	 */
	public void push(E element);

	/**
	 * Return reference to the element at the top of stack
	 * 
	 * @returns A reference to the top element.
	 * @throws EmptyStackException
	 *             if the stack is empty.
	 */
	public E peek() throws EmptyStackException;

	/**
	 * Remove element at top and return reference to it
	 * 
	 * @returns reference to the most recently pushed element
	 * @throws EmptyStackException
	 *             if the stack is empty.
	 */
	public E pop() throws EmptyStackException;
}

import java.util.*;

public class GenericStack<T> {

    /* YOUR CODE HERE
     * Just like in the ArrayList lab, copy your StringStack code, excluding the
     * main method, here.
     * Then, modify it so it's generic!
     */
	private  T[] stack;
	public int size;
	public int last;
	
    public GenericStack(int size) {
    	this.last = 0;
    	this.size = size;
    	this.stack = (T[]) new Object[size];
    
    }

    /* If someone calls the constructor with no argument, they should get a
     * stack with a default size of 10.
     */
    public GenericStack() {
    	this.size = 10;
    	this.stack = (T[]) new Object[this.size];
    	this.last = 0;
        
    }

    /* Return true if the stack has no elements, and false otherwise.
     */
    public boolean empty() {
        return this.last == 0;
    }

    /* Return the object at the top of the stack, WITHOUT removing it. 
     * If there are no elements to peek, throw a NoSuchElementException.
     */
    public T peek() {
        if(this.last == 0) {
        	throw new NoSuchElementException();
        }
        return this.stack[this.last - 1];
    }

    /* Return the object at the top of the stack, AND ALSO remove it.
     * If there are no elements to pop, throw a NoSuchElementException.
     */
    public T pop() {
        if(this.last == 0) {
        	throw new NoSuchElementException();
        }
        return this.stack[--this.last];
    }

    /* Add a new object to the top of the stack. 
     * If there is no room in the stack, throw a IllegalStateException.
     */
    public T push(T s) {
        if(this.last == this.size) {
        	throw new IllegalStateException();
        } else {
        	stack[last] = (T) s;
        	last++;
        }
        return s;
        
    }

    /* Return the position of an object on the stack.  The position of an object
     * is just its distance from the top of the stack. So, the topmost item is
     * distance 0, the one below the topmost item is at distance 1, etc.
     */
    public int search(T s) {
        int dis = 0;
        int last = this.last -1 ;
        while(last >= 0) {
        	if(this.stack[last].equals(s)) {
        		return dis;
        	}
        	dis++;
        	--last;
        }
        return -1;
    }

    public static void main(String[] args) {
        // If any of these lines cause a compilation error, your stack hasn't
        // been properly made generic.
        GenericStack<Integer> intStack = new GenericStack<>();
        GenericStack<String> stringStack = new GenericStack<>();
        GenericStack<ArrayList<String>> listStack = new GenericStack<>();
    }

}

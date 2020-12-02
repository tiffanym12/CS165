import java.util.Arrays;

interface PriorityQueue<T extends Comparable<T>> {
    public void push(T item);
    public T pop();
    public T peek();
}

public class Heap<T extends Comparable<T>> implements PriorityQueue<T> {

    private T[] heap;
    private int size;

    public Heap(int capacity) {
        heap = (T[]) new Comparable[capacity];
        size = 0;
    }

    /* Given an index in the heap array, calculate what the parent node's
     * index is.
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }

    /* Given an index in the heap array, calculate what the right child's
     * index is.
     */
    private int rchild(int index) {
        return index * 2 + 2;
    }

    /* Given an index in the heap array, calculate what the left child's
     * index is.
     */
    private int lchild(int index) {
        return index * 2 + 1;
    }

    private boolean hasLeftChild(int index) {
        return lchild(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rchild(index) < size;
    }
    
    private boolean hasParent(int index) {
    	return index >= 1;
    }

    /* Swap the items in the array at index1 and index2.
     */
    private void swap(int index1, int index2) {
    	T temp = heap[index1];
    	heap[index1] = heap[index2];
    	heap[index2] = temp;
    }

    /* Perform a heapify starting at the given index.
     * Check the index's two children to see if you should swap the node
     * with either of these children. If you should, do the swap, and call
     * another bubbleDown on the index you swapped to.
     */
    private void bubbleDown(int index) {
        boolean f = false;
        while (!f && hasLeftChild(index)) {
            int left = lchild(index);
            int right = rchild(index);
            int child = left;
            if (hasRightChild(index) && (heap[right].compareTo(heap[left]) > 0)) {
                child = right;
            }
            if ((heap[child].compareTo(heap[index]) > 0)) {
                swap(index, child);
                index = child;
            } else {
                f = true;
    		}
    	}

    }

    /* Perform a "reverse-heapify" starting at the current index.
     * Check the index's parent to see if you should swap the two; If you
     * should, do a swap and call another bubbleUp on the index you swapped to.
     *
     * This should be a significantly simpler method than bubbleDown.
     */
    private void bubbleUp(int index) {
    	while(hasParent(index)) {
    		int p = parent(index);
    		if((heap[index].compareTo(heap[p]) > 0)) {
    			swap(index, p);
    			index = p;
    		} else {
    			return;
    		}
    }
   
    }

    /* Add an item to the queue.
     * Add the item at the end of the array, then bubble it up.
     * Assume that the heap will have space.
     */
    public void push(T item) {
    	heap[size] = item;
    	bubbleUp(size++);
    }

    /* Remove the highest priority item from the queue.
     * Replace the item at the root (index 0) with the last item
     * in the array, then bubble it down.
     * Assume that the heap won't be empty.
     */
    public T pop() {
        T res = peek();
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        bubbleDown(0);
        return res;
    }

    /* Return the highest priority item from the queue. 
     */
    public T peek() {
        return heap[0];
    }

    public String toString() {
        return Arrays.toString(heap);
    }

    public static void main(String[] args) {
        Heap<Integer> numbers = new Heap<Integer>(10);

        numbers.push(2270);
        numbers.push(19720);
        numbers.push(3430);
        numbers.push(2001);
        numbers.push(1998);
        numbers.push(7);

        System.out.println(numbers);

        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        numbers.peek();
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);

        numbers.push(404);
        numbers.push(7778);
        numbers.push(27015);
        System.out.println("               (Three new numbers pushed)");
        System.out.println("               " + numbers);

        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        numbers.peek(); // make sure peek doesn't change anything!
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
    }

}

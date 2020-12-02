import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Random;

import org.w3c.dom.Node;

public class  MyLinkedList<E>{
    private class Node {
        E data;
        Node next;
        public Node(E data) {
            this.data = data;
        }
        @Override
        public String toString(){
            return "Data:" + data;
        }
    }
    Node head;
    int size;

    /**
     * The constructor should initialize Head and size to reasonable values
     *
     */
    public MyLinkedList(){
        size = 0;
    }

    /**TODO - Complete this Method
     * This method should add at element to the end of the linked list
     * Make sure to make special cases for an empty list!(Hint: initialize the Head variable)
     * @param item
     */
    public void add(E item){
    	Node node = new Node(item);
    	if(head == null) {
    		head = node;
    	} else {
    		Node n = head;
    		while(n.next != null) {
    			n = n.next;
    		}
    		n.next = node;
    	}
    	size++;

    }

    /**TODO - Complete this Method
     * This method should return the node at the given index
     * @param index
     */
    public void getNode(int index){
    	if(index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException();
    	}
    	Node n = head;
    	for(int i = 0; i < index; i++) {
    		n = n.next;
    	}
    	return;
    }
    public class MyIterator implements ListIterator<E> {
        int nextI;
        int size;
        Node node;
        
        public MyIterator(Node head, int size) {
            nextI = -1;
            this.size = size;
            node = head;
        }

        /** TODO - Complete this Method
         * Returns a boolean indicating if the iterator has a next element
         * @return if the iterator has a next element this should return True, Otherwise False
         */
        public boolean hasNext() {
            return (nextI + 1) < size;
        }

        /** TODO - Complete this Method
         * This should return the next item or NoSuchElementException if there are no more elements left
         * @return the next item
         * @throws java.util.NoSuchElementException
         */
        public E next() {
            if(!hasNext()) {
            	throw new NoSuchElementException();
            }
            nextI++;
            E data = node.data;
            node = node.next;
            return data;
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int nextIndex() {
            return nextI;
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }
    public MyIterator listIterator(){
        return new MyIterator(head, size);
    }
    public String toString(){
        String ret = "";
        Node cur = head;
        while(cur != null){
            ret += cur + "\n";
            cur = cur.next;
        }
        return ret;
    }
    public static void main(String[] args){
        Random r = new Random(2020);
        MyLinkedList list = new MyLinkedList();
        for(int i = 0; i < 10; i++){
            int num = r.nextInt(1000);
            list.add(num);
        }
        System.out.println(list);

        //Iterator Test Code
        ListIterator iter = list.listIterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("size: " + list.size);
        System.out.println("nextI: " + iter.nextIndex());
        try{
            iter.next();
        }catch(NoSuchElementException e){
            System.err.println("You Caught The Error!");
        }
    }
}

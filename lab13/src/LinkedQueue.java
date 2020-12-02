import java.util.*;

public class LinkedQueue implements MyQueue{

    public class Node {
        String name;
        Node next;
        public Node(String name) {
            this.name = name;
        }
        @Override
        public String toString(){
            return name;
        }
    }

    /**
     * a reference to the head of the Queue
     */
    private Node head;
    /**
     * a reference to the tail of the Queue
     */
    private Node tail;
    /**
     * maximum number of items that can simultaneously be in the Queue
     */
    private final int maxCount;
    /**
     * the current number of items in the Queue
     */
    private int size;

    /**TODO FINISH ME
     * The Constructor should set maxCount to the maximum amount of customers for the day
     * also make sure to initialize size
     * @param maxCount
     */
    public LinkedQueue(int maxCount){
        this.maxCount = maxCount;
        this.size = 0;
        head = tail = null;
    }
    /**TODO FINISH ME
     * This method should add a new Node with the person's name at the
     * end of the Queue. This method should also check if the Queue
     * is full(size of Queue > maxCount) and throw an exception if
     * the Queue is full
     *
     * @param name - person to add
     * @return true if item can be added
     * @throws IllegalStateException if the Queue is full
     *                               element cannot be added because it is a duplicate
     */
    @Override
    public boolean add(String name) {
        if(size == maxCount) {
        	throw new IllegalStateException();
        }
         Node n = new Node(name);
         if(head == null) {
        	 head = tail = n;
         } else {
        	 tail.next = n;
        	 tail = n;
         }
         size++;
         return true;
    }

    /**TODO FINISH ME
     * This method is the same as add EXCEPT that it simply returns
     * false if the item can't be inserted instead of throwing an exception
     *
     * @param name
     * @return true if item can be inserted, false otherwise
     */
    @Override
    public boolean offer(String name) {
        if(size == maxCount) {
        	return false;
        }
        Node n = new Node(name);
        if(head == null) {
        	head = tail = n;
        } else {
        	tail.next = n;
        	tail = n;
        }
        size++;
        return true;
    }

    /**TODO FINISH ME
     * returns the name of the element at the head of the Queue but do
     * NOT remove it
     *
     * @return Element at the head of the Queue
     * @throws NoSuchElementException if the Queue is empty
     */
    @Override
    public String element() {
        if(size == 0) {
        	throw new NoSuchElementException();
        }
        return head.name;
    }

    /**TODO FINISH ME
     * This method is the same as element except for the fact that it
     * doesn't throw an exception
     *
     * @return the head of the Queue, or null if the Queue is empty
     */
    @Override
    public String peek() {
        if(size == 0) {
        	return null;
        }
        return head.name;
    }

    /**TODO FINISH ME
     * removes and returns the name of the element at the head of the Queue
     *
     * @return the name of element at the head of the Queue, or null if Queue is empty
     */
    @Override
    public String poll() {
        if(size == 0) {
        	return null;
        }
        String n = head.name;
        head = head.next;
        size--;
        if(size == 0) {
        	head = tail = null;
        }
        return n;
    }

    /**TODO FINISH ME
     * This method is the same as poll() except that it throws an exception if the Queue
     * is empty
     *
     * @return the name of the element at the head of the Queue
     * @throws NoSuchElementException if the Queue is empty
     */
    @Override
    public String remove() {
        if(size == 0) {
        	throw new NoSuchElementException();
        }
        String n = head.name;
        head = head.next;
        size--;
        if(size == 0) {
        	head = tail = null;
        }
        return n;
    }

    /**TODO FINISH ME
     * Returns true if the Queue contains a node with the same name that was passed in
     *
     * @param name
     * @return true if Queue contains the item, false if not
     */
    @Override
    public boolean contains(String name) {
        for(Node n = head; n != null; n = n.next) {
        	if(n.name.equals(name)) {
        		return true;
        	}
        }
        return false;
    }

    /**TODO FINISH ME
     * @return The current number of items in the string
     */
    @Override
    public int size() {
        return size;
    }
    @Override
    public String toString(){
        String retString = "";
        Node cur = head;
        while(cur != null){
            retString += String.format("%s ", cur.name);
            cur = cur.next;
        }
        return retString;
    }
    public void simulateBooth(){
        LinkedQueue queue = new LinkedQueue(10);
        double money = 0;
        float priceOfCone = 1.25f;
        //add people to queue
        queue.add("John");
        queue.add("James");
        queue.add("Charlie");
        queue.add("Michelle");
        queue.add("Darius");
        queue.add("Daniel");
        queue.add("Lisa");
        queue.add("Bart");
        queue.add("James");
        //print queue
        System.out.printf("There are %d items in the queue\n", queue.size());
        //serve customer and increment cash
        String cur = queue.poll();
        int numCustomers = queue.size();
        while(cur != null){
            System.out.printf("The Ice Cream stall served %s ice cream\n", cur);
            money += priceOfCone;
            cur = queue.poll();
        }
        System.out.printf("The Ice Cream booth made $%.2f and served %d people \n", money, numCustomers);
    }
    public static void main(String[] arg){
        //create Queue
        LinkedQueue queue = new LinkedQueue(4);
        //test add/offer
        try{
            System.out.println("Adding some people...");
            queue.add("John");
            queue.add("James");
            queue.add("Charlie");
            queue.add("Michelle");
            System.out.println(queue);
            queue.add("Darius");
        }catch(IllegalStateException e){
            System.out.println("The Queue is full and threw the correct error!");
        }
        //test remove/poll
        try{
            System.out.println("Removing some people...");
            queue.remove();
            queue.remove();
            queue.remove();
            System.out.println("People remaining in the Queue: " + queue);
            queue.remove();
            queue.remove();
        }catch(NoSuchElementException e){
            System.out.println("The Queue is empty and it threw the correct error");
        }
        queue.add("John");
        queue.add("James");
        queue.add("Charlie");
        queue.add("Michelle");
        //test contains
        System.out.printf("Contains: %b\n", queue.contains("Charlie"));
        //test size
        System.out.println("size of queue: " + queue.size());
        //UNCOMMENT WHEN YOU HAVE TESTED ALL OTHER CODE
//        System.out.println("\n\n\n");
//        queue.simulateBooth();
    }
}

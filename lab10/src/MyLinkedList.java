
/** Linked List Lab
 * Made by Toby Patterson 5/31/2020
 * For CS165 at CSU
 */

public class MyLinkedList<E> implements MiniList<E>{
    /* Private member variables that you need to declare:
     ** The head pointer
     ** The tail pointer
     */
	Node head;
	Node tail;


    public class Node {
        // declare member variables (data, prev and next)
    	E data;
    	Node prev;
    	Node next;

        // finish these constructors
        public Node(E data, Node prev, Node next) {
        	this.data = data;
        	this.next = next;
        	this.prev = prev;
        }
        public Node(E data) {
        	this(data, null, null);

        } // HINT: use this() with next = prev = null
    }


    // Initialize the head and tail pointer
    public MyLinkedList() {
    	head = null;
    	tail = null;
    }

    @Override
    public boolean add(E item) {
        Node newN = new Node(item);
        if(head == null) {
            head = tail = newN;
        } else {
            newN.prev = tail;
            tail.next = newN;
            tail=newN;
        }
        return true;
    }

    @Override
    public void add(int index, E element) {
    	Node newN = new Node(element);
        if(index == 0) {
            head.prev = newN;
            newN.next = head;
            head = newN;
        } else {
            Node c = head;
            for(int i = 0;i < index-1; i++) {
                c = c.next;
            }
            if(c.next!=null) { 
                c.next.prev = newN;
                newN.next = c.next;
                c.next = newN;
                newN.prev = c;
            } else { 
                tail.next = newN;
                newN.prev = tail;
                tail = newN;
  
    		}
    	}

    }

    @Override
    public E remove() {
        E remove;
        if(head == tail) { 
            remove = head.data;
            head = tail = null;
        } else { 
            remove = head.data;
            head.next.prev = null;
            head = head.next;
        }
        return remove;
    }

    @Override
    public E remove(int index) {   	
        E remove;
        if(index == 0) {
            remove = head.data;
            head.next.prev = null;
            head = head.next;
        } else {
            Node c = head;
            for(int i = 0;i < index;i++) {
                c = c.next;
            }
            if(c.next!=null) {
                c.next.prev = c.prev;
                c.prev.next = c.next;
                remove = c.data;
            } else {
                remove = tail.data;
                tail = tail.prev;
                tail.next = null;
            }
        }
        return remove;
    }
    

    @Override
    public boolean remove(E item) {
        remove(indexOf(item));
        return true;
    }

    @Override
    public void clear() {
    	head = tail = null;

    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) != -1;
    }

    @Override
    public E get(int index) {
        Node c = head;
        for(int i = 0; i < index; i++) {
        	c = c.next;
        }
        return c.data;
    }

    @Override
    public int indexOf(E item) {
        int count = -1;
        int index = -1;
        Node c = head;
        while(c != null) {
        	count++;
        	if(c.data == item) {
        		index = count;
        		break;
        	}
        	c = c.next;
        }
        return index;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int count = 0;
        Node c = head;
        while(c != null) {
        	c = c.next;
        	count++;
        }
        return count;
    }

    // Uncomment when ready to test
    @Override
    public String toString() {
        String ret = "";
        Node curr = head;
        while (curr != null) {
            ret += curr.data + " ";
            curr = curr.next;
        }
        return ret;
    }

}

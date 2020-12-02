/** Linked List Lab
 * Made by Toby Patterson 5/29/2020
 * For CS165 at CSU
 */

public class MyLinkedList implements MiniList<Integer>{
    /* Private member variables that you need to declare:
     ** The head pointer
     ** The tail pointer
     */

    public class Node {
        // declare member variables (data and next)
    	Integer data;
    	Node next;

        // finish these constructors
        public Node(int data, Node next) {}
        public Node(int data) {
        	this.data = data;
        	this.next = null;
        } // HINT: use this() with next = null
    }
    public Node head;
    public Node tail;
    

    // Initialize the linked list (set head and tail pointers)
    public MyLinkedList() {
        head = null;
        tail = null;
    }

    

    @Override
    public boolean add(Integer item) {
        Node newN = new Node(item);
        if (head == null) {
        	head = newN;
        	tail = newN;
        } else {
        	tail.next = newN;
        	tail = newN;
        }
        	return true;
        }
    

    @Override
    public void add(int index, Integer element) {
    	Node c = head;
    	if(head == null) {
    		return;
    	}
    	int count = 0;
    	while(c != null) {
    		if(index - 1 == count) {
    		Node n = new Node(element);
    		n.next = c.next;
    		c.next = n;
    		break;
    	}
    	c = c.next;
    	count++;
    	}

    }

    @Override
    public Integer remove() {
        Integer e = null;
        e = head.data;
        head = head.next;
        return e;
    }

    @Override
    public Integer remove(int index) {
        Node c = head;
        Integer e = null;
        int count = 0;
        if(head == null) {
        	return null;
        }
        while(c != null) {
        	if(index - 1 == count && c.next != null) {
        		e = c.next.data;
        		if(c.next.next == null) {
        			tail = c;
        		}
        		c.next = c.next.next;
        		break;
        	}
        	c = c.next;
        	count++;
        	
        }
        return e;
    }

    @Override
    public boolean remove(Integer item) {
        Node c = head;
        if(head == null) {
        	return false;
        }
        if(c.data == item) {
        	head = c.next;
        	return true;
        }
        while (c != null) {
        	if(c.next != null && c.next.data == item) {
        		if(c.next.next == null) {
        			tail = c;
        		}
        		c.next = c.next.next;
        		break;
        	}
        	c = c.next;
        }
        return true;
    }

    @Override
    public void clear() {
    	head = null;

    }

    @Override
    public boolean contains(Integer item) {
        Node c = head;
        if(head == null) {
        	return false;
        }
        while( c != null) {
        	if(c.data == item) {
        		return true;
        	}
        	c = c.next;
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        Node c = head;
        int count = 0;
        if(head == null) {
        	return null;
        }
        while(c != null) {
        	if(index == count) {
        		return c.data;
        	}
        	c = c.next;
        	count++;
        }
        return null;
    }

    @Override
    public int indexOf(Integer item) {
        Node c = head;
        int count = 0;
        if(head == null) {
        	return -1;
        }
        while(c != null) {
        	if(c.data == item) {
        		return count;
        	}
        	c = c.next;
        	count++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        if(head == null) {
        	return true;
        }
        return false;
    }

    @Override
    public int size() {
        Node c = head;
        int count = 0;
        if(head == null) {
        	return 0;
        }
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

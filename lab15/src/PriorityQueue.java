import java.util.Arrays;




public class PriorityQueue {

    /* This class is finished for you.
     */
    private static class Customer implements Comparable<Customer> {
        private double donation;

        public Customer(double donation) {
            this.donation = donation;
        }

        public double getDonation() {
            return donation;
        }

        public void donate(double amount) {
            donation += amount;
        }

        public int compareTo(Customer other) {
            double diff = donation - other.donation;
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            } else {
                return 0;
            }
        }

        public String toString() {
            return String.format("$%.2f", donation);
        }
    }

    private Customer[] data;
    private int size;

    public PriorityQueue(int capacity) {
        data = new Customer[capacity];
        size = 0;
    }
    
    public PriorityQueue() {
        this(10);
    }

    /* Add a customer to the queue.
     * Remember to do so in a way that keeps the queue in sorted order!
     */
    public void push(Customer customer) {
    	if(size == 0) {
    		data[0] = customer;
    	} else {
    		 Customer temp = customer;
    		 int i;
    	     for(i = 0;i<size;i++) {
    	    	 if((data[i].compareTo(customer)) == 1) {
    	    		 continue;
    	           }
    	           else break;
    	       }
    	     for(;i<=size;i++) {         
    	               Customer t = data[i];
    	               data[i] = temp;
    	               temp = t;
    	       }
    	   }
    	size++;
    }

    /* Remove and return the highest priority customer from the queue.
     */
    public Customer pop() {
    	if(size == 0) {
    		return null;
    	} else {
    		Customer c = data[0];
    		for(int i = 0; i < size; i++) {
    			data[i] = data[i + 1];	
    		}
    		size--;
    		return c;
    	}
       
    }

    /* Return, but don't remove, the highest priority item from the queue.
     */
    public Customer peek() {
        if(size == 0) {
        	return null;
        }
        return data[0];
    }

    /* Given the index of a customer, increase their donation amount, letting
     * them cut in line if necessary. 
     *
     * Refer to the Customer class to remind yourself the operations you can do
     * on a customer.
     */
    public void bump(int customerIndex, double amount) {
    	Customer temp = data[customerIndex];
    	temp.donate(amount);
        data[customerIndex] = temp;
        for(int i = 0; i < size; i++) {
        	for(int j = i + 1; j < size; j++) {
        		if(data[i].compareTo(data[j]) < 0) {
        			Customer c = data[i];
        			data[i] = data[j];
        			data[j] = c;
        		}
        	}
        }
    }

    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        PriorityQueue line = new PriorityQueue(6);
        
        line.push(new Customer(5.00));
        line.push(new Customer(10.00));
        line.push(new Customer(1.00));

        System.out.println(line.pop());
        System.out.println(line.pop());

        line.push(new Customer(20.00));
        line.push(new Customer(15.00));
        line.push(new Customer(2.00));

        line.bump(1, 30.00);
        line.bump(3, 60.00);
        System.out.println(line.pop());
        System.out.println(line.peek());
        System.out.println(line.pop());
        System.out.println(line.pop());
        System.out.println(line.pop());
    }
}

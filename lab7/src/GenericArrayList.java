import java.util.List;
import java.util.ArrayList;


public class GenericArrayList<T extends Comparable <Point>>{
    /* YOUR CODE HERE
     * Copy your code from your ArrayStringList class, and place it within 
     * this class.
     *
     * Only copy the code you filled out! Don't copy the main method.
     */

     // Place code here
	private T[] data;
	private int size;


	    private void resizeData(int newSize) {
	    	data = (T[]) new Object[newSize];
	        for(int i = 0; i < size; i++) {
	        	data[i] = data[i];
	        }
	    }
	    

	     
	    public GenericArrayList(int initialCapacity) {
	    	data = (T[]) new Object[initialCapacity];
	        size = 0;
	    }

	    public void add(T str) {
	    	if(size < data.length) {
	    		data[size] = str;
	    		size++;
	    	} else {
	    		resizeData(2 * data.length);
	    		data[size] = str;
	    		size++;
	    	}

	    }

	    public void add(int index, T str) {
	    	if(index < data.length && index >= 0) {
	    		data[index] = str;
	    		size++;
	    	}

	    }
	    public T get(int index) {
	        if(index < data.length && index >= 0) {
	        	return data[index];
	        }
	        return null;
	    }
	    public void remove(int index) {
	    	if(index < data.length && index >= 0) {
	    		for(int i = index; i < data.length; i++) {
	    			if((i + 1) < size) {
	    				data[i] = data[i + 1];
	    			}
	    		}
	    		size--;
	    	}

	    }


	    public int size() {
	        return size;
	    }

	    public boolean contains(T str) {
	    	for(int i = 0; i < data.length; i++) {
	    		if(str.equals(data[i])) {
	    			return true;
	    		}
	    	}
	        return false;
	    }







    public static void main(String[] args) {
        /* PART 1:
         * Modify the GenericArrayList above so that it can store *any* class,
         * not just strings.
         * When you've done that, uncomment the block of code below, and see if
         * it compiles. If it does, run it. If there are no errors, you did
         * it right!
         */

/*
        GenericArrayList<Point> pointList = new GenericArrayList<Point>(2);

        pointList.add(new Point(0, 0));
        pointList.add(new Point(2, 2));
        pointList.add(new Point(7, 0));
        pointList.add(new Point(19.16f, 22.32f));

        pointList.remove(0);
        Point p = pointList.get(2);

        if (p.x != 19.16f && p.y != 22.32f) {
            throw new AssertionError("Your GenericArrayList compiled properly "
            + "but is not correctly storing things. Make sure you didn't "
            + "accidentally change any of your ArrayStringList code, aside "
            + "from changing types.");
        }

        GenericArrayList<Float> floatList = new GenericArrayList<Float>(2);

        for (float f = 0.0f; f < 100.0f; f += 4.3f) {
            floatList.add(f);
        }

        float f = floatList.get(19);

        System.out.println("Hurray, everything worked!");
        */


        /* PART 2:
         * Now, modify your GenericArrayList again so that it can only store
         * things that are comparable to a Point.
         *
         * If you don't know how to do this, reference zybooks and your textbook
         * for help.
         *
         * When you are ready to test it, uncomment the code above and run the
         * code below.
         */

 
        GenericArrayList<Point> pointList = new GenericArrayList<Point>(2);
        GenericArrayList<Point3D> pointList3D = new GenericArrayList<Point3D>(3);

        pointList.add(new Point(0, 0));
        pointList.add(new Point(2, 2));
        pointList.add(new Point(7, 0));
        pointList.add(new Point(19.16f, 22.32f));

        pointList3D.add(new Point3D(1.0f, 2.0f, 3.0f));
        pointList3D.add(new Point3D(7.3f, 4, 0));

        Point p = pointList.get(2);
        Point3D p3 = pointList3D.get(0);

        // You should get a compilation error on this line!
        GenericArrayList<Float> floatList = new GenericArrayList<Float>(2);
        
    }

}


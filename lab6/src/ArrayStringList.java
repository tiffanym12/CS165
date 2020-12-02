import java.util.List;
import java.util.ArrayList;

public class ArrayStringList {

    /* This field is really important!
     * This is the internal array of data you're going to use to implement the
     * ArrayStringList. This is what actually STORES the Strings in your list.
     * More information about how this should be used is in the lab writeup.
     * Read it first!
     */
    private String[] data;

    /* Storing the amount of valid Strings that are in the array turns out to be
     * fairly useful. This variable is for that.
     */
    private int size;

    /* YOUR CODE HERE
     * From this point onward, you're going to see a bunch of empty methods. It
     * is your job to fill them out (or in fancy CS terminology, "implement"
     * them), so they do what the comments say they should.
     *
     * Remember, the comments are not telling you HOW to implement a method.
     * They are telling you WHAT the method should do. The HOW of each of these
     * methods is going to be a combination of your own creativity and the
     * guidelines laid out in the lab writeup. 
     */

    /* This method is mostly here for your own benefit. You may be resizing the
     * array in several places (in both of the add methods, for instance), and
     * whenever we are doing the same thing in multiple places, it's usually a
     * good idea to put it into a function, so it can be easily reused.
     *
     * This method should change the size of that data array to whatever the
     * newSize is. It should keep the original data intact as well. I recommend
     * you start by creating a totally new String[] array of the desired size,
     * then copying over the elements from the data array to this new array,
     * then when that is done, replacing the data array with the new one.
     */
    private void resizeData(int newSize) {
        String[] str = new String[newSize];
        for(int i = 0; i < size; i++) {
        	str[i] = data[i];
        }
        data=str;
    }
    
    /* Remember: An uninitialized field is a bad one. In this constructor, you
     * should initialize data and size, using the initialCapacity as the,
     * well, initial capacity of the data array.
     *
     * Consider the distinction we make between size and capacity! The capacity
     * is the size of the internal array, while the size is the amount of
     * Strings that are actually in the array.
     */
    public ArrayStringList(int initialCapacity) {
        data = new String[initialCapacity];
        size = 0;
    }

    /* This method should add a string to the END of your ArrayList. 
     * For instance, if there are 5 elements, this should go into index 5 (the
     * sixth spot).
     */
    public void add(String str) {
    	if(size < data.length) {
    		data[size] = str;
    		size++;
    	} else {
    		resizeData(2 * data.length);
    		data[size] = str;
    		size++;
    	}

    }

    /* This method should add a string to a specific index in your ArrayList. 
     *
     * The index may not be valid. For instance, calling this with an index of
     * 10 on an ArrayList that only has 7 elements is not allowed. 
     * If the index is out of bounds, stop the method without doing anything.
     */
    public void add(int index, String str) {
    	if(index < data.length && index >= 0) {
    		data[index] = str;
    		size++;
    	}

    }

    /* This method should return the string stored at a certain index.
     * Like the method above, the index may not be valid. Return null if the
     * index given is out of bounds.
     */
    public String get(int index) {
        if(index < data.length && index >= 0) {
        	return data[index];
        }
        return null;
    }

    /* This method should take the string at a given index out of your 
     * ArrayList.
     * If the index isn't valid, then stop the method without doing anything.
     */
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

    /* This method should return how many elements are in your ArrayList.
     * Hint: You should already be storing this in a variable called size.
     */
    public int size() {
        return size;
    }

    /* This method should return true if the given string is in your ArrayList,
     * and false otherwise.
     * Remember to use .equals() instead of == when comparing one String 
     * with another.
     */
    public boolean contains(String str) {
    	for(int i = 0; i < data.length; i++) {
    		if(str.equals(data[i])) {
    			return true;
    		}
    	}
        return false;
    }

    /* Whew! You can stop writing functions now.
     * This is test code to make sure you've done everything properly. Run it
     * when you're finished implementing to see if you "passed" the lab.
     * 
     * If you get an exception when you run the code, then something went wrong.
     * Read the messsage in the error for details about what method didn't work
     * right.
     */
    public static void main(String[] args) {
        ArrayStringList list = new ArrayStringList(2);
        ArrayList<String> referenceList = new ArrayList<>();

        list.add("alpha");
        referenceList.add("alpha");
        list.add("beta");
        referenceList.add("beta");
        list.add("gamma");
        referenceList.add("gamma");

        // You may ask why I didn't just use JUnit instead of these honestly
        // ugly if statements.
        // The only reason is I didn't want to force people to set up JUnit for
        // what should be a fairly simple lab.

        if (list.size() != referenceList.size()) {
            throw new AssertionError(String.format("Your size method produced "
                + "the wrong results. It should be been %d, but it was %d.",
                referenceList.size(), list.size()));
        }

        for (int i = 0; i < referenceList.size(); i++) {
            if (!list.get(i).equals(referenceList.get(i))) {
                throw new AssertionError(String.format("The item at index %d "
                    + "in your list should have been %s, but it was %s. Your "
                    + "add or get methods may be wrong.", i,
                    referenceList.get(i), list.get(i)));
            }
        }

        list.remove(1);
        referenceList.remove(1);

        if (list.size() != referenceList.size()) {
            throw new AssertionError(String.format("After removing an item, "
            + "the size of your list should be %d, but it was %d. Your "
            + "remove method may not properly be updating the list's size.",
            referenceList.size(), list.size()));
        }

        for (int i = 0; i < referenceList.size(); i++) {
            if (!list.get(i).equals(referenceList.get(i))) {
                throw new AssertionError(String.format("After removing an "
                    + "item, the item at index %d "
                    + "in your list should have been %s, but it was %s. Your "
                    + "remove method may be wrong.",
                    referenceList.get(i), list.get(i)));
            }
        }

        if (!list.contains("alpha")) {
            throw new AssertionError(String.format("Your contains method "
                + "reported a string doesn't exist in the List, even though "
                + "it should."));
        }

        if (list.contains("beta")) {
            throw new AssertionError(String.format("Your contains method "
                + "reported a string DID exist in the List, even though it "
                + "should have been removed."));
        }

        // Fun fact: Java strings (and chars, for that matter) are
        // Unicode-compatible!

        list.add("delta");
        referenceList.add("delta");
        list.add("epsilon");
        referenceList.add("epsilon");
        list.add("zeta");
        referenceList.add("zeta");
        list.add("eta");
        referenceList.add("eta");
        list.add("theta");
        referenceList.add("theta");
        list.add("iota");
        referenceList.add("iota");
        list.add("kappa");
        referenceList.add("kappa");
        list.add("lambda");
        referenceList.add("lambda");
        list.add("mu");
        referenceList.add("mu");

        if (list.size() != referenceList.size()) {
            throw new AssertionError(String.format("After adding a bunch of "
                + "new elements, the size of your list should have been %d "
                + "but it was %d", referenceList.size(), list.size()));
        }

        for (int i = 0; i < referenceList.size(); i++) {
            if (!list.get(i).equals(referenceList.get(i))) {
                throw new AssertionError(String.format("After removing an "
                    + "item, the item at index %d "
                    + "in your list should have been %s, but it was %s. Your "
                    + "remove method may be wrong.",
                    referenceList.get(i), list.get(i)));
            }
        }

        System.out.println("If you're reading this, everything worked!");
    }
}

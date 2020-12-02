import java.util.*;
import java.io.*;
import java.math.*;

public class Calculator {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String numbers = "56 3 7 2.0 8.4";
        char[] moreNumbers = "1.0 2 3 4 5 0.324".toCharArray();

        GenericStack<Number> stack1 = makeStack(new StringReader(numbers));
        System.out.println(evaluate(stack1));

        GenericStack<Float> stack2 = new GenericStack<>();
        for (String token : numbers.split(" ")) {
            stack2.push(Float.parseFloat(token));
        }
        System.out.println(evaluate(stack2));

        GenericStack<Number> stack3 = makeStack(new FileReader("numbers.txt"));
        System.out.println(evaluate(stack3));

        GenericStack<Number> stack4 = makeStack(new CharArrayReader(moreNumbers));
        System.out.println(evaluate(stack4));
    }
    
    /* This function is meant to take in a Reader called "reader" and return a 
     * stack of Numbers.
     *
     * Remember: don't change anything that's already there. Just add your new 
     * code where the comment is to fix the function's signature.
     */
    public static GenericStack<Number> makeStack(Reader reader) throws IOException {
        GenericStack<Number> stack = new GenericStack<>(64);
        char[] data = new char[64];
        reader.read(data);
        String tokens = new String(data);
        for (String token : tokens.split(" ")) {
            stack.push(parse(token));
        }
        return stack;
    }

    /* This function is meant to take in a stack of ANY KIND of Number
     * called "stack", and return the double you get if you add all of the
     * numbers together.
     * The function must be able to accept a stack of ANY KIND of Number!
     *
     * Hint: use wildcard generics!
     */
    
    public static double evaluate(GenericStack<? extends Number> stack) {
    	double tot = 0;
    	while(!stack.empty()) {
    		tot += ((Number)stack.pop()).doubleValue();
    	}
        
        return tot;
    }

    /* This function is missing a return type.
     * Examine it, and see if you can tell what type it should return.
     * (Spoiler: it's probably what you think it is.)
     */
    public static Number parse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) { }

        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) { }

        return new BigDecimal(s);
    }


}

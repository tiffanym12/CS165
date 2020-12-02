import java.util.*;

/**
 *
 */
public class ExpressionTree{
    public Node root;

    /**
     *
     */
    public class Node {

        /**
         *
         */
        public String token;
        /**
         *
         */
        public Node left;
        /**
         *
         */
        public Node right;


        /**
         *
         * @param value
         */
        public Node(String value) {
            this.token = value;
        }
    }


    /**
     * Converts infix expression to postfix
     * @param infix
     * @return
     */
    public List<String> convert(Queue<String> infix) {
    	List<String> postfix = new ArrayList<>();
        Deque<String> operators = new ArrayDeque<>(); // used as a stack

        while(!infix.isEmpty()) {
            String token = infix.poll();
            if(ExpressionTree.isInteger(token)) {
                postfix.add(token);
            }
            else if (ExpressionTree.isOperator(token)) {
                while (!operators.isEmpty() && !operators.peek().equals("(") && ExpressionTree.precedence(token) >= ExpressionTree.precedence(operators.peek())) {
                    postfix.add(operators.pop());
                }
                operators.push(token);
            }
            else if (token.equals("(")) {
                operators.push(token);
            }
            else if (token.equals(")")) {
                while (!operators.peek().equals("(")) {
                    postfix.add(operators.pop());
                }
                operators.pop();
            }
        }
        while (!operators.isEmpty()) {
            postfix.add(operators.pop());
        }
        return postfix;
	}
    public void build(List<String> postfix) {
        Collections.reverse(postfix);
        for (String token : postfix)
            buildRecursive(root, token);
    }
    /**
     * Builds an expression tree from the postfix representation returned from the convert method.
     * To build the correct tree, pull tokens from {@code List<String> postfix}, and places
     * them at the next available node in the tree.
     * Here is the exact algorithm:
     * <ol>
     *     <li> If the tree root is null, create a new node containing the token,
     *          assign it to the root, and return {@code true}.
     *     <li> If the right child of the current node is null, create a new node
     *          with the token, place it in the right child, and return {@code true}.
     *     <li> If the right child of the current node is an operator, make a recursive
     *          call passing the right child and token, and return true if successful,
     *          otherwise continue.
     *     <li> If the left child of the current node is null, create a new node with
     *          the token, place it in the left child, and return {@code true}.
     *     <li> If the left child of the current node is an operator, make a recursive
     *          call passing the left child and token, and return {@code true} if successful,
     *          otherwise continue.
     *     <li> If none of the above code returns {@code true}, then the code has failed to add
     *          the token to the tree, so return {@code false}.
     * </ol>
     *
     * Our implementation of the recursive method is ~19 lines of code
     * @param current the current Node being checked
     * @param token the token to add
     * @return {@code true}, if successful
     */
    public boolean buildRecursive(Node current, String token) {
    	if(root == null) {
            root = new Node(token);
            return true;
         }
         if(current.right == null) {
            current.right = new Node(token);
            return true;
         }
         if(ExpressionTree.isOperator(current.right.token)) {
            if(buildRecursive(current.right, token)) {
               return true;
            }
         }
         if(current.left == null) {
            current.left = new Node(token);
            return true;
         }
         if(ExpressionTree.isOperator(current.left.token)) {
            if(buildRecursive(current.left, token)) {
               return true;
            }
         }
         return false;
	}

    /******************************************Utility Methods Below This Line*****************************************/
    /**
     * Parses Input to a Queue of tokens
     * @param expression
     * @return
     */
    public Queue<String> parse(java.lang.String expression) {
        Queue<java.lang.String> infix = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, "(?<=[-+*()%/])|(?=[-+*()%/])", true);
        while(tokenizer.hasMoreTokens()){
            java.lang.String token = tokenizer.nextToken();
            if(!token.trim().isEmpty()) {
                infix.add(token.trim());
            }
        }
        return infix;
    }


    //
    // Utility methods
    //

    /**
     * @param token a token
     * @return true if token is an operator.
     */
    public static boolean isOperator(String token) {
        switch (token) {
            case "*":
            case "/":
            case "%":
            case "+":
            case "-":
                return true;
            default:
                return false;
        }
    }

    /**
     * @param token a token
     * @return true if the token is an int.
     */
    public static boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Converts an {@code String} into an {@code int}.
     * For example the string "11" is converted to the int 11.
     * @param token a string representing a number
     * @return the decimal representation if the token or -1.
     */
    public static int valueOf(String token) {
        try {
            return(Integer.parseInt(token));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Returns operator precedence.
     * @param operator the operator to evaluate
     * @return a ranking of operator precedence.
     */
    public static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 2;
            case "*":
            case "/":
            case "%":
                return 1;
            default:
                return 0;
        }
    }
}


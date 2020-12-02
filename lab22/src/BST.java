

/* Binary Search Tree Class
*  Made by Toby Patterson for CS165 at CSU
*  6/26/2020
*  A binary search tree of generic type which extends Comparable
*/

public class BST<E extends Comparable <E>> implements Tree<E> {

    private TreeNode root;
    private int size;

    public class TreeNode {
        public E element;
        public TreeNode rightChild;
        public TreeNode leftChild;

        /* TODO: finish this constructor
        *  Think: what needs to be initialized, there are three member variables */
        public TreeNode(E element) {
        	this.element = element;
        	this.rightChild = null;
        	this.leftChild = null;
        }
    }

    public BST() {
        this.root = null;
        size = 0;
    }

    public BST(E item) {
        this();
        insert(item);
    }

    public BST(E[] items) {
        for(int i = 0; i < items.length; i++) 
        	insert(items[i]);
        
    }

    /* TODO: finish this method */
    @Override
    public boolean search(E e) {
    	TreeNode c = root;
    	while(c != null) {
    		if(e.compareTo(c.element) > 0) {
    			c = c.rightChild;
    		} else if(e.compareTo(c.element) < 0) {
    			c = c.leftChild;
    		} else 
    			return true;
    	}
    	return false;
    }

    /* TODO: finish this method */
    @Override
    public boolean insert(E e) {
        if(root == null) {
        	root = new TreeNode(e);
        } else {
        	TreeNode c = root;
        	while(c != null) {
        		if(c.element.compareTo(e) == 0) {
        			return false;
        		} else if(c.element.compareTo(e) < 0) {
        			if(c.rightChild == null) {
        				c.rightChild = new TreeNode(e);
        				break;
        			} else
        				c = c.rightChild;
        		} else {
        			if(c.leftChild == null) {
        				c.leftChild = new TreeNode(e);
        				break;
        			} else
        				c = c.leftChild;
        		}
        	}
        }
        size++;
        return true;
    }

    /* TODO: finish this method */
    @Override
    public boolean remove(E e) {
    	TreeNode par = null;
        TreeNode cur = root;

        while(cur != null) {
            if(cur.element.compareTo(e) == 0)
                break;
            else {
                par = cur;
                if(cur.element.compareTo(e) > 0)
                    cur = cur.leftChild;
                else
                    cur = cur.rightChild;
            }
        }
           
        if(cur != null) {
            if(cur.leftChild == null && cur.rightChild == null) {
                if(par == null)
                    root = null;
                else if(par.leftChild == cur)
                        par.leftChild = null;
                else
                    par.rightChild = null;
            } else if(cur.rightChild == null)  {
                if(par == null) {
                    root = root.leftChild;
                }
                else if(par.leftChild == cur) {
                    par.leftChild = cur.leftChild;
                }
                else {
                    par.rightChild = cur.leftChild;
                }
            } else if(cur.leftChild == null) {
                if(par == null) {
                    root = root.rightChild;
                }
                else if(par.leftChild == cur) {
                    par.leftChild = cur.rightChild;
                } else {
                    par.rightChild = cur.rightChild;
                }
            } else  {
                TreeNode p = findsuccessor(cur);
                if(p.leftChild == null) {
                    if(par == null) {
                    	root.element = p.element;
                        root.rightChild = p.rightChild;
                    } else {
                    	cur.element = p.element;
                        cur.rightChild = p.rightChild;
                    }
                } else {
                    TreeNode prev = cur;  
                    while(p.leftChild != null) {
                        prev = p;
                        p.leftChild = cur.leftChild;
                    }
                       
                    if(par == null) {
                        root.element = p.element;
                        prev.leftChild = null;
                    } else {
                        cur.element = p.element;
                        prev.leftChild = null;
                    }
                }
            }
              
            return true;
        }
        else
            return false;
    }
    
    private TreeNode findsuccessor(TreeNode node) {
    	TreeNode curr = node.rightChild;
    	while(curr.leftChild != null) {
    		curr = curr.leftChild;
    	}
    	return curr;
    }

    /* Getter method for the size of the tree
    *  TODO: complete this method
    */
    @Override
    public int size() {
        return size;
    }

    /* Does an inorder traversal of the tree, printing each visited node
    *  TODO: Complete this method
    */
    @Override
    public void inorder() {
    	inorder(root);
    }
    private void inorder(TreeNode node) {
    	if(node != null) {
    		inorder(node.leftChild);
    		System.out.print(node.element + " ");
    		inorder(node.rightChild);
    	}
    }

    /* Does a postorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void postorder() {
    	postorder(root);
    }
    private void postorder(TreeNode node) {
    	if(node != null) {
    		postorder(node.leftChild);
    		postorder(node.rightChild);
    		System.out.print(node.element + " ");
    	}
    }


    /* Does a preorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void preorder() {
    	preorder(root);
    }
    private void preorder(TreeNode node) {
    	if(node != null) {
    		System.out.print(node.element + " ");
    		preorder(node.leftChild);
    		preorder(node.rightChild);
    	}
    }


    /* Prints true on empty tree, false otherwise
     *  TODO: Complete this method
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /* Returns the root node of the tree */
    public TreeNode getRoot() {
        return root;
    }
}

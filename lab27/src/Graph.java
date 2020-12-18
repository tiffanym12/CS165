/* Graph class
* Template made by Toby Patterson
* With the help of: https://www.cs.colostate.edu/~cs165/.Spring20/assignments/P8/doc/
* Completed by: your name here
* 6/2/2020
* For cs165 at CSU
*
* A basic graph which has a depth first search print method. It uses
* link references to keep track of edges.
* */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.w3c.dom.Node;

public class Graph<E extends Comparable> extends GraphAbstract<E> {
    public Graph() {
        nodes = new ArrayList<GraphNode>();
    }

    /* addEdge
    * Params: data1 & data2, both data items to be added and connected
    * If the either of the data items are not in the nodes ArrayList,
    * add them as new nodes. Otherwise, find the nodes in the ArrayList so
    * you can make them point to each other. Implement so there are no duplicates
    * added to either of the nodes neighbors ArrayList.
    * TODO: implement this method.
    * */
    @Override
    public void addEdge(E data1, E data2) {
    	GraphNode<E> d1 = find(data1, nodes);
    	if(d1 != null) {
    		GraphNode<E> d2 = find(data2, d1.neighbors);
    		if(d2 == null) {
    			d1.neighbors.add(new GraphNode<E>(data2));
    		}
    	} else {
    		GraphNode<E> t = new GraphNode<E>(data1);
    		nodes.add(t);
    		t.neighbors.add(new GraphNode<E>(data2));
    	}
    	GraphNode<E> d2 = find(data2, nodes);
    	if(d2 != null) {
    		d1 = find(data1, d2.neighbors);
    		if(d1 == null) {
    			d2.neighbors.add(new GraphNode<E>(data1));
    		}
    	} else {
    		GraphNode<E> t = new GraphNode<E>(data2);
    		nodes.add(t);
    		t.neighbors.add(new GraphNode<E>(data1));
    	}
    }
    
    GraphNode<E> find(E data, ArrayList<GraphAbstract.GraphNode> neighbors) {
    	for(GraphNode<E> n : neighbors) {
    		if(n.data == data) {
    			return n;
    		}
    	}
    	return null;
    }


    /* depthFirst
     * Param: startNode, the node to start the traversal at
     *
     * First, find the startNode based off of startItem (hint: indexOf())
     * I recommend having an ArrayList of GraphNodes called visisted to keep
     * track of the nodes you've visited.
     *
     * Another thing to note: Java does not like it if you try and do a foreach
     * loop on GraphNodes neighbors unless you specifically cast it as an
     * ArrayList of GraphNodes. e.g.
     *       for (GraphNode curr : (ArrayList<GraphNode>)node.neighbors)
     *
     * Prints all of the nodes in the graph in depth first order
     * TODO: implement this method.
     * */
    @Override
    public void depthFirst(E startItem) {
    	GraphNode<E> node = find(startItem, nodes);
    	if(node != null) {
    		ArrayList<GraphNode<E>> visited = new ArrayList<>();
    		depthFirst(node, visited);
    		System.out.println();
    	}
    }

    // Recursive helper method for depthFirst
    private void depthFirst(GraphNode<E> curr, ArrayList<GraphNode<E>> visited) {
    	visited.add(curr);
    	System.out.print(curr.data + " ");
    	for(GraphNode<E> neigh : curr.neighbors) {
    		boolean found = false;
    		for(GraphNode<E> n : visited) {
    			if(n.equals(neigh)) {
    				found = true;
    				break;
    			}
    		}
    		if(!found) {
    			GraphNode<E> n = find(neigh.data, nodes);
    			depthFirst(n, visited);
    		}
    	}
    }

    /* Writes the graph to a .dot file to be displayed in Graphviz */
    public void writeGraph(String filename) {

        ArrayList<String> output = new ArrayList<>();
        output.add("digraph G {");
        output.add("    ratio = 1.0;");
        output.add("    node [style=filled]");
        output.add("    node [fillcolor=darkslateblue]");
        output.add("    node [fixedsize=true]");
        output.add("    node [shape=oval]");
        output.add("    node [width=2]");
        output.add("    node [height=2]");
        output.add("    node [fontname=Arial]");
        output.add("    node [fontsize=30]");
        output.add("    node [fontcolor=white]");
        output.add("    edge [dir=none]");
        output.add("    edge [penwidth=10]");

        for (int i = 0; i < nodes.size(); i++) {
            GraphNode n = nodes.get(i);
            output.add(String.format("    Node%d [label=\"%s\"]", i, n.data));
        }

        ArrayList<GraphNode> v = new ArrayList<>();
        for (GraphNode n : nodes){
            v.add(n);
            for (GraphNode nn : (ArrayList<GraphNode>)n.neighbors) {
                if (v.contains(nn)) continue;
                output.add(String.format("    Node%d -> Node%d [color=\"%s\"]",
                        nodes.indexOf(n), nodes.indexOf(nn), "magenta"));
            }
        }
        output.add("}");
        writeFile(filename, output);
    }

    /**
     * Write contents of {@code ArrayList} to file
     * @param filename the name of the file to write to
     * @param contents an ArrayList of contents to write
     */
    static void writeFile(String filename, ArrayList<String> contents) {
        try(PrintWriter writer = new PrintWriter(filename)) {
            for (String line : contents)
                writer.println(line);
        } catch (IOException e) {
            System.err.println("Cannot write graph: " + filename);
        }
    }
}

public class GraphTest {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph();

        graph.addEdge(5, 3);
        graph.addEdge(5, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 6);

        System.out.println("Expected to go 5, 3, 2, 4, 6");
        graph.depthFirst(5);
        System.out.println("Expected to go 3, 5, 2, 4, 6");
        graph.depthFirst(3);

        graph.writeGraph("Graph.dot");

        /* As always, feel free to write more tests to help gain a better
        *  understanding (I also think it's kinda fun to play with Graphviz). */
    }
}

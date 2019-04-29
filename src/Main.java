import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        ListGraph graph = new ListGraph(13);
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);
        //graph.addEdge(6, 7);
        Components components = new Components(graph);
        System.out.println(components.getCount() + " components");
        components.printComponents();


       /* graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 7);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(4, 9);
        graph.addEdge(4, 10);
        graph.addEdge(8, 8); */

       /* graph.addEdge(0, 11);
        graph.addEdge(0, 12);
        graph.addEdge(11, 12);
        graph.addEdge(11, 9);
        graph.addEdge(11, 7);
        graph.addEdge(9, 10);
        graph.addEdge(9, 7);
        graph.addEdge(7, 8);
        graph.addEdge(7, 6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 13);
        graph.addEdge(2, 13);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);*/

        /*System.out.println(graph.printGraph());

        System.out.println();

        MatrixGraph graph1 = new MatrixGraph(8);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 6);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);
        graph1.addEdge(4, 5);
        graph1.addEdge(5, 7);
        graph1.addEdge(5, 6);

        System.out.println(graph1.printGraph());

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph);
        //depthFirstSearch.dfs(0,0);
        depthFirstSearch.searchAll();
        depthFirstSearch.printOrder();
        */
    }
}


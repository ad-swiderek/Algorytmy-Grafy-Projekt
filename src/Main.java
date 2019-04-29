import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        ListGraph listGraph = new ListGraph(13);
        MatrixGraph matrixGraph = new MatrixGraph(13);
        RandomGraphGenerator randomGraphGenerator = new RandomGraphGenerator(listGraph, matrixGraph, 1);

        Components components = new Components(listGraph);

        System.out.println(components.getCount() + " components");
        components.printComponents();
        System.out.println(listGraph.printGraph());

        components.mergeComponents();
        components = new Components(listGraph);
        System.out.println();
        System.out.println(components.getCount() + " components");
        components.printComponents();
        System.out.println(listGraph.printGraph());
        System.out.println();

        listGraph.removeEdge(3,4);
        listGraph.removeEdge(7,8);

        components=new Components(listGraph);
        System.out.println(components.getCount() + " components");
        components.printComponents();
        System.out.println(listGraph.printGraph());

        /*listGraph.addEdge(0, 5);
        listGraph.addEdge(4, 3);
        listGraph.addEdge(0, 1);
        listGraph.addEdge(9, 12);
        listGraph.addEdge(6, 4);
        listGraph.addEdge(5, 4);
        listGraph.addEdge(0, 2);
        listGraph.addEdge(11, 12);
        listGraph.addEdge(9, 10);
        listGraph.addEdge(0, 6);
        listGraph.addEdge(7, 8);
        listGraph.addEdge(9, 11);
        listGraph.addEdge(5, 3);
        //listGraph.addEdge(6, 7); */
        //System.out.println(matrixGraph.printGraph());


       /* listGraph.addEdge(0, 1);
        listGraph.addEdge(1, 2);
        listGraph.addEdge(1, 3);
        listGraph.addEdge(1, 7);
        listGraph.addEdge(2, 3);
        listGraph.addEdge(2, 5);
        listGraph.addEdge(2, 6);
        listGraph.addEdge(5, 6);
        listGraph.addEdge(6, 7);
        listGraph.addEdge(4, 9);
        listGraph.addEdge(4, 10);
        listGraph.addEdge(8, 8); */

       /* listGraph.addEdge(0, 11);
        listGraph.addEdge(0, 12);
        listGraph.addEdge(11, 12);
        listGraph.addEdge(11, 9);
        listGraph.addEdge(11, 7);
        listGraph.addEdge(9, 10);
        listGraph.addEdge(9, 7);
        listGraph.addEdge(7, 8);
        listGraph.addEdge(7, 6);
        listGraph.addEdge(1, 2);
        listGraph.addEdge(1, 13);
        listGraph.addEdge(2, 13);
        listGraph.addEdge(3, 4);
        listGraph.addEdge(4, 5);*/

        /*System.out.println(listGraph.printGraph());

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

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(listGraph);
        //depthFirstSearch.dfs(0,0);
        depthFirstSearch.searchAll();
        depthFirstSearch.printOrder();
        */
    }
}


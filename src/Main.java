public class Main {

    public static void main(String[] args) {
        ListGraph listGraph = new ListGraph(50);
        MatrixGraph matrixGraph = new MatrixGraph(50);
        //comp.mergeComponents();
        RandomGraphGenerator randomGraphGenerator = new RandomGraphGenerator(listGraph, matrixGraph, 1);
        Components comp = new Components(listGraph);
        Components comp2 = new Components(matrixGraph);

        Tarjan tj = new Tarjan(listGraph);
        System.out.println(listGraph.printGraph());
        System.out.println(comp.getCount() + "components");
        System.out.println(comp2.getCount() + "components");

        /*System.out.println(matrixGraph.printGraph());
        System.out.println(listGraph.printGraph());
        Components comp = new Components(matrixGraph);
        comp.mergeComponents();
        System.out.println(comp.getCount() + "components");
        Components comp2 = new Components(listGraph);
        System.out.println(comp2.getCount() + "components"); */
        //matrixGraph.deleteAllEdges();
        /*for (int t : listGraph.adj(0)) {
            System.out.println(t);
        }*/

       /* matrixGraph.addEdge(0,1);
        matrixGraph.addEdge(1,2);
        matrixGraph.addEdge(1,3);
        matrixGraph.addEdge(2,3);
        matrixGraph.addEdge(1,7);
        matrixGraph.addEdge(2,6);
        matrixGraph.addEdge(2,5);
        matrixGraph.addEdge(6,5);
        matrixGraph.addEdge(4,9);
        matrixGraph.addEdge(9,10);
        matrixGraph.addEdge(10,4);
        matrixGraph.addEdge(8,8);
        TreeEdgesDFS dfs = new TreeEdgesDFS(matrixGraph, 0);
        System.out.println(matrixGraph.printGraph()); */
       /* int v = listGraph.getV();
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

        listGraph.removeEdge((v / 3) - 1, v / 3);
        listGraph.removeEdge(((2 * v) / 3) - 1, (2 * v) / 3);

        components=new Components(listGraph);
        System.out.println(components.getCount() + " components");
        components.printComponents();
        System.out.println(listGraph.printGraph()); */

    }
}


public class Main {

    public static void main(String[] args) {
        ListGraph listGraph = new ListGraph(50);
        MatrixGraph matrixGraph = new MatrixGraph(50);
        RandomGraphGenerator randomGraphGenerator = new RandomGraphGenerator(listGraph, matrixGraph, 0.25);
        System.out.println("List: ");
        listGraph.deleteAllEdges();
        Tarjan tj = new Tarjan(listGraph);
        listGraph.deleteTreeEdges();
        System.out.println("Matrix: ");
        matrixGraph.deleteAllEdges();
        Tarjan tj2 = new Tarjan(listGraph);
        matrixGraph.deleteTreeEdges();

        //Components comp = new Components(listGraph);
       // Components comp2 = new Components(matrixGraph);
       // System.out.println(comp2.getCount() + " components");
        //comp2.mergeComponents();
        //matrixGraph.removeEdge(3,4);
        //comp2= new Components(matrixGraph);
        //System.out.println(comp2.getCount() + "components");
        //matrixGraph.deleteAllEdges();

        //Tarjan tj = new Tarjan(matrixGraph);
        //TreeEdgesDFS dfs = new TreeEdgesDFS(listGraph, 0);

            //System.out.println(listGraph.printGraph());
        //System.out.println(comp.getCount() + "components");
        //System.out.println(comp2.getCount() + "components");

       /* matrixGraph.addEdge(0,1);
        matrixGraph.addEdge(1,2);
        matrixGraph.addEdge(1,3);
        matrixGraph.addEdge(2,3);
        matrixGraph.addEdge(1,7);
        matrixGraph.addEdge(2,6);
        matrixGraph.addEdge(2,5);
        matrixGraph.addEdge(6,5);
        matrixGraph.addEdge(6,7);
        matrixGraph.addEdge(4,9);
        matrixGraph.addEdge(9,10);
        matrixGraph.addEdge(10,4);
        matrixGraph.addEdge(8,8);
        TreeEdgesDFS dfs = new TreeEdgesDFS(matrixGraph, 0);
        System.out.println(matrixGraph.printGraph());
        Tarjan tj = new Tarjan(matrixGraph); */
        //Tarjan tj = new Tarjan(matrixGraph);



    }
}


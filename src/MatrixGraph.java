public class MatrixGraph extends Graph {

    public MatrixGraph(int V) {
        super(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                L[i].add(j, 0);
                singleEdges[i].add(j, 0);
            }
        }
    }

    @Override
    public void addEdge(int v, int w) {
        L[v].set(w, 1);
        L[w].set(v, 1);
    }

    @Override
    public void addSingleEdge(int v, int w) {
        singleEdges[v].set(w, 1);
    }

    @Override
    public void removeEdge(int v, int w) {
        L[v].set(w, 0);
        L[w].set(v, 0);
    }

    @Override
    public boolean exist(int v, int w) {
        if (L[v].get(w) == 0)
            return false;
        else
            return true;
    }

    @Override
    public String printGraph() {
        StringBuilder matrixGraphSB = new StringBuilder();
        matrixGraphSB.append("   ");
        for (int i = 0; i < V; i++) {
            matrixGraphSB.append(i + ": ");
        }
        matrixGraphSB.append("\n");
        for (int i = 0; i < V; i++) {
            matrixGraphSB.append(i + ": ");
            for (int j : treeEdges[i]) {
                matrixGraphSB.append(j + "  ");
            }
            matrixGraphSB.append("\n");
        }
        return matrixGraphSB.toString();
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return L[v];
    }


    @Override
    public void deleteAllEdges() {
        Components comp = new Components(this);
        System.out.println("components count: " + comp.getCount());
        System.out.println(printGraph());
        for (int i = 0; i < V; i++) {
            for (int j : singleEdges[i]) {
                removeEdge(i, j);
                System.out.println(printGraph());
                comp = new Components(this);
                System.out.println("components count: " + comp.getCount());
                addEdge(i, j);
                System.out.println(printGraph());

            }
        }
    }
}

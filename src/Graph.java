import java.util.ArrayList;

public abstract class Graph {
    protected int V;
    protected ArrayList<Integer>[] L;
    protected ArrayList<Integer>[] singleEdges;
    protected ArrayList<Integer>[] treeEdges;
    public Graph(int V) {
        this.V = V;
        L = new ArrayList[V];
        singleEdges = new ArrayList[V];
        treeEdges = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            L[i] = new ArrayList<>();
            singleEdges[i] = new ArrayList<>();
            treeEdges[i] = new ArrayList<>();
        }
    }

    public abstract void addEdge(int v, int w);

    public abstract void removeEdge(int v, int w);

    public abstract boolean exist(int v, int w);

    public abstract String printGraph();

    public abstract Iterable<Integer> adj(int v);

    public int getV() {
        return V;
    }

    public abstract void addSingleEdge(int v, int w);

    public abstract void deleteAllEdges();
}

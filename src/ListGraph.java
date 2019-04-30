import java.util.Iterator;
import java.util.Random;

public class ListGraph extends Graph {

    public ListGraph(int V) {
        super(V);
    }

    @Override
    public void addEdge(int v, int w) {
        L[v].add(w);
        L[w].add(v);
    }

    @Override
    public void addSingleEdge(int v, int w) {
        singleEdges[v].add(w);
    }


    @Override
    public void removeEdge(int v, int w) {
        Iterator<Integer> itv = L[v].iterator();
        Iterator<Integer> itw = L[w].iterator();

        while (itv.hasNext()) {
            if (itv.next() == w) {
                itv.remove();
                break;
            }
        }

        while (itw.hasNext()) {
            if (itw.next() == v) {
                itw.remove();
                break;
            }
        }
    }

    @Override
    public boolean exist(int v, int w) {
        return L[v].contains(w);
    }

    @Override
    public String printGraph() {
        StringBuilder listGraphSB = new StringBuilder();
        for (int i = 0; i < V; i++) {
            listGraphSB.append(i + ": ");
            for (int j : L[i]) {
                listGraphSB.append(j + " ");
            }
            listGraphSB.append("\n");
        }
        return listGraphSB.toString();
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

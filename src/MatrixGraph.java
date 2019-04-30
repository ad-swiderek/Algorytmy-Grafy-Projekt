import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixGraph extends Graph {

    public MatrixGraph(int v) {
        super(v);
    }

    @Override
    public void addEdge(int v, int w) {
        M[v][w] = true;
        M[w][v] = true;
    }

    @Override
    public void addSingleEdge(int v, int w) {
        singleEdges[v].add(w);
    }

    @Override
    public void removeEdge(int v, int w) {
        M[v][w] = false;
        M[w][v] = false;
    }

    @Override
    public boolean exist(int v, int w) {
        return M[v][w];
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
            for (int j : adj(i)) {
                matrixGraphSB.append(j + "  ");
            }
            matrixGraphSB.append("\n");
        }
        return matrixGraphSB.toString();
    }


    @Override
    public Iterable<Integer> adj(int v) {
        return new AdjIterator(v);
    }


    @Override
    public void deleteAllEdges() {
        //long startTime;
        //long stopTime;
        Components comp = new Components(this);
        int componentsCount = comp.getCount();
        //System.out.println("components count: " + componentsCount);
        //System.out.println(printGraph());
        for (int i = 0; i < V; i++) {
            for (int j : singleEdges[i]) {
                //startTime = System.nanoTime();
                removeEdge(i, j);
                //stopTime = System.nanoTime();
                //System.out.println("Macierz Naiwny Usuwanie: " + (stopTime - startTime));

                //startTime = System.nanoTime();
                comp = new Components(this);
                if (comp.getCount() != componentsCount)
                    System.out.println(i + " " + j + " most");
                //stopTime = System.nanoTime();
                //System.out.println("Macierz Naiwny Sprawdzanie Spojnosci: " + (stopTime - startTime));

                //startTime = System.nanoTime();
                addEdge(i, j);
                //stopTime = System.nanoTime();
                //System.out.println("Macierz Naiwny Dodawanie: " + (stopTime - startTime));
            }
        }
    }

    @Override
    public void deleteTreeEdges() {
        //long startTime;
        //long stopTime;
        TreeEdgesDFS teDFS = new TreeEdgesDFS(this, 0);
        Components comp = new Components(this);
        int componentsCount = comp.getCount();
        //System.out.println("components count: " + componentsCount);
        for (int i = 0; i < V; i++) {
            for (int j : treeEdges[i]) {
                //startTime = System.nanoTime();
                removeEdge(i, j);
                //stopTime = System.nanoTime();
                //System.out.println("Macierz Ulepszony Usuwanie: " + (stopTime - startTime));

                //startTime = System.nanoTime();
                comp = new Components(this);
                if (comp.getCount() != componentsCount)
                    System.out.println(i + " " + j + " most");
                //stopTime = System.nanoTime();
                //System.out.println("Macierz Ulepszony Sprawdzanie Spojnosci: " + (stopTime - startTime));

                //startTime = System.nanoTime();
                addEdge(i, j);
                //stopTime = System.nanoTime();
                //System.out.println("Macierz Ulepszony Dodawanie: " + (stopTime - startTime));
            }
        }
    }

    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int v;
        private int w = 0;

        AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (w < V) {
                if (M[v][w]) return true;
                w++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }
    }


}

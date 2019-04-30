import com.sun.source.tree.Tree;

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
        //long startTime;
        //long stopTime;
        Components comp = new Components(this);
        int componentsCount = comp.getCount();
        //System.out.println("components count: " + componentsCount);
        for (int i = 0; i < V; i++) {
            for (int j : singleEdges[i]) {
                //startTime = System.nanoTime();
                removeEdge(i, j);
                //stopTime = System.nanoTime();
                //System.out.println("Lista Naiwny Usuwanie: " + (stopTime - startTime));

                //startTime = System.nanoTime();
                comp = new Components(this);
                if (comp.getCount() != componentsCount) {
                    System.out.println(i + " " + j + " most");
                }
                //stopTime = System.nanoTime();
                //System.out.println("Lista Naiwny Sprawdzanie Spojnosci: " + (stopTime - startTime));

                //startTime = System.nanoTime();
                addEdge(i, j);
                //stopTime = System.nanoTime();
                //System.out.println("Lista Naiwny Dodawanie: " + (stopTime - startTime));
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
                //System.out.println("Lista Ulepszony Usuwanie: " + (stopTime - startTime));

                //startTime = System.nanoTime();
                comp = new Components(this);
                if (comp.getCount() != componentsCount)
                    System.out.println(i + " " + j + " most");
                //stopTime = System.nanoTime();
                //System.out.println("Lista Ulepszony Sprawdzanie Spojnosci: " + (stopTime - startTime));

                //startTime = System.nanoTime();
                addEdge(i, j);
                //stopTime = System.nanoTime();
                //System.out.println("Lista Ulepszony Dodawanie: " + (stopTime - startTime));
            }
        }
    }


}

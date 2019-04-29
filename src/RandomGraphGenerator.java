import java.util.Random;

public class RandomGraphGenerator {
    public RandomGraphGenerator(Graph listGraph, Graph martixGraph, double prob) { // Erdos-Renyi model, prob - to prawdopodobienstwo dodania krawedzi, im wyzsze (przedzial 0-1) tym wieksza gestosc
        double rand;
        for (int i = 0; i < listGraph.getV(); i++) {
            for (int j = i + 1; j < listGraph.getV(); j++) {
                rand = Math.random();
                if (rand <= prob) {
                    listGraph.addEdge(i, j);
                    martixGraph.addEdge(i, j);
                }
            }
        }
    }
}

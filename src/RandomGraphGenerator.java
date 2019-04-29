import java.util.Random;

public class RandomGraphGenerator {
    public RandomGraphGenerator(Graph listGraph, Graph martixGraph, double prob) { // Erdos-Renyi model, prob - to prawdopodobienstwo dodania krawedzi, im wyzsze (przedzial 0-1) tym wieksza gestosc
        double rand;
        int v = listGraph.getV();
        for (int i = 0; i < v / 3; i++) {
            for (int j = i + 1; j < v / 3; j++) {
                rand = Math.random();
                if (rand <= prob) {
                    listGraph.addEdge(i, j);
                    martixGraph.addEdge(i, j);
                }
            }
        }

        //tworzymy most:
        //listGraph.addEdge((v / 3) - 1, v / 3);
        //martixGraph.addEdge((v / 3) - 1, v / 3);

        for (int i = v / 3; i < (2 * v) / 3; i++) {
            for (int j = i + 1; j < (2 * v) / 3; j++) {
                rand = Math.random();
                if (rand <= prob) {
                    listGraph.addEdge(i, j);
                    martixGraph.addEdge(i, j);
                }
            }
        }

        //tworzymy most:
        //listGraph.addEdge(((2 * v) / 3) - 1, (2 * v) / 3);
        //martixGraph.addEdge(((2 * v) / 3) - 1, (2 * v) / 3);

        for (int i = (2 * v) / 3; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                rand = Math.random();
                if (rand <= prob) {
                    listGraph.addEdge(i, j);
                    martixGraph.addEdge(i, j);
                }
            }
        }
    }
}

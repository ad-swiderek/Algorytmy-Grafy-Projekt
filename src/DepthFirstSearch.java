public class DepthFirstSearch {
    private int cnt;
    private int[] order;
    private int[] parent;
    private Graph g;

    public DepthFirstSearch(Graph g) {
        order = new int[g.getV()];
        parent = new int[g.getV()];
        cnt = 0;
        this.g = g;

        for (int i = 0; i < g.getV(); i++) {
            parent[i] = -1;
            order[i] = -1;
        }
    }

    public void dfs(int v, int w) {
        order[w] = cnt++;
        parent[w] = v;
        for (int t : g.adj(w)) {
            if (order[t] == -1) {
                dfs(w, t);
            }
        }
    }

    public void searchAll() { //jesli graf niespojny to dfs dla wszystkich skladowych
        for (int i = 0; i < g.getV(); i++) {
            if (order[i] == -1)
                dfs(i, i);
        }
    }

    public void printOrder() {
        for (int i = 0; i < g.getV(); i++) {
            System.out.print(order[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < g.getV(); i++) {
            System.out.print(parent[i] + " ");
        }
    }
}

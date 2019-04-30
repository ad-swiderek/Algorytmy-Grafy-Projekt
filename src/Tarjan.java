public class Tarjan {
    private int bridges;
    private int count;
    private int[] preorder;
    private int[] low;
    private Graph g;

    public Tarjan(Graph g) {
        this.g = g;
        count = 0;
        preorder = new int[g.getV()];
        low = new int[g.getV()];
        for (int i = 0; i < g.getV(); i++) {
            preorder[i] = -1;
            low[i] = -1;
        }
    }

    public void startTarjan() {
        for (int i = 0; i < g.getV(); i++) {
            if (preorder[i] == -1) {
                dfs(i, i);
            }
        }
    }

    private void dfs(int v, int w) {
        preorder[w] = count++;
        low[w] = preorder[w];
        for (int t : g.adj(w)) {
            if (preorder[t] == -1) {
                dfs(w, t);
                low[w] = Math.min(low[w], low[t]);
                if (low[t] == preorder[t]) {
                    bridges++;
                    System.out.println(w + " " + t + " most");
                }
            } else if (t != v) {
                low[w] = Math.min(low[w], preorder[t]);
            }
        }
    }
}

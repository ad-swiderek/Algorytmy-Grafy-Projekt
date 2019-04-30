public class TreeEdgesDFS {
    private boolean[] visited;
    private int count;
    private Graph g;

    public TreeEdgesDFS(Graph g, int v) {
        this.g = g;
        visited = new boolean[g.getV()];
        count = 0;
        dfs(v);
    }

    private void dfs(int v) {
        count++;
        visited[v] = true;
        for (int t : g.adj(v)) {
            if (visited[t] == false) {
                dfs(t);
                g.treeEdges[v].add(t);
                //System.out.println("Krawedz drzewowa: " + v + " " + t);
            }
        }
    }
}

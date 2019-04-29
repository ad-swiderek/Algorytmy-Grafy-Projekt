public class Components {
    private boolean[] visited;
    private int[] componentNumber;
    private int[] componentSize;
    private int count;
    private Graph g;

    public Components(Graph g) {
        this.g = g;
        visited = new boolean[g.getV()];
        componentNumber = new int[g.getV()];
        componentSize = new int[g.getV()];
        count = 0;
        for (int i = 0; i < g.getV(); i++) {
            if (visited[i] == false) {
                dfs(i);
                count++;
            }
        }
    }

    public int getComponentNumber(int v) {
        return componentNumber[v];
    }

    private int maxComponentSizeId() {
        int componentId = 0, maxSize = 0;
        for (int i = 0; i < count; i++) {
            if (componentSize[i] > maxSize) {
                maxSize = componentSize[i];
                componentId = i;
            }
        }
        return componentId;
    }

    public int getCount() {
        return count;
    }

    private void dfs(int v) {
        visited[v] = true;
        componentNumber[v] = count;
        componentSize[count]++;
        for (int t : g.adj(v)) {
            if (visited[t] == false) {
                dfs(t);
            }
        }
    }

    public boolean connected(int v, int w) {
        return getComponentNumber(v) == getComponentNumber(w);
    }

    public void printComponents() {
        for (int i = 0; i < count; i++) {
            System.out.print((i + 1) + " component: ");
            for (int j = 0; j < g.getV(); j++) {
                if (componentNumber[j] == i)
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public void mergeComponents() {
        if (count > 1) {
            int maxSizeId = maxComponentSizeId();
            int firstVertex = getVertexFromComponent(maxSizeId);
            for (int j = 0; j < g.getV(); j++) {
                if (componentNumber[j] != maxSizeId) {
                    g.addEdge(j, firstVertex);
                }
            }

        }
    }

    private int getVertexFromComponent(int comp) {
        for (int j = 0; j < g.getV(); j++) {
            if (componentNumber[j] == comp) {
                return j;
            }
        }
        return 0;
    }

}

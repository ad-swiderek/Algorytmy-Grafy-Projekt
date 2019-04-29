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

    public int getComponentSize(int v) {
        return componentSize[v];
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

    public void printComponents(){
        for(int i=0; i<count; i++){
            System.out.print((i+1) + " component: ");
            for(int j = 0 ; j< g.getV(); j++){
                if(componentNumber[j]==i)
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

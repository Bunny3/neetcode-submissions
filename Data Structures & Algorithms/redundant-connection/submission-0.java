class DSU {
    int parent[], size[];
    int comps;
    public DSU(int n) {
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<=n;i++) {
            parent[i]=i;
            size[i]=1;
        }
        comps = n;
    }
    public int find(int node) {
        if(parent[node]!=node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if(pu==pv) return false;
        if(size[pu]<=size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        size[pu] +=size[pv];
        comps--;
        parent[pv] = pu;
        return true;
    }
    public int components()
    {
        return comps;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for(int edge[]:edges) {
            if(!dsu.union(edge[0],edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }
}

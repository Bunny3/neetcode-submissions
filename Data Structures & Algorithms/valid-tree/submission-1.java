class DSU {
    int parent[];
    int size[];
    int comps;
    public DSU(int n) {
        comps = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int node) {
        if(parent[node]!=node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if(pv == pu) return false;

        if(size[pu]<size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        comps--;
        size[pu] += size[pv];
        parent[pv] = pu;
        return true; 
    }
    public int components() {
        return comps;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n-1) {
            return false;
        }

        DSU dsu = new DSU(n);
        for(int edge[]:edges) {
            if(!dsu.union(edge[0], edge[1]))
                return false;
        }

        return dsu.components()==1;
    }
}

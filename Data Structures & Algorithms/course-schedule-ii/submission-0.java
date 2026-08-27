class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create graph adjList
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int indegree[] = new int[numCourses];
        Arrays.fill(indegree,0);
        Queue<Integer> queue = new LinkedList<>();
        
        for(int edge[]:prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
            indegree[u]++;
        }
        for(int i=0;i<numCourses;i++) {
            if(indegree[i]==0) {    
                queue.add(i);
            }
        }

        // Kahn's algorithm
        int ans[] = new int[numCourses];
        int i=0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            ans[i] = node;
            i++;
            for(int neighbour:adjList.getOrDefault(node, new ArrayList<>())) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        if(i!=numCourses)
            return new int[0];
        else
            return ans;
    }
}

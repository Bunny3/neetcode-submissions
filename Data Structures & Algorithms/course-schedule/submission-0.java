class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        // Kahn's algorith 
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbour:adjList.getOrDefault(node, new ArrayList<>())) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        for(int i=0;i<numCourses;i++) {
            if(indegree[i]!=0) {    
                return false;
            }
        }
        return true;
    }
}

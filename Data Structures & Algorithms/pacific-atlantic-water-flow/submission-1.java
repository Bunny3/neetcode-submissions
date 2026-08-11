class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int visited[][] = new int[heights.length][heights[0].length];
        for(int i=0;i<visited.length;i++)
            Arrays.fill(visited[i],0);
        List<List<Integer>> ans = new ArrayList<>();
        Queue<int []> queue = new LinkedList<>();
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};

        //Pacific ocean
        for(int i=0;i<heights[0].length;i++) {
            queue.add(new int[]{0,i});
        }
        for(int j=0;j<heights.length;j++) {
            queue.add(new int[]{j,0});
        }

        while(!queue.isEmpty()) {
            int point[] = queue.poll();
            visited[point[0]][point[1]] = 1;
            for(int i=0;i<4;i++) {
                int nx = point[0]+dx[i];
                int ny = point[1]+dy[i];

                if(nx>=0 && nx<heights.length && ny>=0 && ny<heights[0].length && heights[nx][ny]>=heights[point[0]][point[1]] && visited[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                }
            }
        }


        //Atlantic
        int visitedAtlantic[][] = new int[heights.length][heights[0].length];
        for(int i=0;i<visitedAtlantic.length;i++)
            Arrays.fill(visitedAtlantic[i],0);
        queue = new LinkedList<>();
        for(int i=0;i<heights[0].length;i++) {
            queue.add(new int[]{heights.length-1,i});
        }
        for(int j=0;j<heights.length;j++) {
            queue.add(new int[]{j,heights[0].length-1});
        }

        while(!queue.isEmpty()) {
            int point[] = queue.poll();
            visitedAtlantic[point[0]][point[1]] = 1;
            for(int i=0;i<4;i++) {
                int nx = point[0]+dx[i];
                int ny = point[1]+dy[i];

                if(nx>=0 && nx<heights.length && ny>=0 && ny<heights[0].length && heights[nx][ny]>=heights[point[0]][point[1]] && visitedAtlantic[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        for(int i=0;i<heights.length;i++) {
            for(int j=0;j<heights[0].length;j++) {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("========");
        for(int i=0;i<heights.length;i++) {
            for(int j=0;j<heights[0].length;j++) {
                System.out.print(visitedAtlantic[i][j]+" ");
            }
            System.out.println();
        }
        
        for(int i=0;i<heights.length;i++) {
            for(int j=0;j<heights[0].length;j++) {
                if(visited[i][j]==1 && visitedAtlantic[i][j]==1) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    ans.add(point);
                }
            }
        }

        return ans;

    }
}

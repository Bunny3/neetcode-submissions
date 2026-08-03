class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2)
                    queue.add(new int[]{i,j});
            }
        }
        int time = 0;
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        while(!queue.isEmpty()) {
            int size = queue.size();
            time++;
            while(size-->0) {
                int point[] = queue.poll();
                for(int i=0;i<4;i++) {
                    int nx = point[0]+dx[i];
                    int ny = point[1]+dy[i];
                    if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length 
                        && grid[nx][ny]==1) {
                        grid[nx][ny] = 2;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return Math.max(0,time-1);
    }
}

class Solution {
    public void islandsAndTreasure(int[][] grid) {
       Queue<int[]> queue = new LinkedList<>();
       for(int i=0;i<grid.length;i++) {
        for(int j=0;j<grid[0].length;j++) {
            if(grid[i][j] == 0) {
                queue.add(new int[]{i,j});
            }
        }
       }

        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        int level =0;
       while(!queue.isEmpty()) {
        int size = queue.size();
        level++;
        while(size>0) {
            int point[] = queue.poll();
            size--;
            for(int i=0;i<4;i++) {
                int nx = point[0]+dx[i];
                int ny = point[1]+dy[i];
                if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length 
                && grid[nx][ny]==Integer.MAX_VALUE) {
                    grid[nx][ny] = level;
                    queue.add(new int[]{nx,ny});
                }
            }
        }

       }
    }
}

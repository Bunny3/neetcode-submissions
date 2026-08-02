class Solution {
    int dx[] = {0,1,0,-1};
    int dy[] = {1,0,-1,0};
    int area = 0;
    int maxArea = 0;
    public void dfs(int i, int j, int grid[][]) {
        grid[i][j] = 2;
        area++;
        
        for(int k=0;k<4;k++) {
            int nr = i+dx[k];
            int nc = j+dy[k];
            if((nr>=0 && nr<grid.length) && (nc>=0 && nc<grid[0].length) && grid[nr][nc] == 1) {
                dfs(nr,nc, grid);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    area=0;
                    dfs(i,j,grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}

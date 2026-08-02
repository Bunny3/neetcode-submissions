class Solution {
    int dx[] = {0,1,0,-1};
    int dy[] = {1,0,-1,0};
    public void dfs(int i, int j, char grid[][]) {
        grid[i][j] = '#';
        for(int k=0;k<4;k++) {
            int nr = i+dx[k];
            int nc = j+dy[k];
            if((nr>=0 && nr<grid.length) && (nc>=0 && nc<grid[0].length) && grid[nr][nc] == '1') {
                dfs(nr,nc, grid);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count =0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
}

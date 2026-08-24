class Solution {
    public void solve(char[][] board) {
        // find out all the edge with 0

        // Queue for bfs
        Queue<int[]> queue = new LinkedList<>();
        // for(int i=0;i<board.length;i++) {
        //     if(board[i][0] == 'O') {
        //             queue.offer(new int[]{i,0});
        //     }
        //     if(board[i][board[0].length-1] == 'O') {
        //             queue.offer(new int[]{i,board[0].length-1});
        //     }
        // }
        // for(int j=0;j<board[0].length;j++) {
        //     if(board[0][j] == 'O') {
        //             queue.offer(new int[]{0,j});
        //     }
        //     if(board[board.length-1][j] == 'O') {
        //             queue.offer(new int[]{board.length-1,j});
        //     }
        // }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(i==0 || i==board.length-1 || j==0 || j==board[0].length-1) {
                    if(board[i][j]=='O')
                        queue.offer(new int[]{i,j});
                }
            }
        }
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        while(!queue.isEmpty()) {
            int point[] = queue.poll();
            
            board[point[0]][point[1]] = '#';
            for(int i=0;i<4;i++) {
                int nx = point[0]+dx[i];
                int ny = point[1]+dy[i];
                if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && board[nx][ny]=='O') {
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'O') {
                    board[i][j] ='X';
                } 
                if(board[i][j] == '#') {
                    board[i][j] ='O';
                }
            }
        }
    }
}

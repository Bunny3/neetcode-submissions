class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Try starting the search from every cell on the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // Base Case 1: Entire word has been matched
        if (index == word.length()) {
            return true;
        }

        // Base Case 2: Out of bounds or character mismatch
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited using a temporary character
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all 4 adjacent directions (Right, Down, Left, Up)
        boolean found = dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1);

        // Backtrack: Restore original character
        board[i][j] = temp;

        return found;
    }
}
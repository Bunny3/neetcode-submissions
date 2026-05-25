class Solution {
    public boolean isRowValid(char[] row) {
        Set<Integer> set = new HashSet<Integer>();
        for(int j=0;j<9;j++) {
            if(row[j]!='.') {
                int number = row[j]-'0';
                if((number<=0 && number >9) || (set.contains(number) == true))
                    return false;
                set.add(number);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++) {
            if(isRowValid(board[i])==false)
                return false;
        }
        for(int i=0;i<9;i++) {
            Set<Integer> set = new HashSet<Integer>();
            for(int j=0;j<9;j++) {
                if(board[j][i]!='.') {
                    int number = board[j][i]-'0';
                    if((number<=0 && number >9) || (set.contains(number) == true))
                        return false;
                    set.add(number);
                }
            }
        }

        for(int square=0;square<9;square++) {
            Set<Character> seen = new HashSet<>();
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    int row = (square / 3)*3 + i;
                    int col = (square % 3)*3 + j;
                    if(board[row][col] == '.') continue;
                    if(seen.contains(board[row][col])) 
                        return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}

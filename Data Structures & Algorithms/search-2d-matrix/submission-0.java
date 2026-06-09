class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = -1;
        int m = matrix.length;
        int n = matrix[0].length;
        int r = m*n;

        while(l+1<r) {
            int mid = l + (r-l)/2;
            int row = mid/n;
            int column = mid%n;
            if(matrix[row][column] <=target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if(l==-1)
            return false;
        if(matrix[l/n][l%n] == target) 
            return true;
        return false;
    }
}

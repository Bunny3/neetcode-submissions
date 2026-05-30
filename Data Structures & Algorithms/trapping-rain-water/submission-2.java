class Solution {
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && height[i]>=height[st.peek()]) {
                int mid = height[st.pop()];
                if(!st.isEmpty()) {
                    int rightWall = height[i];
                    int leftWall = height[st.peek()];
                    int h = Math.min(rightWall, leftWall)-mid;
                    int w = i-st.peek()-1;
                    res +=h*w;
                }
            }
            st.push(i);
        }
        return res;
    }
}

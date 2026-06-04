class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int result[] = new int[len];

        int i=len-1;
        while(i>=0) {
            while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
            i--;
        }
        return result;
    }
}

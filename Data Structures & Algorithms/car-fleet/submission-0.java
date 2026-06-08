class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // 1 + 3 + 3 + 3
        // 4 + 2 + 2 + 2

        // 10
        // 4 + 2 + 2 + 2 (3h)
        // 1 + 2 + 2 + 2 + 2 (4h)
        // 0 + 1 + 1 + 1 + 1  (4h)
        // 7 + 1 + 1 + 1 (3h)
        int pair[][] = new int[position.length][2];
        for(int i=0;i<position.length;i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b)-> Integer.compare(b[0],a[0]));
        Stack<Double> stack = new Stack<>();
        for(int p[]:pair) {
            double time = (double) (target - p[0]) / p[1];
            if(!stack.isEmpty()) {
                if(stack.peek()>=time)
                    continue;
            }
            stack.push(time);
        }
        return stack.size();
    }
}

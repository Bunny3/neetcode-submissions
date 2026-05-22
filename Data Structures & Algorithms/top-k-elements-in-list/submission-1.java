class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num: nums) {
            mp.putIfAbsent(num,0);
            mp.put(num, mp.get(num)+1);
        }
        int ans[] = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(Map.Entry<Integer, Integer> entry: mp.entrySet()) {              
            if(pq.size() == k) {
                if(pq.peek()[0] < entry.getValue()) {
                    pq.poll();
                    pq.offer(new int[]{entry.getValue(), entry.getKey()});
                }
            } else {
                pq.offer(new int[]{entry.getValue(), entry.getKey()});
            }
        }
        
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[1];
        }
        return ans;
    }
}

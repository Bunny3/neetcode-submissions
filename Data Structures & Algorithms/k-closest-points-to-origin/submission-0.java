class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            double value1 = Math.sqrt(Math.pow(a[0],2) + Math.pow(a[1],2));
            double value2 = Math.sqrt(Math.pow(b[0],2) + Math.pow(b[1],2));
             return Double.compare(value2, value1); 
        });

        for(int i=0;i<points.length;i++) {
           if(pq.size()<k) {
                pq.add(points[i]);
           } else {
            double distance = Math.sqrt(Math.pow(points[i][0],2) + Math.pow(points[i][1],2));
            int point[] = pq.peek();
            double topDistance = Math.sqrt(Math.pow(point[0],2) + Math.pow(point[1],2));
            if(distance<topDistance) {
                pq.poll();
                pq.add(points[i]);
            }
           }
        }

        return pq.toArray(new int[0][]);
    }
}

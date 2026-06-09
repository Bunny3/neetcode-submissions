class Solution {
    public int predicate(int k, int[] piles, int h) {
        int operation = 0;
        for(int i=0;i<piles.length;i++) {
            operation += Math.ceil((double)piles[i]/k);
        }
        if(operation<=h){
            return 1;
        } else {
            return 0;
        }
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i=0;i<piles.length;i++) {
            max = Math.max(piles[i],max);
        }
        int l=0,r=max;
        while(l+1<r){
            int mid = l + (r-l)/2;
            if(predicate(mid,piles,h) == 0) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }
}

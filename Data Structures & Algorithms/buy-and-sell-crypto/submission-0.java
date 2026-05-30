class Solution {
    public int maxProfit(int[] prices) {
        int minleft = prices[0];
        int maxProfit = 0;
        int n = prices.length;
        for(int i=1;i<n;i++) {
            maxProfit=Math.max(maxProfit, prices[i]-minleft);
            if(minleft>prices[i])
                minleft=prices[i];
        }
        return maxProfit;
    }
}

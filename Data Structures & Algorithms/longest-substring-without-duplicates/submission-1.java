class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int n=s.length();
        int start = 0, i =0;
        int maxLength = 0;
        for(i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(mp.containsKey(ch) && mp.get(ch)>=start) {
                maxLength=Math.max(maxLength,(i-start));
                start = mp.get(ch)+1;
            }
            mp.put(ch,i);
        }
        return Math.max(maxLength,(i-start));
    }
}

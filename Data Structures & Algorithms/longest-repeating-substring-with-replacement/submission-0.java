class Solution {
    public int findMaxFreq(HashMap<Character, Integer> mp) {
        int maxFreq =0;
        for(Map.Entry<Character,Integer> entry:mp.entrySet()) {
            if(entry.getValue()>maxFreq) {
                maxFreq = entry.getValue();
            }
        }
        return maxFreq;
    }
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int l = 0;
        int maxWindowLength = 0;
        for(int r=0;r<s.length();r++) {
            char ch = s.charAt(r);
            
            if(mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch)+1);
            } else {
                mp.put(ch, 1);
            }

            //Find Max freq
            int maxFreq = findMaxFreq(mp);
            
            while((r-l+1)-maxFreq > k) {
                char temp = s.charAt(l);
                mp.put(temp, mp.get(temp)-1);
                l++;
            }
            maxWindowLength = Math.max(maxWindowLength, r-l+1);
        }
        return maxWindowLength;
    }
}

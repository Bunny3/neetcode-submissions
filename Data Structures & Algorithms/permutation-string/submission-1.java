class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) 
            return false;
        int count[] = new int[26];
        Arrays.fill(count,0);
        
        for(int i=0;i<s1.length();i++) {
            count[s1.charAt(i)-'a']++;
        }
        
        for(int i=0;i<=s2.length()-s1.length();i++) {
            // Get Window of length of S1
            int start = i;
            int end = i+s1.length()-1;
            int current[] = new int[26];
            Arrays.fill(current,0);
            
            while(start<=end) {
                char ch = s2.charAt(start);
                current[ch-'a']++;
                start++;
            }
            //Check if the character matches in both running count
            boolean temp = true;
            for(int j=0;j<26;j++) {
                if(current[j]!=count[j])
                    temp = false;
            }
            if(temp == true)
                return true;
            
        }
        return false;
    }
}

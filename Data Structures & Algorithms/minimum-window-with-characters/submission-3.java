class Solution {
    public boolean validHelper(HashMap<Character, Integer> count, 
            HashMap<Character, Integer> current) {
                for(Map.Entry<Character,Integer> entry:count.entrySet()) {
                    Character key = entry.getKey();
                    Integer value = entry.getValue();
                    if(current.containsKey(key)== false) {
                        return false;
                    } else {
                        if(current.get(key)<value) 
                            return false;
                    }
                }
                return true;
            }
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();
        HashMap<Character, Integer> current = new HashMap<>();
        int minWindow = s.length()+2;
        int l = 0;
        int start=0, end=-1;
        if(t.length()>s.length())
            return "";
        
        for(int i=0;i<t.length();i++) {
            char ch = t.charAt(i);
            if(!count.containsKey(ch)) {
                count.put(ch,0);
            }
            count.put(ch, count.get(ch)+1);
        }

        for(int r=0;r<s.length();r++) {
            char ch = s.charAt(r);
            if(!current.containsKey(ch)) {
                current.put(ch,0);
            }
            current.put(ch, current.get(ch)+1);
            while(validHelper(count, current) == true) {
                if(minWindow > r-l+1) {
                    minWindow = r-l+1;
                    start=l;
                    end=r;
                }
                char temp = s.charAt(l);
                current.put(temp,current.get(temp)-1);
                l++;
            }
        }
        if (end == -1) return "";
        return s.substring(start, end+1);
    }
}
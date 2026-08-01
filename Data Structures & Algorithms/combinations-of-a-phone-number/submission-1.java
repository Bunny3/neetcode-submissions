class Solution {
    HashMap<Character, String> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {

        map= new HashMap<>();
        res = new ArrayList<>(); 
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits.length()>0){
           dfs("",0,digits); 
        }
        return res;
    }

    public void dfs(String curr,int i, String digits) {
        if(i==digits.length()) {
            res.add(curr);
            return;
        }
        char ch = digits.charAt(i);
        String mapping = map.get(ch); 
        for(int j=0;j<mapping.length();j++) {
            // curr = curr+mapping.charAt(j);
            dfs(curr+mapping.charAt(j), i+1, digits);
            // curr = curr.substring(0,curr.length());
        }
    }
}

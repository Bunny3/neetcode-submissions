class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     HashMap<String, List<String>> mp = new HashMap<>();
     for(String word: strs) {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        String sortedWord = new String(charArray);
        List<String> temp;
        if(!mp.containsKey(sortedWord)) {
            temp = new ArrayList<String>();
        } else {
            temp = mp.get(sortedWord);
        }
        temp.add(word);
        mp.put(sortedWord, temp);
        // mp.putIfAbsent(sortedWord, new ArrayList<>());
        // mp.get(sortedWord).add(word);
     }
     return new ArrayList<>(mp.values());
    }
}

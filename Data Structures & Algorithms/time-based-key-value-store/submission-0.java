class Pair {
    String value;
    int timestamp;
    Pair(String v, int t) {
        value = v;
        timestamp = t;
    }
}
class TimeMap {

    HashMap<String, List<Pair>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair p = new Pair(value, timestamp);
        List<Pair> list = new ArrayList<>();
        if(store.containsKey(key)) {
            list = store.get(key);
        }
        list.add(p);
        store.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = new ArrayList<>();
        if(store.containsKey(key)) {
            list = store.get(key);
        }
        if(list.size()==0) 
            return "";
        // Binary Search in the List
        int n = list.size();
        int l = -1;
        int r = n;
        while(l+1<r) {
            int mid = l + (r-l)/2;
            if(list.get(mid).timestamp<=timestamp) {
                l = mid;
            } else {
                r = mid;
            }
        }
        // System.out.println(n + " <-- N value  an d L value "+l+" value is "+ list.get(l).value);
        if(l==-1)
            return "";
        return list.get(l).value;
    }
}

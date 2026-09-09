class TimeMap {

    HashMap<String, HashMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new HashMap<>());  
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
    
        if (map.containsKey(key)){
            if (map.get(key).containsKey(timestamp)){
                return map.get(key).get(timestamp);
            } else {
                while (timestamp > 0){
                    timestamp--;
                    if (map.get(key).containsKey(timestamp)){
                        return map.get(key).get(timestamp);
                    }
                }
            } 
        }
        return "";
    }
}

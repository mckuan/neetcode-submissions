public class RandomizedSet {
    private Map<Integer, Integer> valToIndex;  // value -> index in the list
    private List<Integer> values;
    private Random rand;

    public RandomizedSet() {
        valToIndex = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        
        // Add to end of list and record its position
        valToIndex.put(val, values.size());
        values.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        
        int indexToRemove = valToIndex.get(val);
        int lastElement = values.get(values.size() - 1);
        
        // Move last element to the position of element to remove
        values.set(indexToRemove, lastElement);
        valToIndex.put(lastElement, indexToRemove);
        
        // Remove the last element
        values.remove(values.size() - 1);
        valToIndex.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
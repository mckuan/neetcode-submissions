public class MedianFinder {
    private List<Integer> arr;

    public MedianFinder() {
        arr = new ArrayList<>();
    }
    
    public void addNum(int num) {
        arr.add(num);
    }
    
    public double findMedian() {
        int size = arr.size();
        Collections.sort(arr);
        if (size%2 == 1) return arr.get((size)/2);
        return ((double)arr.get(size/2) + arr.get(size/2 - 1))/2 ;
    }
}

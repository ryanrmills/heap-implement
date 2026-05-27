import java.util.ArrayList;
import java.util.List;

/**
 * A min-heap. 
 * 
 * Must contain functionality for the following: (n = # of elements in heap)
 * 
 * Adding a new value to the heap  O(log(n))
 * Popping the front of the heap O(log(n))
 * Peeking at the front of the heap without removing the element O(1)
 * Getting the size of the heap O(1)
 * Checking whether the heap is empty O(1)
 * 
 * 
 * The Heap must hold ints
 * 
 * Use List/ArrayList as a backing array, but DO NOT use the 
 * PriorityQueue class. Do not make Node objects, use array
 * indexing instead.
 * 
 * It is up to you to make design decisions about how to:
 *  - name methods
 *  - determine return value and argument types
 *  - hold private instance variables
 */
public class Heap {
    private final List<Integer> numList;

    public Heap(){
        numList = new ArrayList<>();
    }

    public void add(int num){
        numList.add(num);
        siftUp(numList.size() - 1);
    }

    public int pop(){
        if (numList.isEmpty()) {
            throw new IllegalStateException("The heap is empty.");
        }

        int popped = numList.get(0);
        int lastIndex = numList.size() - 1;

        if (lastIndex == 0) {
            numList.remove(lastIndex);
            return popped;
        }

        int last = numList.remove(lastIndex);
        numList.set(0, last);
        siftDown(0);
        return popped;
    }

    public int peek(){
        if (numList.isEmpty()) throw new IllegalStateException("The heap is empty.");
        return numList.get(0);
    }

    public int size(){
        return numList.size();
    }

    public boolean isEmpty() {
        return numList.isEmpty();
    }

    private void siftUp(int index){
        int currentIndex = index;

        while (currentIndex > 0) {
            int parentIndex = findParentIndex(currentIndex);
            if (numList.get(parentIndex) <= numList.get(currentIndex)) {
                break;
            }
            swap(parentIndex, currentIndex);
            currentIndex = parentIndex;
        }
    }

    private void siftDown(int index){
        int currentIndex = index;

        while (true) {
            int left = findLeftChildIndex(currentIndex);
            int right = findRightChildIndex(currentIndex);
            int smallest = currentIndex;

            if (left < numList.size() && numList.get(left) < numList.get(smallest)) {
                smallest = left;
            }

            if (right < numList.size() && numList.get(right) < numList.get(smallest)) {
                smallest = right;
            }

            if (smallest == currentIndex) {
                break;
            }

            swap(currentIndex, smallest);
            currentIndex = smallest;
        }
    }

    private int findParentIndex(int index){
        return (index - 1) / 2;
    }

    private int findLeftChildIndex(int index){
        return 2 * index + 1;
    }

    private int findRightChildIndex(int index){
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        int temp = numList.get(i);
        numList.set(i, numList.get(j));
        numList.set(j, temp);
    }

    @Override
    public String toString(){
        return numList.toString();
    }
}

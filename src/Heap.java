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
    private static List<Integer> numList;

    public Heap(){
        numList = new ArrayList<>();
    }

    public void add(int num){
        //sift up
        numList.add(num);
        siftUp(num, numList.size() - 1);
    }

    public int pop(){
        int popped = numList.get(0);
        int last = numList.get(numList.size() - 1);

        numList.remove(0);
        numList.add(0, last);
        
        //sift down
        siftDown(last, 0);
        return popped;
    }

    public int peek(){
        if (numList.size() == 0) throw new IllegalStateException("The heap is empty.");
        return numList.get(0);
    }

    public int size(){
        return numList.size();
    }

    private static void siftUp(int num, int index){
        int parentIndex = findParentIndex(index) > 0 ? findParentIndex(index) : 0;
        int currentIndex = index;
        while (numList.get(parentIndex) > num){
            //switch?
            int original = numList.get(parentIndex); //[0, 2, 3, 2]
            numList.set(parentIndex, num);
            numList.set(currentIndex, original);
            currentIndex = findParentIndex(currentIndex);
        }
    }

    private static void siftDown(int num, int index){
        int currentIndex = index;
        int currentLeft = findChildIndex(index)[0];
        int currentRight = findChildIndex(index)[1];
        while (numList.get(currentLeft) < num || numList.get(currentRight) < num){
            if (numList.get(currentLeft) < num && numList.get(currentLeft) < numList.get(currentRight)){
                int original = numList.get(currentLeft);
                numList.set(currentLeft, num);
                numList.set(currentIndex, original);
                currentIndex = currentLeft;
                if (findChildIndex(currentIndex)[0] >= numList.size() - 1) return;
            } else if (numList.get(currentRight) < num && numList.get(currentRight) < numList.get(currentLeft)){
                int original = numList.get(currentRight);
                numList.set(currentRight, num);
                numList.set(currentIndex, original);
                currentIndex = currentRight;
                if (findChildIndex(currentIndex)[1] >= numList.size() - 1) return;
            }
        }
    }

    private static int findParentIndex(int index){
        double var1 = Math.floor(index / 2);
        double var2 = index / 2;
        int parentIndex = var1 < var2 ?  (int) var1 : (int) var1 - 1;
        return parentIndex;
    }

    private static int[] findChildIndex(int index){
        return new int[]{(2 * index + 1), (2 * index + 2)};
    }

    public boolean isEmpty(){
        return numList.isEmpty();
    }

    public String toString(){
        return numList.toString();
    }
}
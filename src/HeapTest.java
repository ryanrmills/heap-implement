import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

    @Test
    public void addBuildsExpectedHeapShape() {
        Heap heap = new Heap();

        heap.add(7);
        heap.add(3);
        heap.add(5);
        heap.add(1);
        heap.add(9);
        heap.add(2);

        assertEquals("[1, 3, 2, 7, 9, 5]", heap.toString());
        assertEquals(6, heap.size());
        assertEquals(1, heap.peek());
    }

    @Test
    public void peekDoesNotRemoveFront() {
        Heap heap = new Heap();

        heap.add(12);
        heap.add(4);
        heap.add(7);

        assertEquals(4, heap.peek());
        assertEquals(3, heap.size());
        assertEquals(4, heap.peek());
        assertEquals(3, heap.size());
    }

    @Test
    public void popReturnsValuesInAscendingOrder() {
        Heap heap = new Heap();

        heap.add(8);
        heap.add(4);
        heap.add(10);
        heap.add(1);
        heap.add(6);
        heap.add(14);
        heap.add(13);
        heap.add(3);

        assertEquals(1, heap.pop());
        assertEquals(3, heap.pop());
        assertEquals(4, heap.pop());
        assertEquals(6, heap.pop());
        assertEquals(8, heap.pop());
        assertEquals(10, heap.pop());
        assertEquals(13, heap.pop());
        assertEquals(14, heap.pop());
        assertEquals(0, heap.size());
    }

    @Test
    public void heapHandlesNegativeAndDuplicateValues() {
        Heap heap = new Heap();

        heap.add(-2);
        heap.add(5);
        heap.add(-2);
        heap.add(0);
        heap.add(5);

        assertEquals(-2, heap.peek());
        assertEquals(-2, heap.pop());
        assertEquals(-2, heap.pop());
        assertEquals(0, heap.pop());
        assertEquals(5, heap.pop());
        assertEquals(5, heap.pop());
        assertEquals(0, heap.size());
    }

    @Test
    public void mixedAddPopSequenceMaintainsHeapProperty() {
        Heap heap = new Heap();

        heap.add(10);
        heap.add(4);
        heap.add(15);

        assertEquals(4, heap.pop());

        heap.add(2);
        heap.add(8);

        assertEquals("[2, 8, 10, 15]", heap.toString());
        assertEquals(2, heap.peek());
        assertEquals(4, heap.size());
    }
}

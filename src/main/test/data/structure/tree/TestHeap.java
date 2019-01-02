package data.structure.tree;

import algorithm.sort.HeapSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestHeap {

    private Heap heap = new Heap();

    @Test
    public void testInsert() {
        heap.insert(1);
        heap.insert(2);
        heap.insert(8);
        heap.insert(2);
        heap.insert(5);
        heap.insert(1);
        heap.insert(9);
        System.out.println(heap);
    }

    @Test
    public void testRemoveMax() {
        testInsert();
        heap.removeMax();
        heap.removeMax();
        System.out.println(heap);
    }

    @Test
    public void testSort() {
        int[] ints = {2, 2, 3, 5, 1, 2, 6};
        HeapSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}

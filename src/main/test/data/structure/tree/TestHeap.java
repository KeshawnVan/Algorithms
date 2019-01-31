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

    @Test
    public void testFindSingle() {
        int[] items = {4, 1, 2, 1, 2, 4, 3};

        int n = 0;
        for (int i = 0; i < items.length; i++) {
            n = n ^ items[i];
        }
        System.out.println(n);

        Heap heap = new Heap(items);
        Integer last = heap.removeMax();
        for (int i = 0; i < items.length; i++) {
            int current = heap.removeMax();
            if (last == null) {
                last = current;
            } else if (last == current) {
                last = null;
            } else {
                break;
            }
        }
        System.out.println(last);


    }

    @Test
    public void testNewHeap() {
        Integer[] items = {4, 1, 2, 1, 2, 4, 3, 5};
        MaxHeap<Integer> integerHeap = new MaxHeap<>(items);
        System.out.println(integerHeap);
    }
}

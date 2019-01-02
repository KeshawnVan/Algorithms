package data.structure.tree;

import org.junit.jupiter.api.Test;

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
}

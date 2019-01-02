package algorithm.sort;

import data.structure.tree.Heap;

public class HeapSort {

    public static void sort(int[] items) {
        new Heap(items).sort();
    }
}

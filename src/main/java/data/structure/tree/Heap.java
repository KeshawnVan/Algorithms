package data.structure.tree;

import java.util.Arrays;

public class Heap {

    private int[] items;

    private int capacity;

    private int count;

    public Heap() {
        capacity = 16;
        items = new int[capacity];
    }

    public Heap(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }

    public Heap(int[] items) {
        this.items = items;
        this.count = items.length;
        buildHeap();
    }

    @Override
    public String toString() {
        return "Heap{" +
                "items=" + Arrays.toString(items) +
                ", capacity=" + capacity +
                ", count=" + count +
                '}';
    }

    public Boolean insert(int value) {
        if (count > capacity) return Boolean.FALSE;
        int index = count++;
        items[index] = value;
        int parentIndex = getParentIndex(index);
        while (parentIndex >= 0 && items[index] > items[parentIndex]) {
            swap(items, index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
        return Boolean.TRUE;
    }


    private void swap(int[] items, int a, int b) {
        int tmp = items[a];
        items[a] = items[b];
        items[b] = tmp;
    }

    public int removeMax() {
        if (count == 0) return -1;
        int maxValue = items[0];
        items[0] = items[count - 1];
        items[count - 1] = 0;
        count--;
        heapify(items, count, 0);
        return maxValue;
    }

    public void heapify(int[] items, int count, int index) {
        while (true) {
            int maxIndex = index;
            int leftIndex = getLeftIndex(index);
            int rightIndex = getRightIndex(index);
            if (leftIndex <= count - 1 && items[leftIndex] > items[maxIndex]) maxIndex = leftIndex;
            if (rightIndex <= count - 1 && items[rightIndex] > items[maxIndex]) maxIndex = rightIndex;
            if (maxIndex == index) break;
            swap(items, maxIndex, index);
            index = maxIndex;
        }
    }

    private int getParentIndex(int index) {
        return index - 1 >> 1;
    }

    private int getRightIndex(int index) {
        return (index << 1) + 2;
    }

    private int getLeftIndex(int index) {
        return (index << 1) + 1;
    }

    public void buildHeap() {
        for (int i = (count >> 1) - 1; i >= 0; i--) {
            heapify(items, count, i);
        }
    }

    public void sort() {
        int n = count;
        while (n > 1) {
            swap(items, 0, n - 1);
            n--;
            heapify(items, n, 0);
        }
    }

}

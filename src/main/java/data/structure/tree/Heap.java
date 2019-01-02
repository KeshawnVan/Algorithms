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

    @Override
    public String toString() {
        return "Heap{" +
                "items=" + Arrays.toString(items) +
                ", capacity=" + capacity +
                ", count=" + count +
                '}';
    }

    public Boolean insert(int value) {
        if (count + 1 > capacity) return Boolean.FALSE;
        int index = ++count;
        items[index] = value;
        int parentIndex = index >> 1;
        while (parentIndex > 0 && items[index] > items[parentIndex]) {
            swap(items, index, parentIndex);
            index = parentIndex;
            parentIndex = index >> 1;
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
        int maxValue = items[1];
        items[1] = items[count];
        items[count] = 0;
        count--;
        heapify(items, count, 1);
        return maxValue;
    }

    public void heapify(int[] items, int count, int index) {
        while (true) {
            int maxIndex = index;
            int leftIndex = index << 1;
            int rightIndex = (leftIndex) + 1;
            if (leftIndex <= count && items[leftIndex] > items[maxIndex]) maxIndex = leftIndex;
            if (rightIndex <= count && items[rightIndex] > items[maxIndex]) maxIndex = rightIndex;
            if (maxIndex == index) break;
            swap(items, maxIndex, index);
            index = maxIndex;
        }
    }

}

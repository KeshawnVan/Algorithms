package data.structure.tree;

public class MaxHeap<T> {

    private Object[] items;

    private int size;

    public MaxHeap(int capacity) {

    }

    public MaxHeap(T[] items) {
        this.items = items;
        size = items.length;
        heapify(items);
    }

    private void heapify(T[] array) {
        int half = (size >>> 1) - 1;
        for (int i = half; i >= 0; i--) {
            siftDownComparable(i, array[i], array, size);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int position, T x, Object[] array, int size) {
        if (x instanceof Comparable) {
            Comparable<? super T> key = (Comparable<? super T>) x;
            int half = size >>> 1;
            while (position < half) {
                int largeChildIndex = getLargeChildIndex(position, size, array);
                T largeChildValue = (T) array[largeChildIndex];
                if (key.compareTo(largeChildValue) >= 0) break;
                array[position] = largeChildValue;
                position = largeChildIndex;
            }
            array[position] = x;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @SuppressWarnings("unchecked")
    private int getLargeChildIndex(int position, int size, Object[] array) {
        int leftIndex = getLeftIndex(position);
        int rightIndex = getRightIndex(position);
        if (rightIndex < size) {
            return ((Comparable<? super T>) array[leftIndex]).compareTo((T) array[rightIndex]) > 0 ? leftIndex : rightIndex;
        } else {
            return leftIndex;
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
}

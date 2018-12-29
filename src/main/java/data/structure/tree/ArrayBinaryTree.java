package data.structure.tree;

import java.util.Arrays;
import java.util.function.Function;

@SuppressWarnings("Duplicates")
public class ArrayBinaryTree<T> implements BinaryTree<T> {

    private static final int ROOT_INDEX = 1;

    private Object[] items;

    public ArrayBinaryTree() {
        items = new Object[16];
    }

    public ArrayBinaryTree(int size) {
        this.items = new Object[size];
    }

    @Override
    public TreeNode<T> getLeft(TreeNode<T> node) {
        return mapWithCheck(node, treeNode -> {
            int leftIndex = calculateLeftIndex(treeNode.getIndex());
            if (leftIndex + 1 >= items.length) return null;
            T value = getValue(leftIndex);
            return value == null ? null : new ArrayBinaryTreeNode<>(leftIndex, value);
        });
    }

    @Override
    public TreeNode<T> getRight(TreeNode<T> node) {
        return mapWithCheck(node, treeNode -> {
            int rightIndex = calculateRightIndex(treeNode.getIndex());
            if (rightIndex + 1 >= items.length) return null;
            T value = getValue(rightIndex);
            return value == null ? null : new ArrayBinaryTreeNode<>(rightIndex, value);
        });
    }

    @Override
    public TreeNode<T> setLeft(TreeNode<T> parent, TreeNode<T> left) {
        return mapWithCheck(parent, parentNode -> {
            ArrayBinaryTreeNode<T> leftNode = mapWithCheck(left, x -> x);
            int leftIndex = calculateLeftIndex(parentNode.getIndex());
            setValue(leftIndex, leftNode.getData());
            return new ArrayBinaryTreeNode<>(leftIndex, leftNode.data);
        });
    }

    @Override
    public TreeNode<T> setRight(TreeNode<T> parent, TreeNode<T> right) {
        return mapWithCheck(parent, parentNode -> {
            ArrayBinaryTreeNode<T> rightNode = mapWithCheck(right, x -> x);
            int rightIndex = calculateRightIndex(parentNode.getIndex());
            setValue(rightIndex, rightNode.getData());
            return new ArrayBinaryTreeNode<>(rightIndex, rightNode.data);
        });
    }

    @Override
    public TreeNode<T> getRoot() {
        T value = getValue(ROOT_INDEX);
        if (value == null) return null;
        return new ArrayBinaryTreeNode<>(ROOT_INDEX, value);
    }

    @Override
    public TreeNode<T> setRoot(TreeNode<T> node) {
        setValue(ROOT_INDEX, node.data);
        ArrayBinaryTreeNode<T> root = mapWithCheck(node, x -> x);
        root.setIndex(ROOT_INDEX);
        return root;
    }

    @Override
    public TreeNode<T> getParent(TreeNode<T> node) {
        ArrayBinaryTreeNode<T> treeNode = mapWithCheck(node, x -> x);
        int parentIndex = calculateParentIndex(treeNode.getIndex());
        T value = getValue(parentIndex);
        return value == null ? null : new ArrayBinaryTreeNode<>(parentIndex, value);
    }

    public void setValue(int index, T data) {
        checkAndGrow(index);
        items[index] = data;
    }

    private ArrayBinaryTreeNode<T> mapWithCheck(TreeNode<T> node, Function<ArrayBinaryTreeNode<T>, ArrayBinaryTreeNode<T>> function) {
        if (node == null) return null;
        if (node instanceof ArrayBinaryTreeNode) {
            return function.apply((ArrayBinaryTreeNode<T>) node);
        } else {
            throw new IllegalArgumentException("node must be ArrayBinaryTreeNode");
        }
    }

    @SuppressWarnings("unchecked")
    public T getValue(int index) {
        return index + 1 >= items.length ? null : (T) items[index];
    }

    private void checkAndGrow(int index) {
        if (index >= items.length) grow();
    }

    private int calculateParentIndex(int index) {
        return index == 0 ? -1 : index >> 1;
    }

    private int calculateLeftIndex(int index) {
        return index << 1;
    }

    private int calculateRightIndex(int index) {
        return (index << 1) + 1;
    }

    private void grow() {
        int oldCapacity = items.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        items = Arrays.copyOf(items, newCapacity);
    }

}

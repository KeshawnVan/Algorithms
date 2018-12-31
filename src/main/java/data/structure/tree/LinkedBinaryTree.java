package data.structure.tree;

import java.util.function.Function;

@SuppressWarnings("Duplicates")
public class LinkedBinaryTree<T> implements BinaryTree<T> {

    private LinkedBinaryTreeNode<T> root;

    @Override
    public String toString() {
        return "LinkedBinaryTree{" +
                "root=" + root +
                '}';
    }

    @Override
    public LinkedBinaryTreeNode<T> getRoot() {
        return root;
    }

    @Override
    public TreeNode<T> setRoot(T data) {
        if (data == null) return null;
        LinkedBinaryTreeNode<T> node = new LinkedBinaryTreeNode<>(data);
        this.root = node;
        return node;
    }

    void setRoot(TreeNode<T> node) {
        mapWithCheck(node, rootNode -> {
            this.root = rootNode;
            return null;
        });
    }

    public LinkedBinaryTreeNode<T> mapWithCheck(TreeNode<T> node, Function<LinkedBinaryTreeNode<T>, LinkedBinaryTreeNode<T>> function) {
        if (node == null) return null;
        if (node instanceof LinkedBinaryTreeNode) {
            return function.apply((LinkedBinaryTreeNode<T>) node);
        } else {
            throw new IllegalArgumentException("node must be LinkedBinaryTreeNode");
        }
    }

    @Override
    public TreeNode<T> getParent(TreeNode<T> node) {
        return mapWithCheck(node, LinkedBinaryTreeNode::getParent);
    }

    @Override
    public TreeNode<T> getLeft(TreeNode<T> node) {
        return mapWithCheck(node, LinkedBinaryTreeNode::getLeft);
    }

    @Override
    public TreeNode<T> getRight(TreeNode<T> node) {
        return mapWithCheck(node, LinkedBinaryTreeNode::getRight);
    }

    @Override
    public TreeNode<T> setLeft(TreeNode<T> parent, T data) {
        return mapWithCheck(parent, parentNode -> {
            if (data == null) {
                parentNode.setLeft(null);
                return null;
            } else {
                LinkedBinaryTreeNode<T> leftNode = new LinkedBinaryTreeNode<>(data);
                leftNode.setParent(parentNode);
                parentNode.setLeft(leftNode);
                return leftNode;
            }
        });
    }

    @Override
    public TreeNode<T> setRight(TreeNode<T> parent, T data) {
        return mapWithCheck(parent, parentNode -> {
            if (data == null) {
                parentNode.setRight(null);
                return null;
            } else {
                LinkedBinaryTreeNode<T> rightNode = new LinkedBinaryTreeNode<>(data);
                rightNode.setParent(parentNode);
                parentNode.setRight(rightNode);
                return rightNode;
            }
        });
    }
}

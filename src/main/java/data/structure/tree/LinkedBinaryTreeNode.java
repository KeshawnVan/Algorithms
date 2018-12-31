package data.structure.tree;

public class LinkedBinaryTreeNode<T> extends TreeNode<T> {

    private LinkedBinaryTreeNode<T> parent;

    private LinkedBinaryTreeNode<T> left;

    private LinkedBinaryTreeNode<T> right;

    public LinkedBinaryTreeNode() {
    }

    public LinkedBinaryTreeNode(T data) {
        super.data = data;
    }

    @Override
    public String toString() {
        return "\nLinkedBinaryTreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public LinkedBinaryTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(LinkedBinaryTreeNode<T> parent) {
        this.parent = parent;
    }

    public LinkedBinaryTreeNode<T> getLeft() {
        return left;
    }

    public LinkedBinaryTreeNode<T> setLeft(LinkedBinaryTreeNode<T> left) {
        this.left = left;
        return left;
    }

    public LinkedBinaryTreeNode<T> getRight() {
        return right;
    }

    public LinkedBinaryTreeNode<T> setRight(LinkedBinaryTreeNode<T> right) {
        this.right = right;
        return right;
    }
}
